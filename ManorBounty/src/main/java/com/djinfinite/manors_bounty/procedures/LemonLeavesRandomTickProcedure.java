package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModItems;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

public class LemonLeavesRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double chance = 0;
		ItemStack item_stick = ItemStack.EMPTY;
		ItemStack item_lemon = ItemStack.EMPTY;
		FruitTreeLeavesRandomTickProcedure.execute(world, x, y, z, blockstate, new ItemStack(ModItems.LEMON.get()), 2, 1);
	}
}
