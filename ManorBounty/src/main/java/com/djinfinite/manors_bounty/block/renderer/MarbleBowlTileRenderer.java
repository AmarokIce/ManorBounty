package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.MarbleBowlBlockModel;
import com.djinfinite.manors_bounty.block.entity.MarbleBowlTileEntity;

public class MarbleBowlTileRenderer extends GeoBlockRenderer<MarbleBowlTileEntity> {
	public MarbleBowlTileRenderer() {
		super(new MarbleBowlBlockModel());
	}

	@Override
	public RenderType getRenderType(MarbleBowlTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
