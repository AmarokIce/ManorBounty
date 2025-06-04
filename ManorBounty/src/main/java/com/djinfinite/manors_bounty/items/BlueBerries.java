/*
 * Copyright (c) 2025 fho4565.
 *
 * Licensed under the LGPL v3 License.
 * (you may not receive this file in the LGPL v3 License)
 */

package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.procedures.BlueberryBushPlantProcedure;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import org.jetbrains.annotations.NotNull;

public abstract class BlueBerries extends Item implements IFoodItem {
    protected BlueBerries(Properties properties) {
        super(properties);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.BLUEBERRIES;
    }

    public static class Self extends BlueBerries {
        public Self() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.1f).build()));
        }

        @Override
        public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
            super.useOn(context);
            return BlueberryBushPlantProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getClickedFace(), context.getPlayer(), context.getItemInHand());
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

    public static class BlueBerryYogurt extends BlueBerries {
        public BlueBerryYogurt() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.1f).alwaysEat().build()));
        }

        @Override
        public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemstack) {
            return UseAnim.DRINK;
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.C;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.C.of().addEffect(ModMobEffects.BURSTING_BERRY.get());
        }
    }

    public static class BlueBerryIceCream extends BlueBerries {
        public BlueBerryIceCream() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3f).alwaysEat().build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.C;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.C.of().addEffect(ModMobEffects.BURSTING_BERRY.get());
        }
    }

    public static class BlueBerryMuffin extends BlueBerries {
        public BlueBerryMuffin() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.6f).alwaysEat().build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.C;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.C.of().addEffect(ModMobEffects.BURSTING_BERRY.get());
        }
    }

    public static class BlueBerryCookie extends BlueBerries {
        public BlueBerryCookie() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.1f).alwaysEat().build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.C;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.C.of().addEffect(ModMobEffects.BURSTING_BERRY.get());
        }
    }
}