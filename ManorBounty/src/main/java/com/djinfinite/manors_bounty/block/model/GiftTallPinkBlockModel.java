package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.GiftTallPinkTileEntity;

public class GiftTallPinkBlockModel extends GeoModel<GiftTallPinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(GiftTallPinkTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_tall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftTallPinkTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_tall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftTallPinkTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_tall_pink.png");
	}
}
