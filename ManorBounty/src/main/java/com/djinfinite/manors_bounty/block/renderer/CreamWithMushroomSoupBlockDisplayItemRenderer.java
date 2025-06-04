package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.CreamWithMushroomSoupBlockDisplayModel;
import com.djinfinite.manors_bounty.block.display.CreamWithMushroomSoupBlockDisplayItem;

public class CreamWithMushroomSoupBlockDisplayItemRenderer extends GeoItemRenderer<CreamWithMushroomSoupBlockDisplayItem> {
	public CreamWithMushroomSoupBlockDisplayItemRenderer() {
		super(new CreamWithMushroomSoupBlockDisplayModel());
	}

	@Override
	public RenderType getRenderType(CreamWithMushroomSoupBlockDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
