package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class Pineapple extends Item implements IFoodItem {
    protected Pineapple(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.PINEAPPLE;
    }

    public static class Sliced extends Pineapple {
        public Sliced() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.3f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of().addEffect(ModMobEffects.SUMMER_HEATWAVE.get(), 25);
        }
    }

    public static class Juice extends Pineapple {
        public Juice() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.1f).alwaysEat().build()));
        }

        @Override
        public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemstack) {
            return UseAnim.DRINK;
        }

        @Override
        public ItemStack usedWhenNotInCooldown(Level level, Player player, ItemStack itemStack) {
            if (getFoodEffect().apply(player)) {
                cooldown(player, this);
            }
            return returnCup(player, itemStack);
        }

        @Override
        public ItemStack usedWhenInCooldown(Level level, Player player, ItemStack itemStack) {
            return returnCup(player, itemStack);
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.B;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.B.of().addEffect(ModMobEffects.SUMMER_HEATWAVE.get(), 70.0);
        }
    }

    public static class Pie extends Pineapple {
        public Pie() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.35f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.C;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.C.of().addEffect(ModMobEffects.SUMMER_HEATWAVE.get());
        }
    }
    public static class Paleteria extends Pineapple {
        public Paleteria() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.2f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.C;
        }

        @Override
        public ItemStack usedWhenNotInCooldown(Level level, Player player, ItemStack itemStack) {
            if (getFoodEffect().apply(player)) {
                cooldown(player, this);
            }
            return returnItem(player, itemStack, Items.STICK.getDefaultInstance());
        }

        @Override
        public ItemStack usedWhenInCooldown(Level level, Player player, ItemStack itemStack) {
            return returnItem(player, itemStack, Items.STICK.getDefaultInstance());
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.C.of().addEffect(ModMobEffects.SUMMER_HEATWAVE.get());
        }
    }
    public static class Pastries extends Pineapple {
        public Pastries() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.6f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.C;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.C.of().addEffect(ModMobEffects.SUMMER_HEATWAVE.get());
        }
    }
}