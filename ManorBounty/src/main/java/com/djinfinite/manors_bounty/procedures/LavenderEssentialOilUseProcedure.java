package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import com.djinfinite.manors_bounty.registries.ModMobEffects;

public class LavenderEssentialOilUseProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(ModMobEffects.LAVENDER_MOOD.get(), 3600, 0, false, true));
		if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
			itemstack.shrink(1);
		}
	}
}
