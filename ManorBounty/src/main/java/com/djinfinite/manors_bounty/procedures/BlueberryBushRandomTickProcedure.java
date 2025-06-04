package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;

public class BlueberryBushRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (Math.random() < 0.2) {
			BlueberryBushBonemealUseProcedure.execute(world, x, y, z, blockstate);
		}
	}
}
