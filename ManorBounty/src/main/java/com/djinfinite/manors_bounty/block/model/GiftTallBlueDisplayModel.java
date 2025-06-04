package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.GiftTallBlueDisplayItem;

public class GiftTallBlueDisplayModel extends GeoModel<GiftTallBlueDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(GiftTallBlueDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_tall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftTallBlueDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_tall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftTallBlueDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_tall_blue.png");
	}
}
