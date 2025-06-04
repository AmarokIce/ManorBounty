package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.ChristmasBaublesBlueTileEntity;

public class ChristmasBaublesBlueBlockModel extends GeoModel<ChristmasBaublesBlueTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasBaublesBlueTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
        return new ResourceLocation("manors_bounty", "animations/christmas_baubles.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasBaublesBlueTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
        return new ResourceLocation("manors_bounty", "geo/christmas_baubles.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasBaublesBlueTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "textures/block/christmas_baubles_blue_yellow.png");
		if (blockstate == 2)
			return new ResourceLocation("manors_bounty", "textures/block/christmas_baubles_blue_blue.png");
		if (blockstate == 3)
			return new ResourceLocation("manors_bounty", "textures/block/christmas_baubles_blue_white.png");
		return new ResourceLocation("manors_bounty", "textures/block/christmas_baubles_blue_red.png");
	}
}
