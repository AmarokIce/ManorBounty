package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.MarbleBowlDisplayItem;

public class MarbleBowlDisplayModel extends GeoModel<MarbleBowlDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MarbleBowlDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/marble_bowl.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MarbleBowlDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/marble_bowl.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MarbleBowlDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/marble_bowl.png");
	}
}
