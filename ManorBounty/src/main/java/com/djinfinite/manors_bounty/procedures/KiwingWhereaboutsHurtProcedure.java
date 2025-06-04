package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class KiwingWhereaboutsHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
		execute(null, damagesource, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
		if (damagesource == null || entity == null || sourceentity == null)
			return;
		double time;
		double level;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ModMobEffects.KIWING_WHEREABOUTS.get())) {
			if (sourceentity instanceof LivingEntity) {
				time = Math.floor(10 + ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.KIWING_WHEREABOUTS.get()) ? _livEnt.getEffect(ModMobEffects.KIWING_WHEREABOUTS.get()).getAmplifier() : 0) + 1)
						* FruitsEffectConfig.KIWING_WHEREABOUTS_TIME.get());
				level = Math.floor(FruitsEffectConfig.KIWING_WHEREABOUTS_LEVEL.get());
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, (int) time, 0, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, (int) time, (int) level, false, false));
				time = time + 10;
				if (entity.invulnerableTime < time) {
					entity.invulnerableTime = (int) time;
				}
			}
			if (damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("minecraft:is_fall")))) {
				if (event instanceof LivingHurtEvent _hurt) {
					_hurt.setAmount((float) (amount * (1
							- (0.4 + ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.KIWING_WHEREABOUTS.get()) ? _livEnt.getEffect(ModMobEffects.KIWING_WHEREABOUTS.get()).getAmplifier() : 0) + 1)
									* FruitsEffectConfig.KIWING_WHEREABOUTS_FALL_RESISTANCE_AMOUNT.get()))));
				}
			}
		}
	}
}
