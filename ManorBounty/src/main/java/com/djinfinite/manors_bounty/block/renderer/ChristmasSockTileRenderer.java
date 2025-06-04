package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasSockBlockModel;
import com.djinfinite.manors_bounty.block.entity.ChristmasSockTileEntity;

public class ChristmasSockTileRenderer extends GeoBlockRenderer<ChristmasSockTileEntity> {
	public ChristmasSockTileRenderer() {
		super(new ChristmasSockBlockModel());
	}

	@Override
	public RenderType getRenderType(ChristmasSockTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
