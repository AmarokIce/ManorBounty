
package com.djinfinite.manors_bounty.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;

import com.djinfinite.manors_bounty.procedures.MultipieFruitEffectUsingProcedure;
import org.jetbrains.annotations.NotNull;

public class HeartCrushPaleteriaItem extends Item {
	public HeartCrushPaleteriaItem() {
		super(new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.2f).build()));
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull LivingEntity entity) {
		ItemStack retval = new ItemStack(Items.STICK);
		super.finishUsingItem(itemstack, world, entity);
		MultipieFruitEffectUsingProcedure.execute(entity, itemstack);
		if (itemstack.isEmpty()) {
			return retval;
		} else {
			if (entity instanceof Player player && !player.getAbilities().instabuild) {
				if (!player.getInventory().add(retval))
					player.drop(retval, false);
			}
			return itemstack;
		}
	}
}
