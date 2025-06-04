package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.GiftTallGreenTileEntity;

public class GiftTallGreenBlockModel extends GeoModel<GiftTallGreenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(GiftTallGreenTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/gift_tall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiftTallGreenTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/gift_tall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiftTallGreenTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/gift_tall_green.png");
	}
}
