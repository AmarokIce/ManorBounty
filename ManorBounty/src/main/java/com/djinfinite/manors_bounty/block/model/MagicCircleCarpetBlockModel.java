package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.MagicCircleCarpetTileEntity;

public class MagicCircleCarpetBlockModel extends GeoModel<MagicCircleCarpetTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MagicCircleCarpetTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "animations/magic_circle_carpet.animation.json");
		return new ResourceLocation("manors_bounty", "animations/magic_circle_carpet_down.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MagicCircleCarpetTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "geo/magic_circle_carpet.geo.json");
		return new ResourceLocation("manors_bounty", "geo/magic_circle_carpet_down.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MagicCircleCarpetTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
        return new ResourceLocation("manors_bounty", "textures/block/magic_circle_carpet.png");
	}
}
