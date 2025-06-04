package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasRibbonBlueBlockModel;
import com.djinfinite.manors_bounty.block.entity.ChristmasRibbonBlueTileEntity;

public class ChristmasRibbonBlueTileRenderer extends GeoBlockRenderer<ChristmasRibbonBlueTileEntity> {
	public ChristmasRibbonBlueTileRenderer() {
		super(new ChristmasRibbonBlueBlockModel());
	}

	@Override
	public RenderType getRenderType(ChristmasRibbonBlueTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
