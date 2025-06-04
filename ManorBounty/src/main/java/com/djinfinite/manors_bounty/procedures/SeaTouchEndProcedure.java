package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class SeaTouchEndProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()) != null) {
			if (((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).getModifier(UUID.fromString("88d70b63-78c7-4a6a-a0ac-452c1988d142")) != null) {
				((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).removePermanentModifier(UUID.fromString("88d70b63-78c7-4a6a-a0ac-452c1988d142"));
			}
		}
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ForgeMod.BLOCK_REACH.get()) != null) {
			if (((LivingEntity) entity).getAttribute(ForgeMod.BLOCK_REACH.get()).getModifier(UUID.fromString("442264d5-13f5-48ca-8baf-69c90009501e")) != null) {
				((LivingEntity) entity).getAttribute(ForgeMod.BLOCK_REACH.get()).removePermanentModifier(UUID.fromString("442264d5-13f5-48ca-8baf-69c90009501e"));
			}
		}
	}
}
