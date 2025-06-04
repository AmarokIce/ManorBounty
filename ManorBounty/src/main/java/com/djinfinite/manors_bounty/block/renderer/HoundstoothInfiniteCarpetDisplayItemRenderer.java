package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.HoundstoothInfiniteCarpetDisplayModel;
import com.djinfinite.manors_bounty.block.display.HoundstoothInfiniteCarpetDisplayItem;

public class HoundstoothInfiniteCarpetDisplayItemRenderer extends GeoItemRenderer<HoundstoothInfiniteCarpetDisplayItem> {
	public HoundstoothInfiniteCarpetDisplayItemRenderer() {
		super(new HoundstoothInfiniteCarpetDisplayModel());
	}

	@Override
	public RenderType getRenderType(HoundstoothInfiniteCarpetDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
