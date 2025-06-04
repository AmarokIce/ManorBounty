package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModItems;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

public class OrangeLeavesRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		FruitTreeLeavesRandomTickProcedure.execute(world, x, y, z, blockstate, new ItemStack(ModItems.ORANGE.get()), 2, 1);
	}
}
