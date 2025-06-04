package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.PancakeBlockDisplayModel;
import com.djinfinite.manors_bounty.block.display.PancakeBlockDisplayItem;

public class PancakeBlockDisplayItemRenderer extends GeoItemRenderer<PancakeBlockDisplayItem> {
	public PancakeBlockDisplayItemRenderer() {
		super(new PancakeBlockDisplayModel());
	}

	@Override
	public RenderType getRenderType(PancakeBlockDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
