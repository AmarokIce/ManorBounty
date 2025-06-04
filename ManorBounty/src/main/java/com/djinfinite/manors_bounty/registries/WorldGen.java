package com.djinfinite.manors_bounty.registries;

import com.djinfinite.manors_bounty.ManorsBountyMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class WorldGen {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeature::boostrap)
            ;

    public static HolderLookup.Provider createLookup(final HolderLookup.Provider vanillaProvider) {
        final RegistryAccess.Frozen registryAccess = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);
        return BUILDER.buildPatch(registryAccess, vanillaProvider);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(final String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ManorsBountyMod.MOD_ID, name));
    }
}