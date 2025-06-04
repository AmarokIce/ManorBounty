package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class BlueberryCherriesIceCream extends Item implements IFoodItem {

    public BlueberryCherriesIceCream() {
        super(new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3f).build()));
    }

    @Override
    public FoodEffectType getFoodEffectType() {
        return FoodEffectType.C;
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.BLUEBERRY_AND_CHERRIES_ICE_CREAM;
    }

    @Override
    public FoodEffect getFoodEffect() {
        return FoodEffect.C.of()
                .addEffect(ModMobEffects.BURSTING_BERRY.get())
                .addEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
                ;
    }
}
