package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasBaublesBlueDisplayModel;
import com.djinfinite.manors_bounty.block.display.ChristmasBaublesBlueDisplayItem;

public class ChristmasBaublesBlueDisplayItemRenderer extends GeoItemRenderer<ChristmasBaublesBlueDisplayItem> {
	public ChristmasBaublesBlueDisplayItemRenderer() {
		super(new ChristmasBaublesBlueDisplayModel());
	}

	@Override
	public RenderType getRenderType(ChristmasBaublesBlueDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
