package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftShortRedBlockModel;
import com.djinfinite.manors_bounty.block.entity.GiftShortRedTileEntity;

public class GiftShortRedTileRenderer extends GeoBlockRenderer<GiftShortRedTileEntity> {
	public GiftShortRedTileRenderer() {
		super(new GiftShortRedBlockModel());
	}

	@Override
	public RenderType getRenderType(GiftShortRedTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
