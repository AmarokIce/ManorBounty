
package com.djinfinite.manors_bounty.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.djinfinite.manors_bounty.procedures.HypothermiaTickProcedure;
import com.djinfinite.manors_bounty.procedures.HypothermiaStartProcedure;
import com.djinfinite.manors_bounty.procedures.HypothermiaEndProcedure;
import org.jetbrains.annotations.NotNull;

public class HypothermiaMobEffect extends MobEffect {
	public HypothermiaMobEffect() {
		super(MobEffectCategory.HARMFUL, -16741406);
	}

	@Override
	public void addAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attributeMap, int amplifier) {
		super.addAttributeModifiers(entity, attributeMap, amplifier);
		HypothermiaStartProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
		HypothermiaTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public void removeAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		HypothermiaEndProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
