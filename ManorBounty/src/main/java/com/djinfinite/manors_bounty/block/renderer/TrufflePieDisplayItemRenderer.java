package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.TrufflePieDisplayModel;
import com.djinfinite.manors_bounty.block.display.TrufflePieDisplayItem;

public class TrufflePieDisplayItemRenderer extends GeoItemRenderer<TrufflePieDisplayItem> {
	public TrufflePieDisplayItemRenderer() {
		super(new TrufflePieDisplayModel());
	}

	@Override
	public RenderType getRenderType(TrufflePieDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
