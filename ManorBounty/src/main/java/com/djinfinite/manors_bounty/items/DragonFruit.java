package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.procedures.DragonFruitBlockPlaceProcedure;
import com.djinfinite.manors_bounty.procedures.DragonFruitSlicePlaceProcedure;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public abstract class DragonFruit extends Item implements IFoodItem {
    protected DragonFruit(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.DRAGON_FRUIT;
    }

    public static class Self extends DragonFruit {
        public Self() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.3f).build()));
        }
        @Override
        public InteractionResult useOn(UseOnContext context) {
            super.useOn(context);
            return DragonFruitBlockPlaceProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getClickedFace(), context.getPlayer(), context.getItemInHand());
        }
        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of()
                    .addEffect(ModMobEffects.HACKED_THORNS.get())
                    .addEffect(ModMobEffects.SUMMER_HEATWAVE.get())
                    ;
        }
    }

    public static class Slice extends DragonFruit {
        public Slice() {
            super(new Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3f).build()));
        }
        @Override
        public InteractionResult useOn(UseOnContext context) {
            super.useOn(context);
            return DragonFruitSlicePlaceProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getClickedFace(), context.getPlayer(), context.getItemInHand());
        }
        @Override
        public FoodEffectType getFoodEffectType() {
            return FoodEffectType.A;
        }

        @Override
        public FoodEffect getFoodEffect() {
            return FoodEffect.A.of()
                    .addEffect(ModMobEffects.HACKED_THORNS.get(), 33)
                    .addEffect(ModMobEffects.SUMMER_HEATWAVE.get(), 33)
                    ;
        }
    }
}