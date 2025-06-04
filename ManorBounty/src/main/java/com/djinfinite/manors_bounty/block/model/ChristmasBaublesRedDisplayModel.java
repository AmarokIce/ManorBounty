package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.ChristmasBaublesRedDisplayItem;

public class ChristmasBaublesRedDisplayModel extends GeoModel<ChristmasBaublesRedDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasBaublesRedDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/christmas_baubles.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasBaublesRedDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/christmas_baubles.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasBaublesRedDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/christmas_baubles_red_red.png");
	}
}
