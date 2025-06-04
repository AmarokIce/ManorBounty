package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftTallGreenBlockModel;
import com.djinfinite.manors_bounty.block.entity.GiftTallGreenTileEntity;

public class GiftTallGreenTileRenderer extends GeoBlockRenderer<GiftTallGreenTileEntity> {
	public GiftTallGreenTileRenderer() {
		super(new GiftTallGreenBlockModel());
	}

	@Override
	public RenderType getRenderType(GiftTallGreenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
