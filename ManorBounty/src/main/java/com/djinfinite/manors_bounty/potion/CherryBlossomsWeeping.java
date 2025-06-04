
package com.djinfinite.manors_bounty.potion;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.djinfinite.manors_bounty.procedures.CherryBlossomsWeepingTickProcedure;
import com.djinfinite.manors_bounty.procedures.CherryBlossomsWeepingStartProcedure;
import com.djinfinite.manors_bounty.procedures.CherryBlossomsWeepingEndProcedure;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.ArrayList;

public class CherryBlossomsWeeping extends MobEffect {
	public CherryBlossomsWeeping() {
		super(MobEffectCategory.BENEFICIAL, -32367);
	}

	@Override
	public List<ItemStack> getCurativeItems() {
        return new ArrayList<>();
	}

	@Override
	public void addAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attributeMap, int amplifier) {
		super.addAttributeModifiers(entity, attributeMap, amplifier);
		CherryBlossomsWeepingStartProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
		CherryBlossomsWeepingTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void removeAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		CherryBlossomsWeepingEndProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
