package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class Mango extends Item implements IFoodItem {
    protected Mango(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.MANGO;
    }

    public static class Self extends Mango {
        public Self() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.3f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of().addEffect(ModMobEffects.SUMMER_HEATWAVE.get()).addEffect(ModMobEffects.ORIGINAL_EVOLUTION.get());
        }
    }

    public static class Slice extends Mango {
        public Slice() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.3f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of()
                    .addEffect(ModMobEffects.SUMMER_HEATWAVE.get(),50)
                    .addEffect(ModMobEffects.ORIGINAL_EVOLUTION.get(),50);
        }
    }

    public static class Juice extends Mango {
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
            return FoodEffect.B.of()
                    .addEffect(ModMobEffects.SUMMER_HEATWAVE.get(), 70.0)
                    .addEffect(ModMobEffects.ORIGINAL_EVOLUTION.get(), 70.0);
        }
    }

    public static class Pudding extends Mango {
        public Pudding() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.3f).alwaysEat().build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.C;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.C.of()
                    .addEffect(ModMobEffects.SUMMER_HEATWAVE.get())
                    .addEffect(ModMobEffects.ORIGINAL_EVOLUTION.get())
                    ;
        }
    }
}