package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class PineappleCropDownCheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return DownNormalFarmlandCheckProcedure.execute(world, x, y, z) || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.SAND;
	}
}
