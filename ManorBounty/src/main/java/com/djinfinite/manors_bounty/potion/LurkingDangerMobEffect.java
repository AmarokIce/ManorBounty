
package com.djinfinite.manors_bounty.potion;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.djinfinite.manors_bounty.procedures.LurkingDangerSneakingProcedure;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.ArrayList;

public class LurkingDangerMobEffect extends MobEffect {
	public LurkingDangerMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13679602);
	}

	@Override
	public List<ItemStack> getCurativeItems() {
        return new ArrayList<>();
	}

	@Override
	public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
		LurkingDangerSneakingProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
