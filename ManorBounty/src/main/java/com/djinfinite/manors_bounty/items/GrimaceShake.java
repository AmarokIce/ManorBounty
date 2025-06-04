package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GrimaceShake extends Item implements IFoodItem {
    public GrimaceShake() {
        super(new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.1f).alwaysEat().build()));
    }

    @Override
    public FoodEffectType getFoodEffectType() {
        return FoodEffectType.B;
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.GRIMACE_SHAKE;
    }

    @Override
    public int cooldownTime() {
        return 750 * 20;
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
    public FoodEffect getFoodEffect() {
        return FoodEffect.B.of()
                .addEffect(ModMobEffects.BURSTING_BERRY.get(),70,900*20,1,900*20,1800*20)
                .addEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get(),70,900*20,1,900*20,1800*20)
                ;
    }
}
