package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.CherriesPieBlockModel;
import com.djinfinite.manors_bounty.block.entity.CherriesPieTileEntity;

public class CherriesPieTileRenderer extends GeoBlockRenderer<CherriesPieTileEntity> {
	public CherriesPieTileRenderer() {
		super(new CherriesPieBlockModel());
	}

	@Override
	public RenderType getRenderType(CherriesPieTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
