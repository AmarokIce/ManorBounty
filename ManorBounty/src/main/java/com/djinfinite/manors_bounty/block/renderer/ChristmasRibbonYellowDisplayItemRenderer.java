package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasRibbonYellowDisplayModel;
import com.djinfinite.manors_bounty.block.display.ChristmasRibbonYellowDisplayItem;

public class ChristmasRibbonYellowDisplayItemRenderer extends GeoItemRenderer<ChristmasRibbonYellowDisplayItem> {
	public ChristmasRibbonYellowDisplayItemRenderer() {
		super(new ChristmasRibbonYellowDisplayModel());
	}

	@Override
	public RenderType getRenderType(ChristmasRibbonYellowDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
