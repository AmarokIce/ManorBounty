package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class SweetBerries extends Item implements IFoodItem {
    protected SweetBerries(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.SWEET_BERRIES;
    }
    public static class Self implements IFoodItem {
        @Override
        public FoodType getFoodType() {
            return FoodType.SWEET_BERRIES;
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
    public static class CakeSlice extends SweetBerries {
        public CakeSlice() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.1f).build()));
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
    public static class EtonMess extends SweetBerries {

        public EtonMess() {
            super(new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.6f).alwaysEat().build()));
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
            return FoodEffectType.C;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.C.of().addEffect(ModMobEffects.BURSTING_BERRY.get(),92.5,25,1, FruitsEffectConfig.FOODS_NEW_TIME_C.get() * 20);
        }
    }
}