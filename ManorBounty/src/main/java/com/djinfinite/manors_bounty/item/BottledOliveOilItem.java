
package com.djinfinite.manors_bounty.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class BottledOliveOilItem extends Item {
	public BottledOliveOilItem() {
		super(new Item.Properties().durability(16));
	}

	@Override
	public boolean hasCraftingRemainingItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		ItemStack stack = new ItemStack(this);
		stack.setDamageValue(itemstack.getDamageValue() + 1);
		if (stack.getDamageValue() >= stack.getMaxDamage()) {
			return ItemStack.EMPTY;
		}
		return stack;
	}

	@Override
	public boolean isRepairable(@NotNull ItemStack itemstack) {
		return false;
	}
}
