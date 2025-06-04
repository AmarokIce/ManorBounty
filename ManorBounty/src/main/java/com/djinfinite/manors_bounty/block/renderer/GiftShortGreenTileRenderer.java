package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftShortGreenBlockModel;
import com.djinfinite.manors_bounty.block.entity.GiftShortGreenTileEntity;

public class GiftShortGreenTileRenderer extends GeoBlockRenderer<GiftShortGreenTileEntity> {
	public GiftShortGreenTileRenderer() {
		super(new GiftShortGreenBlockModel());
	}

	@Override
	public RenderType getRenderType(GiftShortGreenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
