package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class HeartCrushPaleteria extends Item implements IFoodItem {
    public HeartCrushPaleteria() {
        super(new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.2f).build()));
    }

    @Override
    public FoodEffectType getFoodEffectType() {
        return FoodEffectType.C;
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.HEART_CRUSH_PALETERIA;
    }

    @Override
    public FoodEffect getFoodEffect() {
        return FoodEffect.C.of()
                .addEffect(ModMobEffects.ROSA_HEDGE.get())
                .addEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
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
