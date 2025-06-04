package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RosaSalad extends Item implements IFoodItem {
    public RosaSalad() {
        super(new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(7).saturationMod(0.3f).build()));
    }

    @Override
    public FoodEffectType getFoodEffectType() {
        return FoodEffectType.B;
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.ROSA_SALAD;
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
    public int cooldownTime() {
        return 750 * 20;
    }

    @Override
    public FoodEffect getFoodEffect() {
        return FoodEffect.B.of()
                .addEffect(ModMobEffects.ROSA_HEDGE.get(),70,900*20,2,900*20,1800*20)
                ;
    }
}
