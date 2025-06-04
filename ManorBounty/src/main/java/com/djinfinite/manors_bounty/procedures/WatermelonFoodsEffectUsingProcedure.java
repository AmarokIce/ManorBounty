package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModItems;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import com.djinfinite.manors_bounty.network.ManorsBountyModVariables;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

public class WatermelonFoodsEffectUsingProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean do_effect_have = false;
		double raw_fruit_cd_time = 0;
		double rough_fruit_cd_time = 0;
		double refined_fruit_cd_time = 0;
		double org_effect_level = 0;
		double org_effect_time = 0;
		double b_type_add_time = 0;
		double c_type_new_time = 0;
		double b_type_new_time = 0;
		if (DoFruitEffectEnableCheckProcedure.execute()) {
            raw_fruit_cd_time = FruitsEffectConfig.FOODS_COOLDOWN_A.get() * 20;
            rough_fruit_cd_time = FruitsEffectConfig.FOODS_COOLDOWN_B.get() * 20;
            refined_fruit_cd_time = FruitsEffectConfig.FOODS_COOLDOWN_C.get() * 20;
            b_type_add_time = FruitsEffectConfig.FOODS_ADD_TIME_B.get() * 20;
            b_type_new_time = FruitsEffectConfig.FOODS_NEW_TIME_B.get() * 20;
            c_type_new_time = FruitsEffectConfig.FOODS_NEW_TIME_C.get() * 20;
            if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_WatermelonCooldown <= 0) {
				if (itemstack.getItem() == Items.MELON_SLICE) {
                    do_effect_have = entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(ModMobEffects.MELON_GRAVITY.get());
                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get()) ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getAmplifier() : 0;
                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get()) ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getDuration() : 0;
                    if (do_effect_have && org_effect_level <= 2 && Math.random() < 0.5) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(ModMobEffects.MELON_GRAVITY.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
						{
							double _setval = Math.floor(raw_fruit_cd_time * 0.5);
							entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MB_WatermelonCooldown = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
			if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_WatermelonFoodsCooldown <= 0) {
				if (itemstack.getItem() == ModItems.WATERMELON_JUICE.get()) {
					if (Math.random() < 0.7) {
                        do_effect_have = entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(ModMobEffects.MELON_GRAVITY.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get()) ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get()) ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getDuration() : 0;
                        if (do_effect_have) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(ModMobEffects.MELON_GRAVITY.get(), (int) (org_effect_time + b_type_add_time), (int) org_effect_level, false, false));
							{
								double _setval = rough_fruit_cd_time;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_WatermelonFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else {
                        do_effect_have = entity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(ModMobEffects.MELON_GRAVITY.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get()) ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get()) ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getDuration() : 0;
                        if (org_effect_level <= 4) {
							if (do_effect_have) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.MELON_GRAVITY.get(), (int) (org_effect_time + b_type_add_time), (int) (org_effect_level + 1), false, false));
							} else {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.MELON_GRAVITY.get(), (int) b_type_new_time, 0, false, false));
							}
							{
								double _setval = rough_fruit_cd_time;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_WatermelonFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
				if (itemstack.getItem() == ModItems.WATERMELON_PALETERIA.get()) {
					if (Math.random() < 0.9) {
                        do_effect_have = entity instanceof LivingEntity _livEnt25 && _livEnt25.hasEffect(ModMobEffects.MELON_GRAVITY.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get()) ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get()) ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getDuration() : 0;
                        if (org_effect_level <= 6) {
							if (do_effect_have) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.MELON_GRAVITY.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
								if (Math.random() < 0.15) {
                                    if (entity instanceof LivingEntity _livEnt29) {
                                        _livEnt29.hasEffect(ModMobEffects.MELON_GRAVITY.get());
                                    }
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get())
                                            ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getAmplifier()
                                            : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get()) ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getDuration() : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(ModMobEffects.MELON_GRAVITY.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
								}
							} else {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.MELON_GRAVITY.get(), (int) c_type_new_time, 0, false, false));
								if (Math.random() < 0.15) {
                                    if (entity instanceof LivingEntity _livEnt34) {
                                        _livEnt34.hasEffect(ModMobEffects.MELON_GRAVITY.get());
                                    }
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get())
                                            ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getAmplifier()
                                            : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get()) ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getDuration() : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(ModMobEffects.MELON_GRAVITY.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
								}
							}
						}
					}
					{
						double _setval = refined_fruit_cd_time;
						entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MB_WatermelonFoodsCooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
