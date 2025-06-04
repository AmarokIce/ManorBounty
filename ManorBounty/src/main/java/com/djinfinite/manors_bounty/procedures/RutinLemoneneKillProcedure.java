package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RutinLemoneneKillProcedure {
	@SubscribeEvent
	public static void onLivingDropXp(LivingExperienceDropEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getAttackingPlayer(), event.getDroppedExperience());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity, double droppedexperience) {
		execute(null, world, x, y, z, sourceentity, droppedexperience);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity sourceentity, double droppedexperience) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ModMobEffects.RUTIN_LEMONENE.get())) {
			if (world instanceof ServerLevel _level)
				_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, (int) Math.floor(droppedexperience * FruitsEffectConfig.RUTIN_LEMONENE_AMOUNT.get()
						* (5 + (1 + (sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.RUTIN_LEMONENE.get()) ? _livEnt.getEffect(ModMobEffects.RUTIN_LEMONENE.get()).getAmplifier() : 0)) * 0.25)
						* (1 + Math.min(FruitsEffectConfig.RUTIN_LEMONENE_MAX_LEVEL.get(), Math.max(sourceentity instanceof Player _plr ? _plr.experienceLevel : 0, 0))
								* FruitsEffectConfig.RUTIN_LEMONENE_LEVEL_AMOUNT.get()))));
		}
	}
}
