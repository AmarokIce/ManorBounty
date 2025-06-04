package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class CherryBlossomsWeepingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.2) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CHERRY_LEAVES, x, (y + entity.getEyeHeight()), z, Mth.nextInt(RandomSource.create(), 1, 3), 1, 1, 1, 0.05);
		}
	}
}
