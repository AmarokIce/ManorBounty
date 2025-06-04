package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.ChristmasSockTileEntity;

public class ChristmasSockBlockModel extends GeoModel<ChristmasSockTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasSockTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/christmas_sock.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasSockTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/christmas_sock.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasSockTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/christmas_sock.png");
	}
}
