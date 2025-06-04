package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.ChristmasRibbonYellowDisplayItem;

public class ChristmasRibbonYellowDisplayModel extends GeoModel<ChristmasRibbonYellowDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasRibbonYellowDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/christmas_ribbon.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasRibbonYellowDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/christmas_ribbon.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasRibbonYellowDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/christmas_ribbon_yellow.png");
	}
}
