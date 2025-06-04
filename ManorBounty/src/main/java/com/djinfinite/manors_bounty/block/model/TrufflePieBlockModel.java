package com.djinfinite.manors_bounty.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.block.entity.TrufflePieTileEntity;

public class TrufflePieBlockModel extends GeoModel<TrufflePieTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(TrufflePieTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "animations/big_pie_1.animation.json");
		if (blockstate == 2)
			return new ResourceLocation("manors_bounty", "animations/big_pie_2.animation.json");
		if (blockstate == 3)
			return new ResourceLocation("manors_bounty", "animations/big_pie_3.animation.json");
		if (blockstate == 4)
			return new ResourceLocation("manors_bounty", "animations/big_pie_4.animation.json");
		return new ResourceLocation("manors_bounty", "animations/big_pie_slice.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TrufflePieTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "geo/big_pie_1.geo.json");
		if (blockstate == 2)
			return new ResourceLocation("manors_bounty", "geo/big_pie_2.geo.json");
		if (blockstate == 3)
			return new ResourceLocation("manors_bounty", "geo/big_pie_3.geo.json");
		if (blockstate == 4)
			return new ResourceLocation("manors_bounty", "geo/big_pie_4.geo.json");
		return new ResourceLocation("manors_bounty", "geo/big_pie_slice.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TrufflePieTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("manors_bounty", "textures/block/truffle_pie.png");
        return new ResourceLocation("manors_bounty", "textures/block/truffle_pie.png");
	}
}
