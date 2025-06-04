package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class MelonGravityEndProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE) != null) {
			if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).getModifier(UUID.fromString("3d3e494e-26ad-4982-9187-3d53c9364d57")) != null) {
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).removePermanentModifier(UUID.fromString("3d3e494e-26ad-4982-9187-3d53c9364d57"));
			}
		}
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get()) != null) {
			if (((LivingEntity) entity).getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get()).getModifier(UUID.fromString("e2fe9efd-910b-43d0-ac7b-0c7f41536f03")) != null) {
				((LivingEntity) entity).getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get()).removePermanentModifier(UUID.fromString("e2fe9efd-910b-43d0-ac7b-0c7f41536f03"));
			}
		}
	}
}
