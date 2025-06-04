package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.GiftShortPinkTileEntity;

public class GiftShortPinkBlockModel extends GeoModel<GiftShortPinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(GiftShortPinkTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_short.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftShortPinkTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_short.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftShortPinkTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_short_pink.png");
	}
}
