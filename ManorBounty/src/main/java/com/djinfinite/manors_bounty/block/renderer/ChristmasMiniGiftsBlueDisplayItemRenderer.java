package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasMiniGiftsBlueDisplayModel;
import com.djinfinite.manors_bounty.block.display.ChristmasMiniGiftsBlueDisplayItem;

public class ChristmasMiniGiftsBlueDisplayItemRenderer extends GeoItemRenderer<ChristmasMiniGiftsBlueDisplayItem> {
	public ChristmasMiniGiftsBlueDisplayItemRenderer() {
		super(new ChristmasMiniGiftsBlueDisplayModel());
	}

	@Override
	public RenderType getRenderType(ChristmasMiniGiftsBlueDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
