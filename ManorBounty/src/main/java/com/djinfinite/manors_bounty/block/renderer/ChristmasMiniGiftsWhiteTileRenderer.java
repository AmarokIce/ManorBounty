package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasMiniGiftsWhiteBlockModel;
import com.djinfinite.manors_bounty.block.entity.ChristmasMiniGiftsWhiteTileEntity;

public class ChristmasMiniGiftsWhiteTileRenderer extends GeoBlockRenderer<ChristmasMiniGiftsWhiteTileEntity> {
	public ChristmasMiniGiftsWhiteTileRenderer() {
		super(new ChristmasMiniGiftsWhiteBlockModel());
	}

	@Override
	public RenderType getRenderType(ChristmasMiniGiftsWhiteTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
