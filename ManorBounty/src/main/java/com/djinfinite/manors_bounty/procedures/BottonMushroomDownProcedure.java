package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class BottonMushroomDownProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.MYCELIUM || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ModBlocks.SNOWY_MYCELIUM.get();
	}
}
