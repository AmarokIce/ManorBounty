package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.ChristmasBaublesYellowDisplayItem;

public class ChristmasBaublesYellowDisplayModel extends GeoModel<ChristmasBaublesYellowDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasBaublesYellowDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/christmas_baubles.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasBaublesYellowDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/christmas_baubles.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasBaublesYellowDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/christmas_baubles_yellow_red.png");
	}
}
