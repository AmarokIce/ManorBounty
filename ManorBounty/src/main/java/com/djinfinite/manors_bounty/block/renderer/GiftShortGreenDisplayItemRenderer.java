package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftShortGreenDisplayModel;
import com.djinfinite.manors_bounty.block.display.GiftShortGreenDisplayItem;

public class GiftShortGreenDisplayItemRenderer extends GeoItemRenderer<GiftShortGreenDisplayItem> {
	public GiftShortGreenDisplayItemRenderer() {
		super(new GiftShortGreenDisplayModel());
	}

	@Override
	public RenderType getRenderType(GiftShortGreenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
