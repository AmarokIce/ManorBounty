package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.GiftTallRedTileEntity;

public class GiftTallRedBlockModel extends GeoModel<GiftTallRedTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(GiftTallRedTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_tall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftTallRedTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_tall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftTallRedTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_tall_red.png");
	}
}
