package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class SweetBerryCake extends BlockItem implements IFoodItem {
    public SweetBerryCake(Block pBlock) {
        super(pBlock, new Item.Properties());
    }

    @Override
    public FoodEffectType getFoodEffectType() {
        return FoodEffectType.C;
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.SWEET_BERRIES;
    }

    @Override
    public FoodEffect getFoodEffect() {
        return FoodEffect.C.of().addEffect(ModMobEffects.BURSTING_BERRY.get());
    }
}
