package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.GiftShortBlueDisplayItem;

public class GiftShortBlueDisplayModel extends GeoModel<GiftShortBlueDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(GiftShortBlueDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_short.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftShortBlueDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_short.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftShortBlueDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_short_blue.png");
	}
}
