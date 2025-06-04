package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.PancakeBlockTileEntity;

public class PancakeBlockBlockModel extends GeoModel<PancakeBlockTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(PancakeBlockTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
        return new ResourceLocation("manors_bounty", "animations/pancake.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PancakeBlockTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
        return new ResourceLocation("manors_bounty", "geo/pancake.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PancakeBlockTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "textures/block/pancake_block_honey.png");
		return new ResourceLocation("manors_bounty", "textures/block/pancake_block.png");
	}
}
