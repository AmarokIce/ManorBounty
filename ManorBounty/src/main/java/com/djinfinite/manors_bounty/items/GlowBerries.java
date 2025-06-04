package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.item.Item;

public abstract class GlowBerries extends Item implements IFoodItem {
    protected GlowBerries(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.GLOW_BERRIES;
    }

    public static class Self implements IFoodItem {
        @Override
        public FoodType getFoodType() {
            return FoodType.GLOW_BERRIES;
        }
        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of().addEffect(ModMobEffects.BURSTING_BERRY.get());
        }
    }
}
