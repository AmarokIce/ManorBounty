package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftTallLuckyBlockModel;
import com.djinfinite.manors_bounty.block.entity.GiftTallLuckyTileEntity;

public class GiftTallLuckyTileRenderer extends GeoBlockRenderer<GiftTallLuckyTileEntity> {
	public GiftTallLuckyTileRenderer() {
		super(new GiftTallLuckyBlockModel());
	}

	@Override
	public RenderType getRenderType(GiftTallLuckyTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
