package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class Apple extends Item implements IFoodItem {
    protected Apple(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public FoodType getFoodType() {
        return FoodType.APPLE;
    }
    public static class Self implements IFoodItem {
        @Override
        public FoodType getFoodType() {
            return FoodType.APPLE;
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
    public static class Golden implements IFoodItem {
        @Override
        public FoodType getFoodType() {
            return FoodType.APPLE;
        }
        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.B;
        }
        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.B.of().addEffect(ModMobEffects.ROSA_HEDGE.get(),70);
        }
    }
    public static class Enchanted implements IFoodItem {
        @Override
        public FoodType getFoodType() {
            return FoodType.APPLE;
        }
        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.C;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.C.of().addEffect(ModMobEffects.ROSA_HEDGE.get());
        }
    }
    public static class Slice extends Apple {
        public Slice() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3f).alwaysEat().build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of().addEffect(ModMobEffects.ROSA_HEDGE.get(),33.3);
        }
    }
    public static class Drink extends Apple {
        public Drink() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.1f).alwaysEat().build()));
        }

        @Override
        public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemstack) {
            return UseAnim.DRINK;
        }

        @Override
        public ItemStack usedWhenNotInCooldown(Level level, Player player, ItemStack itemStack) {
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