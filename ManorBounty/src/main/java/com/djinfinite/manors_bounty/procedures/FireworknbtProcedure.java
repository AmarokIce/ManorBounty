package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FireworknbtProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		String result = execute(event, event.getEntity());
	}

	public static String execute(Entity entity) {
		return execute(null, entity);
	}

	private static String execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return "0";
		ItemStack itemStack = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
		if (itemStack.getItem() == Items.FIREWORK_STAR) {
			CompoundTag nbt = itemStack.getTag();
			if (nbt != null && nbt.contains("Explosion")) {
				CompoundTag explosionTag = nbt.getCompound("Explosion");
				return explosionTag.toString();
			}
		}
		return "0";
	}
}
