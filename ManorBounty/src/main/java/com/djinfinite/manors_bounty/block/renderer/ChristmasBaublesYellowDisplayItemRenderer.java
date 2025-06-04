package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasBaublesYellowDisplayModel;
import com.djinfinite.manors_bounty.block.display.ChristmasBaublesYellowDisplayItem;

public class ChristmasBaublesYellowDisplayItemRenderer extends GeoItemRenderer<ChristmasBaublesYellowDisplayItem> {
	public ChristmasBaublesYellowDisplayItemRenderer() {
		super(new ChristmasBaublesYellowDisplayModel());
	}

	@Override
	public RenderType getRenderType(ChristmasBaublesYellowDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
