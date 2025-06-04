package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftTallPinkDisplayModel;
import com.djinfinite.manors_bounty.block.display.GiftTallPinkDisplayItem;

public class GiftTallPinkDisplayItemRenderer extends GeoItemRenderer<GiftTallPinkDisplayItem> {
	public GiftTallPinkDisplayItemRenderer() {
		super(new GiftTallPinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(GiftTallPinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
