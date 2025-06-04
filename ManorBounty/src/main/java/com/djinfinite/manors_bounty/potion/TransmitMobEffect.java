
package com.djinfinite.manors_bounty.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.djinfinite.manors_bounty.procedures.TransmitTickProcedure;
import com.djinfinite.manors_bounty.procedures.TransmitStartProcedure;
import com.djinfinite.manors_bounty.procedures.TransmitEndProcedure;
import org.jetbrains.annotations.NotNull;

public class TransmitMobEffect extends MobEffect {
	public TransmitMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public void addAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attributeMap, int amplifier) {
		super.addAttributeModifiers(entity, attributeMap, amplifier);
		TransmitStartProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
		TransmitTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public void removeAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		TransmitEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
