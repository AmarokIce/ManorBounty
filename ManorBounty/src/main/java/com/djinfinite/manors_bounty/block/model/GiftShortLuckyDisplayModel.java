package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.GiftShortLuckyDisplayItem;

public class GiftShortLuckyDisplayModel extends GeoModel<GiftShortLuckyDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(GiftShortLuckyDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_short.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftShortLuckyDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_short.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftShortLuckyDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_short_lucky.png");
	}
}
