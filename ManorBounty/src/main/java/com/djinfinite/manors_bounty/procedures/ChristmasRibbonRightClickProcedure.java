package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class ChristmasRibbonRightClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		ChristmasMiniGiftTransProcedure.execute(world, x, y, z, blockstate, entity);
		ChristmasBaublesTransProcedure.execute(world, x, y, z, blockstate, entity);
	}
}
