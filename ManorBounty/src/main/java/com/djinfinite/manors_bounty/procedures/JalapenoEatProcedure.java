package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import com.djinfinite.manors_bounty.registries.ModMobEffects;

public class JalapenoEatProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == ModItems.JALAPENO.get()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ModMobEffects.WARM_SHIELD.get(), 20, 0, false, true));
		}
		if (itemstack.getItem() == ModItems.JALAPENO_ICE_CREAM.get()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ModMobEffects.WARM_SHIELD.get(), 40, 0, false, true));
		}
		if (itemstack.getItem() == ModItems.STARFRUIT_JALAPENO_ICE_CREAM.get()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ModMobEffects.WARM_SHIELD.get(), 40, 0, false, true));
		}
	}
}
