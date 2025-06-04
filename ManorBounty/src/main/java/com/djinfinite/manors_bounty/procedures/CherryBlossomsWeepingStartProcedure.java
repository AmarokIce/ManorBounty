package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

import java.util.UUID;

public class CherryBlossomsWeepingStartProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK) != null) {
			if (!(entity.getAttribute(Attributes.ATTACK_KNOCKBACK)
					.hasModifier((new AttributeModifier(UUID.fromString("d702e5ad-ca59-4659-b0ab-d55e215d5689"), "CherryBlossomsWeeping", (FruitsEffectConfig.CHERRY_BLOSSOMS_WEEPING_AMOUNT.get()
							* ((_livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()) ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getAmplifier() : 0)
									+ 1)),
							AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK)
						.addPermanentModifier((new AttributeModifier(UUID.fromString("d702e5ad-ca59-4659-b0ab-d55e215d5689"), "CherryBlossomsWeeping", (FruitsEffectConfig.CHERRY_BLOSSOMS_WEEPING_AMOUNT.get()
								* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()) ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getAmplifier() : 0)
										+ 1)),
								AttributeModifier.Operation.ADDITION)));
		}
	}
}
