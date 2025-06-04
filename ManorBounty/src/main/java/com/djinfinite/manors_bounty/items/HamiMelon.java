package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class HamiMelon extends Item implements IFoodItem {
    protected HamiMelon(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.HAMI_MELON;
    }

    public static class Slice extends HamiMelon {
        public Slice() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of().addEffect(ModMobEffects.MELON_GRAVITY.get(), 0.11);
        }
    }

    public static class Soda extends HamiMelon {
        public Soda() {
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
            return FoodEffect.B.of().addEffect(ModMobEffects.MELON_GRAVITY.get(), 70.0);
        }
    }

    public static class Paleteria extends HamiMelon {
        public Paleteria() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.2f).alwaysEat().build()));
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
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.C;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.C.of().addEffect(ModMobEffects.MELON_GRAVITY.get());
        }
    }
}