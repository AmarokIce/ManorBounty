package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.ChristmasBaublesRedTileEntity;

public class ChristmasBaublesRedBlockModel extends GeoModel<ChristmasBaublesRedTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasBaublesRedTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
        return new ResourceLocation("manors_bounty", "animations/christmas_baubles.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasBaublesRedTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
        return new ResourceLocation("manors_bounty", "geo/christmas_baubles.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasBaublesRedTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "textures/block/christmas_baubles_red_yellow.png");
		if (blockstate == 2)
			return new ResourceLocation("manors_bounty", "textures/block/christmas_baubles_red_blue.png");
		if (blockstate == 3)
			return new ResourceLocation("manors_bounty", "textures/block/christmas_baubles_red_white.png");
		return new ResourceLocation("manors_bounty", "textures/block/christmas_baubles_red_red.png");
	}
}
