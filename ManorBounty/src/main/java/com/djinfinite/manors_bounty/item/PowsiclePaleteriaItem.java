
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

public class PowsiclePaleteriaItem extends Item {
	public PowsiclePaleteriaItem() {
		super(new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.2f).build()));
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull LivingEntity entity) {
		ItemStack retval = new ItemStack(Items.STICK);
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
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
