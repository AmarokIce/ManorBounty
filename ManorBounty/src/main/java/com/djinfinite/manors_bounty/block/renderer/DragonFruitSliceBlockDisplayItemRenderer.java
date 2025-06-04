package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.DragonFruitSliceBlockDisplayModel;
import com.djinfinite.manors_bounty.block.display.DragonFruitSliceBlockDisplayItem;

public class DragonFruitSliceBlockDisplayItemRenderer extends GeoItemRenderer<DragonFruitSliceBlockDisplayItem> {
	public DragonFruitSliceBlockDisplayItemRenderer() {
		super(new DragonFruitSliceBlockDisplayModel());
	}

	@Override
	public RenderType getRenderType(DragonFruitSliceBlockDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
