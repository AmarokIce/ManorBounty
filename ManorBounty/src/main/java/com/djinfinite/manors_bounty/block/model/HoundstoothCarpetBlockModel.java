package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.HoundstoothCarpetTileEntity;

public class HoundstoothCarpetBlockModel extends GeoModel<HoundstoothCarpetTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(HoundstoothCarpetTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "animations/houndstooth_carpet.animation.json");
		return new ResourceLocation("manors_bounty", "animations/houndstooth_carpet_down.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HoundstoothCarpetTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "geo/houndstooth_carpet.geo.json");
		return new ResourceLocation("manors_bounty", "geo/houndstooth_carpet_down.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HoundstoothCarpetTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
        return new ResourceLocation("manors_bounty", "textures/block/houndstooth_carpet.png");
	}
}
