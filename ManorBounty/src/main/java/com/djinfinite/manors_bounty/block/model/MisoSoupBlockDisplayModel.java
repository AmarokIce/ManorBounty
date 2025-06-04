package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.MisoSoupBlockDisplayItem;

public class MisoSoupBlockDisplayModel extends GeoModel<MisoSoupBlockDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MisoSoupBlockDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/miso_soup.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MisoSoupBlockDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/miso_soup.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MisoSoupBlockDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/miso_soup_block.png");
	}
}
