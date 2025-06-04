package com.djinfinite.manors_bounty.procedures;

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
import com.djinfinite.manors_bounty.registries.ModItems;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

import javax.annotation.Nullable;

import java.util.List;

//@Mod.EventBusSubscriber
public class MultipleFruitFoodsTipsProcedure {
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
				if (itemstack.getItem() == ModItems.ROSA_SALAD.get()) {
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_AppleCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PeachCooldown
                            && (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_AppleCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PearCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_AppleCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PeachCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_AppleCooldown
                            && (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PeachCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PearCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PeachCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PearCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_AppleCooldown
                            && (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PearCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PeachCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PearCooldown;
                    }
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_AppleFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PeachFoodsCooldown
                            && (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_AppleFoodsCooldown >= (entity
                                    .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PearFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_AppleFoodsCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PeachFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_AppleFoodsCooldown
                            && (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PeachFoodsCooldown >= (entity
                                    .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PearFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PeachFoodsCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PearFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_AppleFoodsCooldown
                            && (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PearFoodsCooldown >= (entity
                                    .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PeachFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PearFoodsCooldown;
                    }
                    Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString();
                    new java.text.DecimalFormat("##").format(usingA / 20);
                    FoodsCooldown = (Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString()).replace(" %1 ", new java.text.DecimalFormat("##").format(usingB / 20));
                    FoodsCooldownCheck = usingB != 0;
                    if (Screen.hasShiftDown()) {
						tooltip.add(Component
								.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_1").getString()).replace(" %1 ", "70")).replace(" %2 ", Component.translatable("effect.manors_bounty.rosa_hedge").getString()))
										.replace(" %3 ", new java.text.DecimalFormat("##").format(Math.floor(FruitsEffectConfig.FOODS_ADD_TIME_B.get() * 2.5))))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_2").getString())));
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_3").getString()).replace(" %1 ", "30")).replace(" %2 ", "2")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.rosa_hedge").getString()))));
						tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_4").getString()).replace(" %1 ",
								new java.text.DecimalFormat("##").format(Math.floor(FruitsEffectConfig.FOODS_ADD_TIME_B.get() * 2.5))))
								.replace(" %2 ", new java.text.DecimalFormat("##").format(Math.floor(FruitsEffectConfig.FOODS_NEW_TIME_B.get() * 2.5))))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.foods_effect_level_limit").getString()).replace(" %1 ", "VI"))));
						if (FoodsCooldownCheck) {
							tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_cooldown_0").getString())));
							tooltip.add(Component.literal(FoodsCooldown));
						} else {
							tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_second").getString()).replace(" %1 ", "B")).replace(" %2 ",
									new java.text.DecimalFormat("##").format(Math.floor(FruitsEffectConfig.FOODS_COOLDOWN_B.get() * 2.5))))));
						}
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_shift_check").getString())));
					}
				}
				if (itemstack.getItem() == ModItems.COSMIC_DRAGON_SALAD.get()) {
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StarfruitCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_DragonFruitCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StarfruitCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_DragonFruitCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StarfruitCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_DragonFruitCooldown;
                    }
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StarfruitFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_DragonFruitFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StarfruitFoodsCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_DragonFruitFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StarfruitFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_DragonFruitFoodsCooldown;
                    }
                    Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString();
                    new java.text.DecimalFormat("##").format(usingA / 20);
                    FoodsCooldown = (Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString()).replace(" %1 ", new java.text.DecimalFormat("##").format(usingB / 20));
                    FoodsCooldownCheck = usingB != 0;
                    if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_1").getString()).replace(" %1 ", "70")).replace(" %2 ",
								Component.translatable("effect.manors_bounty.momentary_meteor").getString() + "/" + Component.translatable("effect.manors_bounty.hacked_thorns").getString() + "/"
										+ Component.translatable("effect.manors_bounty.summer_heatwave").getString()))
								.replace(" %3 ", new java.text.DecimalFormat("##").format(Math.floor(FruitsEffectConfig.FOODS_ADD_TIME_B.get() * 2.5))))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_2").getString())));
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_3").getString()).replace(" %1 ", "30")).replace(" %2 ", "2")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.momentary_meteor").getString() + "/" + Component.translatable("effect.manors_bounty.hacked_thorns").getString() + "/"
										+ Component.translatable("effect.manors_bounty.summer_heatwave").getString()))));
						tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_4").getString()).replace(" %1 ",
								new java.text.DecimalFormat("##").format(Math.floor(FruitsEffectConfig.FOODS_ADD_TIME_B.get() * 2.5))))
								.replace(" %2 ", new java.text.DecimalFormat("##").format(Math.floor(FruitsEffectConfig.FOODS_NEW_TIME_B.get() * 2.5))))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.foods_effect_level_limit").getString()).replace(" %1 ", "VI"))));
						if (FoodsCooldownCheck) {
							tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_cooldown_0").getString())));
							tooltip.add(Component.literal(FoodsCooldown));
						} else {
							tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_second").getString()).replace(" %1 ", "B")).replace(" %2 ",
									new java.text.DecimalFormat("##").format(Math.floor(FruitsEffectConfig.FOODS_COOLDOWN_B.get() * 2.5))))));
						}
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_shift_check").getString())));
					}
				}
				if (itemstack.getItem() == ModItems.HEART_CRUSH_PALETERIA.get()) {
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PeachCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PeachCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PeachCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesCooldown;
                    }
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PeachFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PeachFoodsCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PeachFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesFoodsCooldown;
                    }
                    Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString();
                    new java.text.DecimalFormat("##").format(usingA / 20);
                    FoodsCooldown = (Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString()).replace(" %1 ", new java.text.DecimalFormat("##").format(usingB / 20));
                    FoodsCooldownCheck = usingB != 0;
                    if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_1").getString()).replace(" %1 ", "90")).replace(" %2 ", "1")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.rosa_hedge").getString() + "/" + Component.translatable("effect.manors_bounty.cherry_blossoms_weeping").getString()))));
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_2").getString()).replace(" %1 ", "15")).replace(" %2 ", "1")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.rosa_hedge").getString() + "/" + Component.translatable("effect.manors_bounty.cherry_blossoms_weeping").getString()))));
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
				if (itemstack.getItem() == ModItems.BLUEBERRY_CHERRIES_ICE_CREAM.get()) {
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryCooldown) {
                        usingA = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesCooldown;
                    }
                    if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryFoodsCooldown;
                    } else if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesFoodsCooldown >= (entity
                            .getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryFoodsCooldown) {
                        usingB = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesFoodsCooldown;
                    }
                    Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString();
                    new java.text.DecimalFormat("##").format(usingA / 20);
                    FoodsCooldown = (Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get").getString()).replace(" %1 ", new java.text.DecimalFormat("##").format(usingB / 20));
                    FoodsCooldownCheck = usingB != 0;
                    if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_1").getString()).replace(" %1 ", "90")).replace(" %2 ", "1")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.bursting_berry").getString() + "/" + Component.translatable("effect.manors_bounty.cherry_blossoms_weeping").getString()))));
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_2").getString()).replace(" %1 ", "15")).replace(" %2 ", "1")).replace(" %3 ",
								Component.translatable("effect.manors_bounty.bursting_berry").getString() + "/" + Component.translatable("effect.manors_bounty.cherry_blossoms_weeping").getString()))));
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
