package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.HoundstoothInfiniteCarpetDisplayItem;

public class HoundstoothInfiniteCarpetDisplayModel extends GeoModel<HoundstoothInfiniteCarpetDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(HoundstoothInfiniteCarpetDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/16x_normal_carpet.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HoundstoothInfiniteCarpetDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/16x_normal_carpet.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HoundstoothInfiniteCarpetDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/houndstooth_infinite_carpet.png");
	}
}
