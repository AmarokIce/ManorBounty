package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.registries.ModBlocks;

public class SnowConcretePowderSoildifyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double previousRecipe = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((world.getFluidState(BlockPos.containing(x + 1, y, z)).createLegacyBlock()).getBlock() == Blocks.WATER || (world.getFluidState(BlockPos.containing(x - 1, y, z)).createLegacyBlock()).getBlock() == Blocks.WATER
				|| (world.getFluidState(BlockPos.containing(x, y, z + 1)).createLegacyBlock()).getBlock() == Blocks.WATER || (world.getFluidState(BlockPos.containing(x, y, z - 1)).createLegacyBlock()).getBlock() == Blocks.WATER
				|| (world.getFluidState(BlockPos.containing(x, y + 1, z)).createLegacyBlock()).getBlock() == Blocks.WATER) {
			world.setBlock(BlockPos.containing(x, y, z), ModBlocks.SNOW_CONCRETE.get().defaultBlockState(), 3);
		}
	}
}
