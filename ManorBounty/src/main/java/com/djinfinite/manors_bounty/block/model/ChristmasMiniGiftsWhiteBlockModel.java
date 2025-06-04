package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.ChristmasMiniGiftsWhiteTileEntity;

public class ChristmasMiniGiftsWhiteBlockModel extends GeoModel<ChristmasMiniGiftsWhiteTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasMiniGiftsWhiteTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "animations/christmas_mini_gifts.animation.json");
        return new ResourceLocation("manors_bounty", "animations/christmas_mini_gifts.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasMiniGiftsWhiteTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "geo/christmas_mini_gifts.geo.json");
        return new ResourceLocation("manors_bounty", "geo/christmas_mini_gifts.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasMiniGiftsWhiteTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "textures/block/christmas_mini_gifts_white_green.png");
		if (blockstate == 2)
			return new ResourceLocation("manors_bounty", "textures/block/christmas_mini_gifts_white_blue.png");
		if (blockstate == 3)
			return new ResourceLocation("manors_bounty", "textures/block/christmas_mini_gifts_white_pink.png");
		if (blockstate == 4)
			return new ResourceLocation("manors_bounty", "textures/block/christmas_mini_gifts_white_lucky.png");
		return new ResourceLocation("manors_bounty", "textures/block/christmas_mini_gifts_white_red.png");
	}
}
