package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.GiftTallRedDisplayItem;

public class GiftTallRedDisplayModel extends GeoModel<GiftTallRedDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(GiftTallRedDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_tall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftTallRedDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_tall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftTallRedDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_tall_red.png");
	}
}
