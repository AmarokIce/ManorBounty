package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.GiftTallBlueTileEntity;

public class GiftTallBlueBlockModel extends GeoModel<GiftTallBlueTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(GiftTallBlueTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_tall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftTallBlueTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_tall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftTallBlueTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_tall_blue.png");
	}
}
