package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HackedThornsKnockbackProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, damagesource, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity) {
		if (damagesource == null || entity == null || sourceentity == null)
			return;
		double knockback_strength;
		double slowness_level;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ModMobEffects.HACKED_THORNS.get()) && !damagesource.isIndirect()) {
			knockback_strength = FruitsEffectConfig.HACKED_THORNS_AMOUNT.get()
					* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.HACKED_THORNS.get()) ? _livEnt.getEffect(ModMobEffects.HACKED_THORNS.get()).getAmplifier() : 0) + 1);
			Vec3 knockbackDirection = sourceentity.position().subtract(entity.position()).normalize().scale(knockback_strength);
			sourceentity.setDeltaMovement(knockbackDirection);
			slowness_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.HACKED_THORNS.get()) ? _livEnt.getEffect(ModMobEffects.HACKED_THORNS.get()).getAmplifier() : 0;
			if (slowness_level > 3) {
				slowness_level = 3;
			}
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) (double) FruitsEffectConfig.HACKED_THORNS_TIME.get(), (int) slowness_level, false, true));
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
