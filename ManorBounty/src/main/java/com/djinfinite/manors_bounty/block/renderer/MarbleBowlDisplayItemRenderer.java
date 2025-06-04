package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.MarbleBowlDisplayModel;
import com.djinfinite.manors_bounty.block.display.MarbleBowlDisplayItem;

public class MarbleBowlDisplayItemRenderer extends GeoItemRenderer<MarbleBowlDisplayItem> {
	public MarbleBowlDisplayItemRenderer() {
		super(new MarbleBowlDisplayModel());
	}

	@Override
	public RenderType getRenderType(MarbleBowlDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
