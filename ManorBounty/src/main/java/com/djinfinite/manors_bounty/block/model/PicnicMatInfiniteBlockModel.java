package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.PicnicMatInfiniteTileEntity;

public class PicnicMatInfiniteBlockModel extends GeoModel<PicnicMatInfiniteTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(PicnicMatInfiniteTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/16x_normal_carpet.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PicnicMatInfiniteTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/16x_normal_carpet.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PicnicMatInfiniteTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/picnic_mat_infinite.png");
	}
}
