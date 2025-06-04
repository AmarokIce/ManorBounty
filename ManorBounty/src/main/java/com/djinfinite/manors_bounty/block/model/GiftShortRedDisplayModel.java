package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.GiftShortRedDisplayItem;

public class GiftShortRedDisplayModel extends GeoModel<GiftShortRedDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(GiftShortRedDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_short.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftShortRedDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_short.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftShortRedDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_short_red.png");
	}
}
