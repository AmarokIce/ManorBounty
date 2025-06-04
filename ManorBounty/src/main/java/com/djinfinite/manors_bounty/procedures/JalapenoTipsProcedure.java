package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import java.util.List;

//@Mod.EventBusSubscriber
public class JalapenoTipsProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (itemstack.getItem() == ModItems.JALAPENO.get()) {
			tooltip.add(1, Component.literal(("\u00A79 " + Component.translatable("effect.manors_bounty.warm_shield").getString() + " (0:01)")));
		}
		if (itemstack.getItem() == ModItems.JALAPENO_ICE_CREAM.get()) {
			tooltip.add(1, Component.literal(("\u00A79 " + Component.translatable("effect.manors_bounty.warm_shield").getString() + " (0:02)")));
		}
		if (itemstack.getItem() == ModItems.STARFRUIT_JALAPENO_ICE_CREAM.get()) {
			tooltip.add(1, Component.literal(("\u00A79 " + Component.translatable("effect.manors_bounty.warm_shield").getString() + " (0:02)")));
		}
	}
}
