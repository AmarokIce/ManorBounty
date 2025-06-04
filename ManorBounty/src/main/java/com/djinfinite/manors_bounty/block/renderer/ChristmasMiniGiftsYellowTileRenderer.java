package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasMiniGiftsYellowBlockModel;
import com.djinfinite.manors_bounty.block.entity.ChristmasMiniGiftsYellowTileEntity;

public class ChristmasMiniGiftsYellowTileRenderer extends GeoBlockRenderer<ChristmasMiniGiftsYellowTileEntity> {
	public ChristmasMiniGiftsYellowTileRenderer() {
		super(new ChristmasMiniGiftsYellowBlockModel());
	}

	@Override
	public RenderType getRenderType(ChristmasMiniGiftsYellowTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
