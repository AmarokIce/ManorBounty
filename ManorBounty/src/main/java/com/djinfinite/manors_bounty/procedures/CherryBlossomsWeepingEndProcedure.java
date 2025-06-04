package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class CherryBlossomsWeepingEndProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK) != null) {
			if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).getModifier(UUID.fromString("d702e5ad-ca59-4659-b0ab-d55e215d5689")) != null) {
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).removePermanentModifier(UUID.fromString("d702e5ad-ca59-4659-b0ab-d55e215d5689"));
			}
		}
	}
}
