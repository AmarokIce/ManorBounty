
package com.djinfinite.manors_bounty.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import org.jetbrains.annotations.NotNull;

public class IceCreamConeItem extends Item {
	public IceCreamConeItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.6f).build()));
	}

	@Override
	public int getUseDuration(@NotNull ItemStack itemstack) {
		return 24;
	}
}
