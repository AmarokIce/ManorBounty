package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HackedThornsAttackedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity) {
		execute(null, world, x, y, z, damagesource, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity) {
		if (damagesource == null || entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ModMobEffects.HACKED_THORNS.get()) && entity instanceof Player && damagesource.isIndirect()) {
			if (Math.random() < Math.min(0.8,
					Math.max(((_livEnt0.hasEffect(ModMobEffects.HACKED_THORNS.get()) ? _livEnt0.getEffect(ModMobEffects.HACKED_THORNS.get()).getAmplifier() : 0) + 1)
							* FruitsEffectConfig.HACKED_THORNS_KNOCKBACK_CHANCE.get(), 0))) {
				entity.invulnerableTime = (int) (entity.invulnerableTime + FruitsEffectConfig.HACKED_THORNS_TIME.get());
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.knockback")), SoundSource.PLAYERS, (float) 0.8, (float) 1.5);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.knockback")), SoundSource.PLAYERS, (float) 0.8, (float) 1.5, false);
					}
				}
			}
		}
	}
}
