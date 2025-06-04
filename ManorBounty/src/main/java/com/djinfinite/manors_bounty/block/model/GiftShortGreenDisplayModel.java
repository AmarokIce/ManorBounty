package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.GiftShortGreenDisplayItem;

public class GiftShortGreenDisplayModel extends GeoModel<GiftShortGreenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(GiftShortGreenDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_short.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftShortGreenDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_short.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftShortGreenDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_short_green.png");
	}
}
