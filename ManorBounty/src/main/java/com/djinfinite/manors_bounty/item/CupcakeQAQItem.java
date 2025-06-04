
package com.djinfinite.manors_bounty.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class CupcakeQAQItem extends Item {
	public CupcakeQAQItem() {
		super(new Item.Properties().rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.6f).build()));
	}
}
