package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import com.djinfinite.manors_bounty.registries.ModItems;

import javax.annotation.Nullable;

import java.util.List;

//@Mod.EventBusSubscriber
public class FlowerRingTipsProcedure {
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
		if (itemstack.getItem() == ModItems.FLOWER_RING_HELMET.get()) {
			tooltip.add(Component.literal("\u00A79+20% \u62A4\u7532\u503C"));
			tooltip.add(Component.literal("\u00A79+20% \u4F24\u5BB3\u51CF\u514D"));
			tooltip.add(Component.literal("\u00A79+10% \u79FB\u52A8\u901F\u5EA6"));
		}
	}
}
