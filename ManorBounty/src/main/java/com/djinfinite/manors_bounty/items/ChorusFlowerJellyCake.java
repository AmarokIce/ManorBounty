package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class ChorusFlowerJellyCake extends BlockItem implements IFoodItem {
    public ChorusFlowerJellyCake(Block pBlock) {
        super(pBlock, new Properties());
    }

    @Override
    public FoodEffectType getFoodEffectType() {
        return FoodEffectType.C;
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.CHORUS_FRUIT;
    }

    @Override
    public FoodEffect getFoodEffect() {
        return FoodEffect.C.of().addEffect(ModMobEffects.TRANSMIT.get());
    }
}
