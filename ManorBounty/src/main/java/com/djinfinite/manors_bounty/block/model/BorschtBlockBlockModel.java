package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.BorschtBlockTileEntity;

public class BorschtBlockBlockModel extends GeoModel<BorschtBlockTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BorschtBlockTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/borscht.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BorschtBlockTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/borscht.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BorschtBlockTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/borscht_block.png");
	}
}
