package com.djinfinite.manors_bounty.registries;

import com.djinfinite.manors_bounty.LeavesParticleType;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import com.djinfinite.manors_bounty.ManorsBountyMod;
@SuppressWarnings("unused")
public class ModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ManorsBountyMod.MOD_ID);
	public static final RegistryObject<SimpleParticleType> FEATHER = REGISTRY.register("feather", () -> new SimpleParticleType(false));
	//public static final RegistryObject<SimpleParticleType> LEAVES = REGISTRY.register("leaves", ()-> new SimpleParticleType(false));
}
