package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class RichBlackDirtFarmlandRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double chance;
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() instanceof BonemealableBlock) {
			chance = Mth.nextInt(RandomSource.create(), 1, 100);
			if (world instanceof Level _level) {
				BlockPos _bp = BlockPos.containing(x, y + 1, z);
				if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
					if (!_level.isClientSide())
						_level.levelEvent(2005, _bp, 0);
				}
			}
			if (chance <= 25) {
				if (world instanceof Level _level) {
					BlockPos _bp = BlockPos.containing(x, y + 1, z);
					if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
						if (!_level.isClientSide())
							_level.levelEvent(2005, _bp, 0);
					}
				}
			}
			if (chance <= 8) {
				if (world instanceof Level _level) {
					BlockPos _bp = BlockPos.containing(x, y + 1, z);
					if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
						if (!_level.isClientSide())
							_level.levelEvent(2005, _bp, 0);
					}
				}
			}
			if (chance <= 3) {
				if (world instanceof Level _level) {
					BlockPos _bp = BlockPos.containing(x, y + 1, z);
					if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
						if (!_level.isClientSide())
							_level.levelEvent(2005, _bp, 0);
					}
				}
			}
		}
	}
}
