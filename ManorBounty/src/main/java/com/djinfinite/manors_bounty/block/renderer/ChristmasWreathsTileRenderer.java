package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasWreathsBlockModel;
import com.djinfinite.manors_bounty.block.entity.ChristmasWreathsTileEntity;

public class ChristmasWreathsTileRenderer extends GeoBlockRenderer<ChristmasWreathsTileEntity> {
	public ChristmasWreathsTileRenderer() {
		super(new ChristmasWreathsBlockModel());
	}

	@Override
	public RenderType getRenderType(ChristmasWreathsTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
