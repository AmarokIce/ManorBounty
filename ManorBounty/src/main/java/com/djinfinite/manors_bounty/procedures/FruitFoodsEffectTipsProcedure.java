package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class FruitFoodsEffectTipsProcedure {
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
		if (itemstack.is(ItemTags.create(new ResourceLocation("manors_bounty:fruit_effect_tips_item")))) {
			if (itemstack.getItem() == ModItems.ROSA_HEDGE_EFFECT_TIPS_ITEM.get()) {
				if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(ModMobEffects.ROSA_HEDGE.get())) {
					if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.rosa_hedge_tips_item_line_1").getString())));
						tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.rosa_hedge_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.effect_tips_item_normal_formula").getString()))
								.replace(" %1 ", "" + (double) FruitsEffectConfig.ROSA_HEDGE_AMOUNT.get()))));
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.rosa_hedge_tips_item_line_1").getString())));
						tooltip.add(Component.literal(
								((Component.translatable("tips.manors_bounty.rosa_hedge_tips_item_line_2").getString()).replace(" %1 ", new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.ROSA_HEDGE_AMOUNT.get()
                                        * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ROSA_HEDGE.get()) ? _livEnt.getEffect(ModMobEffects.ROSA_HEDGE.get()).getAmplifier() : 0) + 1))))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.effect_tips_item_shift_check").getString())));
					}
				} else {
					tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.rosa_hedge_tips_item_line_1").getString())));
					tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.rosa_hedge_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.effect_tips_item_normal_formula").getString()))
							.replace(" %1 ", "" + (double) FruitsEffectConfig.ROSA_HEDGE_AMOUNT.get()))));
				}
			}
			if (itemstack.getItem() == ModItems.RUTIN_LEMONENE_EFFECT_TIPS_ITEM.get()) {
				if (entity instanceof LivingEntity _livEnt28 && _livEnt28.hasEffect(ModMobEffects.RUTIN_LEMONENE.get())) {
					if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.rutin_lemonene_tips_item_line_1").getString())));
						tooltip.add(Component
								.literal(((((Component.translatable("tips.manors_bounty.rutin_lemonene_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.rutin_lemonene_tips_item_line_2_formula").getString()))
										.replace(" %1 ", "" + (double) FruitsEffectConfig.RUTIN_LEMONENE_AMOUNT.get())).replace(" %2 ", "" + (double) FruitsEffectConfig.RUTIN_LEMONENE_LEVEL_AMOUNT.get()))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.rutin_lemonene_tips_item_line_3").getString()).replace(" %1 ",
								new java.text.DecimalFormat("##").format((double) FruitsEffectConfig.RUTIN_LEMONENE_MAX_LEVEL.get())))));
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.rutin_lemonene_tips_item_line_1").getString())));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.rutin_lemonene_tips_item_line_2").getString()).replace(" %1 ",
								(new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.RUTIN_LEMONENE_AMOUNT.get()
										* (5 + ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.RUTIN_LEMONENE.get()) ? _livEnt.getEffect(ModMobEffects.RUTIN_LEMONENE.get()).getAmplifier() : 0) + 1)
												* 0.25)
										* (1 + Math.min(FruitsEffectConfig.RUTIN_LEMONENE_MAX_LEVEL.get(), Math.max(entity instanceof Player _plr ? _plr.experienceLevel : 0, 0))
												* FruitsEffectConfig.RUTIN_LEMONENE_LEVEL_AMOUNT.get())
										* 100)) + "%"))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.rutin_lemonene_tips_item_line_3").getString()).replace(" %1 ",
								new java.text.DecimalFormat("##").format((double) FruitsEffectConfig.RUTIN_LEMONENE_MAX_LEVEL.get())))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.effect_tips_item_shift_check").getString())));
					}
				} else {
					tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.rutin_lemonene_tips_item_line_1").getString())));
					tooltip.add(Component
							.literal(((((Component.translatable("tips.manors_bounty.rutin_lemonene_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.rutin_lemonene_tips_item_line_2_formula").getString()))
									.replace(" %1 ", "" + (double) FruitsEffectConfig.RUTIN_LEMONENE_AMOUNT.get())).replace(" %2 ", "" + (double) FruitsEffectConfig.RUTIN_LEMONENE_LEVEL_AMOUNT.get()))));
					tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.rutin_lemonene_tips_item_line_3").getString()).replace(" %1 ", "" + (double) FruitsEffectConfig.RUTIN_LEMONENE_MAX_LEVEL.get()))));
				}
			}
			if (itemstack.getItem() == ModItems.BURSTING_BERRY_EFFECT_TIPS_ITEM.get()) {
				if (entity instanceof LivingEntity _livEnt67 && _livEnt67.hasEffect(ModMobEffects.BURSTING_BERRY.get())) {
					if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.bursting_berry_tips_item_line_1").getString())));
						tooltip.add(Component
								.literal((((Component.translatable("tips.manors_bounty.bursting_berry_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.bursting_berry_tips_item_line_2_formula").getString()))
										.replace(" %1 ", "" + (double) FruitsEffectConfig.BURSTING_BERRY_AMOUNT.get()))));
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.bursting_berry_tips_item_line_1").getString())));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.bursting_berry_tips_item_line_2").getString()).replace(" %1 ",
                                new java.text.DecimalFormat("##.##").format(1 + FruitsEffectConfig.BURSTING_BERRY_AMOUNT.get()
                                        * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier() : 0)
                                        + 1))))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.effect_tips_item_shift_check").getString())));
					}
				} else {
					tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.bursting_berry_tips_item_line_1").getString())));
					tooltip.add(Component
							.literal((((Component.translatable("tips.manors_bounty.bursting_berry_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.bursting_berry_tips_item_line_2_formula").getString()))
									.replace(" %1 ", "" + (double) FruitsEffectConfig.BURSTING_BERRY_AMOUNT.get()))));
				}
			}
			if (itemstack.getItem() == ModItems.CHERRY_BLOSSOMS_WEEPING_EFFECT_TIPS_ITEM.get()) {
				if (entity instanceof LivingEntity _livEnt91 && _livEnt91.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())) {
					if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.cherry_blossoms_weeping_tips_item_line_1").getString())));
						tooltip.add(Component
								.literal((((Component.translatable("tips.manors_bounty.cherry_blossoms_weeping_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.effect_tips_item_normal_formula").getString()))
										.replace(" %1 ", "" + (double) FruitsEffectConfig.CHERRY_BLOSSOMS_WEEPING_AMOUNT.get()))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.cherry_blossoms_weeping_tips_item_line_3").getString())));
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.cherry_blossoms_weeping_tips_item_line_1").getString())));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.cherry_blossoms_weeping_tips_item_line_2").getString()).replace(" %1 ",
                                new java.text.DecimalFormat("##.##")
                                        .format(FruitsEffectConfig.CHERRY_BLOSSOMS_WEEPING_AMOUNT.get() * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
                                                ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getAmplifier()
                                                : 0) + 1))))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.cherry_blossoms_weeping_tips_item_line_3").getString())));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.effect_tips_item_shift_check").getString())));
					}
				} else {
					tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.cherry_blossoms_weeping_tips_item_line_1").getString())));
					tooltip.add(Component
							.literal((((Component.translatable("tips.manors_bounty.cherry_blossoms_weeping_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.effect_tips_item_normal_formula").getString()))
									.replace(" %1 ", "" + (double) FruitsEffectConfig.CHERRY_BLOSSOMS_WEEPING_AMOUNT.get()))));
					tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.cherry_blossoms_weeping_tips_item_line_3").getString())));
				}
			}
			if (itemstack.getItem() == ModItems.MOMENTARY_METEOR_EFFECT_TIPS_ITEM.get()) {
				if (entity instanceof LivingEntity _livEnt121 && _livEnt121.hasEffect(ModMobEffects.MOMENTARY_METEOR.get())) {
					if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.momentary_meteor_tips_item_line_1").getString())));
						tooltip.add(Component
								.literal(((((Component.translatable("tips.manors_bounty.momentary_meteor_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.effect_tips_item_normal_formula").getString()))
										.replace(" %1 ", "" + (double) FruitsEffectConfig.MOMENTARY_METEOR_CHANCE.get())).replace(" %2 ", "" + (double) FruitsEffectConfig.MOMENTARY_METEOR_MAX_AMOUNT.get()))));
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.momentary_meteor_tips_item_line_1").getString())));
						tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.momentary_meteor_tips_item_line_2").getString()).replace(" %1 ",
                                new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.MOMENTARY_METEOR_CHANCE.get()
                                        * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MOMENTARY_METEOR.get()) ? _livEnt.getEffect(ModMobEffects.MOMENTARY_METEOR.get()).getAmplifier() : 0)
                                        + 1))))
								.replace(" %2 ", "" + (double) FruitsEffectConfig.MOMENTARY_METEOR_MAX_AMOUNT.get()))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.effect_tips_item_shift_check").getString())));
					}
				} else {
					tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.momentary_meteor_tips_item_line_1").getString())));
					tooltip.add(
							Component.literal(((((Component.translatable("tips.manors_bounty.momentary_meteor_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.effect_tips_item_normal_formula").getString()))
									.replace(" %1 ", "" + (double) FruitsEffectConfig.MOMENTARY_METEOR_CHANCE.get())).replace(" %2 ", "" + (double) FruitsEffectConfig.MOMENTARY_METEOR_MAX_AMOUNT.get()))));
				}
			}
			if (itemstack.getItem() == ModItems.SUMMER_HEATWAVE_EFFECT_TIPS_ITEM.get()) {
				if (entity instanceof LivingEntity _livEnt148 && _livEnt148.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get())) {
					if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.summer_heatwave_tips_item_line_1").getString())));
						tooltip.add(Component
								.literal((((Component.translatable("tips.manors_bounty.summer_heatwave_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.summer_heatwave_tips_item_line_formula").getString()))
										.replace(" %1 ", "" + (double) FruitsEffectConfig.SUMMER_HEATWAVE_MOVEMENT_SPEED_AMOUNT.get()))));
						tooltip.add(Component
								.literal((((Component.translatable("tips.manors_bounty.summer_heatwave_tips_item_line_3").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.summer_heatwave_tips_item_line_formula").getString()))
										.replace(" %1 ", "" + (double) FruitsEffectConfig.SUMMER_HEATWAVE_SWIM_SPEED_AMOUNT.get()))));
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.summer_heatwave_tips_item_line_1").getString())));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.summer_heatwave_tips_item_line_2").getString()).replace(" %1 ",
                                new java.text.DecimalFormat("##.##").format(1 + FruitsEffectConfig.SUMMER_HEATWAVE_MOVEMENT_SPEED_AMOUNT.get()
                                        * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get()) ? _livEnt.getEffect(ModMobEffects.SUMMER_HEATWAVE.get()).getAmplifier() : 0)
                                        + 1))))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.summer_heatwave_tips_item_line_3").getString()).replace(" %1 ",
                                new java.text.DecimalFormat("##.##").format(1 + FruitsEffectConfig.SUMMER_HEATWAVE_SWIM_SPEED_AMOUNT.get()
                                        * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get()) ? _livEnt.getEffect(ModMobEffects.SUMMER_HEATWAVE.get()).getAmplifier() : 0)
                                        + 1))))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.effect_tips_item_shift_check").getString())));
					}
				} else {
					tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.summer_heatwave_tips_item_line_1").getString())));
					tooltip.add(Component
							.literal((((Component.translatable("tips.manors_bounty.summer_heatwave_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.summer_heatwave_tips_item_line_formula").getString()))
									.replace(" %1 ", "" + (double) FruitsEffectConfig.SUMMER_HEATWAVE_MOVEMENT_SPEED_AMOUNT.get()))));
					tooltip.add(Component
							.literal((((Component.translatable("tips.manors_bounty.summer_heatwave_tips_item_line_3").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.summer_heatwave_tips_item_line_formula").getString()))
									.replace(" %1 ", "" + (double) FruitsEffectConfig.SUMMER_HEATWAVE_SWIM_SPEED_AMOUNT.get()))));
				}
			}
			if (itemstack.getItem() == ModItems.ORIGINAL_EVOLUTION_EFFECT_TIPS_ITEM.get()) {
				if (entity instanceof LivingEntity _livEnt184 && _livEnt184.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get())) {
					if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.original_evolution_tips_item_line_1").getString())));
						tooltip.add(Component.literal(
								(((((Component.translatable("tips.manors_bounty.original_evolution_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.original_evolution_tips_item_line_2_formula").getString()))
										.replace(" %1 ", "" + (double) FruitsEffectConfig.ORIGINAL_EVOLUTION_AMOUNT.get())).replace(" %2 ", Component.translatable("effect.manors_bounty.original_evolution_metamorphosis").getString()))
										.replace(" %3 ", "" + (double) FruitsEffectConfig.ORIGINAL_EVOLUTION_METAMORPHOSIS_AMOUNT.get()))));
						tooltip.add(Component
								.literal(((Component.translatable("tips.manors_bounty.original_evolution_tips_item_line_3").getString()).replace(" %1 ", Component.translatable("effect.manors_bounty.original_evolution_metamorphosis").getString()))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.original_evolution_tips_item_line_4").getString())));
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.original_evolution_tips_item_line_1").getString())));
						if (entity instanceof LivingEntity _livEnt201 && _livEnt201.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION_METAMORPHOSIS.get())) {
							tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.original_evolution_tips_item_line_2").getString()).replace(" %1 ",
									(new java.text.DecimalFormat("##.##").format(Math.min(90,
											Math.max((FruitsEffectConfig.ORIGINAL_EVOLUTION_AMOUNT.get()
													* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get())
															? _livEnt.getEffect(ModMobEffects.ORIGINAL_EVOLUTION.get()).getAmplifier()
															: 0) + 1)
													+ FruitsEffectConfig.ORIGINAL_EVOLUTION_METAMORPHOSIS_AMOUNT.get()
															* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION_METAMORPHOSIS.get())
																	? _livEnt.getEffect(ModMobEffects.ORIGINAL_EVOLUTION_METAMORPHOSIS.get()).getAmplifier()
																	: 0) + 1))
													* 100, 0))))
											+ "%"))));
						} else {
							tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.original_evolution_tips_item_line_2").getString()).replace(" %1 ",
									(new java.text.DecimalFormat("##.##").format(Math.min(90,
											Math.max(FruitsEffectConfig.ORIGINAL_EVOLUTION_AMOUNT.get() * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get())
													? _livEnt.getEffect(ModMobEffects.ORIGINAL_EVOLUTION.get()).getAmplifier()
													: 0) + 1) * 100, 0))))
											+ "%"))));
						}
						tooltip.add(Component
								.literal(((Component.translatable("tips.manors_bounty.original_evolution_tips_item_line_3").getString()).replace(" %1 ", Component.translatable("effect.manors_bounty.original_evolution_metamorphosis").getString()))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.original_evolution_tips_item_line_4").getString())));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.effect_tips_item_shift_check").getString())));
					}
				} else {
					tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.original_evolution_tips_item_line_1").getString())));
					tooltip.add(Component.literal(
							(((((Component.translatable("tips.manors_bounty.original_evolution_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.original_evolution_tips_item_line_2_formula").getString()))
									.replace(" %1 ", "" + (double) FruitsEffectConfig.ORIGINAL_EVOLUTION_AMOUNT.get())).replace(" %2 ", Component.translatable("effect.manors_bounty.original_evolution_metamorphosis").getString()))
									.replace(" %3 ", "" + (double) FruitsEffectConfig.ORIGINAL_EVOLUTION_METAMORPHOSIS_AMOUNT.get()))));
					tooltip.add(Component
							.literal(((Component.translatable("tips.manors_bounty.original_evolution_tips_item_line_3").getString()).replace(" %1 ", Component.translatable("effect.manors_bounty.original_evolution_metamorphosis").getString()))));
					tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.original_evolution_tips_item_line_4").getString())));
				}
			}
			if (itemstack.getItem() == ModItems.MELON_GRAVITY_EFFECT_TIPS_ITEM.get()) {
				if (entity instanceof LivingEntity _livEnt236 && _livEnt236.hasEffect(ModMobEffects.MELON_GRAVITY.get())) {
					if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.melon_gravity_tips_item_line_1").getString())));
						tooltip.add(
								Component.literal((((Component.translatable("tips.manors_bounty.melon_gravity_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.effect_tips_item_normal_formula").getString()))
										.replace(" %1 ", "" + (double) FruitsEffectConfig.MELON_GRAVITY_KNOCKBACK_RESISTANCE_AMOUNT.get()))));
						tooltip.add(
								Component.literal((((Component.translatable("tips.manors_bounty.melon_gravity_tips_item_line_3").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.effect_tips_item_normal_formula").getString()))
										.replace(" %1 ", "" + (double) FruitsEffectConfig.MELON_GRAVITY_STEP_HEIGHT_AMOUNT.get()))));
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.melon_gravity_tips_item_line_1").getString())));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.melon_gravity_tips_item_line_2").getString()).replace(" %1 ",
                                new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.MELON_GRAVITY_KNOCKBACK_RESISTANCE_AMOUNT.get()
                                        * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get()) ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getAmplifier() : 0) + 1))))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.melon_gravity_tips_item_line_3").getString()).replace(" %1 ",
                                new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.MELON_GRAVITY_STEP_HEIGHT_AMOUNT.get()
                                        * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get()) ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getAmplifier() : 0) + 1))))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.effect_tips_item_shift_check").getString())));
					}
				} else {
					tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.melon_gravity_tips_item_line_1").getString())));
					tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.melon_gravity_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.effect_tips_item_normal_formula").getString()))
							.replace(" %1 ", "" + (double) FruitsEffectConfig.MELON_GRAVITY_KNOCKBACK_RESISTANCE_AMOUNT.get()))));
					tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.melon_gravity_tips_item_line_3").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.effect_tips_item_normal_formula").getString()))
							.replace(" %1 ", "" + (double) FruitsEffectConfig.MELON_GRAVITY_STEP_HEIGHT_AMOUNT.get()))));
				}
			}
			if (itemstack.getItem() == ModItems.SEA_TOUCH_EFFECT_TIPS_ITEM.get()) {
				if (entity instanceof LivingEntity _livEnt272 && _livEnt272.hasEffect(ModMobEffects.SEA_TOUCH.get())) {
					if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.sea_touch_tips_item_line_1").getString())));
						tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.sea_touch_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.effect_tips_item_normal_formula").getString()))
								.replace(" %1 ", "" + (double) FruitsEffectConfig.SEA_TOUCH_ENTITY_AMOUNT.get()))));
						tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.sea_touch_tips_item_line_3").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.effect_tips_item_normal_formula").getString()))
								.replace(" %1 ", "" + (double) FruitsEffectConfig.SEA_TOUCH_BLOCK_AMOUNT.get()))));
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.sea_touch_tips_item_line_1").getString())));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.sea_touch_tips_item_line_2").getString()).replace(" %1 ",
                                new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.SEA_TOUCH_ENTITY_AMOUNT.get()
                                        * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SEA_TOUCH.get()) ? _livEnt.getEffect(ModMobEffects.SEA_TOUCH.get()).getAmplifier() : 0) + 1))))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.sea_touch_tips_item_line_3").getString()).replace(" %1 ",
                                new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.SEA_TOUCH_BLOCK_AMOUNT.get()
                                        * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SEA_TOUCH.get()) ? _livEnt.getEffect(ModMobEffects.SEA_TOUCH.get()).getAmplifier() : 0) + 1))))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.effect_tips_item_shift_check").getString())));
					}
				} else {
					tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.sea_touch_tips_item_line_1").getString())));
					tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.sea_touch_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.effect_tips_item_normal_formula").getString()))
							.replace(" %1 ", "" + (double) FruitsEffectConfig.SEA_TOUCH_ENTITY_AMOUNT.get()))));
					tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.sea_touch_tips_item_line_3").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.effect_tips_item_normal_formula").getString()))
							.replace(" %1 ", "" + (double) FruitsEffectConfig.SEA_TOUCH_BLOCK_AMOUNT.get()))));
				}
			}
			if (itemstack.getItem() == ModItems.HACKED_THORNS_EFFECT_TIPS_ITEM.get()) {
				if (entity instanceof LivingEntity _livEnt308 && _livEnt308.hasEffect(ModMobEffects.HACKED_THORNS.get())) {
					if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.hacked_thorns_tips_item_line_1").getString())));
						tooltip.add(
								Component.literal(((((Component.translatable("tips.manors_bounty.hacked_thorns_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.effect_tips_item_normal_formula").getString()))
										.replace(" %1 ", "" + (double) FruitsEffectConfig.HACKED_THORNS_AMOUNT.get()))
										.replace(" %2 ", new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.HACKED_THORNS_TIME.get() / 20)))));
						tooltip.add(
								Component.literal(((((Component.translatable("tips.manors_bounty.hacked_thorns_tips_item_line_3").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.effect_tips_item_normal_formula").getString()))
										.replace(" %1 ", "" + (double) FruitsEffectConfig.HACKED_THORNS_KNOCKBACK_CHANCE.get()))
										.replace(" %2 ", new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.HACKED_THORNS_TIME.get() / 20)))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.hacked_thorns_tips_item_line_4").getString())));
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.hacked_thorns_tips_item_line_1").getString())));
						tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.hacked_thorns_tips_item_line_2").getString()).replace(" %1 ",
                                new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.HACKED_THORNS_AMOUNT.get()
                                        * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.HACKED_THORNS.get()) ? _livEnt.getEffect(ModMobEffects.HACKED_THORNS.get()).getAmplifier() : 0) + 1))))
								.replace(" %2 ", new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.HACKED_THORNS_TIME.get() / 20)))));
						tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.hacked_thorns_tips_item_line_3").getString()).replace(" %1 ",
								(new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.HACKED_THORNS_KNOCKBACK_CHANCE.get()
										* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.HACKED_THORNS.get()) ? _livEnt.getEffect(ModMobEffects.HACKED_THORNS.get()).getAmplifier() : 0) + 1) * 100))
										+ "%"))
								.replace(" %2 ", new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.HACKED_THORNS_TIME.get() / 20)))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.hacked_thorns_tips_item_line_4").getString())));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.effect_tips_item_shift_check").getString())));
					}
				} else {
					tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.hacked_thorns_tips_item_line_1").getString())));
					tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.hacked_thorns_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.effect_tips_item_normal_formula").getString()))
							.replace(" %1 ", "" + (double) FruitsEffectConfig.HACKED_THORNS_AMOUNT.get()))
							.replace(" %2 ", new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.HACKED_THORNS_TIME.get() / 20)))));
					tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.hacked_thorns_tips_item_line_3").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.effect_tips_item_normal_formula").getString()))
							.replace(" %1 ", "" + (double) FruitsEffectConfig.HACKED_THORNS_KNOCKBACK_CHANCE.get()))
							.replace(" %2 ", new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.HACKED_THORNS_TIME.get() / 20)))));
					tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.hacked_thorns_tips_item_line_4").getString())));
				}
			}
			if (itemstack.getItem() == ModItems.KIWING_WHEREABOUTS_EFFECT_TIPS_ITEM.get()) {
				if (entity instanceof LivingEntity _livEnt356 && _livEnt356.hasEffect(ModMobEffects.KIWING_WHEREABOUTS.get())) {
					if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.kiwing_whereabouts_tips_item_line_1").getString())));
						tooltip.add(Component.literal(
								((((Component.translatable("tips.manors_bounty.kiwing_whereabouts_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.kiwing_whereabouts_tips_item_line_2_formula").getString()))
										.replace(" %1 ", new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.KIWING_WHEREABOUTS_TIME.get() / 20)))
										.replace(" %2 ", new java.text.DecimalFormat("##").format(FruitsEffectConfig.KIWING_WHEREABOUTS_LEVEL.get() + 1)))));
						tooltip.add(Component.literal(
								(((Component.translatable("tips.manors_bounty.kiwing_whereabouts_tips_item_line_3").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.kiwing_whereabouts_tips_item_line_3_formula").getString()))
										.replace(" %1 ", new java.text.DecimalFormat("##.##").format((double) FruitsEffectConfig.KIWING_WHEREABOUTS_FALL_RESISTANCE_AMOUNT.get())))));
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.kiwing_whereabouts_tips_item_line_1").getString())));
						tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.kiwing_whereabouts_tips_item_line_2").getString()).replace(" %1 ",
								new java.text.DecimalFormat("##.##").format(0.5 + (FruitsEffectConfig.KIWING_WHEREABOUTS_TIME.get() / 20)
										* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.KIWING_WHEREABOUTS.get()) ? _livEnt.getEffect(ModMobEffects.KIWING_WHEREABOUTS.get()).getAmplifier() : 0)
												+ 1))))
								.replace(" %2 ", new java.text.DecimalFormat("##").format(FruitsEffectConfig.KIWING_WHEREABOUTS_LEVEL.get() + 1)))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.kiwing_whereabouts_tips_item_line_3").getString()).replace(" %1 ", (new java.text.DecimalFormat("##.##").format(
								(0.4 + ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.KIWING_WHEREABOUTS.get()) ? _livEnt.getEffect(ModMobEffects.KIWING_WHEREABOUTS.get()).getAmplifier() : 0) + 1)
										* FruitsEffectConfig.KIWING_WHEREABOUTS_FALL_RESISTANCE_AMOUNT.get()) * 100))
								+ "%"))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.effect_tips_item_shift_check").getString())));
					}
				} else {
					tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.kiwing_whereabouts_tips_item_line_1").getString())));
					tooltip.add(Component.literal(
							((((Component.translatable("tips.manors_bounty.kiwing_whereabouts_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.kiwing_whereabouts_tips_item_line_2_formula").getString()))
									.replace(" %1 ", new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.KIWING_WHEREABOUTS_TIME.get() / 20)))
									.replace(" %2 ", new java.text.DecimalFormat("##").format(FruitsEffectConfig.KIWING_WHEREABOUTS_LEVEL.get() + 1)))));
					tooltip.add(Component.literal(
							(((Component.translatable("tips.manors_bounty.kiwing_whereabouts_tips_item_line_3").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.kiwing_whereabouts_tips_item_line_3_formula").getString()))
									.replace(" %1 ", new java.text.DecimalFormat("##.##").format((double) FruitsEffectConfig.KIWING_WHEREABOUTS_FALL_RESISTANCE_AMOUNT.get())))));
				}
			}
			if (itemstack.getItem() == ModItems.LURKING_DANGER_EFFECT_TIPS_ITEM.get()) {
				if (entity instanceof LivingEntity _livEnt395 && _livEnt395.hasEffect(ModMobEffects.LURKING_DANGER.get())) {
					if (Screen.hasShiftDown()) {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.lurking_danger_tips_item_line_1").getString())));
						tooltip.add(Component.literal(
								((((((((Component.translatable("tips.manors_bounty.lurking_danger_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.lurking_danger_tips_item_line_2_formula").getString()))
										.replace(" %1 ", "" + FruitsEffectConfig.LURKING_DANGER_LURK_TIME.get() / 20)).replace(" %2 ", "" + FruitsEffectConfig.LURKING_DANGER_LURK_TIME_REDUCE.get() / 20))
										.replace(" %5 ", Component.translatable("tips.manors_bounty.lurking_danger_tips_item_line_2_formula_2").getString()))
										.replace(" %3 ", "" + (double) FruitsEffectConfig.LURKING_DANGER_LURK_SNEAKING_MOVEMENT_SPEED_BASE.get()))
										.replace(" %4 ", "" + (double) FruitsEffectConfig.LURKING_DANGER_LURK_SNEAKING_MOVEMENT_SPEED_ADD.get()))
										.replace(" %6 ", "" + (double) FruitsEffectConfig.LURKING_DANGER_LURK_HIDDEN_REACH_RADIUS.get()))));
						tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.lurking_danger_tips_item_line_3").getString()).replace(" %1 ",
                                new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.LURKING_DANGER_LURK_STRENGTH_TIME.get() / 20)))
								.replace(" %2 ", new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.LURKING_DANGER_LURK_STRENGTH_LEVEL.get() + 1)))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.lurking_danger_tips_item_line_4").getString()).replace(" %1 ",
                                new java.text.DecimalFormat("##.##").format(Math.abs(FruitsEffectConfig.LURKING_DANGER_LURK_ATTACKED_PENALTY_TIME.get()) / 20)))));
					} else {
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.lurking_danger_tips_item_line_1").getString())));
						tooltip.add(Component.literal(((((Component.translatable("tips.manors_bounty.lurking_danger_tips_item_line_2").getString()).replace(" %1 ",
                                new java.text.DecimalFormat("##.##").format((FruitsEffectConfig.LURKING_DANGER_LURK_TIME.get()
                                        - (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.LURKING_DANGER.get()) ? _livEnt.getEffect(ModMobEffects.LURKING_DANGER.get()).getAmplifier() : 0)
                                        * FruitsEffectConfig.LURKING_DANGER_LURK_TIME_REDUCE.get())
                                        / 20)))
								.replace(" %5 ", (new java.text.DecimalFormat("##.##").format(100 * (FruitsEffectConfig.LURKING_DANGER_LURK_SNEAKING_MOVEMENT_SPEED_BASE.get()
										+ ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.LURKING_DANGER.get()) ? _livEnt.getEffect(ModMobEffects.LURKING_DANGER.get()).getAmplifier() : 0) + 1)
												* FruitsEffectConfig.LURKING_DANGER_LURK_SNEAKING_MOVEMENT_SPEED_ADD.get())))
										+ "%"))
								.replace(" %6 ", "" + (double) FruitsEffectConfig.LURKING_DANGER_LURK_HIDDEN_REACH_RADIUS.get()))));
						tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.lurking_danger_tips_item_line_3").getString()).replace(" %1 ",
								new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.LURKING_DANGER_LURK_STRENGTH_TIME.get() / 20)))
								.replace(" %2 ", new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.LURKING_DANGER_LURK_STRENGTH_LEVEL.get() + 1)))));
						tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.lurking_danger_tips_item_line_4").getString()).replace(" %1 ",
                                new java.text.DecimalFormat("##.##").format(Math.abs(FruitsEffectConfig.LURKING_DANGER_LURK_ATTACKED_PENALTY_TIME.get()) / 20)))));
						tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.effect_tips_item_shift_check").getString())));
					}
				} else {
					tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.lurking_danger_tips_item_line_1").getString())));
					tooltip.add(Component
							.literal(((((((((Component.translatable("tips.manors_bounty.lurking_danger_tips_item_line_2").getString()).replace(" %1 ", Component.translatable("tips.manors_bounty.lurking_danger_tips_item_line_2_formula").getString()))
									.replace(" %1 ", "" + FruitsEffectConfig.LURKING_DANGER_LURK_TIME.get() / 20)).replace(" %2 ", "" + FruitsEffectConfig.LURKING_DANGER_LURK_TIME_REDUCE.get() / 20))
									.replace(" %5 ", Component.translatable("tips.manors_bounty.lurking_danger_tips_item_line_2_formula_2").getString()))
									.replace(" %3 ", "" + (double) FruitsEffectConfig.LURKING_DANGER_LURK_SNEAKING_MOVEMENT_SPEED_BASE.get()))
									.replace(" %4 ", "" + (double) FruitsEffectConfig.LURKING_DANGER_LURK_SNEAKING_MOVEMENT_SPEED_ADD.get()))
									.replace(" %6 ", "" + (double) FruitsEffectConfig.LURKING_DANGER_LURK_HIDDEN_REACH_RADIUS.get()))));
					tooltip.add(Component.literal((((Component.translatable("tips.manors_bounty.lurking_danger_tips_item_line_3").getString()).replace(" %1 ",
                            new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.LURKING_DANGER_LURK_STRENGTH_TIME.get() / 20)))
							.replace(" %2 ", new java.text.DecimalFormat("##.##").format(FruitsEffectConfig.LURKING_DANGER_LURK_STRENGTH_LEVEL.get() + 1)))));
					tooltip.add(Component.literal(((Component.translatable("tips.manors_bounty.lurking_danger_tips_item_line_4").getString()).replace(" %1 ",
                            new java.text.DecimalFormat("##.##").format(Math.abs(FruitsEffectConfig.LURKING_DANGER_LURK_ATTACKED_PENALTY_TIME.get()) / 20)))));
				}
			}
			if (itemstack.getItem() == ModItems.TRANSMIT_EFFECT_TIPS_ITEM.get()) {
				tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.transmit_tips_item_line_1").getString())));
				tooltip.add(Component.literal((Component.translatable("tips.manors_bounty.transmit_tips_item_line_2").getString())));
			}
		}
	}
}
