package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.DragonFruitSliceBlockTileEntity;

public class DragonFruitSliceBlockBlockModel extends GeoModel<DragonFruitSliceBlockTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(DragonFruitSliceBlockTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "animations/dragon_fruit_slice_block.animation.json");
		if (blockstate == 2)
			return new ResourceLocation("manors_bounty", "animations/dragon_fruit_slice_block.animation.json");
        return new ResourceLocation("manors_bounty", "animations/dragon_fruit_slice_block.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DragonFruitSliceBlockTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "geo/dragon_fruit_slice_block.geo.json");
		if (blockstate == 2)
			return new ResourceLocation("manors_bounty", "geo/dragon_fruit_slice_block.geo.json");
        return new ResourceLocation("manors_bounty", "geo/dragon_fruit_slice_block.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DragonFruitSliceBlockTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "textures/block/dragon_fruit_slice_block_2.png");
		if (blockstate == 2)
			return new ResourceLocation("manors_bounty", "textures/block/dragon_fruit_slice_block_3.png");
		if (blockstate == 3)
			return new ResourceLocation("manors_bounty", "textures/block/dragon_fruit_slice_block_4.png");
		if (blockstate == 4)
			return new ResourceLocation("manors_bounty", "textures/block/dragon_fruit_slice_block_5.png");
		if (blockstate == 5)
			return new ResourceLocation("manors_bounty", "textures/block/dragon_fruit_slice_block_6.png");
		return new ResourceLocation("manors_bounty", "textures/block/dragon_fruit_slice_block_1.png");
	}
}
