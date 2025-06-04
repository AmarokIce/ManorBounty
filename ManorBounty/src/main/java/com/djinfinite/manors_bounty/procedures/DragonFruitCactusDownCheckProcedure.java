package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.registries.ModBlocks;

public class DragonFruitCactusDownCheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return DownSandCheckProcedure.execute(world, x, y, z) || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ModBlocks.DRAGON_FRUIT_CACTUS.get();
	}
}
