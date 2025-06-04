package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.MagicCircleCarpetDisplayItem;

public class MagicCircleCarpetDisplayModel extends GeoModel<MagicCircleCarpetDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MagicCircleCarpetDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/magic_circle_carpet_down.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MagicCircleCarpetDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/magic_circle_carpet_down.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MagicCircleCarpetDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/magic_circle_carpet.png");
	}
}
