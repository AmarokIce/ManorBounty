package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import com.djinfinite.manors_bounty.network.ManorsBountyModVariables;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

public class BerryBloodTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double healAmount;
		if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).BerryBloodHeal < 20) {
			{
				double _setval = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).BerryBloodHeal + 1;
				entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BerryBloodHeal = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				double _setval = 0;
				entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BerryBloodHeal = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			healAmount = FruitsEffectConfig.BERRY_BLOOD_HEAL_AMOUNT_1.get()
					* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BERRY_BLOOD.get()) ? _livEnt.getEffect(ModMobEffects.BERRY_BLOOD.get()).getAmplifier() : 0) + 1)
					+ FruitsEffectConfig.BERRY_BLOOD_HEAL_AMOUNT_2.get() * (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
			if (entity instanceof LivingEntity _livEnt) {
				_livEnt.heal((float) healAmount);
			}
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList()
						.broadcastSystemMessage(Component.literal(((FruitsEffectConfig.BERRY_BLOOD_HEAL_AMOUNT_1.get()
								* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BERRY_BLOOD.get()) ? _livEnt.getEffect(ModMobEffects.BERRY_BLOOD.get()).getAmplifier() : 0) + 1)) + ""
								+ (FruitsEffectConfig.BERRY_BLOOD_HEAL_AMOUNT_2.get() * (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)))), false);
		}
	}
}
