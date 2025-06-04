
package com.djinfinite.manors_bounty.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import com.djinfinite.manors_bounty.procedures.HamimelonCropPlantProcedure;
import org.jetbrains.annotations.NotNull;

public class HamimelonSeedItem extends Item {
	public HamimelonSeedItem() {
		super(new Item.Properties());
	}

	@Override
	public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
		super.useOn(context);
		return HamimelonCropPlantProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getClickedFace(), context.getPlayer(), context.getItemInHand());
	}
}
