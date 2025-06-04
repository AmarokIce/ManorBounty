package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.GiftTallGreenDisplayItem;

public class GiftTallGreenDisplayModel extends GeoModel<GiftTallGreenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(GiftTallGreenDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_tall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftTallGreenDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_tall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftTallGreenDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_tall_green.png");
	}
}
