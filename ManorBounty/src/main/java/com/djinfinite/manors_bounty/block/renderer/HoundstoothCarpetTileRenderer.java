package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.HoundstoothCarpetBlockModel;
import com.djinfinite.manors_bounty.block.entity.HoundstoothCarpetTileEntity;

public class HoundstoothCarpetTileRenderer extends GeoBlockRenderer<HoundstoothCarpetTileEntity> {
	public HoundstoothCarpetTileRenderer() {
		super(new HoundstoothCarpetBlockModel());
	}

	@Override
	public RenderType getRenderType(HoundstoothCarpetTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
