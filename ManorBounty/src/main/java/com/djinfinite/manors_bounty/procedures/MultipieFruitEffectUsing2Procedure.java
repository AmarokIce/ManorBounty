package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import com.djinfinite.manors_bounty.network.ManorsBountyModVariables;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

public class MultipieFruitEffectUsing2Procedure {
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
            if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_MangoFoodsCooldown <= 0
					&& (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_PineappleFoodsCooldown <= 0) {
				if (itemstack.getItem() == ModItems.LUAU_PALETERIA.get()) {
                    if (Math.random() < 0.95) {
                        do_effect_have = entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get())
                                ? _livEnt.getEffect(ModMobEffects.ORIGINAL_EVOLUTION.get()).getAmplifier()
                                : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get())
                                ? _livEnt.getEffect(ModMobEffects.ORIGINAL_EVOLUTION.get()).getDuration()
                                : 0;
                        if (org_effect_level <= 6) {
                            if (do_effect_have) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.ORIGINAL_EVOLUTION.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                if (Math.random() < 0.3) {
                                    do_effect_have = entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get());
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get())
                                            ? _livEnt.getEffect(ModMobEffects.ORIGINAL_EVOLUTION.get()).getAmplifier()
                                            : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get())
                                            ? _livEnt.getEffect(ModMobEffects.ORIGINAL_EVOLUTION.get()).getDuration()
                                            : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(ModMobEffects.ORIGINAL_EVOLUTION.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                }
                            } else {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.ORIGINAL_EVOLUTION.get(), (int) c_type_new_time, 0, false, false));
                                if (Math.random() < 0.3) {
                                    do_effect_have = entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get());
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get())
                                            ? _livEnt.getEffect(ModMobEffects.ORIGINAL_EVOLUTION.get()).getAmplifier()
                                            : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get())
                                            ? _livEnt.getEffect(ModMobEffects.ORIGINAL_EVOLUTION.get()).getDuration()
                                            : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(ModMobEffects.ORIGINAL_EVOLUTION.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                }
                            }
                        }
                        do_effect_have = entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get()) ? _livEnt.getEffect(ModMobEffects.SUMMER_HEATWAVE.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get()) ? _livEnt.getEffect(ModMobEffects.SUMMER_HEATWAVE.get()).getDuration() : 0;
                        if (org_effect_level <= 6) {
                            if (do_effect_have) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.SUMMER_HEATWAVE.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                if (Math.random() < 0.3) {
                                    do_effect_have = entity instanceof LivingEntity _livEnt25 && _livEnt25.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get());
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get())
                                            ? _livEnt.getEffect(ModMobEffects.SUMMER_HEATWAVE.get()).getAmplifier()
                                            : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get())
                                            ? _livEnt.getEffect(ModMobEffects.SUMMER_HEATWAVE.get()).getDuration()
                                            : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(ModMobEffects.SUMMER_HEATWAVE.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                }
                            } else {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.SUMMER_HEATWAVE.get(), (int) c_type_new_time, 0, false, false));
                                if (Math.random() < 0.3) {
                                    do_effect_have = entity instanceof LivingEntity _livEnt30 && _livEnt30.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get());
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get())
                                            ? _livEnt.getEffect(ModMobEffects.SUMMER_HEATWAVE.get()).getAmplifier()
                                            : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get())
                                            ? _livEnt.getEffect(ModMobEffects.SUMMER_HEATWAVE.get()).getDuration()
                                            : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(ModMobEffects.SUMMER_HEATWAVE.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                }
                            }
                        }
                    }
                    {
                        double _setval = refined_fruit_cd_time;
                        entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.MB_MangoFoodsCooldown = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                    {
                        double _setval = refined_fruit_cd_time;
                        entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.MB_PineappleFoodsCooldown = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                }
			}
			if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryFoodsCooldown <= 0
					&& (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_SweetBerriesFoodsCooldown <= 0) {
				if (itemstack.getItem() == ModItems.ETON_MESS.get()) {
                    if (Math.random() < 0.925) {
                        do_effect_have = entity instanceof LivingEntity _livEnt36 && _livEnt36.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration() : 0;
                        if (org_effect_level <= 6) {
                            if (do_effect_have) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                if (Math.random() < 0.2) {
                                    do_effect_have = entity instanceof LivingEntity _livEnt40 && _livEnt40.hasEffect(ModMobEffects.BURSTING_BERRY.get());
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
                                if (Math.random() < 0.2) {
                                    do_effect_have = entity instanceof LivingEntity _livEnt45 && _livEnt45.hasEffect(ModMobEffects.BURSTING_BERRY.get());
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
                            capability.MB_SweetBerriesFoodsCooldown = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                }
			}
			if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_StrawberryFoodsCooldown <= 0) {
				if (itemstack.getItem() == ModItems.PINK_SNOWMAN_PALETERIA.get()) {
                    if (Math.random() < 0.95) {
                        do_effect_have = entity instanceof LivingEntity _livEnt51 && _livEnt51.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration() : 0;
                        if (org_effect_level <= 6) {
                            if (do_effect_have) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                if (Math.random() < 0.3) {
                                    do_effect_have = entity instanceof LivingEntity _livEnt55 && _livEnt55.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get())
                                            ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier()
                                            : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get())
                                            ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration()
                                            : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                    if (org_effect_level <= 6) {
                                        do_effect_have = entity instanceof LivingEntity _livEnt59 && _livEnt59.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get())
                                                ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier()
                                                : 0;
                                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get())
                                                ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration()
                                                : 0;
                                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                    }
                                    if (org_effect_level <= 6) {
                                        do_effect_have = entity instanceof LivingEntity _livEnt63 && _livEnt63.hasEffect(ModMobEffects.BURSTING_BERRY.get());
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
                            } else {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) c_type_new_time, 0, false, false));
                                if (Math.random() < 0.3) {
                                    do_effect_have = entity instanceof LivingEntity _livEnt68 && _livEnt68.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get())
                                            ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier()
                                            : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get())
                                            ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration()
                                            : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                }
                                if (org_effect_level <= 6) {
                                    do_effect_have = entity instanceof LivingEntity _livEnt72 && _livEnt72.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get())
                                            ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier()
                                            : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get())
                                            ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration()
                                            : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                }
                                if (org_effect_level <= 6) {
                                    do_effect_have = entity instanceof LivingEntity _livEnt76 && _livEnt76.hasEffect(ModMobEffects.BURSTING_BERRY.get());
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
                }
			}
			if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_OliveFruitCooldown <= 0
					&& (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_GlowBerriesCooldown <= 0) {
				if (itemstack.getItem() == ModItems.SEA_PEARL_SALAD.get()) {
					rough_fruit_cd_time = FruitsEffectConfig.FOODS_COOLDOWN_X.get() * 20;
					if (Math.random() < 0.7) {
                        do_effect_have = entity instanceof LivingEntity _livEnt83 && _livEnt83.hasEffect(ModMobEffects.SEA_TOUCH.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SEA_TOUCH.get()) ? _livEnt.getEffect(ModMobEffects.SEA_TOUCH.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SEA_TOUCH.get()) ? _livEnt.getEffect(ModMobEffects.SEA_TOUCH.get()).getDuration() : 0;
                        if (do_effect_have) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(ModMobEffects.SEA_TOUCH.get(), (int) (org_effect_time + b_type_add_time), (int) org_effect_level, false, false));
							FruitEffectTimeAddProcedure.execute(entity, 1 + FruitsEffectConfig.FOODS_VALUE_X.get() * 2);
							{
								double _setval = rough_fruit_cd_time;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_OliveFruitFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else {
                        do_effect_have = entity instanceof LivingEntity _livEnt88 && _livEnt88.hasEffect(ModMobEffects.SEA_TOUCH.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SEA_TOUCH.get()) ? _livEnt.getEffect(ModMobEffects.SEA_TOUCH.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SEA_TOUCH.get()) ? _livEnt.getEffect(ModMobEffects.SEA_TOUCH.get()).getDuration() : 0;
                        if (org_effect_level <= 4) {
							if (do_effect_have) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.SEA_TOUCH.get(), (int) (org_effect_time + b_type_add_time), (int) (org_effect_level + 1), false, false));
							} else {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.SEA_TOUCH.get(), (int) b_type_new_time, 0, false, false));
							}
							FruitEffectTimeAddProcedure.execute(entity, 1 + FruitsEffectConfig.FOODS_VALUE_X.get() * 2);
							{
								double _setval = rough_fruit_cd_time;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_OliveFruitFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
			}
			if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_WatermelonCooldown <= 0
					&& (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_HamimelonCooldown <= 0) {
				if (itemstack.getItem() == ModItems.MELON_SALAD.get()) {
					if (Math.random() < 0.7) {
                        do_effect_have = entity instanceof LivingEntity _livEnt96 && _livEnt96.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration() : 0;
                        if (do_effect_have) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(ModMobEffects.MELON_GRAVITY.get(), (int) (org_effect_time + b_type_add_time * 2.5), (int) org_effect_level, false, false));
							{
								double _setval = rough_fruit_cd_time;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_StrawberryFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else {
                        do_effect_have = entity instanceof LivingEntity _livEnt100 && _livEnt100.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration() : 0;
                        if (org_effect_level <= 4) {
							if (do_effect_have) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.MELON_GRAVITY.get(), (int) (org_effect_time + b_type_add_time * 2.5), (int) (org_effect_level + 1), false, false));
							} else {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.MELON_GRAVITY.get(), (int) (b_type_new_time * 2.5), 0, false, false));
							}
							{
								double _setval = rough_fruit_cd_time;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_WatermelonCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = rough_fruit_cd_time;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_HamimelonCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
			}
		}
	}
}
