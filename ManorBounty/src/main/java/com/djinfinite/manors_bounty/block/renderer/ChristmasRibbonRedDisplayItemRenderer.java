package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasRibbonRedDisplayModel;
import com.djinfinite.manors_bounty.block.display.ChristmasRibbonRedDisplayItem;

public class ChristmasRibbonRedDisplayItemRenderer extends GeoItemRenderer<ChristmasRibbonRedDisplayItem> {
	public ChristmasRibbonRedDisplayItemRenderer() {
		super(new ChristmasRibbonRedDisplayModel());
	}

	@Override
	public RenderType getRenderType(ChristmasRibbonRedDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
