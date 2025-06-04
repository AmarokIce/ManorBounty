
package com.djinfinite.manors_bounty.potion;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.djinfinite.manors_bounty.procedures.SummerHeatwaveStartProcedure;
import com.djinfinite.manors_bounty.procedures.SummerHeatwaveEndProcedure;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.ArrayList;

public class SummerHeatwaveMobEffect extends MobEffect {
	public SummerHeatwaveMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -17408);
	}

	@Override
	public List<ItemStack> getCurativeItems() {
        return new ArrayList<>();
	}

	@Override
	public void addAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attributeMap, int amplifier) {
		super.addAttributeModifiers(entity, attributeMap, amplifier);
		SummerHeatwaveStartProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		SummerHeatwaveEndProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
