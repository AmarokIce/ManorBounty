package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftTallBlueBlockModel;
import com.djinfinite.manors_bounty.block.entity.GiftTallBlueTileEntity;

public class GiftTallBlueTileRenderer extends GeoBlockRenderer<GiftTallBlueTileEntity> {
	public GiftTallBlueTileRenderer() {
		super(new GiftTallBlueBlockModel());
	}

	@Override
	public RenderType getRenderType(GiftTallBlueTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
