package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class CornCropDownProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ModBlocks.CORN_CROP_2.get()) {
			if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ModBlocks.CORN_CROP_2.get()) && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ModBlocks.CORN_CROP_1.get())) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
		}
	}
}
