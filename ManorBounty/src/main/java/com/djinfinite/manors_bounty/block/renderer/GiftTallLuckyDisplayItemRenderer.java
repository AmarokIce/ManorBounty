package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.GiftTallLuckyDisplayModel;
import com.djinfinite.manors_bounty.block.display.GiftTallLuckyDisplayItem;

public class GiftTallLuckyDisplayItemRenderer extends GeoItemRenderer<GiftTallLuckyDisplayItem> {
	public GiftTallLuckyDisplayItemRenderer() {
		super(new GiftTallLuckyDisplayModel());
	}

	@Override
	public RenderType getRenderType(GiftTallLuckyDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
