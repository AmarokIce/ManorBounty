package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CosmicDragonSalad extends Item implements IFoodItem {
    public CosmicDragonSalad() {
        super(new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(9).saturationMod(0.3f).build()));
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
        return FoodType.COSMIC_DRAGON_SALAD;
    }

    @Override
    public int cooldownTime() {
        return 750 * 20;
    }

    @Override
    public FoodEffect getFoodEffect() {
        return FoodEffect.B.of()
                .addEffect(ModMobEffects.MOMENTARY_METEOR.get(),70,900*20,2,900*20,1800*20)
                .addEffect(ModMobEffects.HACKED_THORNS.get(),70,900*20,2,900*20,1800*20)
                .addEffect(ModMobEffects.SUMMER_HEATWAVE.get(),70,900*20,2,900*20,1800*20)
                ;
    }
}
