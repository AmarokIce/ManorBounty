package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.PrawnAndCornSoupBlockDisplayModel;
import com.djinfinite.manors_bounty.block.display.PrawnAndCornSoupBlockDisplayItem;

public class PrawnAndCornSoupBlockDisplayItemRenderer extends GeoItemRenderer<PrawnAndCornSoupBlockDisplayItem> {
	public PrawnAndCornSoupBlockDisplayItemRenderer() {
		super(new PrawnAndCornSoupBlockDisplayModel());
	}

	@Override
	public RenderType getRenderType(PrawnAndCornSoupBlockDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
