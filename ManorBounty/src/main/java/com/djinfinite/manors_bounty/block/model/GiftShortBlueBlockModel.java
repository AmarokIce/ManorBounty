package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.GiftShortBlueTileEntity;

public class GiftShortBlueBlockModel extends GeoModel<GiftShortBlueTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(GiftShortBlueTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_short.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftShortBlueTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_short.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftShortBlueTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_short_blue.png");
	}
}
