
package com.djinfinite.manors_bounty.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class OriginalEvolutionMetamorphosisMobEffect extends MobEffect {
	public OriginalEvolutionMetamorphosisMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1048748);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
