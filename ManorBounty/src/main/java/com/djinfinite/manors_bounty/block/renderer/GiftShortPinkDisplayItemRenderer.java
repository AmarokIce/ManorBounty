package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftShortPinkDisplayModel;
import com.djinfinite.manors_bounty.block.display.GiftShortPinkDisplayItem;

public class GiftShortPinkDisplayItemRenderer extends GeoItemRenderer<GiftShortPinkDisplayItem> {
	public GiftShortPinkDisplayItemRenderer() {
		super(new GiftShortPinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(GiftShortPinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
