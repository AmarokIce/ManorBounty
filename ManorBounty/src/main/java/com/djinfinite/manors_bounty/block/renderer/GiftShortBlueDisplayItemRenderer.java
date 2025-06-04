package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftShortBlueDisplayModel;
import com.djinfinite.manors_bounty.block.display.GiftShortBlueDisplayItem;

public class GiftShortBlueDisplayItemRenderer extends GeoItemRenderer<GiftShortBlueDisplayItem> {
	public GiftShortBlueDisplayItemRenderer() {
		super(new GiftShortBlueDisplayModel());
	}

	@Override
	public RenderType getRenderType(GiftShortBlueDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
