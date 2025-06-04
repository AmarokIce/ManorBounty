package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasBaublesBlueBlockModel;
import com.djinfinite.manors_bounty.block.entity.ChristmasBaublesBlueTileEntity;

public class ChristmasBaublesBlueTileRenderer extends GeoBlockRenderer<ChristmasBaublesBlueTileEntity> {
	public ChristmasBaublesBlueTileRenderer() {
		super(new ChristmasBaublesBlueBlockModel());
	}

	@Override
	public RenderType getRenderType(ChristmasBaublesBlueTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
