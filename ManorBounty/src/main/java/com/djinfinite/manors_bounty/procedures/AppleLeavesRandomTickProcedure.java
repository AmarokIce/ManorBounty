package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

public class AppleLeavesRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		FruitTreeLeavesRandomTickProcedure.execute(world, x, y, z, blockstate, new ItemStack(Items.APPLE), 2, 1);
	}
}
