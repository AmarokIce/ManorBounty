package com.djinfinite.manors_bounty.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.djinfinite.manors_bounty.block.model.DragonFruitSliceBlockBlockModel;
import com.djinfinite.manors_bounty.block.entity.DragonFruitSliceBlockTileEntity;

public class DragonFruitSliceBlockTileRenderer extends GeoBlockRenderer<DragonFruitSliceBlockTileEntity> {
	public DragonFruitSliceBlockTileRenderer() {
		super(new DragonFruitSliceBlockBlockModel());
	}

	@Override
	public RenderType getRenderType(DragonFruitSliceBlockTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
