package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.GiftTallPinkDisplayItem;

public class GiftTallPinkDisplayModel extends GeoModel<GiftTallPinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(GiftTallPinkDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_tall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftTallPinkDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_tall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftTallPinkDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_tall_pink.png");
	}
}
