
package com.djinfinite.manors_bounty.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class LavenderMoodMobEffect extends MobEffect {
	public LavenderMoodMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -4887082);
	}

    @Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
