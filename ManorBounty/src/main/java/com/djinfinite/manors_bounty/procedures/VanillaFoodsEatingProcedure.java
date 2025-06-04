package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class VanillaFoodsEatingProcedure {
	@SubscribeEvent
	public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getItem());
		}
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (DoFruitEffectEnableCheckProcedure.execute()) {
			if (itemstack.getItem() == Items.APPLE) {
				AppleFoodsEffectUsingProcedure.execute(entity, itemstack);
			} else if (itemstack.getItem() == Items.MELON_SLICE) {
				WatermelonFoodsEffectUsingProcedure.execute(entity, itemstack);
			} else if (itemstack.getItem() == Items.CHORUS_FRUIT) {
				ChorusFruitFoodsEffectUsingProcedure.execute(entity, itemstack);
			} else if (itemstack.getItem() == Items.SWEET_BERRIES) {
				SweetBerriesFoodsEffectUsingProcedure.execute(entity, itemstack);
			} else if (itemstack.getItem() == Items.GLOW_BERRIES) {
				GlowBerriesFoodsEffectUsingProcedure.execute(entity, itemstack);
			}
		}
	}
}
