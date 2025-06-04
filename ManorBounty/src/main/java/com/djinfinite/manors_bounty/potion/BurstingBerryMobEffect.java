
package com.djinfinite.manors_bounty.potion;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.djinfinite.manors_bounty.procedures.BurstingBerryStartProcedure;
import com.djinfinite.manors_bounty.procedures.BurstingBerryEndProcedure;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.ArrayList;

public class BurstingBerryMobEffect extends MobEffect {
	public BurstingBerryMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -39271);
	}

	@Override
	public List<ItemStack> getCurativeItems() {
        return new ArrayList<>();
	}

	@Override
	public void addAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attributeMap, int amplifier) {
		super.addAttributeModifiers(entity, attributeMap, amplifier);
		BurstingBerryStartProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		BurstingBerryEndProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
