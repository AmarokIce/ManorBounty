package com.djinfinite.manors_bounty.registries;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;
import com.djinfinite.manors_bounty.configuration.CommonConfig;
import com.djinfinite.manors_bounty.ManorsBountyMod;
@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = ManorsBountyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FruitsEffectConfig.SPEC, "manors_bounty.fruit_effect_config.toml");
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC, "manors_bounty.common_config.toml");
		});
	}
}
