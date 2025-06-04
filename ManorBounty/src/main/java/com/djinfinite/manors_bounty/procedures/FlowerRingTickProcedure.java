package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import com.djinfinite.manors_bounty.registries.ModItems;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class FlowerRingTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == ModItems.FLOWER_RING_HELMET.get()) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
					.hasModifier((new AttributeModifier(UUID.fromString("a5a50252-da58-48a4-8cf1-d821ec0ece58"), "fr_am", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
						.addTransientModifier((new AttributeModifier(UUID.fromString("a5a50252-da58-48a4-8cf1-d821ec0ece58"), "fr_am", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL)));
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.hasModifier((new AttributeModifier(UUID.fromString("8d218672-d7af-4917-97d3-0fe41c636818"), "fr_sp", 0.1, AttributeModifier.Operation.MULTIPLY_TOTAL)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
						.addTransientModifier((new AttributeModifier(UUID.fromString("8d218672-d7af-4917-97d3-0fe41c636818"), "fr_sp", 0.1, AttributeModifier.Operation.MULTIPLY_TOTAL)));
			if ((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getModifier(UUID.fromString("27da0ec6-aeb7-499b-8c66-891bd5616c81")) != null)) {
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).removeModifier(UUID.fromString("27da0ec6-aeb7-499b-8c66-891bd5616c81"));
			}
		} else {
			if ((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getModifier(UUID.fromString("a5a50252-da58-48a4-8cf1-d821ec0ece58")) != null)) {
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).removeModifier(UUID.fromString("a5a50252-da58-48a4-8cf1-d821ec0ece58"));
			}
			if ((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getModifier(UUID.fromString("8d218672-d7af-4917-97d3-0fe41c636818")) != null)) {
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).removeModifier(UUID.fromString("8d218672-d7af-4917-97d3-0fe41c636818"));
			}
		}
	}
}
