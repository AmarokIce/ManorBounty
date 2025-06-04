
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.djinfinite.manors_bounty.registries;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import com.djinfinite.manors_bounty.client.gui.OvenGuiScreen;
import com.djinfinite.manors_bounty.client.gui.IceCreamMachineGuiScreen;
import com.djinfinite.manors_bounty.client.gui.FryerGuiScreen;
import com.djinfinite.manors_bounty.client.gui.CuttingBoardGuiScreen;
@SuppressWarnings("unused")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(ModMenus.ICE_CREAM_MACHINE_GUI.get(), IceCreamMachineGuiScreen::new);
			MenuScreens.register(ModMenus.FRYER_GUI.get(), FryerGuiScreen::new);
			MenuScreens.register(ModMenus.CUTTING_BOARD_GUI.get(), CuttingBoardGuiScreen::new);
			MenuScreens.register(ModMenus.OVEN_GUI.get(), OvenGuiScreen::new);
		});
	}
}
