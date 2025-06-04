package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class VanillaCropGrowthCheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, double MaxGrowrhSpeed) {
		if (VanillaCropGrowthSpeedProcedure.execute(world, x, y, z, blockstate) > MaxGrowrhSpeed) {
			return world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) >= 9 && Mth.nextInt(RandomSource.create(), 1, 100) < 100 / (1 + Math.round(25 / MaxGrowrhSpeed));
		}
		if (VanillaCropGrowthSpeedProcedure.execute(world, x, y, z, blockstate) <= MaxGrowrhSpeed) {
			return world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) >= 9 && Mth.nextInt(RandomSource.create(), 1, 100) < 100 / (1 + Math.round(25 / VanillaCropGrowthSpeedProcedure.execute(world, x, y, z, blockstate)));
		}
		return false;
	}
}
