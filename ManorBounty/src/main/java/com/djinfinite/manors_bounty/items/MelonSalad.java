package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MelonSalad extends Item implements IFoodItem {
    public MelonSalad() {
        super(new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.3f).build()));
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
    public FoodEffectType getFoodEffectType() {
        return FoodEffectType.B;
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.MELON_SALAD;
    }


    @Override
    public FoodEffect getFoodEffect() {
        return FoodEffect.B.of()
                .addEffect(ModMobEffects.MELON_GRAVITY.get(),70,900*20,1,900*20,1800*20)
                ;
    }
}
