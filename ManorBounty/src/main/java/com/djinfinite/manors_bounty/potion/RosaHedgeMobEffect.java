
package com.djinfinite.manors_bounty.potion;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import java.util.List;
import java.util.ArrayList;

public class RosaHedgeMobEffect extends MobEffect {
	public RosaHedgeMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -26215);
	}

	@Override
	public List<ItemStack> getCurativeItems() {
        return new ArrayList<>();
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
