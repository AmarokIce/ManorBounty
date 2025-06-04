package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.GiftShortRedTileEntity;

public class GiftShortRedBlockModel extends GeoModel<GiftShortRedTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(GiftShortRedTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_short.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftShortRedTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_short.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftShortRedTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_short_red.png");
	}
}
