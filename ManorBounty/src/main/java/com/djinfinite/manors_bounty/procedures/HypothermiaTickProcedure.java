package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import com.djinfinite.manors_bounty.network.ManorsBountyModVariables;
import com.djinfinite.manors_bounty.registries.ModMobEffects;

public class HypothermiaTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double hyp;
		entity.setTicksFrozen(entity.getTicksFrozen() + 4);
		entity.getPersistentData().putDouble("freezing_hurt", (entity.getPersistentData().getDouble("freezing_hurt") + 1));
		if (entity.getPersistentData().getDouble("freezing_hurt") >= 40) {
			if (entity instanceof Player livEnt) {
				hyp = 2 + (livEnt.hasEffect(ModMobEffects.HYPOTHERMIA.get()) ? livEnt.getEffect(ModMobEffects.HYPOTHERMIA.get()).getAmplifier() : 0) + 2
						+ Math.floor(entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables()).niflheim_freezing * 0.00034) * 2;
			} else {
				hyp = 2 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.HYPOTHERMIA.get()) ? _livEnt.getEffect(ModMobEffects.HYPOTHERMIA.get()).getAmplifier() : 0) + 2;
			}
			if (hyp > 12) {
				hyp = 12;
			}
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("manors_bounty:frostbite")))), (float) hyp);
			entity.getPersistentData().putDouble("freezing_hurt", 0);
		}
	}
}
