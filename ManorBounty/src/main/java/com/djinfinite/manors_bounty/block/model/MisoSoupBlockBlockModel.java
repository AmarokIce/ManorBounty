package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.MisoSoupBlockTileEntity;

public class MisoSoupBlockBlockModel extends GeoModel<MisoSoupBlockTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MisoSoupBlockTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "animations/miso_soup.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MisoSoupBlockTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "geo/miso_soup.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MisoSoupBlockTileEntity animatable) {
		return new ResourceLocation("manors_bounty", "textures/block/miso_soup_block.png");
	}
}
