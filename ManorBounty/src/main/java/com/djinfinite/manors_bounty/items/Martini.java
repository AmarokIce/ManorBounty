package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class Martini extends Item implements IFoodItem{
    public Martini() {
        super(new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.1f).alwaysEat().build()));
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemstack) {
        return UseAnim.DRINK;
    }

    @Override
    public FoodEffectType getFoodEffectType() {
        return FoodEffectType.XB;
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.MARTINI;
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
        int toAdd = FruitsEffectConfig.FOODS_VALUE_X.get();
        FoodEffect.X.XB xb = FoodEffect.X.XB.of(
                FoodEffect.B.of().addEffect(ModMobEffects.SEA_TOUCH.get(), 70)
        );
        xb.tooltip.add(Component.translatable("tips.manors_bounty.olive_effect_time_add","I",toAdd).withStyle(ChatFormatting.DARK_AQUA));
        return xb.addConsumer(livingEntity -> addAllFruitEffectsDuration(livingEntity, toAdd*20));

    }
}
