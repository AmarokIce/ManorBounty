package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.PancakeBlockBlockModel;
import com.djinfinite.manors_bounty.block.entity.PancakeBlockTileEntity;

public class PancakeBlockTileRenderer extends GeoBlockRenderer<PancakeBlockTileEntity> {
	public PancakeBlockTileRenderer() {
		super(new PancakeBlockBlockModel());
	}

	@Override
	public RenderType getRenderType(PancakeBlockTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
