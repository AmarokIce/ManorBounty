package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasSockDisplayModel;
import com.djinfinite.manors_bounty.block.display.ChristmasSockDisplayItem;

public class ChristmasSockDisplayItemRenderer extends GeoItemRenderer<ChristmasSockDisplayItem> {
	public ChristmasSockDisplayItemRenderer() {
		super(new ChristmasSockDisplayModel());
	}

	@Override
	public RenderType getRenderType(ChristmasSockDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
