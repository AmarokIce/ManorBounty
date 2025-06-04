package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.ChristmasRibbonYellowTileEntity;

public class ChristmasRibbonYellowBlockModel extends GeoModel<ChristmasRibbonYellowTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasRibbonYellowTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/christmas_ribbon.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasRibbonYellowTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/christmas_ribbon.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasRibbonYellowTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/christmas_ribbon_yellow.png");
	}
}
