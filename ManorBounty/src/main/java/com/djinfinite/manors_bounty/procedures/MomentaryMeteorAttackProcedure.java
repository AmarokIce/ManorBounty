package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MomentaryMeteorAttackProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity sourceentity, double amount) {
		execute(null, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, Entity sourceentity, double amount) {
		if (sourceentity == null)
			return;
		double newDamage;
		double maxDamage;
		if (sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ModMobEffects.MOMENTARY_METEOR.get())) {
			if (Math.random() < FruitsEffectConfig.MOMENTARY_METEOR_CHANCE.get()
					* ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MOMENTARY_METEOR.get()) ? _livEnt.getEffect(ModMobEffects.MOMENTARY_METEOR.get()).getAmplifier() : 0) + 1)) {
				newDamage = amount * 5;
				maxDamage = FruitsEffectConfig.MOMENTARY_METEOR_MAX_AMOUNT.get();
				if (amount > maxDamage) {
					maxDamage = amount;
				}
				if (newDamage > maxDamage) {
					newDamage = maxDamage;
				}
				if (event instanceof LivingHurtEvent hurtEvent) {
                    LivingEntity targetEntity = hurtEvent.getEntity();
					hurtEvent.setAmount((float) newDamage);
				}
			}
		}
	}
}
