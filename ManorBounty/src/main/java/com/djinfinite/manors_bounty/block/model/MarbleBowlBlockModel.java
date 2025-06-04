package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.MarbleBowlTileEntity;

public class MarbleBowlBlockModel extends GeoModel<MarbleBowlTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MarbleBowlTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/marble_bowl.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MarbleBowlTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/marble_bowl.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MarbleBowlTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/marble_bowl.png");
	}
}
