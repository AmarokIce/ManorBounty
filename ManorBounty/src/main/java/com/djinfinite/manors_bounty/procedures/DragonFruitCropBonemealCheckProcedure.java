package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.registries.ModBlocks;

public class DragonFruitCropBonemealCheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ModBlocks.DRAGON_FRUIT_CACTUS_FLOWER.get()) {
			return true;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ModBlocks.DRAGON_FRUIT_CROP.get()) {
			return (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip5 ? blockstate.getValue(_getip5) : -1) <= 1;
		}
		return false;
	}
}
