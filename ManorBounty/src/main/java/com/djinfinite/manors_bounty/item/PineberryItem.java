
package com.djinfinite.manors_bounty.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import com.djinfinite.manors_bounty.procedures.StrawberryFoodEffectUsingProcedure;
import org.jetbrains.annotations.NotNull;

public class PineberryItem extends Item {
	public PineberryItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.2f).build()));
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		StrawberryFoodEffectUsingProcedure.execute(entity, itemstack);
		return retval;
	}
}
