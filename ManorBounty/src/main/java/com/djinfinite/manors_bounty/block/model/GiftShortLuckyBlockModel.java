package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.GiftShortLuckyTileEntity;

public class GiftShortLuckyBlockModel extends GeoModel<GiftShortLuckyTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(GiftShortLuckyTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_short.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftShortLuckyTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_short.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftShortLuckyTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_short_lucky.png");
	}
}
