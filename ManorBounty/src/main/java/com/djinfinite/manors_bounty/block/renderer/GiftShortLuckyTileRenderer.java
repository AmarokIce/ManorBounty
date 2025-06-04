package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftShortLuckyBlockModel;
import com.djinfinite.manors_bounty.block.entity.GiftShortLuckyTileEntity;

public class GiftShortLuckyTileRenderer extends GeoBlockRenderer<GiftShortLuckyTileEntity> {
	public GiftShortLuckyTileRenderer() {
		super(new GiftShortLuckyBlockModel());
	}

	@Override
	public RenderType getRenderType(GiftShortLuckyTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
