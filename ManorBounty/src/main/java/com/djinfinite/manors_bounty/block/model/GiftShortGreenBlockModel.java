package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.GiftShortGreenTileEntity;

public class GiftShortGreenBlockModel extends GeoModel<GiftShortGreenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(GiftShortGreenTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_short.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftShortGreenTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_short.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftShortGreenTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_short_green.png");
	}
}
