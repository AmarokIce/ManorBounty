
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.djinfinite.manors_bounty.registries;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;
@SuppressWarnings("unused")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ModEntities.LOVE_SPECTRUM_RED.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ModEntities.LOVE_SPECTRUM_YELLOW.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ModEntities.LOVE_SPECTRUM_BLUE.get(), ThrownItemRenderer::new);
	}
}
