package com.djinfinite.manors_bounty.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageWidget;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
/**
 * 自定义的渲染图像类，继承自 ImageWidget<p>
 * 提供了旋转、切换图像功能
 * @author fho4565
 */
public class RenderedImage extends ImageWidget {
    private final ResourceLocation[] textures;
    private float rotateAngle = 0.0f;
    private int index = 0;
    private int cycleTick = 20, currentTick = 0;
    private float minU = 0,maxU = 1,minV = 0,maxV = 1;

    public RenderedImage(ResourceLocation... textures){
        this(0,0,textures[0]);
    }
    public RenderedImage(int w,int h,ResourceLocation... textures){
        this(0,0,w,h,textures[0]);
    }
    public RenderedImage(int x,int y,int w,int h,ResourceLocation... textures){
        super(x,y,w,h,textures[0]);
        this.textures = textures;
    }

    public float getMaxU() {
        return maxU;
    }

    public void setMaxU(float maxU) {
        this.maxU = maxU;
    }

    public float getMaxV() {
        return maxV;
    }

    public void setMaxV(float maxV) {
        this.maxV = maxV;
    }

    public float getMinU() {
        return minU;
    }

    public void setMinU(float minU) {
        this.minU = minU;
    }

    public float getMinV() {
        return minV;
    }

    public void setMinV(float minV) {
        this.minV = minV;
    }

    public ResourceLocation currentTexture(){
        return textures[index];
    }

    public void nextTexture(){
        if (index < textures.length - 1){
            index++;
        }else{
            index = 0;
        }
    }

    public void prevTexture(){
        if (index > 0){
            index--;
        }else{
            index = textures.length - 1;
        }
    }

    public int getCycleTick() {
        return cycleTick;
    }

    public void setCycleTick(int cycleTick) {
        this.cycleTick = cycleTick;
    }

    public int getCurrentTick() {
        return currentTick;
    }

    public void setCurrentTick(int currentTick) {
        this.currentTick = currentTick;
    }

    public void guiTick(){
        if (currentTick == cycleTick) {
            nextTexture();
            currentTick = 0;
        } else {
            currentTick++;
        }
    }
    public void setRotate(float angle){
        this.rotateAngle = (float) Math.toRadians(angle);
    }
    public void rotate(float angle){
        this.rotateAngle = this.rotateAngle+(float) Math.toRadians(angle);
    }

    @Override
    protected @NotNull ClientTooltipPositioner createTooltipPositioner() {
        return new CustomTooltipPositioner();
    }

    @Override
    public void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderImage(pGuiGraphics);
    }

    public void renderImage(GuiGraphics guiGraphics) {
        RenderSystem.setShaderTexture(0, this.currentTexture());
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        Matrix4f matrix4f = new Matrix4f(guiGraphics.pose().last().pose());

        float centerX = this.getX() + this.getWidth() / 2.0f;
        float centerY = this.getY() + this.getHeight() / 2.0f;

        if (this.rotateAngle != 0) {
            Matrix4f translationMatrix = new Matrix4f().translate(centerX, centerY, 0.0F);

            Matrix4f rotationMatrix = new Matrix4f().rotate(this.rotateAngle, 0.0F, 0.0F, 1.0F);
            translationMatrix.mul(rotationMatrix);

            Matrix4f inverseTranslationMatrix = new Matrix4f().translate(-centerX, -centerY, 0.0F);
            translationMatrix.mul(inverseTranslationMatrix);

            matrix4f.mul(translationMatrix);
        }

        BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(matrix4f, this.getX(), this.getY(), 0.0F).uv(minU,minV).endVertex();
        bufferbuilder.vertex(matrix4f, this.getX(), this.getY() + this.getHeight(), 0.0F).uv(minU, maxV).endVertex();
        bufferbuilder.vertex(matrix4f, this.getX() + this.getWidth(), this.getY() + this.getHeight(), 0.0F).uv(maxU, maxV).endVertex();
        bufferbuilder.vertex(matrix4f, this.getX() + this.getWidth(), this.getY(), 0.0F).uv(maxU, minV).endVertex();

        BufferUploader.drawWithShader(bufferbuilder.end());
    }
}
