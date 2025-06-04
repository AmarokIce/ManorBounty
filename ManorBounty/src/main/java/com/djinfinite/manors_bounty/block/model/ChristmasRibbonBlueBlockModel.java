package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.ChristmasRibbonBlueTileEntity;

public class ChristmasRibbonBlueBlockModel extends GeoModel<ChristmasRibbonBlueTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasRibbonBlueTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/christmas_ribbon.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasRibbonBlueTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/christmas_ribbon.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasRibbonBlueTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/christmas_ribbon_blue.png");
	}
}
