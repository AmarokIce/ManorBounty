package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.djinfinite.manors_bounty.registries.ModMobEffects;

public class EffectHauntingUseProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double flamtick = 0;
		double flamlevel = 0;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.MOVEMENT_SPEED)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,
						(int) Math.floor((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED) ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getDuration() : 0)
								* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.EFFECT_HAUNTING.get()) ? _livEnt.getEffect(ModMobEffects.EFFECT_HAUNTING.get()).getAmplifier() : 0) + 1) * 0.25),
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED) ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier() : 0, false, true));
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
			{
                if (!entity.level().isClientSide() && entity.getServer() != null) {
					entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
							entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "particle minecraft:soul ~ ~ ~ 0.25 0.25 0.25 0.5 150 normal");
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MobEffects.DAMAGE_BOOST)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,
						(int) Math.floor((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getDuration() : 0)
								* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.EFFECT_HAUNTING.get()) ? _livEnt.getEffect(ModMobEffects.EFFECT_HAUNTING.get()).getAmplifier() : 0) + 1) * 0.25),
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, true));
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.DAMAGE_BOOST);
			{
                if (!entity.level().isClientSide() && entity.getServer() != null) {
					entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
							entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "particle minecraft:soul ~ ~ ~ 0.25 0.25 0.25 0.5 150 normal");
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(MobEffects.DIG_SPEED)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN,
						(int) Math.floor((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DIG_SPEED) ? _livEnt.getEffect(MobEffects.DIG_SPEED).getDuration() : 0)
								* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.EFFECT_HAUNTING.get()) ? _livEnt.getEffect(ModMobEffects.EFFECT_HAUNTING.get()).getAmplifier() : 0) + 1) * 0.25),
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DIG_SPEED) ? _livEnt.getEffect(MobEffects.DIG_SPEED).getAmplifier() : 0, false, true));
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.DIG_SPEED);
			{
                if (!entity.level().isClientSide() && entity.getServer() != null) {
					entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
							entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "particle minecraft:soul ~ ~ ~ 0.25 0.25 0.25 0.5 150 normal");
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(MobEffects.NIGHT_VISION)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS,
						(int) Math.floor((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.NIGHT_VISION) ? _livEnt.getEffect(MobEffects.NIGHT_VISION).getDuration() : 0)
								* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.EFFECT_HAUNTING.get()) ? _livEnt.getEffect(ModMobEffects.EFFECT_HAUNTING.get()).getAmplifier() : 0) + 1) * 0.25),
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.NIGHT_VISION) ? _livEnt.getEffect(MobEffects.NIGHT_VISION).getAmplifier() : 0, false, true));
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.NIGHT_VISION);
			{
                if (!entity.level().isClientSide() && entity.getServer() != null) {
					entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
							entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "particle minecraft:soul ~ ~ ~ 0.25 0.25 0.25 0.5 150 normal");
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt28 && _livEnt28.hasEffect(MobEffects.REGENERATION)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.POISON,
						(int) Math.floor((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.REGENERATION) ? _livEnt.getEffect(MobEffects.REGENERATION).getDuration() : 0)
								* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.EFFECT_HAUNTING.get()) ? _livEnt.getEffect(ModMobEffects.EFFECT_HAUNTING.get()).getAmplifier() : 0) + 1) * 0.25),
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.REGENERATION) ? _livEnt.getEffect(MobEffects.REGENERATION).getAmplifier() : 0, false, true));
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.REGENERATION);
			{
                if (!entity.level().isClientSide() && entity.getServer() != null) {
					entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
							entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "particle minecraft:soul ~ ~ ~ 0.25 0.25 0.25 0.5 150 normal");
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt35 && _livEnt35.hasEffect(MobEffects.LUCK)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK,
						(int) Math.floor((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.LUCK) ? _livEnt.getEffect(MobEffects.LUCK).getDuration() : 0)
								* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.EFFECT_HAUNTING.get()) ? _livEnt.getEffect(ModMobEffects.EFFECT_HAUNTING.get()).getAmplifier() : 0) + 1) * 0.25),
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.LUCK) ? _livEnt.getEffect(MobEffects.LUCK).getAmplifier() : 0, false, true));
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.LUCK);
			{
                if (!entity.level().isClientSide() && entity.getServer() != null) {
					entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
							entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "particle minecraft:soul ~ ~ ~ 0.25 0.25 0.25 0.5 150 normal");
				}
			}
		}
	}
}
