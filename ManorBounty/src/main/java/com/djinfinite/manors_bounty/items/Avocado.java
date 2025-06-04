package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public abstract class Avocado extends Item implements IFoodItem {
    protected Avocado(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public FoodType getFoodType() {
        return FoodType.AVOCADO;
    }
    public static class HalfOf extends Avocado{

        public HalfOf() {
            super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.3f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of()
                    .addEffect(ModMobEffects.LURKING_DANGER.get(),50)
                    .addEffect(ModMobEffects.SUMMER_HEATWAVE.get(),50);
        }
    }
    public static class Slice extends Avocado{

        public Slice() {
            super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of()
                    .addEffect(ModMobEffects.LURKING_DANGER.get(),25)
                    .addEffect(ModMobEffects.SUMMER_HEATWAVE.get(),25);
        }
    }
}
