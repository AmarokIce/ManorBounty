package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.PrawnAndCornSoupBlockBlockModel;
import com.djinfinite.manors_bounty.block.entity.PrawnAndCornSoupBlockTileEntity;

public class PrawnAndCornSoupBlockTileRenderer extends GeoBlockRenderer<PrawnAndCornSoupBlockTileEntity> {
	public PrawnAndCornSoupBlockTileRenderer() {
		super(new PrawnAndCornSoupBlockBlockModel());
	}

	@Override
	public RenderType getRenderType(PrawnAndCornSoupBlockTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
