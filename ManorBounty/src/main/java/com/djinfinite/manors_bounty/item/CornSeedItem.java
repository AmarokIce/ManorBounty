
package com.djinfinite.manors_bounty.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import com.djinfinite.manors_bounty.procedures.CornPlantProcedure;
import org.jetbrains.annotations.NotNull;

public class CornSeedItem extends Item {
	public CornSeedItem() {
		super(new Item.Properties());
	}

	@Override
	public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
		super.useOn(context);
		return CornPlantProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getClickedFace(), context.getPlayer(), context.getItemInHand());
	}
}
