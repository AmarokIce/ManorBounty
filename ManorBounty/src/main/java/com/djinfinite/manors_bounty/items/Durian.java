package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public abstract class Durian extends Item implements IFoodItem {
    protected Durian(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.DURIAN;
    }

    public static class HalfOf extends Durian {
        public HalfOf() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.3f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of()
                    .addEffect(ModMobEffects.HACKED_THORNS.get(),50)
                    .addEffect(ModMobEffects.SUMMER_HEATWAVE.get(),50);
        }
    }

    public static class Flesh extends Durian {
        public Flesh() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of()
                    .addEffect(ModMobEffects.HACKED_THORNS.get(),16.6)
                    .addEffect(ModMobEffects.SUMMER_HEATWAVE.get(),16.6);
        }
    }

    public static class CookedFlesh extends Durian {
        public CookedFlesh() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.3f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.B;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.B.of()
                    .addEffect(ModMobEffects.HACKED_THORNS.get(), 70.0)
                    .addEffect(ModMobEffects.SUMMER_HEATWAVE.get(), 70.0);
        }
    }

    public static class Crisp extends Durian {
        public Crisp() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.35f).alwaysEat().build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.B;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.B.of()
                    .addEffect(ModMobEffects.HACKED_THORNS.get(), 70.0)
                    .addEffect(ModMobEffects.SUMMER_HEATWAVE.get(), 70.0);
        }
    }

    public static class Cake extends Durian {
        public Cake() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.3f).alwaysEat().build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.C;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.C.of()
                    .addEffect(ModMobEffects.HACKED_THORNS.get())
                    .addEffect(ModMobEffects.SUMMER_HEATWAVE.get())
                    ;
        }
    }

    public static class CakeSlice extends Durian {
        public CakeSlice() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3f).alwaysEat().build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.C;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.C.of()
                    .addEffect(ModMobEffects.HACKED_THORNS.get())
                    .addEffect(ModMobEffects.SUMMER_HEATWAVE.get())
                    ;
        }
    }
}