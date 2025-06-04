package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.HoundstoothInfiniteCarpetTileEntity;

public class HoundstoothInfiniteCarpetBlockModel extends GeoModel<HoundstoothInfiniteCarpetTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(HoundstoothInfiniteCarpetTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "animations/16x_normal_carpet.animation.json");
		if (blockstate == 2)
			return new ResourceLocation("manors_bounty", "animations/16x_normal_carpet.animation.json");
		if (blockstate == 3)
			return new ResourceLocation("manors_bounty", "animations/16x_normal_carpet.animation.json");
		if (blockstate == 4)
			return new ResourceLocation("manors_bounty", "animations/16x_normal_carpet.animation.json");
		if (blockstate == 5)
			return new ResourceLocation("manors_bounty", "animations/16x_normal_carpet.animation.json");
		if (blockstate == 6)
			return new ResourceLocation("manors_bounty", "animations/16x_normal_carpet.animation.json");
		if (blockstate == 7)
			return new ResourceLocation("manors_bounty", "animations/16x_normal_carpet.animation.json");
		if (blockstate == 8)
			return new ResourceLocation("manors_bounty", "animations/16x_normal_carpet.animation.json");
		if (blockstate == 9)
			return new ResourceLocation("manors_bounty", "animations/16x_normal_carpet.animation.json");
		if (blockstate == 10)
			return new ResourceLocation("manors_bounty", "animations/16x_normal_carpet.animation.json");
		if (blockstate == 11)
			return new ResourceLocation("manors_bounty", "animations/16x_normal_carpet.animation.json");
		if (blockstate == 12)
			return new ResourceLocation("manors_bounty", "animations/16x_normal_carpet.animation.json");
        return new ResourceLocation("manors_bounty", "animations/16x_normal_carpet.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HoundstoothInfiniteCarpetTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "geo/16x_normal_carpet.geo.json");
		if (blockstate == 2)
			return new ResourceLocation("manors_bounty", "geo/16x_normal_carpet.geo.json");
		if (blockstate == 3)
			return new ResourceLocation("manors_bounty", "geo/16x_normal_carpet.geo.json");
		if (blockstate == 4)
			return new ResourceLocation("manors_bounty", "geo/16x_normal_carpet.geo.json");
		if (blockstate == 5)
			return new ResourceLocation("manors_bounty", "geo/16x_normal_carpet.geo.json");
		if (blockstate == 6)
			return new ResourceLocation("manors_bounty", "geo/16x_normal_carpet.geo.json");
		if (blockstate == 7)
			return new ResourceLocation("manors_bounty", "geo/16x_normal_carpet.geo.json");
		if (blockstate == 8)
			return new ResourceLocation("manors_bounty", "geo/16x_normal_carpet.geo.json");
		if (blockstate == 9)
			return new ResourceLocation("manors_bounty", "geo/16x_normal_carpet.geo.json");
		if (blockstate == 10)
			return new ResourceLocation("manors_bounty", "geo/16x_normal_carpet.geo.json");
		if (blockstate == 11)
			return new ResourceLocation("manors_bounty", "geo/16x_normal_carpet.geo.json");
		if (blockstate == 12)
			return new ResourceLocation("manors_bounty", "geo/16x_normal_carpet.geo.json");
        return new ResourceLocation("manors_bounty", "geo/16x_normal_carpet.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HoundstoothInfiniteCarpetTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "textures/block/houndstooth_infinite_carpet_upleft.png");
		if (blockstate == 2)
			return new ResourceLocation("manors_bounty", "textures/block/houndstooth_infinite_carpet_upup.png");
		if (blockstate == 3)
			return new ResourceLocation("manors_bounty", "textures/block/houndstooth_infinite_carpet_upright.png");
		if (blockstate == 4)
			return new ResourceLocation("manors_bounty", "textures/block/houndstooth_infinite_carpet_leftleft.png");
		if (blockstate == 5)
			return new ResourceLocation("manors_bounty", "textures/block/houndstooth_infinite_carpet_middle.png");
		if (blockstate == 6)
			return new ResourceLocation("manors_bounty", "textures/block/houndstooth_infinite_carpet_rightright.png");
		if (blockstate == 7)
			return new ResourceLocation("manors_bounty", "textures/block/houndstooth_infinite_carpet_downleft.png");
		if (blockstate == 8)
			return new ResourceLocation("manors_bounty", "textures/block/houndstooth_infinite_carpet_downdown.png");
		if (blockstate == 9)
			return new ResourceLocation("manors_bounty", "textures/block/houndstooth_infinite_carpet_downright.png");
		if (blockstate == 10)
			return new ResourceLocation("manors_bounty", "textures/block/houndstooth_infinite_carpet_up.png");
		if (blockstate == 11)
			return new ResourceLocation("manors_bounty", "textures/block/houndstooth_infinite_carpet_updown.png");
		if (blockstate == 12)
			return new ResourceLocation("manors_bounty", "textures/block/houndstooth_infinite_carpet_down.png");
		if (blockstate == 13)
			return new ResourceLocation("manors_bounty", "textures/block/houndstooth_infinite_carpet_left.png");
		if (blockstate == 14)
			return new ResourceLocation("manors_bounty", "textures/block/houndstooth_infinite_carpet_leftright.png");
		if (blockstate == 15)
			return new ResourceLocation("manors_bounty", "textures/block/houndstooth_infinite_carpet_right.png");
		return new ResourceLocation("manors_bounty", "textures/block/houndstooth_infinite_carpet.png");
	}
}
