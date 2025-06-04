package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasBaublesYellowBlockModel;
import com.djinfinite.manors_bounty.block.entity.ChristmasBaublesYellowTileEntity;

public class ChristmasBaublesYellowTileRenderer extends GeoBlockRenderer<ChristmasBaublesYellowTileEntity> {
	public ChristmasBaublesYellowTileRenderer() {
		super(new ChristmasBaublesYellowBlockModel());
	}

	@Override
	public RenderType getRenderType(ChristmasBaublesYellowTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
