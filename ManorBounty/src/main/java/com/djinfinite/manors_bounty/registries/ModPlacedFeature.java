package com.djinfinite.manors_bounty.registries;

import com.djinfinite.manors_bounty.ManorsBountyMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeature {
    public static final ResourceKey<PlacedFeature> LEMON_TREE = createKey("lemon_tree_checked");
    public static final ResourceKey<PlacedFeature> STARFRUIT_TREE = createKey("lemon_tree_checked");

    public static void boostrap(final BootstapContext<PlacedFeature> context) {
        register(context, LEMON_TREE, ModConfiguredFeature.LEMON_TREE, checkTree(ModBlocks.LEMON_SEED));
        register(context, STARFRUIT_TREE, ModConfiguredFeature.STARFRUIT_TREE, checkTree(ModBlocks.STARFRUIT_SEED));

    }
    private static ResourceKey<PlacedFeature> createKey(final String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ManorsBountyMod.MOD_ID, name));
    }
    public static Holder.Reference<PlacedFeature> register(final BootstapContext<PlacedFeature> context, final ResourceKey<PlacedFeature> key, final ResourceKey<ConfiguredFeature<?, ?>> featureKey, final List<PlacementModifier> placement) {
        final Holder<ConfiguredFeature<?, ?>> feature = context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(featureKey);
        return context.register(key, new net.minecraft.world.level.levelgen.placement.PlacedFeature(feature, placement));
    }

    private static List<PlacementModifier> checkTree(RegistryObject<? extends Block> sapling) {
        return List.of(saplingFilter(sapling));
    }

    private static List<PlacementModifier> checkMangrove(RegistryObject<? extends Block> sapling, int maxWaterDepth) {
        return List.of(SurfaceWaterDepthFilter.forMaxDepth(maxWaterDepth), saplingFilter(sapling));
    }

    private static BlockPredicateFilter saplingFilter(RegistryObject<? extends Block> sapling) {
        return BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(sapling.get().defaultBlockState(), BlockPos.ZERO));
    }
}
