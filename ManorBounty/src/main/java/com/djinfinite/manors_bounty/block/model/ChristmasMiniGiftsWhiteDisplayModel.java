package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.ChristmasMiniGiftsWhiteDisplayItem;

public class ChristmasMiniGiftsWhiteDisplayModel extends GeoModel<ChristmasMiniGiftsWhiteDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasMiniGiftsWhiteDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/christmas_mini_gifts.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasMiniGiftsWhiteDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/christmas_mini_gifts.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasMiniGiftsWhiteDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/christmas_mini_gifts_white_red.png");
	}
}
