package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class JalapenoCropDownCheckProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		JalapenoCropBottomUpdataProcedure.execute(world, x, y, z, blockstate);
		if (!(world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("forge:farmland")))
				&& !(world.getBlockState(BlockPos.containing(x, y - 2, z))).is(BlockTags.create(new ResourceLocation("forge:farmland")))) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		}
	}
}
