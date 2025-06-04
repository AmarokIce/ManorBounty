
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.djinfinite.manors_bounty.registries;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import com.djinfinite.manors_bounty.world.inventory.OvenGuiMenu;
import com.djinfinite.manors_bounty.world.inventory.IceCreamMachineGuiMenu;
import com.djinfinite.manors_bounty.world.inventory.FryerGuiMenu;
import com.djinfinite.manors_bounty.world.inventory.CuttingBoardGuiMenu;
import com.djinfinite.manors_bounty.ManorsBountyMod;
@SuppressWarnings("unused")
public class ModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ManorsBountyMod.MOD_ID);
	public static final RegistryObject<MenuType<IceCreamMachineGuiMenu>> ICE_CREAM_MACHINE_GUI = REGISTRY.register("ice_cream_machine_gui", () -> IForgeMenuType.create(IceCreamMachineGuiMenu::new));
	public static final RegistryObject<MenuType<FryerGuiMenu>> FRYER_GUI = REGISTRY.register("fryer_gui", () -> IForgeMenuType.create(FryerGuiMenu::new));
	public static final RegistryObject<MenuType<CuttingBoardGuiMenu>> CUTTING_BOARD_GUI = REGISTRY.register("cutting_board_gui", () -> IForgeMenuType.create(CuttingBoardGuiMenu::new));
	public static final RegistryObject<MenuType<OvenGuiMenu>> OVEN_GUI = REGISTRY.register("oven_gui", () -> IForgeMenuType.create(OvenGuiMenu::new));
}
