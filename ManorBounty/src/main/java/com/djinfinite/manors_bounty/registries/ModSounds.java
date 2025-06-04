
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.djinfinite.manors_bounty.registries;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import com.djinfinite.manors_bounty.ManorsBountyMod;
@SuppressWarnings("unused")
public class ModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ManorsBountyMod.MOD_ID);
	public static final RegistryObject<SoundEvent> PRISM_IV_BEAT = REGISTRY.register("prism_iv_beat", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("manors_bounty", "prism_iv_beat")));
	public static final RegistryObject<SoundEvent> PRISM_IV_SHOOT = REGISTRY.register("prism_iv_shoot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("manors_bounty", "prism_iv_shoot")));
	public static final RegistryObject<SoundEvent> NEON_USING = REGISTRY.register("neon_using", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("manors_bounty", "neon_using")));
	public static final RegistryObject<SoundEvent> WAO = REGISTRY.register("wao", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("manors_bounty", "wao")));
	public static final RegistryObject<SoundEvent> WAOOOOO = REGISTRY.register("waooooo", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("manors_bounty", "waooooo")));
	public static final RegistryObject<SoundEvent> ICE_CREAM_MACHINE_TYPE_ITEM = REGISTRY.register("ice_cream_machine_type_item", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("manors_bounty", "ice_cream_machine_type_item")));
	public static final RegistryObject<SoundEvent> FRYING = REGISTRY.register("frying", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("manors_bounty", "frying")));
	public static final RegistryObject<SoundEvent> OVEN_WORKING = REGISTRY.register("oven_working", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("manors_bounty", "oven_working")));
	public static final RegistryObject<SoundEvent> OVEN_DING = REGISTRY.register("oven_ding", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("manors_bounty", "oven_ding")));
}
