package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class Cherries extends Item implements IFoodItem {
    protected Cherries(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.CHERRIES;
    }

    public static class Self extends Cherries {
        public Self() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.1f).build()));
        }


        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of().addEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get());
        }
    }

    public static class Risalamande extends Cherries {
        public Risalamande() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.1f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.C;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.C.of().addEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get());
        }
    }

    public static class IceCream extends Cherries {
        public IceCream() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3f).alwaysEat().build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.C;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.C.of().addEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get());
        }
    }

    public static class PieSlice extends Cherries {
        public PieSlice() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.3f).build()));
        }

        @Override
        public ItemStack usedWhenNotInCooldown(Level level, Player player, ItemStack itemStack) {
            if (getFoodEffect().apply(player)) {
                cooldown(player, this);
            }
            return super.usedWhenNotInCooldown(level, player, itemStack);
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of().addEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get(), 33);
        }
    }
}