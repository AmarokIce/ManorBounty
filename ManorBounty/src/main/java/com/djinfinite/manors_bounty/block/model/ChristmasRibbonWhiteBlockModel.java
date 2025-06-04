package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.ChristmasRibbonWhiteTileEntity;

public class ChristmasRibbonWhiteBlockModel extends GeoModel<ChristmasRibbonWhiteTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasRibbonWhiteTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/christmas_ribbon.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasRibbonWhiteTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/christmas_ribbon.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasRibbonWhiteTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/christmas_ribbon_white.png");
	}
}
