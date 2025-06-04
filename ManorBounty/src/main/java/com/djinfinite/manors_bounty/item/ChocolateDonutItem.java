
package com.djinfinite.manors_bounty.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class ChocolateDonutItem extends Item {
	public ChocolateDonutItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(9).saturationMod(0.65f).build()));
	}
}
