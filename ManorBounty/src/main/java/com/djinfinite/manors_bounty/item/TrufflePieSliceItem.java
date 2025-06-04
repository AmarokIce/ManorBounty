
package com.djinfinite.manors_bounty.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.InteractionResult;

import com.djinfinite.manors_bounty.procedures.BigPieSlicePlaceProcedure;
import org.jetbrains.annotations.NotNull;

public class TrufflePieSliceItem extends Item {
	public TrufflePieSliceItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3f).build()));
	}

	@Override
	public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
		super.useOn(context);
		return BigPieSlicePlaceProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getClickedFace(), context.getPlayer(), context.getItemInHand());
	}
}
