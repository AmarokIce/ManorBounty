package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import com.djinfinite.manors_bounty.network.ManorsBountyModVariables;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

public class MultipieFruitEffectUsingProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean do_effect_have = false;
		double rough_fruit_cd_time = 0;
		double b_type_add_time = 0;
		double org_effect_level = 0;
		double b_type_new_time = 0;
		double org_effect_time = 0;
		double raw_fruit_cd_time = 0;
		double c_type_new_time = 0;
		double refined_fruit_cd_time = 0;
		if (DoFruitEffectEnableCheckProcedure.execute()) {
            FruitsEffectConfig.FOODS_COOLDOWN_A.get();
            rough_fruit_cd_time = FruitsEffectConfig.FOODS_COOLDOWN_B.get() * 20;
            refined_fruit_cd_time = FruitsEffectConfig.FOODS_COOLDOWN_C.get() * 20;
            b_type_add_time = FruitsEffectConfig.FOODS_ADD_TIME_B.get() * 20;
            b_type_new_time = FruitsEffectConfig.FOODS_NEW_TIME_B.get() * 20;
            c_type_new_time = FruitsEffectConfig.FOODS_NEW_TIME_C.get() * 20;
            if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StarfruitFoodsCooldown <= 0
					&& (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_DragonFruitFoodsCooldown <= 0) {
				if (itemstack.getItem() == ModItems.COSMIC_DRAGON_SALAD.get()) {
					if (Math.random() < 0.7) {
                        do_effect_have = entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration() : 0;
                        if (do_effect_have) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(ModMobEffects.MOMENTARY_METEOR.get(), (int) (org_effect_time + Math.floor(b_type_add_time * 2.5)), (int) org_effect_level, false, false));
							{
								double _setval = Math.floor(b_type_new_time * 2.5);
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_StarfruitFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = Math.floor(b_type_new_time * 2.5);
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_DragonFruitFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
                        do_effect_have = entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(ModMobEffects.HACKED_THORNS.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.HACKED_THORNS.get()) ? _livEnt.getEffect(ModMobEffects.HACKED_THORNS.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.HACKED_THORNS.get()) ? _livEnt.getEffect(ModMobEffects.HACKED_THORNS.get()).getDuration() : 0;
                        if (do_effect_have) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(ModMobEffects.HACKED_THORNS.get(), (int) (org_effect_time + Math.floor(b_type_add_time * 2.5)), (int) org_effect_level, false, false));
							{
								double _setval = Math.floor(b_type_new_time * 2.5);
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_StarfruitFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = Math.floor(b_type_new_time * 2.5);
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_DragonFruitFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
                        do_effect_have = entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get()) ? _livEnt.getEffect(ModMobEffects.SUMMER_HEATWAVE.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get()) ? _livEnt.getEffect(ModMobEffects.SUMMER_HEATWAVE.get()).getDuration() : 0;
                        if (do_effect_have) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(ModMobEffects.SUMMER_HEATWAVE.get(), (int) (org_effect_time + Math.floor(b_type_add_time * 2.5)), (int) org_effect_level, false, false));
							{
								double _setval = Math.floor(b_type_new_time * 2.5);
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_StarfruitFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = Math.floor(b_type_new_time * 2.5);
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_DragonFruitFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else {
                        do_effect_have = entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration() : 0;
                        if (org_effect_level <= 4) {
							if (do_effect_have) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.MOMENTARY_METEOR.get(), (int) (org_effect_time + Math.floor(b_type_add_time * 2.5)), (int) (org_effect_level + 1), false, false));
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.MOMENTARY_METEOR.get(), (int) (org_effect_time + Math.floor(b_type_add_time * 2.5)), (int) (org_effect_level + 1), false, false));
                            } else {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.MOMENTARY_METEOR.get(), (int) Math.floor(b_type_new_time * 2.5), 0, false, false));
							}
							{
								double _setval = Math.floor(rough_fruit_cd_time * 2.5);
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_StarfruitFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = Math.floor(b_type_new_time * 2.5);
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_DragonFruitFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
                        do_effect_have = entity instanceof LivingEntity _livEnt26 && _livEnt26.hasEffect(ModMobEffects.HACKED_THORNS.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.HACKED_THORNS.get()) ? _livEnt.getEffect(ModMobEffects.HACKED_THORNS.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.HACKED_THORNS.get()) ? _livEnt.getEffect(ModMobEffects.HACKED_THORNS.get()).getDuration() : 0;
                        if (org_effect_level <= 4) {
							if (do_effect_have) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.HACKED_THORNS.get(), (int) (org_effect_time + Math.floor(b_type_add_time * 2.5)), (int) (org_effect_level + 1), false, false));
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.HACKED_THORNS.get(), (int) (org_effect_time + Math.floor(b_type_add_time * 2.5)), (int) (org_effect_level + 1), false, false));
                            } else {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.HACKED_THORNS.get(), (int) Math.floor(b_type_new_time * 2.5), 0, false, false));
							}
							{
								double _setval = Math.floor(rough_fruit_cd_time * 2.5);
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_StarfruitFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = Math.floor(b_type_new_time * 2.5);
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_DragonFruitFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
                        do_effect_have = entity instanceof LivingEntity _livEnt32 && _livEnt32.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get()) ? _livEnt.getEffect(ModMobEffects.SUMMER_HEATWAVE.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get()) ? _livEnt.getEffect(ModMobEffects.SUMMER_HEATWAVE.get()).getDuration() : 0;
                        if (org_effect_level <= 4) {
							if (do_effect_have) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.SUMMER_HEATWAVE.get(), (int) (org_effect_time + Math.floor(b_type_add_time * 2.5)), (int) (org_effect_level + 1), false, false));
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.SUMMER_HEATWAVE.get(), (int) (org_effect_time + Math.floor(b_type_add_time * 2.5)), (int) (org_effect_level + 1), false, false));
                            } else {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.SUMMER_HEATWAVE.get(), (int) Math.floor(b_type_new_time * 2.5), 0, false, false));
							}
							{
								double _setval = Math.floor(rough_fruit_cd_time * 2.5);
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_StarfruitFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = Math.floor(b_type_new_time * 2.5);
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_DragonFruitFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
			}
			if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_AppleFoodsCooldown <= 0
					&& (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PeachFoodsCooldown <= 0
					&& (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PearFoodsCooldown <= 0) {
				if (itemstack.getItem() == ModItems.ROSA_SALAD.get()) {
					if (Math.random() < 0.7) {
						if (do_effect_have) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) (org_effect_time + Math.floor(b_type_add_time * 2.5)), (int) org_effect_level, false, false));
							{
								double _setval = Math.floor(rough_fruit_cd_time * 2.5);
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_AppleFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = Math.floor(rough_fruit_cd_time * 2.5);
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_PeachFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = Math.floor(rough_fruit_cd_time * 2.5);
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_PearFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else {
						if (org_effect_level <= 4) {
							if (do_effect_have) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) (org_effect_time + Math.floor(b_type_add_time * 2.5)), (int) (org_effect_level + 1), false, false));
							} else {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) Math.floor(b_type_new_time * 2.5), 0, false, false));
							}
							{
								double _setval = Math.floor(rough_fruit_cd_time * 2.5);
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_AppleFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = Math.floor(rough_fruit_cd_time * 2.5);
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_PeachFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = Math.floor(rough_fruit_cd_time * 2.5);
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_PearFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
			}
			if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_AppleFoodsCooldown <= 0
					&& (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PeachFoodsCooldown <= 0
					&& (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PearFoodsCooldown <= 0) {
				if (itemstack.getItem() == ModItems.HEART_CRUSH_PALETERIA.get()) {
                    if (Math.random() < 0.9) {
                        do_effect_have = entity instanceof LivingEntity _livEnt45 && _livEnt45.hasEffect(ModMobEffects.ROSA_HEDGE.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ROSA_HEDGE.get()) ? _livEnt.getEffect(ModMobEffects.ROSA_HEDGE.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ROSA_HEDGE.get()) ? _livEnt.getEffect(ModMobEffects.ROSA_HEDGE.get()).getDuration() : 0;
                        if (org_effect_level <= 6) {
                            if (do_effect_have) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                if (Math.random() < 0.15) {
                                    do_effect_have = entity instanceof LivingEntity _livEnt49 && _livEnt49.hasEffect(ModMobEffects.ROSA_HEDGE.get());
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ROSA_HEDGE.get()) ? _livEnt.getEffect(ModMobEffects.ROSA_HEDGE.get()).getAmplifier() : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ROSA_HEDGE.get()) ? _livEnt.getEffect(ModMobEffects.ROSA_HEDGE.get()).getDuration() : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                }
                            } else {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) c_type_new_time, 0, false, false));
                                if (Math.random() < 0.15) {
                                    do_effect_have = entity instanceof LivingEntity _livEnt54 && _livEnt54.hasEffect(ModMobEffects.ROSA_HEDGE.get());
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ROSA_HEDGE.get()) ? _livEnt.getEffect(ModMobEffects.ROSA_HEDGE.get()).getAmplifier() : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ROSA_HEDGE.get()) ? _livEnt.getEffect(ModMobEffects.ROSA_HEDGE.get()).getDuration() : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                }
                            }
                        }
                        do_effect_have = entity instanceof LivingEntity _livEnt58 && _livEnt58.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
                                ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getAmplifier()
                                : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
                                ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getDuration()
                                : 0;
                        if (org_effect_level <= 6) {
                            if (do_effect_have) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                if (Math.random() < 0.15) {
                                    do_effect_have = entity instanceof LivingEntity _livEnt62 && _livEnt62.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get());
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
                                            ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getAmplifier()
                                            : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
                                            ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getDuration()
                                            : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                }
                            } else {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get(), (int) c_type_new_time, 0, false, false));
                                if (Math.random() < 0.15) {
                                    do_effect_have = entity instanceof LivingEntity _livEnt67 && _livEnt67.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get());
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
                                            ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getAmplifier()
                                            : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
                                            ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getDuration()
                                            : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                }
                            }
                        }
                    }
                    {
                        double _setval = refined_fruit_cd_time;
                        entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.MB_PeachFoodsCooldown = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                    {
                        double _setval = refined_fruit_cd_time;
                        entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.MB_CherriesFoodsCooldown = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                }
			}
			if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryFoodsCooldown <= 0
					&& (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesFoodsCooldown <= 0) {
				if (itemstack.getItem() == ModItems.BLUEBERRY_CHERRIES_ICE_CREAM.get()) {
                    if (Math.random() < 0.9) {
                        do_effect_have = entity instanceof LivingEntity _livEnt73 && _livEnt73.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
                                ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getAmplifier()
                                : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
                                ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getDuration()
                                : 0;
                        if (org_effect_level <= 6) {
                            if (do_effect_have) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                if (Math.random() < 0.15) {
                                    do_effect_have = entity instanceof LivingEntity _livEnt77 && _livEnt77.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get());
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
                                            ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getAmplifier()
                                            : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
                                            ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getDuration()
                                            : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                }
                            } else {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get(), (int) c_type_new_time, 0, false, false));
                                if (Math.random() < 0.15) {
                                    do_effect_have = entity instanceof LivingEntity _livEnt82 && _livEnt82.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get());
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
                                            ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getAmplifier()
                                            : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
                                            ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getDuration()
                                            : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                }
                            }
                        }
                        do_effect_have = entity instanceof LivingEntity _livEnt86 && _livEnt86.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration() : 0;
                        if (org_effect_level <= 6) {
                            if (do_effect_have) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                if (Math.random() < 0.15) {
                                    do_effect_have = entity instanceof LivingEntity _livEnt90 && _livEnt90.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get())
                                            ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier()
                                            : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get())
                                            ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration()
                                            : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                }
                            } else {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) c_type_new_time, 0, false, false));
                                if (Math.random() < 0.15) {
                                    do_effect_have = entity instanceof LivingEntity _livEnt95 && _livEnt95.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get())
                                            ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier()
                                            : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get())
                                            ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration()
                                            : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                }
                            }
                        }
                    }
                    {
                        double _setval = refined_fruit_cd_time;
                        entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.MB_CherriesFoodsCooldown = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                    {
                        double _setval = refined_fruit_cd_time;
                        entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.MB_BlueberryFoodsCooldown = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                }
			}
			if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryFoodsCooldown <= 0
					&& (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryFoodsCooldown <= 0
					&& (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_CherriesFoodsCooldown <= 0) {
				if (itemstack.getItem() == ModItems.GRIMACE_SHAKE.get()) {
					if (Math.random() < 0.7) {
                        do_effect_have = entity instanceof LivingEntity _livEnt101 && _livEnt101.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration() : 0;
                        if (do_effect_have) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) (org_effect_time + b_type_add_time * 2.5), (int) org_effect_level, false, false));
							{
								double _setval = rough_fruit_cd_time;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_StrawberryFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = rough_fruit_cd_time;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_BlueberryFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = rough_fruit_cd_time;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_CherriesFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
                        do_effect_have = entity instanceof LivingEntity _livEnt105 && _livEnt105.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
                                ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getAmplifier()
                                : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
                                ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getDuration()
                                : 0;
                        if (do_effect_have) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) (org_effect_time + b_type_add_time * 2.5), (int) org_effect_level, false, false));
							{
								double _setval = rough_fruit_cd_time;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_StrawberryFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = rough_fruit_cd_time;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_BlueberryFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = rough_fruit_cd_time;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_CherriesFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else {
                        do_effect_have = entity instanceof LivingEntity _livEnt109 && _livEnt109.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration() : 0;
                        if (org_effect_level <= 4) {
							if (do_effect_have) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) (org_effect_time + b_type_add_time * 2.5), (int) (org_effect_level + 1), false, false));
							} else {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) (b_type_new_time * 2.5), 0, false, false));
							}
							{
								double _setval = rough_fruit_cd_time * 2.5;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_StrawberryFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = rough_fruit_cd_time * 2.5;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_BlueberryFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = rough_fruit_cd_time * 2.5;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_CherriesFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
                        do_effect_have = entity instanceof LivingEntity _livEnt114 && _livEnt114.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
                                ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getAmplifier()
                                : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
                                ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getDuration()
                                : 0;
                        if (org_effect_level <= 4) {
							if (do_effect_have) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get(), (int) (org_effect_time + b_type_add_time * 2.5), (int) (org_effect_level + 1), false, false));
							} else {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get(), (int) (b_type_new_time * 1.6), 0, false, false));
							}
							{
								double _setval = rough_fruit_cd_time * 2.5;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_StrawberryFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = rough_fruit_cd_time * 2.5;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_BlueberryFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = rough_fruit_cd_time * 2.5;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_CherriesFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
			}
			if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryFoodsCooldown <= 0
					&& (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_BlueberryFoodsCooldown <= 0) {
				if (itemstack.getItem() == ModItems.POWSICLE_PALETERIA.get()) {
                    if (Math.random() < 0.95) {
                        do_effect_have = entity instanceof LivingEntity _livEnt121 && _livEnt121.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration() : 0;
                        if (org_effect_level <= 6) {
                            if (do_effect_have) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                if (Math.random() < 0.3) {
                                    if (entity instanceof LivingEntity _livEnt125) {
                                        _livEnt125.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                                    }
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get())
                                            ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier()
                                            : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get())
                                            ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration()
                                            : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                }
                            } else {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) c_type_new_time, 0, false, false));
                                if (Math.random() < 0.3) {
                                    if (entity instanceof LivingEntity _livEnt130) {
                                        _livEnt130.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                                    }
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get())
                                            ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier()
                                            : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get())
                                            ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration()
                                            : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                }
                            }
                        }
                    }
                    {
                        double _setval = refined_fruit_cd_time;
                        entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.MB_StrawberryFoodsCooldown = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                    {
                        double _setval = refined_fruit_cd_time;
                        entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.MB_BlueberryFoodsCooldown = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                }
			}
		}
	}
}
