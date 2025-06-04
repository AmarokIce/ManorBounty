
package com.djinfinite.manors_bounty.item;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResult;

import com.djinfinite.manors_bounty.procedures.SoupDrinkDoneProcedure;
import com.djinfinite.manors_bounty.procedures.CreamWithMushroomSoupPlaceProcedure;
import org.jetbrains.annotations.NotNull;

public class CreamWithMushroomSoupItem extends Item {
	public CreamWithMushroomSoupItem() {
		super(new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(16).saturationMod(0.8f).alwaysEat().build()));
	}

	@Override
	public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull LivingEntity entity) {
		ItemStack retval = new ItemStack(ModBlocks.MARBLE_BOWL.get());
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		SoupDrinkDoneProcedure.execute(entity, itemstack);
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

	@Override
	public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
		super.useOn(context);
		return CreamWithMushroomSoupPlaceProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getClickedFace(), context.getPlayer(), context.getItemInHand());
	}
}
