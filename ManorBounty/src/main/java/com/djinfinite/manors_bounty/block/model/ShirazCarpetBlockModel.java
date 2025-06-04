package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.ShirazCarpetTileEntity;

public class ShirazCarpetBlockModel extends GeoModel<ShirazCarpetTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(ShirazCarpetTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "animations/shiraz_carpet.animation.json");
		return new ResourceLocation("manors_bounty", "animations/shiraz_carpet_down.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ShirazCarpetTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "geo/shiraz_carpet.geo.json");
		return new ResourceLocation("manors_bounty", "geo/shiraz_carpet_down.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ShirazCarpetTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
        return new ResourceLocation("manors_bounty", "textures/block/shiraz_carpet.png");
	}
}
