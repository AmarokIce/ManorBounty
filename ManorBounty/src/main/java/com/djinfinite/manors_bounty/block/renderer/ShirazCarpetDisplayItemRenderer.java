package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ShirazCarpetDisplayModel;
import com.djinfinite.manors_bounty.block.display.ShirazCarpetDisplayItem;

public class ShirazCarpetDisplayItemRenderer extends GeoItemRenderer<ShirazCarpetDisplayItem> {
	public ShirazCarpetDisplayItemRenderer() {
		super(new ShirazCarpetDisplayModel());
	}

	@Override
	public RenderType getRenderType(ShirazCarpetDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
