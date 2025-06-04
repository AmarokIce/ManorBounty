
package com.djinfinite.manors_bounty.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import com.djinfinite.manors_bounty.registries.ModFluids;

public class ChocolateIceCreamFluidItem extends BucketItem {
	public ChocolateIceCreamFluidItem() {
		super(ModFluids.CHOCOLATE_ICE_CREAM_FLUID, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1));
	}
}
