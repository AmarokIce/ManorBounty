package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class ScotsPineSaplingBonemealUseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double chance;
		chance = Mth.nextInt(RandomSource.create(), 1, 100);
		if (chance <= 46) {
			ScotsPineSaplingGrowProcedure.execute(world, x, y, z);
		}
	}
}
