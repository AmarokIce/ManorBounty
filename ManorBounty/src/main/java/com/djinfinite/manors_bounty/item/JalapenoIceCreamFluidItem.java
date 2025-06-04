
package com.djinfinite.manors_bounty.item;

import com.djinfinite.manors_bounty.registries.ModFluids;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

public class JalapenoIceCreamFluidItem extends BucketItem {
	public JalapenoIceCreamFluidItem() {
		super(ModFluids.JALAPENO_ICE_CREAM_FLUID, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1));
	}
}
