/*
 * Copyright (c) 2025 fho4565.
 *
 * Licensed under the LGPL v3 License.
 * (you may not receive this file in the LGPL v3 License)
 */

package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.procedures.CranberryBushPlantProcedure;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public abstract class Cranberry extends Item implements IFoodItem {
    protected Cranberry(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.CRANBERRY;
    }

    public static class Self extends Cranberry {
        public Self() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.1f).build()));
        }

        @Override
        public InteractionResult useOn(UseOnContext context) {
            super.useOn(context);
            return CranberryBushPlantProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getClickedFace(), context.getPlayer(), context.getItemInHand());
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

    public static class Muffin extends Cranberry {
        public Muffin() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.6f).build()));
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

    public static class Cookie extends Cranberry {
        public Cookie() {
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