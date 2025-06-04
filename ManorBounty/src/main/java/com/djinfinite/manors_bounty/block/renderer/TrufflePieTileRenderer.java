package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.TrufflePieBlockModel;
import com.djinfinite.manors_bounty.block.entity.TrufflePieTileEntity;

public class TrufflePieTileRenderer extends GeoBlockRenderer<TrufflePieTileEntity> {
	public TrufflePieTileRenderer() {
		super(new TrufflePieBlockModel());
	}

	@Override
	public RenderType getRenderType(TrufflePieTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
