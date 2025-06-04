
package com.djinfinite.manors_bounty.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class CookedBottonMushroomItem extends Item {
	public CookedBottonMushroomItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.6f).build()));
	}
}
