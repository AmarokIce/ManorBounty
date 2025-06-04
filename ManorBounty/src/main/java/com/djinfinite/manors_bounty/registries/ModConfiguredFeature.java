package com.djinfinite.manors_bounty.registries;

import com.djinfinite.manors_bounty.ManorsBountyMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class ModConfiguredFeature {
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON_TREE = createKey("lemon_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STARFRUIT_TREE = createKey("starfruit_tree");

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(final String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ManorsBountyMod.MOD_ID, name));
    }
}
