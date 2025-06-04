package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.HoundstoothCarpetDisplayModel;
import com.djinfinite.manors_bounty.block.display.HoundstoothCarpetDisplayItem;

public class HoundstoothCarpetDisplayItemRenderer extends GeoItemRenderer<HoundstoothCarpetDisplayItem> {
	public HoundstoothCarpetDisplayItemRenderer() {
		super(new HoundstoothCarpetDisplayModel());
	}

	@Override
	public RenderType getRenderType(HoundstoothCarpetDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
