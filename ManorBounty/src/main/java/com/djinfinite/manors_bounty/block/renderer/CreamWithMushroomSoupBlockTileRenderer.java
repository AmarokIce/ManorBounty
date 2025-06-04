package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.CreamWithMushroomSoupBlockBlockModel;
import com.djinfinite.manors_bounty.block.entity.CreamWithMushroomSoupBlockTileEntity;

public class CreamWithMushroomSoupBlockTileRenderer extends GeoBlockRenderer<CreamWithMushroomSoupBlockTileEntity> {
	public CreamWithMushroomSoupBlockTileRenderer() {
		super(new CreamWithMushroomSoupBlockBlockModel());
	}

	@Override
	public RenderType getRenderType(CreamWithMushroomSoupBlockTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
