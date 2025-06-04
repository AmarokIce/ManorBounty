package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.ChristmasRibbonWhiteDisplayItem;

public class ChristmasRibbonWhiteDisplayModel extends GeoModel<ChristmasRibbonWhiteDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasRibbonWhiteDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/christmas_ribbon.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasRibbonWhiteDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/christmas_ribbon.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasRibbonWhiteDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/christmas_ribbon_white.png");
	}
}
