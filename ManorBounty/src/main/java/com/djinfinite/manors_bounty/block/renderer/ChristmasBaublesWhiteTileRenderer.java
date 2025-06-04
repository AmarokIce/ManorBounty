package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasBaublesWhiteBlockModel;
import com.djinfinite.manors_bounty.block.entity.ChristmasBaublesWhiteTileEntity;

public class ChristmasBaublesWhiteTileRenderer extends GeoBlockRenderer<ChristmasBaublesWhiteTileEntity> {
	public ChristmasBaublesWhiteTileRenderer() {
		super(new ChristmasBaublesWhiteBlockModel());
	}

	@Override
	public RenderType getRenderType(ChristmasBaublesWhiteTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
