package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasRibbonWhiteBlockModel;
import com.djinfinite.manors_bounty.block.entity.ChristmasRibbonWhiteTileEntity;

public class ChristmasRibbonWhiteTileRenderer extends GeoBlockRenderer<ChristmasRibbonWhiteTileEntity> {
	public ChristmasRibbonWhiteTileRenderer() {
		super(new ChristmasRibbonWhiteBlockModel());
	}

	@Override
	public RenderType getRenderType(ChristmasRibbonWhiteTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
