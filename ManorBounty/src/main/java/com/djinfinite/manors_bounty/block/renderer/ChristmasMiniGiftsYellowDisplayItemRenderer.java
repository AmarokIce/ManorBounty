package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasMiniGiftsYellowDisplayModel;
import com.djinfinite.manors_bounty.block.display.ChristmasMiniGiftsYellowDisplayItem;

public class ChristmasMiniGiftsYellowDisplayItemRenderer extends GeoItemRenderer<ChristmasMiniGiftsYellowDisplayItem> {
	public ChristmasMiniGiftsYellowDisplayItemRenderer() {
		super(new ChristmasMiniGiftsYellowDisplayModel());
	}

	@Override
	public RenderType getRenderType(ChristmasMiniGiftsYellowDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
