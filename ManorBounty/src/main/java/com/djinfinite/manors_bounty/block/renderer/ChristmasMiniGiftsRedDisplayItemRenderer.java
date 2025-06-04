package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasMiniGiftsRedDisplayModel;
import com.djinfinite.manors_bounty.block.display.ChristmasMiniGiftsRedDisplayItem;

public class ChristmasMiniGiftsRedDisplayItemRenderer extends GeoItemRenderer<ChristmasMiniGiftsRedDisplayItem> {
	public ChristmasMiniGiftsRedDisplayItemRenderer() {
		super(new ChristmasMiniGiftsRedDisplayModel());
	}

	@Override
	public RenderType getRenderType(ChristmasMiniGiftsRedDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
