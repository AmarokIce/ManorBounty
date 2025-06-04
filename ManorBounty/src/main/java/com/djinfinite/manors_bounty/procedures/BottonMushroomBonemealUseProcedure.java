package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class BottonMushroomBonemealUseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (blockstate.getBlock() == ModBlocks.BOTTON_MUSHROOM.get()) {
			world.setBlock(BlockPos.containing(x, y, z), ModBlocks.BOTTON_MUSHROOM_2.get().defaultBlockState(), 3);
		} else if (blockstate.getBlock() == ModBlocks.BOTTON_MUSHROOM_2.get()) {
			world.setBlock(BlockPos.containing(x, y, z), ModBlocks.BOTTON_MUSHROOM_3.get().defaultBlockState(), 3);
		}
	}
}
