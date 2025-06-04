package com.djinfinite.manors_bounty.world.features;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class StarFruitTree extends Feature<NoneFeatureConfiguration> {
    public StarFruitTree() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        //TODO 自定义的树生成
        return false;
    }
}
