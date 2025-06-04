package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class SummerHeatwaveEndProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED) != null) {
			if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getModifier(UUID.fromString("0378cdb4-432d-4fea-b1b0-083a8d92b35d")) != null) {
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).removePermanentModifier(UUID.fromString("0378cdb4-432d-4fea-b1b0-083a8d92b35d"));
			}
		}
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()) != null) {
			if (((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()).getModifier(UUID.fromString("c4da594d-8e8f-453e-9195-1c6c9057e70c")) != null) {
				((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()).removePermanentModifier(UUID.fromString("c4da594d-8e8f-453e-9195-1c6c9057e70c"));
			}
		}
	}
}
