package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.ChristmasRibbonYellowBlockModel;
import com.djinfinite.manors_bounty.block.entity.ChristmasRibbonYellowTileEntity;

public class ChristmasRibbonYellowTileRenderer extends GeoBlockRenderer<ChristmasRibbonYellowTileEntity> {
	public ChristmasRibbonYellowTileRenderer() {
		super(new ChristmasRibbonYellowBlockModel());
	}

	@Override
	public RenderType getRenderType(ChristmasRibbonYellowTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
