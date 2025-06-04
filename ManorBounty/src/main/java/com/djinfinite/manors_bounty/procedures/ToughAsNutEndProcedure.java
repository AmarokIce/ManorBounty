package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class ToughAsNutEndProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR) != null) {
			if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getModifier(UUID.fromString("9df25da8-f03c-4e96-a22b-d7a6e23fb0bc")) != null) {
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).removePermanentModifier(UUID.fromString("9df25da8-f03c-4e96-a22b-d7a6e23fb0bc"));
			}
		}
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS) != null) {
			if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).getModifier(UUID.fromString("057584c1-99bf-4ec7-be00-d42f3542e541")) != null) {
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).removePermanentModifier(UUID.fromString("057584c1-99bf-4ec7-be00-d42f3542e541"));
			}
		}
	}
}
