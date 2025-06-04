package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import org.jetbrains.annotations.NotNull;

public abstract class StarFruit extends Item implements IFoodItem {
    protected StarFruit(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.STARFRUIT;
    }

    public static class Self extends StarFruit {
        public Self() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.3f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of()
                    .addEffect(ModMobEffects.MOMENTARY_METEOR.get())
                    .addEffect(ModMobEffects.SUMMER_HEATWAVE.get())
                    ;
        }
    }

    public static class Sliced extends StarFruit {
        public Sliced() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of()
                    .addEffect(ModMobEffects.MOMENTARY_METEOR.get(), 33)
                    .addEffect(ModMobEffects.SUMMER_HEATWAVE.get(), 33);
        }
    }

    public static class IceCream extends StarFruit {
        public IceCream() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3f).alwaysEat().build()));
        }

        @Override
        public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemstack) {
            return UseAnim.EAT;
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.C;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.C.of()
                    .addEffect(ModMobEffects.MOMENTARY_METEOR.get())
                    .addEffect(ModMobEffects.SUMMER_HEATWAVE.get())
                    ;
        }
    }
}