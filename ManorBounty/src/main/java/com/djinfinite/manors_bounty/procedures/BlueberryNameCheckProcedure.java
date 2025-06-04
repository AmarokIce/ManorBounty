package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class BlueberryNameCheckProcedure {
	public static double execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return 0;
		if ((itemstack.getDisplayName().getString()).equals("[Electric Blueberry]") || (itemstack.getDisplayName().getString()).equals("[\u7535\u51FB\u84DD\u8393]")) {
			if (entity instanceof Player _plrCldCheck5 && _plrCldCheck5.getCooldowns().isOnCooldown(itemstack.getItem())) {
				return 2;
			} else {
				return 1;
			}
		}
		return 0;
	}
}
