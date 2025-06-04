package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.PicnicMatDisplayItem;

public class PicnicMatDisplayModel extends GeoModel<PicnicMatDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(PicnicMatDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/magic_circle_carpet_down.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PicnicMatDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/magic_circle_carpet_down.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PicnicMatDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/picnic_mat.png");
	}
}
