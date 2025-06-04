package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class StarfruitJalapenoIceCream extends Item implements IFoodItem {

    public StarfruitJalapenoIceCream() {
        super(new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3f).build()));
    }
    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
        pTooltip.add(Component.translatable("effect.manors_bounty.warm_shield").append(" (0:02)").withStyle(ChatFormatting.BLUE));
	}
    @Override
    public FoodEffectType getFoodEffectType() {
        return FoodEffectType.C;
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.STARFRUIT_JALAPENO_ICE_CREAM;
    }

    @Override
    public FoodEffect getFoodEffect() {
        return FoodEffect.C.of()
                .addEffect(ModMobEffects.MOMENTARY_METEOR.get())
                .addEffect(ModMobEffects.SUMMER_HEATWAVE.get())
                ;
    }
}
