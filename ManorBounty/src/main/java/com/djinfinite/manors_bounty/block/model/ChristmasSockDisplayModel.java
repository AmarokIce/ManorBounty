package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.ChristmasSockDisplayItem;

public class ChristmasSockDisplayModel extends GeoModel<ChristmasSockDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasSockDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/christmas_sock.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasSockDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/christmas_sock.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasSockDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/christmas_sock.png");
	}
}
