package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.ChristmasMiniGiftsYellowDisplayItem;

public class ChristmasMiniGiftsYellowDisplayModel extends GeoModel<ChristmasMiniGiftsYellowDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasMiniGiftsYellowDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/christmas_mini_gifts.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasMiniGiftsYellowDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/christmas_mini_gifts.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasMiniGiftsYellowDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/christmas_mini_gifts_yellow_red.png");
	}
}
