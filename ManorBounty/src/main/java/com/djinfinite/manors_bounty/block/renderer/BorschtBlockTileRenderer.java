package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.BorschtBlockBlockModel;
import com.djinfinite.manors_bounty.block.entity.BorschtBlockTileEntity;

public class BorschtBlockTileRenderer extends GeoBlockRenderer<BorschtBlockTileEntity> {
	public BorschtBlockTileRenderer() {
		super(new BorschtBlockBlockModel());
	}

	@Override
	public RenderType getRenderType(BorschtBlockTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
