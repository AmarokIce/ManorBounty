package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftTallGreenDisplayModel;
import com.djinfinite.manors_bounty.block.display.GiftTallGreenDisplayItem;

public class GiftTallGreenDisplayItemRenderer extends GeoItemRenderer<GiftTallGreenDisplayItem> {
	public GiftTallGreenDisplayItemRenderer() {
		super(new GiftTallGreenDisplayModel());
	}

	@Override
	public RenderType getRenderType(GiftTallGreenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
