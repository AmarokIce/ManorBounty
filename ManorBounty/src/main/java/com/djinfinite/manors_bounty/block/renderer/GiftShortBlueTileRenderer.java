package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftShortBlueBlockModel;
import com.djinfinite.manors_bounty.block.entity.GiftShortBlueTileEntity;

public class GiftShortBlueTileRenderer extends GeoBlockRenderer<GiftShortBlueTileEntity> {
	public GiftShortBlueTileRenderer() {
		super(new GiftShortBlueBlockModel());
	}

	@Override
	public RenderType getRenderType(GiftShortBlueTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
