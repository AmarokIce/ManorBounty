package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.BorschtBlockDisplayModel;
import com.djinfinite.manors_bounty.block.display.BorschtBlockDisplayItem;

public class BorschtBlockDisplayItemRenderer extends GeoItemRenderer<BorschtBlockDisplayItem> {
	public BorschtBlockDisplayItemRenderer() {
		super(new BorschtBlockDisplayModel());
	}

	@Override
	public RenderType getRenderType(BorschtBlockDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
