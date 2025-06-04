package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasBaublesRedBlockModel;
import com.djinfinite.manors_bounty.block.entity.ChristmasBaublesRedTileEntity;

public class ChristmasBaublesRedTileRenderer extends GeoBlockRenderer<ChristmasBaublesRedTileEntity> {
	public ChristmasBaublesRedTileRenderer() {
		super(new ChristmasBaublesRedBlockModel());
	}

	@Override
	public RenderType getRenderType(ChristmasBaublesRedTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
