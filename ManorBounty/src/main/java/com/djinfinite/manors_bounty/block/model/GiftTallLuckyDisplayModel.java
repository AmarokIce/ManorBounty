package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.GiftTallLuckyDisplayItem;

public class GiftTallLuckyDisplayModel extends GeoModel<GiftTallLuckyDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(GiftTallLuckyDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_tall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftTallLuckyDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_tall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftTallLuckyDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_tall_lucky.png");
	}
}
