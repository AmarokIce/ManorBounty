
package com.djinfinite.manors_bounty.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResult;

import com.djinfinite.manors_bounty.procedures.JalapenoEatProcedure;
import com.djinfinite.manors_bounty.procedures.JalapenoCropPlantProcedure;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class JalapenoItem extends Item {
	public JalapenoItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3f).alwaysEat().build()));
	}
	@Override
	public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
		super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
		pTooltip.add(Component.translatable("effect.manors_bounty.warm_shield").append(" (0:01)").withStyle(ChatFormatting.BLUE));
	}
	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		JalapenoEatProcedure.execute(entity, itemstack);
		return retval;
	}

	@Override
	public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
		super.useOn(context);
		return JalapenoCropPlantProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getClickedFace(), context.getPlayer(), context.getItemInHand());
	}
}
