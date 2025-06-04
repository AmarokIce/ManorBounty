package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import com.djinfinite.manors_bounty.network.ManorsBountyModVariables;
import com.djinfinite.manors_bounty.registries.ModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BurstingBerryAttackProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity sourceentity, double amount) {
		execute(null, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, Entity sourceentity, double amount) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ModMobEffects.BURSTING_BERRY.get())) {
			if (sourceentity instanceof Player player && player.getAttackStrengthScale(0.5F) >= 0.9F && sourceentity.fallDistance > 0 && !sourceentity.isSprinting() && !sourceentity.isPassenger()) {
                if (!player.hasEffect(MobEffects.BLINDNESS) && !sourceentity.isInWaterOrBubble() && !sourceentity.onGround()) {
                    if (event instanceof LivingHurtEvent _hurt) {
                        _hurt.setAmount((float) (amount * (sourceentity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).AdditionalDamageMultiplier));
                    }
                }
            }
		}
	}
}
