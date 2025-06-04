package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasMiniGiftsBlueBlockModel;
import com.djinfinite.manors_bounty.block.entity.ChristmasMiniGiftsBlueTileEntity;

public class ChristmasMiniGiftsBlueTileRenderer extends GeoBlockRenderer<ChristmasMiniGiftsBlueTileEntity> {
	public ChristmasMiniGiftsBlueTileRenderer() {
		super(new ChristmasMiniGiftsBlueBlockModel());
	}

	@Override
	public RenderType getRenderType(ChristmasMiniGiftsBlueTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
