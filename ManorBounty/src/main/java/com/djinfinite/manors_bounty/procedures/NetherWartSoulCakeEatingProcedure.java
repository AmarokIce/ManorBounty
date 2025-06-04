package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import com.djinfinite.manors_bounty.registries.ModMobEffects;

public class NetherWartSoulCakeEatingProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		if ((entity instanceof Player _plr && _plr.getAbilities().instabuild) || (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 20) {
			LainCakesEatingProcedure.execute(world, x, y, z, blockstate, entity);
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ModMobEffects.EFFECT_HAUNTING.get(), 200, 1, false, true));
			if (entity instanceof Player player) {
                player.getFoodData().eat(1, 0.2F);
			}
		}
		return InteractionResult.SUCCESS;
	}
}
