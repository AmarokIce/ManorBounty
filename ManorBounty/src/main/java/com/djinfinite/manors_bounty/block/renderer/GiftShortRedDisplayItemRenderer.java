package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftShortRedDisplayModel;
import com.djinfinite.manors_bounty.block.display.GiftShortRedDisplayItem;

public class GiftShortRedDisplayItemRenderer extends GeoItemRenderer<GiftShortRedDisplayItem> {
	public GiftShortRedDisplayItemRenderer() {
		super(new GiftShortRedDisplayModel());
	}

	@Override
	public RenderType getRenderType(GiftShortRedDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
