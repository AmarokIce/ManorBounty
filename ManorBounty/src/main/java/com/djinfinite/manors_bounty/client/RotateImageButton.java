package com.djinfinite.manors_bounty.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix4f;

/**
 * 提供了旋转的图像按钮
 * @author fho4565
 * */
public class RotateImageButton extends ImageButton {
    float rotateAngle = 0.0f;
    public RotateImageButton(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, ResourceLocation pResourceLocation, OnPress pOnPress) {
        super(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pResourceLocation, pOnPress);
    }

    public RotateImageButton(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int pYDiffTex, ResourceLocation pResourceLocation, OnPress pOnPress) {
        super(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pYDiffTex, pResourceLocation, pOnPress);
    }

    public RotateImageButton(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int pYDiffTex, ResourceLocation pResourceLocation, int pTextureWidth, int pTextureHeight, OnPress pOnPress) {
        super(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pYDiffTex, pResourceLocation, pTextureWidth, pTextureHeight, pOnPress);
    }

   public RotateImageButton(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int pYDiffTex, ResourceLocation pResourceLocation, int pTextureWidth, int pTextureHeight, OnPress pOnPress, Component pMessage) {
        super(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pYDiffTex, pResourceLocation, pTextureWidth, pTextureHeight, pOnPress, pMessage);
    }
    public float getRotateAngle(){
        return rotateAngle;
    }
    public void setRotate(float angle){
        this.rotateAngle = (float) Math.toRadians(angle);
    }
    public void rotate(float angle){
        this.rotateAngle = this.rotateAngle+(float) Math.toRadians(angle);
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        rotateBlit(guiGraphics,this.getX(),this.getY(),this.textureWidth, (float) this.textureHeight/2,0,0,1,0.5f);
    }

    public void rotateBlit(GuiGraphics guiGraphics, float pX, float pY, float pWidth, float pHeight,float minU,float minV,float maxU,float maxV) {
        RenderSystem.setShaderTexture(0, this.resourceLocation);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        Matrix4f matrix4f = new Matrix4f(guiGraphics.pose().last().pose());

        float centerX = pX + pWidth / 2.0f;
        float centerY = pY + pHeight / 2.0f;

        Matrix4f translationMatrix = new Matrix4f().translate(centerX, centerY, 0.0F);

        Matrix4f rotationMatrix = new Matrix4f().rotate(this.rotateAngle, 0.0F, 0.0F, 1.0F);
        translationMatrix.mul(rotationMatrix);

        Matrix4f inverseTranslationMatrix = new Matrix4f().translate(-centerX, -centerY, 0.0F);
        translationMatrix.mul(inverseTranslationMatrix);

        matrix4f.mul(translationMatrix);

        BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(matrix4f, pX, pY, 0.0F).uv(minU,minV).endVertex();
        bufferbuilder.vertex(matrix4f, pX, pY + pHeight, 0.0F).uv(minU, maxV).endVertex();
        bufferbuilder.vertex(matrix4f, pX + pWidth, pY + pHeight, 0.0F).uv(maxU, maxV).endVertex();
        bufferbuilder.vertex(matrix4f, pX + pWidth, pY, 0.0F).uv(maxU, minV).endVertex();

        BufferUploader.drawWithShader(bufferbuilder.end());
    }

}
