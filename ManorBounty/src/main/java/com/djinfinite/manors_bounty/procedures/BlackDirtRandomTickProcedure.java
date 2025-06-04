package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.registries.ModBlocks;

public class BlackDirtRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
        Mth.nextInt(RandomSource.create(), 1, 100);
        if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.SNOW) {
			world.setBlock(BlockPos.containing(x, y, z), ModBlocks.SNOWY_BLACK_DIRT.get().defaultBlockState(), 3);
		}
	}
}
