package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResult;

import com.djinfinite.manors_bounty.registries.ModItems;

public class OliveTreeLeavesRightClickProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) == 5) {
			FruitTreeLeavesRightClickProcedure.execute(world, x, y, z, new ItemStack(ModItems.OLIVE_FRUIT.get()), 5, 3);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}
}
