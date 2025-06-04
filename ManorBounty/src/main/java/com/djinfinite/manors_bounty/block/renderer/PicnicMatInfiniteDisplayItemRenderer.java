package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.PicnicMatInfiniteDisplayModel;
import com.djinfinite.manors_bounty.block.display.PicnicMatInfiniteDisplayItem;

public class PicnicMatInfiniteDisplayItemRenderer extends GeoItemRenderer<PicnicMatInfiniteDisplayItem> {
	public PicnicMatInfiniteDisplayItemRenderer() {
		super(new PicnicMatInfiniteDisplayModel());
	}

	@Override
	public RenderType getRenderType(PicnicMatInfiniteDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
