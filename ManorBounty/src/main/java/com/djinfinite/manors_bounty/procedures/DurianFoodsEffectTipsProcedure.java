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
public class DurianFoodsEffectTipsProcedure {
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
			if (itemstack.is(ItemTags.create(new ResourceLocation("manors_bounty:durian_foods")))) {
                Cooldown = (Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString()).replace(" %1 ",
                        new java.text.DecimalFormat("##").format((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_DurianCooldown / 20));
                FoodsCooldown = (Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString()).replace(" %1 ",
                        new java.text.DecimalFormat("##").format((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_DurianFoodsCooldown / 20));
                CooldownCheck = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_DurianCooldown > 0;
                FoodsCooldownCheck = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_DurianFoodsCooldown != 0;
                if (itemstack.getItem() == ModItems.HALF_OF_MUSANG_KING_DURIAN.get()) {
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
				if (itemstack.getItem() == ModItems.MUSANG_KING_DURIAN_FLESH.get()) {
					if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_raw_give").getString()).replace(" %1 ",
								Component.translatable("effect.manors_bounty.hacked_thorns").getString() + "/" + Component.translatable("effect.manors_bounty.summer_heatwave").getString())).replace(" %2 ", "100")).replace(" %3 ", "1"))));
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
				if (itemstack.getItem() == ModItems.COOKED_DURIAN_FLESH.get()) {
					if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_1").getString()).replace(" %1 ", "70")).replace(" %2 ",
								Component.translatable("effect.manors_bounty.hacked_thorns").getString() + "/" + Component.translatable("effect.manors_bounty.summer_heatwave").getString()))
								.replace(" %3 ", new java.text.DecimalFormat("##").format((double) FruitsEffectConfig.FOODS_ADD_TIME_B.get())))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_2").getString())));
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_3").getString()).replace(" %1 ", "30")).replace(" %2 ", "1")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.hacked_thorns").getString() + "/" + Component.translatable("effect.manors_bounty.summer_heatwave").getString()))));
						tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_4").getString()).replace(" %1 ",
								new java.text.DecimalFormat("##").format((double) FruitsEffectConfig.FOODS_ADD_TIME_B.get())))
								.replace(" %2 ", new java.text.DecimalFormat("##").format((double) FruitsEffectConfig.FOODS_NEW_TIME_B.get())))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.foods_effect_level_limit").getString()).replace(" %1 ", "VI"))));
						if (FoodsCooldownCheck) {
							tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_cooldown_0").getString())));
							tooltip.add(Component.literal(FoodsCooldown));
						} else {
							tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_second").getString()).replace(" %1 ", "B")).replace(" %2 ",
									new java.text.DecimalFormat("##").format((double) FruitsEffectConfig.FOODS_COOLDOWN_B.get())))));
						}
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_shift_check").getString())));
					}
				}
				if (itemstack.getItem() == ModItems.DURIAN_CRISP.get() || itemstack.getItem() == ModItems.DURIAN_MILE_CREPE_CAKE.get()) {
					if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_1").getString()).replace(" %1 ", "90")).replace(" %2 ", "1")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.hacked_thorns").getString() + "/" + Component.translatable("effect.manors_bounty.summer_heatwave").getString()))));
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_2").getString()).replace(" %1 ", "15")).replace(" %2 ", "1")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.hacked_thorns").getString() + "/" + Component.translatable("effect.manors_bounty.summer_heatwave").getString()))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_3").getString()).replace(" %1 ",
								new java.text.DecimalFormat("##").format((double) FruitsEffectConfig.FOODS_NEW_TIME_C.get())))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.foods_effect_level_limit").getString()).replace(" %1 ", "VIII"))));
						if (FoodsCooldownCheck) {
							tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_cooldown_0").getString())));
							tooltip.add(Component.literal(FoodsCooldown));
						} else {
							tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_second").getString()).replace(" %1 ", "C")).replace(" %2 ",
									new java.text.DecimalFormat("##").format((double) FruitsEffectConfig.FOODS_COOLDOWN_C.get())))));
						}
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_shift_check").getString())));
					}
				}
				if (itemstack.getItem() == ModItems.DURIAN_MILE_CREPE_CAKE_SLICE.get()) {
					if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_1").getString()).replace(" %1 ", "65")).replace(" %2 ", "1")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.hacked_thorns").getString() + "/" + Component.translatable("effect.manors_bounty.summer_heatwave").getString()))));
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_2").getString()).replace(" %1 ", "7.5")).replace(" %2 ", "1")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.original_evolution").getString() + "/" + Component.translatable("effect.manors_bounty.summer_heatwave").getString()))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_3").getString()).replace(" %1 ",
								new java.text.DecimalFormat("##").format((double) FruitsEffectConfig.FOODS_NEW_TIME_C.get())))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.foods_effect_level_limit").getString()).replace(" %1 ", "VIII"))));
						if (FoodsCooldownCheck) {
							tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_cooldown_0").getString())));
							tooltip.add(Component.literal(FoodsCooldown));
						} else {
							tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_second").getString()).replace(" %1 ", "C")).replace(" %2 ",
									new java.text.DecimalFormat("##").format((double) FruitsEffectConfig.FOODS_COOLDOWN_C.get())))));
						}
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_shift_check").getString())));
					}
				}
			}
		}
	}
}
