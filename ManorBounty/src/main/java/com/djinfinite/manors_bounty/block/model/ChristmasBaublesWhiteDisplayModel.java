package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.ChristmasBaublesWhiteDisplayItem;

public class ChristmasBaublesWhiteDisplayModel extends GeoModel<ChristmasBaublesWhiteDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasBaublesWhiteDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/christmas_baubles.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasBaublesWhiteDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/christmas_baubles.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasBaublesWhiteDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/christmas_baubles_white_red.png");
	}
}
