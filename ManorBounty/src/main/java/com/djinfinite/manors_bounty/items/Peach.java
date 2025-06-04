/*
 * Copyright (c) 2025 fho4565.
 *
 * Licensed under the LGPL v3 License.
 * (you may not receive this file in the LGPL v3 License)
 */

package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class Peach extends Item implements IFoodItem {
    protected Peach(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.PEACH;
    }

    public static class Self extends Peach {
        public Self() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.3f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of().addEffect(ModMobEffects.ROSA_HEDGE.get());
        }
    }
    public static class Sliced extends Peach {
        public Sliced() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of().addEffect(ModMobEffects.ROSA_HEDGE.get(),33);
        }
    }
    public static class Juice extends Peach {
        public Juice() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.1f).alwaysEat().build()));
        }

        @Override
        public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemstack) {
            return UseAnim.DRINK;
        }

        @Override
        public ItemStack usedWhenNotInCooldown(Level level, Player player, ItemStack itemStack) {
            if(level.isClientSide()){
                return itemStack;
            }
            if(getFoodEffect().apply(player)){
                cooldown(player,this);
            }
            return returnCup(player,itemStack);
        }

        @Override
        public ItemStack usedWhenInCooldown(Level level, Player player, ItemStack itemStack) {
            return returnCup(player,itemStack);
        }
        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.B;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.B.of().addEffect(ModMobEffects.ROSA_HEDGE.get(),70.0);
        }
    }
}
