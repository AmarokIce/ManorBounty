package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class PowsiclePaleteria extends Item implements IFoodItem {
    public PowsiclePaleteria() {
        super(new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.2f).build()));
    }

    @Override
    public FoodEffectType getFoodEffectType() {
        return FoodEffectType.C;
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.POWSICLE_PALETERIA;
    }

    @Override
    public FoodEffect getFoodEffect() {
        return FoodEffect.C.of()
                .addEffect(ModMobEffects.BURSTING_BERRY.get(),95,30,1,480*20)
                ;
    }

    @Override
    public ItemStack usedWhenNotInCooldown(Level level, Player player, ItemStack itemStack) {
        if (getFoodEffect().apply(player)) {
            cooldown(player, this);
        }
        return returnItem(player, itemStack, Items.STICK.getDefaultInstance());
    }

    @Override
    public ItemStack usedWhenInCooldown(Level level, Player player, ItemStack itemStack) {
        return returnItem(player, itemStack, Items.STICK.getDefaultInstance());
    }
}
