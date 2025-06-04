package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.PancakeBlockDisplayItem;

public class PancakeBlockDisplayModel extends GeoModel<PancakeBlockDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(PancakeBlockDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/pancake.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PancakeBlockDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/pancake.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PancakeBlockDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/pancake_block.png");
	}
}
