package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasBaublesRedDisplayModel;
import com.djinfinite.manors_bounty.block.display.ChristmasBaublesRedDisplayItem;

public class ChristmasBaublesRedDisplayItemRenderer extends GeoItemRenderer<ChristmasBaublesRedDisplayItem> {
	public ChristmasBaublesRedDisplayItemRenderer() {
		super(new ChristmasBaublesRedDisplayModel());
	}

	@Override
	public RenderType getRenderType(ChristmasBaublesRedDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
