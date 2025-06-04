package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.HoundstoothInfiniteCarpetBlockModel;
import com.djinfinite.manors_bounty.block.entity.HoundstoothInfiniteCarpetTileEntity;

public class HoundstoothInfiniteCarpetTileRenderer extends GeoBlockRenderer<HoundstoothInfiniteCarpetTileEntity> {
	public HoundstoothInfiniteCarpetTileRenderer() {
		super(new HoundstoothInfiniteCarpetBlockModel());
	}

	@Override
	public RenderType getRenderType(HoundstoothInfiniteCarpetTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
