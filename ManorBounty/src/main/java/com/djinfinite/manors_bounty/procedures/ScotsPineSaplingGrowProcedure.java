package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class ScotsPineSaplingGrowProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double chance = 0;
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		if (world instanceof ServerLevel _level)
			_level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolderOrThrow(FeatureUtils.createKey("manors_bounty:scots_pine_2")).value().place(_level, _level.getChunkSource().getGenerator(), _level.getRandom(),
					BlockPos.containing(x, y, z));
	}
}
