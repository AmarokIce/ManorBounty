package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class CherriesPieRightClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			BigPieTrunProcedure.execute(world, x, y, z, blockstate);
		} else {
			PieEatProcedure.execute(world, x, y, z, entity);
		}
	}
}
