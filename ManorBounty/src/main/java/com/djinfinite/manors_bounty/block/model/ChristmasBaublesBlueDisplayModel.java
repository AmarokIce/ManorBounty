package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.ChristmasBaublesBlueDisplayItem;

public class ChristmasBaublesBlueDisplayModel extends GeoModel<ChristmasBaublesBlueDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasBaublesBlueDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/christmas_baubles.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasBaublesBlueDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/christmas_baubles.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasBaublesBlueDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/christmas_baubles_blue_red.png");
	}
}
