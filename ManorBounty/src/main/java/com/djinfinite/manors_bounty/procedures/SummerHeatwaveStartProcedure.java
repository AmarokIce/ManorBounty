package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

import java.util.UUID;

public class SummerHeatwaveStartProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED) != null) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.hasModifier((new AttributeModifier(UUID.fromString("0378cdb4-432d-4fea-b1b0-083a8d92b35d"), "SummerHeatwave",
							(FruitsEffectConfig.SUMMER_HEATWAVE_MOVEMENT_SPEED_AMOUNT.get()
									* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get()) ? _livEnt.getEffect(ModMobEffects.SUMMER_HEATWAVE.get()).getAmplifier() : 0) + 1)),
							AttributeModifier.Operation.MULTIPLY_TOTAL)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
						.addPermanentModifier((new AttributeModifier(UUID.fromString("0378cdb4-432d-4fea-b1b0-083a8d92b35d"), "SummerHeatwave",
								(FruitsEffectConfig.SUMMER_HEATWAVE_MOVEMENT_SPEED_AMOUNT.get()
										* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get()) ? _livEnt.getEffect(ModMobEffects.SUMMER_HEATWAVE.get()).getAmplifier() : 0) + 1)),
								AttributeModifier.Operation.MULTIPLY_TOTAL)));
		}
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()) != null) {
			if (!(((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get())
					.hasModifier((new AttributeModifier(UUID.fromString("c4da594d-8e8f-453e-9195-1c6c9057e70c"), "SummerHeatwave2",
							(FruitsEffectConfig.SUMMER_HEATWAVE_SWIM_SPEED_AMOUNT.get()
									* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get()) ? _livEnt.getEffect(ModMobEffects.SUMMER_HEATWAVE.get()).getAmplifier() : 0) + 1)),
							AttributeModifier.Operation.MULTIPLY_TOTAL)))))
				((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get())
						.addPermanentModifier((new AttributeModifier(UUID.fromString("c4da594d-8e8f-453e-9195-1c6c9057e70c"), "SummerHeatwave2",
								(FruitsEffectConfig.SUMMER_HEATWAVE_SWIM_SPEED_AMOUNT.get()
										* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get()) ? _livEnt.getEffect(ModMobEffects.SUMMER_HEATWAVE.get()).getAmplifier() : 0) + 1)),
								AttributeModifier.Operation.MULTIPLY_TOTAL)));
		}
	}
}
