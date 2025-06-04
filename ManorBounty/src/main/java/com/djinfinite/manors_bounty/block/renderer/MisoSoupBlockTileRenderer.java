package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.MisoSoupBlockBlockModel;
import com.djinfinite.manors_bounty.block.entity.MisoSoupBlockTileEntity;

public class MisoSoupBlockTileRenderer extends GeoBlockRenderer<MisoSoupBlockTileEntity> {
	public MisoSoupBlockTileRenderer() {
		super(new MisoSoupBlockBlockModel());
	}

	@Override
	public RenderType getRenderType(MisoSoupBlockTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
