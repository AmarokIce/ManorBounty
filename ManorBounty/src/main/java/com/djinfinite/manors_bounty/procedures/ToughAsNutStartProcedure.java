package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

import java.util.UUID;

public class ToughAsNutStartProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR) != null) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
					.hasModifier((new AttributeModifier(UUID.fromString("9df25da8-f03c-4e96-a22b-d7a6e23fb0bc"), "toughAsNut",
							(FruitsEffectConfig.TOUGH_AS_NUT_ARMOR_AMOUNT.get()
									* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TOUGH_AS_NUT.get()) ? _livEnt.getEffect(ModMobEffects.TOUGH_AS_NUT.get()).getAmplifier() : 0) + 1)),
							AttributeModifier.Operation.MULTIPLY_TOTAL)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
						.addPermanentModifier((new AttributeModifier(UUID.fromString("9df25da8-f03c-4e96-a22b-d7a6e23fb0bc"), "toughAsNut",
								(FruitsEffectConfig.TOUGH_AS_NUT_ARMOR_AMOUNT.get()
										* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TOUGH_AS_NUT.get()) ? _livEnt.getEffect(ModMobEffects.TOUGH_AS_NUT.get()).getAmplifier() : 0) + 1)),
								AttributeModifier.Operation.MULTIPLY_TOTAL)));
		}
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS) != null) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS)
					.hasModifier((new AttributeModifier(UUID.fromString("057584c1-99bf-4ec7-be00-d42f3542e541"), "toughAsNut2",
							(FruitsEffectConfig.TOUGH_AS_NUT_ARMOR_TOUGHNESS_AMOUNT.get()
									* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TOUGH_AS_NUT.get()) ? _livEnt.getEffect(ModMobEffects.TOUGH_AS_NUT.get()).getAmplifier() : 0) + 1)),
							AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS)
						.addPermanentModifier((new AttributeModifier(UUID.fromString("057584c1-99bf-4ec7-be00-d42f3542e541"), "toughAsNut2",
								(FruitsEffectConfig.TOUGH_AS_NUT_ARMOR_TOUGHNESS_AMOUNT.get()
										* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TOUGH_AS_NUT.get()) ? _livEnt.getEffect(ModMobEffects.TOUGH_AS_NUT.get()).getAmplifier() : 0) + 1)),
								AttributeModifier.Operation.ADDITION)));
		}
	}
}
