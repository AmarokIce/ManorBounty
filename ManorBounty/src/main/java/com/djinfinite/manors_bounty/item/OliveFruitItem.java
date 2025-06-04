
package com.djinfinite.manors_bounty.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import com.djinfinite.manors_bounty.procedures.OliveFruitFoodsEffectUsingProcedure;
import org.jetbrains.annotations.NotNull;

public class OliveFruitItem extends Item {
	public OliveFruitItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.6f).build()));
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull LivingEntity entity) {
		OliveFruitFoodsEffectUsingProcedure.execute(entity, itemstack);
		return super.finishUsingItem(itemstack, world, entity);
	}
}
