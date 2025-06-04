
package com.djinfinite.manors_bounty.potion;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import java.util.List;
import java.util.ArrayList;

public class RutinLemoneneMobEffect extends MobEffect {
	public RutinLemoneneMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13261);
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
