package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.items.IFoodItem;
import com.djinfinite.manors_bounty.registries.ModItems;
import com.djinfinite.manors_bounty.utils.CapabilityUtils;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;

public class SweetBerryCakeEatingProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null) {
			return InteractionResult.PASS;
		}
		if(entity instanceof Player player) {
			if ((player.getAbilities().instabuild) || player.getFoodData().getFoodLevel() < 20) {
				LainCakesEatingProcedure.execute(world, x, y, z, blockstate, entity);
				if (!CapabilityUtils.isInModCooldown(ModItems.SWEET_BERRY_CAKE_SLICE.get(), player)) {
					if (((IFoodItem) ModItems.SWEET_BERRY_CAKE.get()).getFoodEffect().apply(player)) {
						CapabilityUtils.addModCooldown(ModItems.SWEET_BERRY_CAKE_SLICE.get(), player);
					}
				}
				player.getFoodData().eat(1, 0.2F);
			}
		}
		return InteractionResult.SUCCESS;
	}
}
