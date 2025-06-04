
package com.djinfinite.manors_bounty.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.djinfinite.manors_bounty.procedures.WarmShieldTickProcedure;
import org.jetbrains.annotations.NotNull;

public class WarmShieldMobEffect extends MobEffect {
	public WarmShieldMobEffect() {
		super(MobEffectCategory.HARMFUL, -18627);
	}

	@Override
	public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
		WarmShieldTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
