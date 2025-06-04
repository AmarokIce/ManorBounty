package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OriginalEvolutionHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource(), event.getEntity(), event.getAmount());
		}
	}

	public static void execute(DamageSource damagesource, Entity entity, double amount) {
		execute(null, damagesource, entity, amount);
	}

	private static void execute(@Nullable Event event, DamageSource damagesource, Entity entity, double amount) {
		if (damagesource == null || entity == null)
			return;
		double newDamage;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get())) {
			if (damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("manors_bounty:metamorphosis")))) {
				if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION_METAMORPHOSIS.get())) {
					newDamage = amount - (amount * FruitsEffectConfig.ORIGINAL_EVOLUTION_AMOUNT.get()
							* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get()) ? _livEnt.getEffect(ModMobEffects.ORIGINAL_EVOLUTION.get()).getAmplifier() : 0) + 1)
							+ amount * FruitsEffectConfig.ORIGINAL_EVOLUTION_METAMORPHOSIS_AMOUNT.get()
									* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION_METAMORPHOSIS.get())
											? _livEnt.getEffect(ModMobEffects.ORIGINAL_EVOLUTION_METAMORPHOSIS.get()).getAmplifier()
											: 0) + 1));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(ModMobEffects.ORIGINAL_EVOLUTION_METAMORPHOSIS.get(), 300,
                                (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION_METAMORPHOSIS.get())
                                        ? _livEnt.getEffect(ModMobEffects.ORIGINAL_EVOLUTION_METAMORPHOSIS.get()).getAmplifier()
                                        : 0) + 1,
								false, true));
				} else {
					newDamage = amount - amount * FruitsEffectConfig.ORIGINAL_EVOLUTION_AMOUNT.get()
							* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get()) ? _livEnt.getEffect(ModMobEffects.ORIGINAL_EVOLUTION.get()).getAmplifier() : 0) + 1);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(ModMobEffects.ORIGINAL_EVOLUTION_METAMORPHOSIS.get(), 300, 0, false, true));
				}
				if (newDamage < amount * 0.1) {
					newDamage = amount * 0.1;
				}
				if (event instanceof LivingHurtEvent hurtEvent) {
                    LivingEntity targetEntity = hurtEvent.getEntity();
					hurtEvent.setAmount((float) newDamage);
				}
			}
		}
	}
}
