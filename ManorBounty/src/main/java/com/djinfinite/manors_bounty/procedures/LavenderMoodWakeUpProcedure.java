package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import com.djinfinite.manors_bounty.registries.ModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LavenderMoodWakeUpProcedure {
	@SubscribeEvent
	public static void onEntityEndSleep(PlayerWakeUpEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ModMobEffects.LAVENDER_MOOD.get())) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.LAVENDER_MOOD.get()) ? _livEnt.getEffect(ModMobEffects.LAVENDER_MOOD.get()).getAmplifier() : 0) == 0) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(ModMobEffects.LAVENDER_MOOD.get(), 19200, 1, false, true));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 19200, 0, false, true));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 19200, 0, false, true));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 19200, 0, false, true));
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.LAVENDER_MOOD.get()) ? _livEnt.getEffect(ModMobEffects.LAVENDER_MOOD.get()).getAmplifier() : 0) == 1) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(ModMobEffects.LAVENDER_MOOD.get(), 19200, 2, false, true));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 19200, 1, false, true));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 19200, 1, false, true));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 19200, 1, false, true));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 19200, 0, false, true));
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.LAVENDER_MOOD.get()) ? _livEnt.getEffect(ModMobEffects.LAVENDER_MOOD.get()).getAmplifier() : 0) >= 2) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(ModMobEffects.LAVENDER_MOOD.get(), 19200, 2, false, true));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 19200, 1, false, true));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 19200, 2, false, true));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 19200, 2, false, true));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 19200, 1, false, true));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 19200, 0, false, true));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 19200, 0, false, true));
			}
		}
	}
}
