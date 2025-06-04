package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

import java.util.UUID;

public class SeaTouchStartProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()) != null) {
			if (!(((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get())
					.hasModifier((new AttributeModifier(UUID.fromString("88d70b63-78c7-4a6a-a0ac-452c1988d142"), "SeaTouch",
							(FruitsEffectConfig.SEA_TOUCH_ENTITY_AMOUNT.get()
									* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SEA_TOUCH.get()) ? _livEnt.getEffect(ModMobEffects.SEA_TOUCH.get()).getAmplifier() : 0) + 1)),
							AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get())
						.addPermanentModifier((new AttributeModifier(UUID.fromString("88d70b63-78c7-4a6a-a0ac-452c1988d142"), "SeaTouch",
								(FruitsEffectConfig.SEA_TOUCH_ENTITY_AMOUNT.get()
										* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SEA_TOUCH.get()) ? _livEnt.getEffect(ModMobEffects.SEA_TOUCH.get()).getAmplifier() : 0) + 1)),
								AttributeModifier.Operation.ADDITION)));
		}
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ForgeMod.BLOCK_REACH.get()) != null) {
			if (!(((LivingEntity) entity).getAttribute(ForgeMod.BLOCK_REACH.get())
					.hasModifier((new AttributeModifier(UUID.fromString("442264d5-13f5-48ca-8baf-69c90009501e"), "SeaTouch2",
							(FruitsEffectConfig.SEA_TOUCH_BLOCK_AMOUNT.get()
									* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SEA_TOUCH.get()) ? _livEnt.getEffect(ModMobEffects.SEA_TOUCH.get()).getAmplifier() : 0) + 1)),
							AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(ForgeMod.BLOCK_REACH.get())
						.addPermanentModifier((new AttributeModifier(UUID.fromString("442264d5-13f5-48ca-8baf-69c90009501e"), "SeaTouch2",
								(FruitsEffectConfig.SEA_TOUCH_BLOCK_AMOUNT.get()
										* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SEA_TOUCH.get()) ? _livEnt.getEffect(ModMobEffects.SEA_TOUCH.get()).getAmplifier() : 0) + 1)),
								AttributeModifier.Operation.ADDITION)));
		}
	}
}
