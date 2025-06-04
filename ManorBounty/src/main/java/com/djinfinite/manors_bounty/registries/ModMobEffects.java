
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.djinfinite.manors_bounty.registries;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import com.djinfinite.manors_bounty.potion.WarmShieldMobEffect;
import com.djinfinite.manors_bounty.potion.TransmitMobEffect;
import com.djinfinite.manors_bounty.potion.ToughAsNutMobEffect;
import com.djinfinite.manors_bounty.potion.SummerHeatwaveMobEffect;
import com.djinfinite.manors_bounty.potion.SeaTouchMobEffect;
import com.djinfinite.manors_bounty.potion.RutinLemoneneMobEffect;
import com.djinfinite.manors_bounty.potion.RosaHedgeMobEffect;
import com.djinfinite.manors_bounty.potion.OriginalEvolutionMobEffect;
import com.djinfinite.manors_bounty.potion.OriginalEvolutionMetamorphosisMobEffect;
import com.djinfinite.manors_bounty.potion.MomentaryMeteorMobEffect;
import com.djinfinite.manors_bounty.potion.MelonGravityMobEffect;
import com.djinfinite.manors_bounty.potion.LurkingDangerMobEffect;
import com.djinfinite.manors_bounty.potion.LavenderMoodMobEffect;
import com.djinfinite.manors_bounty.potion.KiwingWhereaboutsMobEffect;
import com.djinfinite.manors_bounty.potion.HypothermiaMobEffect;
import com.djinfinite.manors_bounty.potion.HackedThornsMobEffect;
import com.djinfinite.manors_bounty.potion.EffectHauntingMobEffect;
import com.djinfinite.manors_bounty.potion.CherryBlossomsWeeping;
import com.djinfinite.manors_bounty.potion.BurstingBerryMobEffect;
import com.djinfinite.manors_bounty.potion.BerryBloodMobEffect;
import com.djinfinite.manors_bounty.ManorsBountyMod;
@SuppressWarnings("unused")
public class ModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ManorsBountyMod.MOD_ID);
	public static final RegistryObject<MobEffect> EFFECT_HAUNTING = REGISTRY.register("effect_haunting", EffectHauntingMobEffect::new);
	public static final RegistryObject<MobEffect> HYPOTHERMIA = REGISTRY.register("hypothermia", HypothermiaMobEffect::new);
	public static final RegistryObject<MobEffect> TRANSMIT = REGISTRY.register("transmit", TransmitMobEffect::new);
	public static final RegistryObject<MobEffect> WARM_SHIELD = REGISTRY.register("warm_shield", WarmShieldMobEffect::new);
	public static final RegistryObject<MobEffect> LAVENDER_MOOD = REGISTRY.register("lavender_mood", LavenderMoodMobEffect::new);
	public static final RegistryObject<MobEffect> ROSA_HEDGE = REGISTRY.register("rosa_hedge", RosaHedgeMobEffect::new);
	public static final RegistryObject<MobEffect> RUTIN_LEMONENE = REGISTRY.register("rutin_lemonene", RutinLemoneneMobEffect::new);
	public static final RegistryObject<MobEffect> BURSTING_BERRY = REGISTRY.register("bursting_berry", BurstingBerryMobEffect::new);
	public static final RegistryObject<MobEffect> TOUGH_AS_NUT = REGISTRY.register("tough_as_nut", ToughAsNutMobEffect::new);
	public static final RegistryObject<MobEffect> CHERRY_BLOSSOMS_WEEPING = REGISTRY.register("cherry_blossoms_weeping", CherryBlossomsWeeping::new);
	public static final RegistryObject<MobEffect> BERRY_BLOOD = REGISTRY.register("berry_blood", BerryBloodMobEffect::new);
	public static final RegistryObject<MobEffect> MOMENTARY_METEOR = REGISTRY.register("momentary_meteor", MomentaryMeteorMobEffect::new);
	public static final RegistryObject<MobEffect> SUMMER_HEATWAVE = REGISTRY.register("summer_heatwave", SummerHeatwaveMobEffect::new);
	public static final RegistryObject<MobEffect> ORIGINAL_EVOLUTION = REGISTRY.register("original_evolution", OriginalEvolutionMobEffect::new);
	public static final RegistryObject<MobEffect> ORIGINAL_EVOLUTION_METAMORPHOSIS = REGISTRY.register("original_evolution_metamorphosis", OriginalEvolutionMetamorphosisMobEffect::new);
	public static final RegistryObject<MobEffect> MELON_GRAVITY = REGISTRY.register("melon_gravity", MelonGravityMobEffect::new);
	public static final RegistryObject<MobEffect> SEA_TOUCH = REGISTRY.register("sea_touch", SeaTouchMobEffect::new);
	public static final RegistryObject<MobEffect> HACKED_THORNS = REGISTRY.register("hacked_thorns", HackedThornsMobEffect::new);
	public static final RegistryObject<MobEffect> KIWING_WHEREABOUTS = REGISTRY.register("kiwing_whereabouts", KiwingWhereaboutsMobEffect::new);
	public static final RegistryObject<MobEffect> LURKING_DANGER = REGISTRY.register("lurking_danger", LurkingDangerMobEffect::new);
}
