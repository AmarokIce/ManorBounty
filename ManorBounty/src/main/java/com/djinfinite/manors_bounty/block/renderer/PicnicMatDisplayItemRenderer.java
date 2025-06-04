package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.PicnicMatDisplayModel;
import com.djinfinite.manors_bounty.block.display.PicnicMatDisplayItem;

public class PicnicMatDisplayItemRenderer extends GeoItemRenderer<PicnicMatDisplayItem> {
	public PicnicMatDisplayItemRenderer() {
		super(new PicnicMatDisplayModel());
	}

	@Override
	public RenderType getRenderType(PicnicMatDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
