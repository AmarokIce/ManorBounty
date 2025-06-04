package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.ShirazCarpetDisplayItem;

public class ShirazCarpetDisplayModel extends GeoModel<ShirazCarpetDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ShirazCarpetDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/shiraz_carpet_down.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ShirazCarpetDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/shiraz_carpet_down.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ShirazCarpetDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/shiraz_carpet.png");
	}
}
