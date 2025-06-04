package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class PineBerry extends Item implements IFoodItem {
    public PineBerry() {
        super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.1f).build()));
    }

    @Override
    public FoodEffectType getFoodEffectType() {
        return FoodEffectType.A;
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.PINE_BERRY;
    }

    @Override
    public FoodEffect getFoodEffect() {
        return FoodEffect.A.of().addEffect(ModMobEffects.BURSTING_BERRY.get(),100,3);
    }
}
