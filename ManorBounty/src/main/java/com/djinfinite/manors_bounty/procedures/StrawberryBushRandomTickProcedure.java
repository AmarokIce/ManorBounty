package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class StrawberryBushRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("forge:farmland")))) {
			if (Math.random() < 0.2) {
				StrawberryBushBonemealUseProcedure.execute(world, x, y, z, blockstate);
			}
		} else {
			if (Math.random() < 0.08) {
				StrawberryBushBonemealUseProcedure.execute(world, x, y, z, blockstate);
			}
		}
	}
}
