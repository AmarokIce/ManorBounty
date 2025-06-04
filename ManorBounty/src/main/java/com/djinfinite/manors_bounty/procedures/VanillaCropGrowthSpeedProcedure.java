package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class VanillaCropGrowthSpeedProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double growth_speed;
		growth_speed = 1;
		if (((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock().getStateDefinition().getProperty("moisture") instanceof IntegerProperty _getip1 ? (world.getBlockState(BlockPos.containing(x, y - 1, z))).getValue(_getip1) : -1) == 7
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ModBlocks.RICH_BLACK_DIRT_FARMLAND.get()) {
			growth_speed = growth_speed + 3;
		} else {
			growth_speed = growth_speed + 1;
		}
        if (((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock().getStateDefinition().getProperty("moisture") instanceof IntegerProperty _getip5
                ? (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getValue(_getip5)
                : -1) == 7 || (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == ModBlocks.RICH_BLACK_DIRT_FARMLAND.get()) {
            growth_speed = growth_speed + 0.75;
        } else if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(new ResourceLocation("forge:farmland")))) {
            growth_speed = growth_speed + 0.25;
        }
        if (((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock().getStateDefinition().getProperty("moisture") instanceof IntegerProperty _getip11
                ? (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getValue(_getip11)
                : -1) == 7 || (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == ModBlocks.RICH_BLACK_DIRT_FARMLAND.get()) {
            growth_speed = growth_speed + 0.75;
        } else if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(new ResourceLocation("forge:farmland")))) {
            growth_speed = growth_speed + 0.25;
        }
        if (((world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).getBlock().getStateDefinition().getProperty("moisture") instanceof IntegerProperty _getip17
                ? (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).getValue(_getip17)
                : -1) == 7 || (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).getBlock() == ModBlocks.RICH_BLACK_DIRT_FARMLAND.get()) {
            growth_speed = growth_speed + 0.75;
        } else if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).is(BlockTags.create(new ResourceLocation("forge:farmland")))) {
            growth_speed = growth_speed + 0.25;
        }
        if (((world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 1))).getBlock().getStateDefinition().getProperty("moisture") instanceof IntegerProperty _getip23
                ? (world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 1))).getValue(_getip23)
                : -1) == 7 || (world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 1))).getBlock() == ModBlocks.RICH_BLACK_DIRT_FARMLAND.get()) {
            growth_speed = growth_speed + 0.75;
        } else if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 1))).is(BlockTags.create(new ResourceLocation("forge:farmland")))) {
            growth_speed = growth_speed + 0.25;
        }
        if (((world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).getBlock().getStateDefinition().getProperty("moisture") instanceof IntegerProperty _getip29
                ? (world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).getValue(_getip29)
                : -1) == 7 || (world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).getBlock() == ModBlocks.RICH_BLACK_DIRT_FARMLAND.get()) {
            growth_speed = growth_speed + 0.75;
        } else if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).is(BlockTags.create(new ResourceLocation("forge:farmland")))) {
            growth_speed = growth_speed + 0.25;
        }
        if (((world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).getBlock().getStateDefinition().getProperty("moisture") instanceof IntegerProperty _getip35
                ? (world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).getValue(_getip35)
                : -1) == 7 || (world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).getBlock() == ModBlocks.RICH_BLACK_DIRT_FARMLAND.get()) {
            growth_speed = growth_speed + 0.75;
        } else if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).is(BlockTags.create(new ResourceLocation("forge:farmland")))) {
            growth_speed = growth_speed + 0.25;
        }
        if (((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock().getStateDefinition().getProperty("moisture") instanceof IntegerProperty _getip41
                ? (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getValue(_getip41)
                : -1) == 7 || (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == ModBlocks.RICH_BLACK_DIRT_FARMLAND.get()) {
            growth_speed = growth_speed + 0.75;
        } else if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(new ResourceLocation("forge:farmland")))) {
            growth_speed = growth_speed + 0.25;
        }
        if (((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock().getStateDefinition().getProperty("moisture") instanceof IntegerProperty _getip47
                ? (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getValue(_getip47)
                : -1) == 7 || (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == ModBlocks.RICH_BLACK_DIRT_FARMLAND.get()) {
            growth_speed = growth_speed + 0.75;
        } else if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(new ResourceLocation("forge:farmland")))) {
            growth_speed = growth_speed + 0.25;
        }
        if ((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == blockstate.getBlock() || (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == blockstate.getBlock()
				|| (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == blockstate.getBlock() || (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == blockstate.getBlock()
				|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == blockstate.getBlock() && (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == blockstate.getBlock()
				|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == blockstate.getBlock() && (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == blockstate.getBlock()
				|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == blockstate.getBlock() && (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == blockstate.getBlock()
				|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == blockstate.getBlock() && (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == blockstate.getBlock()) {
			growth_speed = growth_speed / 2;
		}
		return growth_speed;
	}
}
