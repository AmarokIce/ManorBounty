package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.display.DragonFruitSliceBlockDisplayItem;

public class DragonFruitSliceBlockDisplayModel extends GeoModel<DragonFruitSliceBlockDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DragonFruitSliceBlockDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "animations/dragon_fruit_slice_block.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DragonFruitSliceBlockDisplayItem animatable) {
		return new ResourceLocation("manors_bounty", "geo/dragon_fruit_slice_block.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DragonFruitSliceBlockDisplayItem entity) {
		return new ResourceLocation("manors_bounty", "textures/block/dragon_fruit_slice_block_1.png");
	}
}
