package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasMiniGiftsRedBlockModel;
import com.djinfinite.manors_bounty.block.entity.ChristmasMiniGiftsRedTileEntity;

public class ChristmasMiniGiftsRedTileRenderer extends GeoBlockRenderer<ChristmasMiniGiftsRedTileEntity> {
	public ChristmasMiniGiftsRedTileRenderer() {
		super(new ChristmasMiniGiftsRedBlockModel());
	}

	@Override
	public RenderType getRenderType(ChristmasMiniGiftsRedTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
