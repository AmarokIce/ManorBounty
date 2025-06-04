package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasRibbonWhiteDisplayModel;
import com.djinfinite.manors_bounty.block.display.ChristmasRibbonWhiteDisplayItem;

public class ChristmasRibbonWhiteDisplayItemRenderer extends GeoItemRenderer<ChristmasRibbonWhiteDisplayItem> {
	public ChristmasRibbonWhiteDisplayItemRenderer() {
		super(new ChristmasRibbonWhiteDisplayModel());
	}

	@Override
	public RenderType getRenderType(ChristmasRibbonWhiteDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
