package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasBaublesWhiteDisplayModel;
import com.djinfinite.manors_bounty.block.display.ChristmasBaublesWhiteDisplayItem;

public class ChristmasBaublesWhiteDisplayItemRenderer extends GeoItemRenderer<ChristmasBaublesWhiteDisplayItem> {
	public ChristmasBaublesWhiteDisplayItemRenderer() {
		super(new ChristmasBaublesWhiteDisplayModel());
	}

	@Override
	public RenderType getRenderType(ChristmasBaublesWhiteDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
