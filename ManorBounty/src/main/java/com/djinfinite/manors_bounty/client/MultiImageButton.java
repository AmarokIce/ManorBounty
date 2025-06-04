package com.djinfinite.manors_bounty.client;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * 继承自ImageButton，提供了切换图像的功能
 * @author fho4565
 * */
public class MultiImageButton extends ImageButton {
    ArrayList<ResourceLocation> textures = new ArrayList<>();
    int index = 0;
    public MultiImageButton(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, ResourceLocation[] pResourceLocation, OnPress pOnPress) {
        this(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pHeight, pResourceLocation, 256, 256, pOnPress);
    }

    public MultiImageButton(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int pYDiffTex, ResourceLocation[] pResourceLocation, OnPress pOnPress) {
        this(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pYDiffTex, pResourceLocation, 256, 256, pOnPress);
    }

    public MultiImageButton(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int pYDiffTex, ResourceLocation[] pResourceLocation, int pTextureWidth, int pTextureHeight, OnPress pOnPress) {
        this(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pYDiffTex, pResourceLocation, pTextureWidth, pTextureHeight, pOnPress, CommonComponents.EMPTY);
    }

    public MultiImageButton(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int pYDiffTex, ResourceLocation[] pResourceLocation, int pTextureWidth, int pTextureHeight, OnPress pOnPress, Component pMessage) {
        super(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pYDiffTex, pResourceLocation[0], pTextureWidth, pTextureHeight, pOnPress, pMessage);
        this.textures.addAll(List.of(pResourceLocation));
    }

    public ResourceLocation currentTexture(){
        return textures.get(index);
    }
    public void setIndex(int index){
        this.index = index;
    }

    public void nextTexture(){
        if (index < textures.size() - 1){
            index++;
        }else{
            index = 0;
        }
    }

    public void prevTexture(){
        if (index > 0){
            index--;
        }else{
            index = textures.size() - 1;
        }
    }
    @Override
    public void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderTexture(pGuiGraphics, currentTexture(), this.getX(), this.getY(), this.xTexStart, this.yTexStart, this.yDiffTex, this.width, this.height, this.textureWidth, this.textureHeight);
    }
}
