
package com.djinfinite.manors_bounty.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import com.djinfinite.manors_bounty.procedures.JalapenoEatProcedure;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class JalapenoIceCreamItem extends Item {
	public JalapenoIceCreamItem() {
		super(new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3f).alwaysEat().build()));
	}
	@Override
	public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
		super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
		pTooltip.add(Component.translatable("effect.manors_bounty.warm_shield").append(" (0:02)").withStyle(ChatFormatting.BLUE));
	}
	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		JalapenoEatProcedure.execute(entity, itemstack);
		return retval;
	}
}
