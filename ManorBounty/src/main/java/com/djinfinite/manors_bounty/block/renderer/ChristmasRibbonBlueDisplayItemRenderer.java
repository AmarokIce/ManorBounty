package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasRibbonBlueDisplayModel;
import com.djinfinite.manors_bounty.block.display.ChristmasRibbonBlueDisplayItem;

public class ChristmasRibbonBlueDisplayItemRenderer extends GeoItemRenderer<ChristmasRibbonBlueDisplayItem> {
	public ChristmasRibbonBlueDisplayItemRenderer() {
		super(new ChristmasRibbonBlueDisplayModel());
	}

	@Override
	public RenderType getRenderType(ChristmasRibbonBlueDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
