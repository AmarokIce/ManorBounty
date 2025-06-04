package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.BlockPos;

public class PieEatProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		if ((entity instanceof Player _plr && _plr.getAbilities().instabuild) || (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 20) {
			if (entity instanceof Player player) {
                player.getFoodData().eat(8, 0.3F);
			}
			world.destroyBlock(BlockPos.containing(x, y, z), false);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}
}
