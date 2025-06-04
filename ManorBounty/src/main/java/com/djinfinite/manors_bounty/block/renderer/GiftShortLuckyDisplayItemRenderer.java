package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftShortLuckyDisplayModel;
import com.djinfinite.manors_bounty.block.display.GiftShortLuckyDisplayItem;

public class GiftShortLuckyDisplayItemRenderer extends GeoItemRenderer<GiftShortLuckyDisplayItem> {
	public GiftShortLuckyDisplayItemRenderer() {
		super(new GiftShortLuckyDisplayModel());
	}

	@Override
	public RenderType getRenderType(GiftShortLuckyDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
