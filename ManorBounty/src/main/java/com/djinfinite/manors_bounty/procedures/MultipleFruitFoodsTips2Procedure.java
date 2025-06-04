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
public class MultipleFruitFoodsTips2Procedure {
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
		boolean FoodsCooldownCheck = false;
		boolean CooldownCheck = false;
		String Cooldown = "";
		String FoodsCooldown = "";
		double usingA = 0;
		double usingB = 0;
		if (DoFruitEffectEnableCheckProcedure.execute()) {
			if (itemstack.is(ItemTags.create(new ResourceLocation("manors_bounty:multiple_fruit_foods")))) {
				if (itemstack.getItem() == ModItems.GRIMACE_SHAKE.get()) {
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryCooldown
                            && (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryCooldown
                            && (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryCooldown
                            && (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesCooldown;
                    }
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryFoodsCooldown
                            && (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryFoodsCooldown >= (entity
                                    .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryFoodsCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryFoodsCooldown
                            && (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryFoodsCooldown >= (entity
                                    .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryFoodsCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryFoodsCooldown
                            && (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesFoodsCooldown >= (entity
                                    .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesFoodsCooldown;
                    }
                    Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString();
                    new java.text.DecimalFormat("##").format(usingA / 20);
                    FoodsCooldown = (Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString()).replace(" %1 ", new java.text.DecimalFormat("##").format(usingB / 20));
                    FoodsCooldownCheck = usingB != 0;
                    if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_1").getString()).replace(" %1 ", "70")).replace(" %2 ",
								Component.translatable("effect.manors_bounty.bursting_berry").getString() + "/" + Component.translatable("effect.manors_bounty.cherry_blossoms_weeping").getString()))
								.replace(" %3 ", new java.text.DecimalFormat("##").format(FruitsEffectConfig.FOODS_ADD_TIME_B.get() * 2.5)))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_2").getString())));
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_3").getString()).replace(" %1 ", "30")).replace(" %2 ", "1")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.bursting_berry").getString() + "/" + Component.translatable("effect.manors_bounty.cherry_blossoms_weeping").getString()))));
						tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_4").getString()).replace(" %1 ",
								new java.text.DecimalFormat("##").format(FruitsEffectConfig.FOODS_ADD_TIME_B.get() * 2.5)))
								.replace(" %2 ", new java.text.DecimalFormat("##").format(FruitsEffectConfig.FOODS_NEW_TIME_B.get() * 2.5)))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.foods_effect_level_limit").getString()).replace(" %1 ", "VI"))));
						if (FoodsCooldownCheck) {
							tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_cooldown_0").getString())));
							tooltip.add(Component.literal(FoodsCooldown));
						} else {
							tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_second").getString()).replace(" %1 ", "B")).replace(" %2 ",
									new java.text.DecimalFormat("##").format(FruitsEffectConfig.FOODS_COOLDOWN_B.get() * 2.5)))));
						}
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_shift_check").getString())));
					}
				}
				if (itemstack.getItem() == ModItems.POWSICLE_PALETERIA.get()) {
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryCooldown;
                    }
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryFoodsCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryFoodsCooldown;
                    }
                    Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString();
                    new java.text.DecimalFormat("##").format(usingA / 20);
                    FoodsCooldown = (Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString()).replace(" %1 ", new java.text.DecimalFormat("##").format(usingB / 20));
                    FoodsCooldownCheck = usingB != 0;
                    if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_1").getString()).replace(" %1 ", "95")).replace(" %2 ", "1")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.bursting_berry").getString()))));
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_2").getString()).replace(" %1 ", "30")).replace(" %2 ", "1")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.bursting_berry").getString()))));
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
				if (itemstack.getItem() == ModItems.ETON_MESS.get()) {
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_SweetBerriesCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_SweetBerriesCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_SweetBerriesCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryCooldown;
                    }
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_SweetBerriesFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_SweetBerriesFoodsCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_SweetBerriesFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryFoodsCooldown;
                    }
                    Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString();
                    new java.text.DecimalFormat("##").format(usingA / 20);
                    FoodsCooldown = (Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString()).replace(" %1 ", new java.text.DecimalFormat("##").format(usingB / 20));
                    FoodsCooldownCheck = usingB != 0;
                    if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_1").getString()).replace(" %1 ", "92.5")).replace(" %2 ", "1")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.bursting_berry").getString()))));
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_2").getString()).replace(" %1 ", "20")).replace(" %2 ", "1")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.bursting_berry").getString()))));
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
				if (itemstack.getItem() == ModItems.LUAU_PALETERIA.get()) {
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_MangoCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PineappleCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_MangoCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PineappleCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_MangoCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PineappleCooldown;
                    }
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_MangoFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PineappleFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_MangoFoodsCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PineappleFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_MangoFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PineappleFoodsCooldown;
                    }
                    Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString();
                    new java.text.DecimalFormat("##").format(usingA / 20);
                    FoodsCooldown = (Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString()).replace(" %1 ", new java.text.DecimalFormat("##").format(usingB / 20));
                    FoodsCooldownCheck = usingB != 0;
                    if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_1").getString()).replace(" %1 ", "95")).replace(" %2 ", "1")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.original_evolution").getString() + "/" + Component.translatable("effect.manors_bounty.summer_heatwave").getString()))));
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_2").getString()).replace(" %1 ", "30")).replace(" %2 ", "1")).replace(" %3 ",
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
				if (itemstack.getItem() == ModItems.SEA_PEARL_SALAD.get()) {
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_OliveFruitCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_GlowBerriesCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_OliveFruitCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_GlowBerriesCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_OliveFruitCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_GlowBerriesCooldown;
                    }
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_OliveFruitFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_GlowBerriesFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_OliveFruitFoodsCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_GlowBerriesFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_OliveFruitFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_GlowBerriesFoodsCooldown;
                    }
                    Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString();
                    new java.text.DecimalFormat("##").format(usingA / 20);
                    FoodsCooldown = (Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString()).replace(" %1 ", new java.text.DecimalFormat("##").format(usingB / 20));
                    FoodsCooldownCheck = usingB != 0;
                    if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal(
								(((Component.translatable("tips.manors_bounty.olive_effect_time_add").getString()).replace(" %1 ", new java.text.DecimalFormat("##").format(FruitsEffectConfig.FOODS_VALUE_X.get() * 100 * 2)))
										.replace(" %2 ", "II"))));
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_1").getString()).replace(" %1 ", "70")).replace(" %2 ",
								Component.translatable("effect.manors_bounty.bursting_berry").getString() + "/" + Component.translatable("effect.manors_bounty.sea_touch").getString()))
								.replace(" %3 ", new java.text.DecimalFormat("##").format((double) FruitsEffectConfig.FOODS_ADD_TIME_B.get())))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_2").getString())));
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_3").getString()).replace(" %1 ", "30")).replace(" %2 ", "1")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.bursting_berry").getString() + "/" + Component.translatable("effect.manors_bounty.sea_touch").getString()))));
						tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_4").getString()).replace(" %1 ",
								new java.text.DecimalFormat("##").format((double) FruitsEffectConfig.FOODS_ADD_TIME_B.get())))
								.replace(" %2 ", new java.text.DecimalFormat("##").format((double) FruitsEffectConfig.FOODS_NEW_TIME_B.get())))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.foods_effect_level_limit").getString()).replace(" %1 ", "VI"))));
						if (FoodsCooldownCheck) {
							tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_cooldown_0").getString())));
							tooltip.add(Component.literal(FoodsCooldown));
						} else {
							tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_second").getString()).replace(" %1 ", "X")).replace(" %2 ",
									new java.text.DecimalFormat("##").format((double) FruitsEffectConfig.FOODS_COOLDOWN_X.get())))));
						}
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_shift_check").getString())));
					}
				}
				if (itemstack.getItem() == ModItems.MELON_SALAD.get()) {
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_WatermelonCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_HamimelonCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_WatermelonCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_HamimelonCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_WatermelonCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_HamimelonCooldown;
                    }
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_WatermelonFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_HamimelonFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_WatermelonFoodsCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_HamimelonFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_WatermelonFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_HamimelonFoodsCooldown;
                    }
                    Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString();
                    new java.text.DecimalFormat("##").format(usingA / 20);
                    FoodsCooldown = (Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString()).replace(" %1 ", new java.text.DecimalFormat("##").format(usingB / 20));
                    FoodsCooldownCheck = usingB != 0;
                    if (Screen.hasShiftDown()) {
						tooltip.add(Component
								.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_1").getString()).replace(" %1 ", "70")).replace(" %2 ", Component.translatable("effect.manors_bounty.melon_gravity").getString()))
										.replace(" %3 ", new java.text.DecimalFormat("##").format(FruitsEffectConfig.FOODS_ADD_TIME_B.get() * 2.5)))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_2").getString())));
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_3").getString()).replace(" %1 ", "30")).replace(" %2 ", "1")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.melon_gravity").getString()))));
						tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_4").getString()).replace(" %1 ",
								new java.text.DecimalFormat("##").format(FruitsEffectConfig.FOODS_ADD_TIME_B.get() * 2.5)))
								.replace(" %2 ", new java.text.DecimalFormat("##").format(FruitsEffectConfig.FOODS_NEW_TIME_B.get() * 2.5)))));
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
			}
		}
	}
}
