package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.ChristmasMiniGiftsBlueTileEntity;

public class ChristmasMiniGiftsBlueBlockModel extends GeoModel<ChristmasMiniGiftsBlueTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(ChristmasMiniGiftsBlueTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "animations/christmas_mini_gifts.animation.json");
        return new ResourceLocation("manors_bounty", "animations/christmas_mini_gifts.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChristmasMiniGiftsBlueTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "geo/christmas_mini_gifts.geo.json");
        return new ResourceLocation("manors_bounty", "geo/christmas_mini_gifts.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChristmasMiniGiftsBlueTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "textures/block/christmas_mini_gifts_blue_green.png");
		if (blockstate == 2)
			return new ResourceLocation("manors_bounty", "textures/block/christmas_mini_gifts_blue_blue.png");
		if (blockstate == 3)
			return new ResourceLocation("manors_bounty", "textures/block/christmas_mini_gifts_blue_pink.png");
		if (blockstate == 4)
			return new ResourceLocation("manors_bounty", "textures/block/christmas_mini_gifts_blue_lucky.png");
		return new ResourceLocation("manors_bounty", "textures/block/christmas_mini_gifts_blue_red.png");
	}
}
