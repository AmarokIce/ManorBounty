package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.CreamWithMushroomSoupBlockTileEntity;

public class CreamWithMushroomSoupBlockBlockModel extends GeoModel<CreamWithMushroomSoupBlockTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(CreamWithMushroomSoupBlockTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/cream_with_mushroom_soup.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CreamWithMushroomSoupBlockTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/cream_with_mushroom_soup.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CreamWithMushroomSoupBlockTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/cream_with_mushroom_soup_block.png");
	}
}
