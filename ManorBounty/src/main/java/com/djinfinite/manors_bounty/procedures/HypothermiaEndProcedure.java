package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class HypothermiaEndProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED) != null)) {
			if ((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getModifier(UUID.fromString("3a2805f9-2211-45e4-b73d-1b03c3302274")) != null)) {
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).removeModifier(UUID.fromString("3a2805f9-2211-45e4-b73d-1b03c3302274"));
			}
		}
		if ((entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()) != null)) {
			if ((((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()).getModifier(UUID.fromString("04437118-c775-4852-aa4d-7e8b09373df6")) != null)) {
				((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()).removeModifier(UUID.fromString("04437118-c775-4852-aa4d-7e8b09373df6"));
			}
		}
		if ((entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FLYING_SPEED) != null)) {
			if ((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FLYING_SPEED).getModifier(UUID.fromString("4531bd0a-f64d-4a42-a3c7-68f8a73bc966")) != null)) {
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FLYING_SPEED).removeModifier(UUID.fromString("4531bd0a-f64d-4a42-a3c7-68f8a73bc966"));
			}
		}
		if ((entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE) != null)) {
			if ((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getModifier(UUID.fromString("35b636e6-dc9f-4330-8c66-c1eaef28b541")) != null)) {
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).removeModifier(UUID.fromString("35b636e6-dc9f-4330-8c66-c1eaef28b541"));
			}
		}
		entity.setTicksFrozen(140);
	}
}
