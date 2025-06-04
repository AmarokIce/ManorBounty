package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public abstract class OliveFruit extends Item implements IFoodItem {
    protected OliveFruit(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.OLIVE_FRUIT;
    }

    public static class Self extends OliveFruit {
        public Self() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.6f).alwaysEat().build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of().addEffect(ModMobEffects.SEA_TOUCH.get());
        }
    }
}