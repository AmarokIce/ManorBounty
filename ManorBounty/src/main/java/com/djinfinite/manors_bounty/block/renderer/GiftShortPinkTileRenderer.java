package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftShortPinkBlockModel;
import com.djinfinite.manors_bounty.block.entity.GiftShortPinkTileEntity;

public class GiftShortPinkTileRenderer extends GeoBlockRenderer<GiftShortPinkTileEntity> {
	public GiftShortPinkTileRenderer() {
		super(new GiftShortPinkBlockModel());
	}

	@Override
	public RenderType getRenderType(GiftShortPinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
