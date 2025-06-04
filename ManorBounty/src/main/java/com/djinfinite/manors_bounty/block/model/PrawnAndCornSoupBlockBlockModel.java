package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.PrawnAndCornSoupBlockTileEntity;

public class PrawnAndCornSoupBlockBlockModel extends GeoModel<PrawnAndCornSoupBlockTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(PrawnAndCornSoupBlockTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/prawn_and_corn_soup.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PrawnAndCornSoupBlockTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/prawn_and_corn_soup.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PrawnAndCornSoupBlockTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/prawn_and_corn_soup_block.png");
	}
}
