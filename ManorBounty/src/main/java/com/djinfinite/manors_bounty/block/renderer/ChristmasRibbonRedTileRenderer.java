package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasRibbonRedBlockModel;
import com.djinfinite.manors_bounty.block.entity.ChristmasRibbonRedTileEntity;

public class ChristmasRibbonRedTileRenderer extends GeoBlockRenderer<ChristmasRibbonRedTileEntity> {
	public ChristmasRibbonRedTileRenderer() {
		super(new ChristmasRibbonRedBlockModel());
	}

	@Override
	public RenderType getRenderType(ChristmasRibbonRedTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
