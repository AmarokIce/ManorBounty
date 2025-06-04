package com.djinfinite.manors_bounty.registries;

import com.djinfinite.manors_bounty.ManorsBountyMod;
import com.djinfinite.manors_bounty.world.features.LemonTree;
import com.djinfinite.manors_bounty.world.features.StarFruitTree;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, ManorsBountyMod.MOD_ID);

    public static final RegistryObject<LemonTree> LEMON_TREE = register("lemon_tree", LemonTree::new);
    public static final RegistryObject<StarFruitTree> STARFRUIT_TREE = register("starfruit_tree", StarFruitTree::new);

    public static <T extends Feature<?>> RegistryObject<T> register(final String name, final Supplier<T> sup) {
        return FEATURES.register(name, sup);
    }

    public static <F extends Feature<NoneFeatureConfiguration>> Holder.Reference<net.minecraft.world.level.levelgen.feature.ConfiguredFeature<?, ?>> registerTo(final BootstapContext<net.minecraft.world.level.levelgen.feature.ConfiguredFeature<?, ?>> context, final ResourceKey<net.minecraft.world.level.levelgen.feature.ConfiguredFeature<?, ?>> key, final RegistryObject<F> feature) {
        return context.register(key, new net.minecraft.world.level.levelgen.feature.ConfiguredFeature<>(feature.get(), NoneFeatureConfiguration.INSTANCE));
    }

    public static void bootstrap(final BootstapContext<net.minecraft.world.level.levelgen.feature.ConfiguredFeature<?, ?>> context) {
        registerTo(context, ModConfiguredFeature.LEMON_TREE, LEMON_TREE);
        registerTo(context, ModConfiguredFeature.STARFRUIT_TREE, STARFRUIT_TREE);
    }

}
