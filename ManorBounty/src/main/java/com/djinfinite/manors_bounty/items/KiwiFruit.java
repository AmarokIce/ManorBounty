package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;


public abstract class KiwiFruit extends Item implements IFoodItem {
    protected KiwiFruit(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.KIWIFRUIT;
    }

    public static class HalfOf extends KiwiFruit {
        public HalfOf() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.3f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of().addEffect(ModMobEffects.KIWING_WHEREABOUTS.get(),50);
        }
    }

    public static class Slice extends KiwiFruit {
        public Slice() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of().addEffect(ModMobEffects.KIWING_WHEREABOUTS.get(), 25);
        }
    }
}