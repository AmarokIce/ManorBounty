package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftTallBlueDisplayModel;
import com.djinfinite.manors_bounty.block.display.GiftTallBlueDisplayItem;

public class GiftTallBlueDisplayItemRenderer extends GeoItemRenderer<GiftTallBlueDisplayItem> {
	public GiftTallBlueDisplayItemRenderer() {
		super(new GiftTallBlueDisplayModel());
	}

	@Override
	public RenderType getRenderType(GiftTallBlueDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
