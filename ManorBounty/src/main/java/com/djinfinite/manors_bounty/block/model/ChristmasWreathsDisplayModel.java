package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.ChristmasWreathsDisplayItem;

public class ChristmasWreathsDisplayModel extends GeoModel<ChristmasWreathsDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasWreathsDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/christmas_wreaths.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasWreathsDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/christmas_wreaths.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasWreathsDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/christmas_wreaths.png");
	}
}
