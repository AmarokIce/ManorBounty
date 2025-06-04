package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.PicnicMatBlockModel;
import com.djinfinite.manors_bounty.block.entity.PicnicMatTileEntity;

public class PicnicMatTileRenderer extends GeoBlockRenderer<PicnicMatTileEntity> {
	public PicnicMatTileRenderer() {
		super(new PicnicMatBlockModel());
	}

	@Override
	public RenderType getRenderType(PicnicMatTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
