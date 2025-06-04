package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftTallRedBlockModel;
import com.djinfinite.manors_bounty.block.entity.GiftTallRedTileEntity;

public class GiftTallRedTileRenderer extends GeoBlockRenderer<GiftTallRedTileEntity> {
	public GiftTallRedTileRenderer() {
		super(new GiftTallRedBlockModel());
	}

	@Override
	public RenderType getRenderType(GiftTallRedTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
