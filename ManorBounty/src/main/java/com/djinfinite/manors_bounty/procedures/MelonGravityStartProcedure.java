package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

import java.util.UUID;

public class MelonGravityStartProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE) != null) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
					.hasModifier((new AttributeModifier(UUID.fromString("3d3e494e-26ad-4982-9187-3d53c9364d57"), "MelonGravity",
							(FruitsEffectConfig.MELON_GRAVITY_KNOCKBACK_RESISTANCE_AMOUNT.get()
									* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get()) ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getAmplifier() : 0) + 1)),
							AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
						.addPermanentModifier((new AttributeModifier(UUID.fromString("3d3e494e-26ad-4982-9187-3d53c9364d57"), "MelonGravity",
								(FruitsEffectConfig.MELON_GRAVITY_KNOCKBACK_RESISTANCE_AMOUNT.get()
										* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get()) ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getAmplifier() : 0) + 1)),
								AttributeModifier.Operation.ADDITION)));
		}
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get()) != null) {
			if (!(((LivingEntity) entity).getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get())
					.hasModifier((new AttributeModifier(UUID.fromString("e2fe9efd-910b-43d0-ac7b-0c7f41536f03"), "MelonGravity2",
							(FruitsEffectConfig.MELON_GRAVITY_STEP_HEIGHT_AMOUNT.get()
									* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get()) ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getAmplifier() : 0) + 1)),
							AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get())
						.addPermanentModifier((new AttributeModifier(UUID.fromString("e2fe9efd-910b-43d0-ac7b-0c7f41536f03"), "MelonGravity2",
								(FruitsEffectConfig.MELON_GRAVITY_STEP_HEIGHT_AMOUNT.get()
										* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get()) ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getAmplifier() : 0) + 1)),
								AttributeModifier.Operation.ADDITION)));
		}
	}
}
