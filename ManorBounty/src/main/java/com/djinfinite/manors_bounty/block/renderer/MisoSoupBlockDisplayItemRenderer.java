package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.MisoSoupBlockDisplayModel;
import com.djinfinite.manors_bounty.block.display.MisoSoupBlockDisplayItem;

public class MisoSoupBlockDisplayItemRenderer extends GeoItemRenderer<MisoSoupBlockDisplayItem> {
	public MisoSoupBlockDisplayItemRenderer() {
		super(new MisoSoupBlockDisplayModel());
	}

	@Override
	public RenderType getRenderType(MisoSoupBlockDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
