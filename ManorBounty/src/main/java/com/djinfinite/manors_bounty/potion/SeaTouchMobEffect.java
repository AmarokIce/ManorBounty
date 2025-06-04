
package com.djinfinite.manors_bounty.potion;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.djinfinite.manors_bounty.procedures.SeaTouchStartProcedure;
import com.djinfinite.manors_bounty.procedures.SeaTouchEndProcedure;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.ArrayList;

public class SeaTouchMobEffect extends MobEffect {
	public SeaTouchMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -14572560);
	}

	@Override
	public List<ItemStack> getCurativeItems() {
        return new ArrayList<>();
	}

	@Override
	public void addAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attributeMap, int amplifier) {
		super.addAttributeModifiers(entity, attributeMap, amplifier);
		SeaTouchStartProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		SeaTouchEndProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
