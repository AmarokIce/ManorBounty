package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.CherriesPieDisplayItem;

public class CherriesPieDisplayModel extends GeoModel<CherriesPieDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(CherriesPieDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/big_pie_slice.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CherriesPieDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/big_pie_slice.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CherriesPieDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/cherries_pie.png");
	}
}
