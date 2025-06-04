package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;
import com.djinfinite.manors_bounty.registries.ModBlocks;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SeaPearlSalad extends Item implements IFoodItem{
    public SeaPearlSalad() {
        super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.3f).alwaysEat().build()));
    }

    @Override
    public FoodEffectType getFoodEffectType() {
        return FoodEffectType.XB;
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.SEA_PEARL_SALAD;
    }

    @Override
    public ItemStack usedWhenNotInCooldown(Level level, Player player, ItemStack itemStack) {
        if(getFoodEffect().apply(player)){
            cooldown(player,this);
        }
        return returnItem(player,itemStack,new ItemStack(ModBlocks.MARBLE_BOWL.get()));
    }

    @Override
    public ItemStack usedWhenInCooldown(Level level, Player player, ItemStack itemStack) {
        return returnItem(player,itemStack,new ItemStack(ModBlocks.MARBLE_BOWL.get()));
    }

    @Override
    public FoodEffect getFoodEffect() {
        int toAdd = FruitsEffectConfig.FOODS_VALUE_X.get()*2;
        FoodEffect.X.XB xb = FoodEffect.X.XB.of(
                FoodEffect.B.of()
                        .addEffect(ModMobEffects.SEA_TOUCH.get(), 70)
                        .addEffect(ModMobEffects.BURSTING_BERRY.get(), 70)
        );
        xb.addTooltip(Component.translatable("tips.manors_bounty.olive_effect_time_add","I",toAdd).withStyle(ChatFormatting.DARK_AQUA));
        return xb.addConsumer(livingEntity -> addAllFruitEffectsDuration(livingEntity, toAdd*20));

    }
}
