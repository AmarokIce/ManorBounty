package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

import com.djinfinite.manors_bounty.registries.ModItems;

public class StarfruitTreeRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		FruitTreeLeavesRandomTickProcedure.execute(world, x, y, z, blockstate, new ItemStack(ModItems.STARFRUIT.get()), 1, 1);
	}
}
