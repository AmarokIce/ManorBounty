package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.PicnicMatInfiniteBlockModel;
import com.djinfinite.manors_bounty.block.entity.PicnicMatInfiniteTileEntity;

public class PicnicMatInfiniteTileRenderer extends GeoBlockRenderer<PicnicMatInfiniteTileEntity> {
	public PicnicMatInfiniteTileRenderer() {
		super(new PicnicMatInfiniteBlockModel());
	}

	@Override
	public RenderType getRenderType(PicnicMatInfiniteTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
