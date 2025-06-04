package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftTallPinkBlockModel;
import com.djinfinite.manors_bounty.block.entity.GiftTallPinkTileEntity;

public class GiftTallPinkTileRenderer extends GeoBlockRenderer<GiftTallPinkTileEntity> {
	public GiftTallPinkTileRenderer() {
		super(new GiftTallPinkBlockModel());
	}

	@Override
	public RenderType getRenderType(GiftTallPinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
