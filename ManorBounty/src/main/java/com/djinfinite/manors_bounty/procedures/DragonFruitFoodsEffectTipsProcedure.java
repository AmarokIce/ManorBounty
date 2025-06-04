package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import com.djinfinite.manors_bounty.network.ManorsBountyModVariables;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

import javax.annotation.Nullable;

import java.util.List;

//@Mod.EventBusSubscriber
public class DragonFruitFoodsEffectTipsProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getEntity(), event.getItemStack(), event.getToolTip());
	}

	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		execute(null, entity, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		String Cooldown = "";
		String FoodsCooldown = "";
		boolean CooldownCheck = false;
		boolean FoodsCooldownCheck = false;
		if (DoFruitEffectEnableCheckProcedure.execute()) {
			if (itemstack.is(ItemTags.create(new ResourceLocation("manors_bounty:dragon_fruit_foods")))) {
                Cooldown = (Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString()).replace(" %1 ",
                        new java.text.DecimalFormat("##").format((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_DragonFruitCooldown / 20));
                Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString();
                new java.text.DecimalFormat("##").format((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_DragonFruitFoodsCooldown / 20);
                CooldownCheck = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_DragonFruitCooldown > 0;
                entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables());
                if (itemstack.getItem() == ModItems.DRAGON_FRUIT.get()) {
					if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_raw_give").getString()).replace(" %1 ",
								Component.translatable("effect.manors_bounty.hacked_thorns").getString() + "/" + Component.translatable("effect.manors_bounty.summer_heatwave").getString())).replace(" %2 ", "100")).replace(" %3 ", "1"))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.foods_effect_level_limit").getString()).replace(" %1 ", "IV"))));
						if (CooldownCheck) {
							tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_cooldown_0").getString())));
							tooltip.add(Component.literal(Cooldown));
						} else {
							tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_second").getString()).replace(" %1 ", "A")).replace(" %2 ",
									new java.text.DecimalFormat("##").format((double) FruitsEffectConfig.FOODS_COOLDOWN_A.get())))));
						}
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_shift_check").getString())));
					}
				}
				if (itemstack.getItem() == ModItems.DRAGON_FRUIT_SLICE.get()) {
					if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_raw_give").getString()).replace(" %1 ",
								Component.translatable("effect.manors_bounty.hacked_thorns").getString() + "/" + Component.translatable("effect.manors_bounty.summer_heatwave").getString())).replace(" %2 ", "33")).replace(" %3 ", "1"))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.foods_effect_level_limit").getString()).replace(" %1 ", "IV"))));
						if (CooldownCheck) {
							tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_cooldown_0").getString())));
							tooltip.add(Component.literal(Cooldown));
						} else {
							tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_second").getString()).replace(" %1 ", "A")).replace(" %2 ",
									new java.text.DecimalFormat("##").format(Math.floor(FruitsEffectConfig.FOODS_COOLDOWN_A.get() * 0.33))))));
						}
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_shift_check").getString())));
					}
				}
			}
		}
	}
}
