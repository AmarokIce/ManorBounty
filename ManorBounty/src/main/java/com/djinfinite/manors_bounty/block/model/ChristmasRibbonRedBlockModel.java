package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.ChristmasRibbonRedTileEntity;

public class ChristmasRibbonRedBlockModel extends GeoModel<ChristmasRibbonRedTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasRibbonRedTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/christmas_ribbon.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasRibbonRedTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/christmas_ribbon.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasRibbonRedTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/christmas_ribbon_red.png");
	}
}
