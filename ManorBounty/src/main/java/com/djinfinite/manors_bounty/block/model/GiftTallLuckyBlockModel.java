package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.GiftTallLuckyTileEntity;

public class GiftTallLuckyBlockModel extends GeoModel<GiftTallLuckyTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(GiftTallLuckyTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_tall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftTallLuckyTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_tall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftTallLuckyTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_tall_lucky.png");
	}
}
