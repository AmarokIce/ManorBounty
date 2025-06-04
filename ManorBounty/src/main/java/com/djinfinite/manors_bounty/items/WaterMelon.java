package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class WaterMelon extends Item implements IFoodItem {
    protected WaterMelon(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.MELON;
    }
    public static class Self implements IFoodItem {
        @Override
        public FoodType getFoodType() {
            return FoodType.MELON;
        }
        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of().addEffect(ModMobEffects.MELON_GRAVITY.get());
        }
    }
    public static class Juice extends WaterMelon {
        public Juice() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.1f).alwaysEat().build()));
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

    public static class Paleteria extends WaterMelon {
        public Paleteria() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.2f).alwaysEat().build()));
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