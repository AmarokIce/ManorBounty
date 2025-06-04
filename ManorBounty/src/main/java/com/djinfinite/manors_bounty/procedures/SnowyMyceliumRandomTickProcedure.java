package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.registries.ModBlocks;

public class SnowyMyceliumRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBlockState(BlockPos.containing(x, y + 1, z)).isFaceSturdy(world, BlockPos.containing(x, y + 1, z), Direction.DOWN) && !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.SNOW)
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.LAVA) {
			world.setBlock(BlockPos.containing(x, y, z), ModBlocks.BLACK_DIRT.get().defaultBlockState(), 3);
		}
	}
}
