package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.ChristmasRibbonRedDisplayItem;

public class ChristmasRibbonRedDisplayModel extends GeoModel<ChristmasRibbonRedDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasRibbonRedDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/christmas_ribbon.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasRibbonRedDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/christmas_ribbon.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasRibbonRedDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/christmas_ribbon_red.png");
	}
}
