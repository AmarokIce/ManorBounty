
package com.djinfinite.manors_bounty.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.djinfinite.manors_bounty.procedures.EffectHauntingUseProcedure;
import org.jetbrains.annotations.NotNull;

public class EffectHauntingMobEffect extends MobEffect {
	public EffectHauntingMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -14876706);
	}

	@Override
	public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
		EffectHauntingUseProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
