package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;

public class PineappleCropBonemealCheckProcedure {
	public static boolean execute(BlockState blockstate) {
		return (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) < 5;
	}
}
