package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class Pear extends Item implements IFoodItem {
    protected Pear(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.PEAR;
    }

    public static class Self extends Pear {
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

    public static class Slice extends Pear {
        public Slice() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3f).build()));
        }

        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of().addEffect(ModMobEffects.ROSA_HEDGE.get(), 33);
        }
    }

    public static class Juice extends Pear {
        public Juice() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.1f).alwaysEat().build()));
        }

        @Override
        public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemstack) {
            return UseAnim.DRINK;
        }

        @Override
        public ItemStack usedWhenNotInCooldown(Level level, Player player, ItemStack itemStack) {
            double b_type_add_time = FruitsEffectConfig.FOODS_ADD_TIME_B.get() * 20;
            double b_type_new_time = FruitsEffectConfig.FOODS_NEW_TIME_B.get() * 20;
            boolean hasEffect;
            int currentEffectLevel = 0;
            int currentEffectTime = 0;
            hasEffect = player.hasEffect(ModMobEffects.ROSA_HEDGE.get());
            MobEffectInstance effect = player.getEffect(ModMobEffects.ROSA_HEDGE.get());
            if (effect != null) {
                currentEffectLevel = effect.getAmplifier();
                currentEffectTime = effect.getDuration();
            }
            double random = Math.random();
            if (random < 0.7) {
                if (hasEffect) {
                    player.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) (currentEffectTime + b_type_add_time), currentEffectLevel, false, false));
                    cooldown(player, this);
                }
            } else {
                if (currentEffectLevel <= 4) {
                    if (hasEffect) {
                        player.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) (currentEffectTime + b_type_add_time), currentEffectLevel + 1, false, false));
                    } else {
                        player.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) b_type_new_time, 0, false, false));
                    }
                    cooldown(player, this);
                }
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
            return FoodEffect.B.of().addEffect(ModMobEffects.ROSA_HEDGE.get(), 70.0);
        }
    }
}