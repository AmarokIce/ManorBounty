package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.ChristmasWreathsTileEntity;

public class ChristmasWreathsBlockModel extends GeoModel<ChristmasWreathsTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasWreathsTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/christmas_wreaths.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasWreathsTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/christmas_wreaths.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasWreathsTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/christmas_wreaths.png");
	}
}
