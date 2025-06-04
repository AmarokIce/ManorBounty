package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.TrufflePieDisplayItem;

public class TrufflePieDisplayModel extends GeoModel<TrufflePieDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(TrufflePieDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/big_pie_slice.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TrufflePieDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/big_pie_slice.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TrufflePieDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/truffle_pie.png");
	}
}
