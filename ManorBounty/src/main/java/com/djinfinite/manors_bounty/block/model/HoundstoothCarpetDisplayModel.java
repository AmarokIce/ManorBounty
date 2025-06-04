package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.HoundstoothCarpetDisplayItem;

public class HoundstoothCarpetDisplayModel extends GeoModel<HoundstoothCarpetDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(HoundstoothCarpetDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/houndstooth_carpet_down.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HoundstoothCarpetDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/houndstooth_carpet_down.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HoundstoothCarpetDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/houndstooth_carpet.png");
	}
}
