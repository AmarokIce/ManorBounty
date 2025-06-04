package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class WoodMushroomRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double chance;
		chance = Mth.nextInt(RandomSource.create(), 1, 100);
		if (chance <= 8) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ModBlocks.WOOD_MUSHROOM.get()) {
				world.setBlock(BlockPos.containing(x, y, z), ModBlocks.WOOD_MUSHROOM_2.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ModBlocks.WOOD_MUSHROOM_2.get()) {
				world.setBlock(BlockPos.containing(x, y, z), ModBlocks.WOOD_MUSHROOM_3.get().defaultBlockState(), 3);
			}
		}
	}
}
