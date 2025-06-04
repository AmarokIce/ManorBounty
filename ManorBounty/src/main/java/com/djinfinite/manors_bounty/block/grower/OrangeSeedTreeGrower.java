package com.djinfinite.manors_bounty.block.grower;

import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.util.RandomSource;
import net.minecraft.resources.ResourceKey;
import net.minecraft.data.worldgen.features.FeatureUtils;
import org.jetbrains.annotations.NotNull;

public class OrangeSeedTreeGrower extends AbstractTreeGrower {
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull RandomSource randomSource, boolean hasFlower) {
		return FeatureUtils.createKey("manors_bounty:orange_tree_spawn");
	}
}
