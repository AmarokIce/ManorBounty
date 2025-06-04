package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.BorschtBlockDisplayItem;

public class BorschtBlockDisplayModel extends GeoModel<BorschtBlockDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(BorschtBlockDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/borscht.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BorschtBlockDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/borscht.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BorschtBlockDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/borscht_block.png");
	}
}
