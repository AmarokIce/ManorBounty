
package com.djinfinite.manors_bounty.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import com.djinfinite.manors_bounty.procedures.ChorusFruitFoodsEffectUsingProcedure;
import org.jetbrains.annotations.NotNull;

public class ChorusChromeCubeItem extends Item {
	public ChorusChromeCubeItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.3f).alwaysEat().build()));
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		ChorusFruitFoodsEffectUsingProcedure.execute(entity, itemstack);
		return retval;
	}
}
