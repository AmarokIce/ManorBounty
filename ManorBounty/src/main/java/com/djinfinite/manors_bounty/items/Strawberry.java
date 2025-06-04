package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.procedures.StrawberryBushPlantProcedure;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class Strawberry extends Item implements IFoodItem {
    protected Strawberry(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.STRAWBERRY;
    }

    public static class Self extends Strawberry {
        public Self() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.1f).build()));
        }

        @Override
        public InteractionResult useOn(UseOnContext context) {
            super.useOn(context);
            return StrawberryBushPlantProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getClickedFace(), context.getPlayer(), context.getItemInHand());
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

    public static class Shake extends Strawberry {
        public Shake() {
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
            return FoodEffect.B.of().addEffect(ModMobEffects.BURSTING_BERRY.get(), 70.0);
        }
    }

    public static class Donut extends Strawberry {
        public Donut() {
            super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(7).saturationMod(0.65f).alwaysEat().build()));
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