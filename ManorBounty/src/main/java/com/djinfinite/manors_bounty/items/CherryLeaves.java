package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public abstract class CherryLeaves extends Item implements IFoodItem {
    protected CherryLeaves(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.CHERRY_LEAVES;
    }

    public static class HanamiDango extends CherryLeaves {
        public HanamiDango() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.6f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.C;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.C.of().addEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get());
        }
    }

    public static class SakuraMochi extends CherryLeaves {
        public SakuraMochi() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.6f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.C;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.C.of().addEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get());
        }
    }
}