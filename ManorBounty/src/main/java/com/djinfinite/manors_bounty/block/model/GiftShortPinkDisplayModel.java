package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.GiftShortPinkDisplayItem;

public class GiftShortPinkDisplayModel extends GeoModel<GiftShortPinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(GiftShortPinkDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_short.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftShortPinkDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_short.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftShortPinkDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_short_pink.png");
	}
}
