package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import com.djinfinite.manors_bounty.network.ManorsBountyModVariables;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

public class BurstingBerryStartProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).AdditionalDamageMultiplier
					+ FruitsEffectConfig.BURSTING_BERRY_AMOUNT.get()
							* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier() : 0) + 1);
			entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.AdditionalDamageMultiplier = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
