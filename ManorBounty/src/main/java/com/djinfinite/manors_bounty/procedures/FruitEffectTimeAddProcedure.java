package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;

import com.djinfinite.manors_bounty.registries.ModMobEffects;

public class FruitEffectTimeAddProcedure {
	public static void execute(Entity entity, double addValue) {
		if (entity == null) {
			return;
		}
		if (entity.level().isClientSide()) {
			return;
		}
        if (!(entity instanceof LivingEntity livingEntity)) {
			return;
		}
		addEffectDurationIfPresent(livingEntity, ModMobEffects.BURSTING_BERRY.get(), addValue);
		addEffectDurationIfPresent(livingEntity, ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get(), addValue);
		addEffectDurationIfPresent(livingEntity, ModMobEffects.HACKED_THORNS.get(), addValue);
		addEffectDurationIfPresent(livingEntity, ModMobEffects.MELON_GRAVITY.get(), addValue);
		addEffectDurationIfPresent(livingEntity, ModMobEffects.MOMENTARY_METEOR.get(), addValue);
		addEffectDurationIfPresent(livingEntity, ModMobEffects.ORIGINAL_EVOLUTION.get(), addValue);
		addEffectDurationIfPresent(livingEntity, ModMobEffects.ROSA_HEDGE.get(), addValue);
		addEffectDurationIfPresent(livingEntity, ModMobEffects.RUTIN_LEMONENE.get(), addValue);
		addEffectDurationIfPresent(livingEntity, ModMobEffects.SEA_TOUCH.get(), addValue);
		addEffectDurationIfPresent(livingEntity, ModMobEffects.SUMMER_HEATWAVE.get(), addValue);
		addEffectDurationIfPresent(livingEntity, ModMobEffects.TOUGH_AS_NUT.get(), addValue);
		addEffectDurationIfPresent(livingEntity, ModMobEffects.TRANSMIT.get(), addValue);
	}

	private static void addEffectDurationIfPresent(LivingEntity livingEntity, MobEffect mobEffect, double addValue) {
		if (livingEntity.hasEffect(mobEffect)) {
			MobEffectInstance existingEffect = livingEntity.getEffect(mobEffect);
			int newDuration = (int) (existingEffect.getDuration() * addValue);
			int amplifier = existingEffect.getAmplifier();
			livingEntity.addEffect(new MobEffectInstance(mobEffect, newDuration, amplifier, false, false));
		}
	}
}
