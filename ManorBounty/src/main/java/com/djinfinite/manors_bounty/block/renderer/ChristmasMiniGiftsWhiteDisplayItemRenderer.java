package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasMiniGiftsWhiteDisplayModel;
import com.djinfinite.manors_bounty.block.display.ChristmasMiniGiftsWhiteDisplayItem;

public class ChristmasMiniGiftsWhiteDisplayItemRenderer extends GeoItemRenderer<ChristmasMiniGiftsWhiteDisplayItem> {
	public ChristmasMiniGiftsWhiteDisplayItemRenderer() {
		super(new ChristmasMiniGiftsWhiteDisplayModel());
	}

	@Override
	public RenderType getRenderType(ChristmasMiniGiftsWhiteDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
