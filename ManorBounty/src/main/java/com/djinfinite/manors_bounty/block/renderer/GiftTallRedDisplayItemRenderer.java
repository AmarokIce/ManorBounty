package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftTallRedDisplayModel;
import com.djinfinite.manors_bounty.block.display.GiftTallRedDisplayItem;

public class GiftTallRedDisplayItemRenderer extends GeoItemRenderer<GiftTallRedDisplayItem> {
	public GiftTallRedDisplayItemRenderer() {
		super(new GiftTallRedDisplayModel());
	}

	@Override
	public RenderType getRenderType(GiftTallRedDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
