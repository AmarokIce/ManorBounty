package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasWreathsDisplayModel;
import com.djinfinite.manors_bounty.block.display.ChristmasWreathsDisplayItem;

public class ChristmasWreathsDisplayItemRenderer extends GeoItemRenderer<ChristmasWreathsDisplayItem> {
	public ChristmasWreathsDisplayItemRenderer() {
		super(new ChristmasWreathsDisplayModel());
	}

	@Override
	public RenderType getRenderType(ChristmasWreathsDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
