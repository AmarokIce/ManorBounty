package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.ChristmasMiniGiftsRedDisplayItem;

public class ChristmasMiniGiftsRedDisplayModel extends GeoModel<ChristmasMiniGiftsRedDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasMiniGiftsRedDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/christmas_mini_gifts.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasMiniGiftsRedDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/christmas_mini_gifts.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasMiniGiftsRedDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/christmas_mini_gifts_red_red.png");
	}
}
