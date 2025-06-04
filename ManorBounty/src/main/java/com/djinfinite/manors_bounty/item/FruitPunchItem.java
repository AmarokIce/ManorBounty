
package com.djinfinite.manors_bounty.item;

import com.djinfinite.manors_bounty.registries.ModItems;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;

import org.jetbrains.annotations.NotNull;

public class FruitPunchItem extends Item {
	public FruitPunchItem() {
		super(new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.1f).alwaysEat().build()));
	}

	@Override
	public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull LivingEntity entity) {
		ItemStack retval = new ItemStack(ModItems.DEFORMED_GLASS_BOTTLE.get());
		super.finishUsingItem(itemstack, world, entity);
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
