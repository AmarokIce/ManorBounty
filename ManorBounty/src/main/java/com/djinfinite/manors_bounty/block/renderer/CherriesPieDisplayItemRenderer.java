package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.CherriesPieDisplayModel;
import com.djinfinite.manors_bounty.block.display.CherriesPieDisplayItem;

public class CherriesPieDisplayItemRenderer extends GeoItemRenderer<CherriesPieDisplayItem> {
	public CherriesPieDisplayItemRenderer() {
		super(new CherriesPieDisplayModel());
	}

	@Override
	public RenderType getRenderType(CherriesPieDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
