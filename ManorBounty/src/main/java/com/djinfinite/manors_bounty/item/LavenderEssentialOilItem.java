
package com.djinfinite.manors_bounty.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import com.djinfinite.manors_bounty.procedures.LavenderEssentialOilUseProcedure;
import org.jetbrains.annotations.NotNull;

public class LavenderEssentialOilItem extends Item {
	public LavenderEssentialOilItem() {
		super(new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(0).saturationMod(0f).alwaysEat().build()));
	}

	@Override
	public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public int getUseDuration(@NotNull ItemStack itemstack) {
		return 16;
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		LavenderEssentialOilUseProcedure.execute(entity, itemstack);
		return retval;
	}
}
