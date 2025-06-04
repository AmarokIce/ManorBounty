package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.MagicCircleCarpetBlockModel;
import com.djinfinite.manors_bounty.block.entity.MagicCircleCarpetTileEntity;

public class MagicCircleCarpetTileRenderer extends GeoBlockRenderer<MagicCircleCarpetTileEntity> {
	public MagicCircleCarpetTileRenderer() {
		super(new MagicCircleCarpetBlockModel());
	}

	@Override
	public RenderType getRenderType(MagicCircleCarpetTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
