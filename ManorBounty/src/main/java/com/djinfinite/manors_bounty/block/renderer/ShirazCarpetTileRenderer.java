package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ShirazCarpetBlockModel;
import com.djinfinite.manors_bounty.block.entity.ShirazCarpetTileEntity;

public class ShirazCarpetTileRenderer extends GeoBlockRenderer<ShirazCarpetTileEntity> {
	public ShirazCarpetTileRenderer() {
		super(new ShirazCarpetBlockModel());
	}

	@Override
	public RenderType getRenderType(ShirazCarpetTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
