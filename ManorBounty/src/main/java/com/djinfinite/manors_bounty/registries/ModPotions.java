
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.djinfinite.manors_bounty.registries;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import com.djinfinite.manors_bounty.ManorsBountyMod;
@SuppressWarnings("unused")
public class ModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, ManorsBountyMod.MOD_ID);
	public static final RegistryObject<Potion> EFFECT_HAUNTING_POTION = REGISTRY.register("effect_haunting_potion", () -> new Potion(new MobEffectInstance(ModMobEffects.EFFECT_HAUNTING.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> HYPOTHERMIA_POTION = REGISTRY.register("hypothermia_potion", () -> new Potion(new MobEffectInstance(ModMobEffects.HYPOTHERMIA.get(), 900, 0, false, true)));
}
