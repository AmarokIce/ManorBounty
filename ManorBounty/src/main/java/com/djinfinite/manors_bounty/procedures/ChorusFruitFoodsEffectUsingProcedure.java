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

public class ChorusFruitFoodsEffectUsingProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean do_effect_have = false;
		double raw_fruit_cd_time = 0;
		double rough_fruit_cd_time = 0;
		double refined_fruit_cd_time = 0;
		double org_effect_level = 0;
		double org_effect_time = 0;
		double b_type_add_time;
		double c_type_new_time;
		double b_type_new_time;
		if (DoFruitEffectEnableCheckProcedure.execute()) {
            raw_fruit_cd_time = FruitsEffectConfig.FOODS_COOLDOWN_A.get() * 20;
            rough_fruit_cd_time = FruitsEffectConfig.FOODS_COOLDOWN_B.get() * 20;
            refined_fruit_cd_time = FruitsEffectConfig.FOODS_COOLDOWN_C.get() * 20;
            FruitsEffectConfig.FOODS_ADD_TIME_B.get();
            FruitsEffectConfig.FOODS_NEW_TIME_B.get();
            FruitsEffectConfig.FOODS_NEW_TIME_C.get();
            b_type_add_time = 10 * 20;
			b_type_new_time = 15 * 20;
			c_type_new_time = 5 * 20;
			if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_ChorusFruitCooldown <= 0) {
				if (itemstack.getItem() == Items.CHORUS_FRUIT) {
                    do_effect_have = entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(ModMobEffects.TRANSMIT.get());
                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TRANSMIT.get()) ? _livEnt.getEffect(ModMobEffects.TRANSMIT.get()).getAmplifier() : 0;
                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TRANSMIT.get()) ? _livEnt.getEffect(ModMobEffects.TRANSMIT.get()).getDuration() : 0;
                    if (do_effect_have && org_effect_level <= 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(ModMobEffects.TRANSMIT.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, true));
						{
							double _setval = Math.floor(raw_fruit_cd_time * 0.25);
							entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MB_ChorusFruitCooldown = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
			if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_ChorusFruitFoodsCooldown <= 0) {
				if (itemstack.getItem() == ModItems.CHORUS_FRUIT_JUICE.get()) {
					if (Math.random() < 0.95) {
                        do_effect_have = entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(ModMobEffects.TRANSMIT.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TRANSMIT.get()) ? _livEnt.getEffect(ModMobEffects.TRANSMIT.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TRANSMIT.get()) ? _livEnt.getEffect(ModMobEffects.TRANSMIT.get()).getDuration() : 0;
                        if (org_effect_level <= 4) {
							if (do_effect_have) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.TRANSMIT.get(), (int) (org_effect_time + b_type_add_time), (int) (org_effect_level + 1), false, true));
							} else {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.TRANSMIT.get(), (int) b_type_new_time, 0, false, true));
							}
							{
								double _setval = rough_fruit_cd_time * 0.25;
								entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_ChorusFruitFoodsCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
				if (itemstack.getItem() == ModItems.CHORUS_FLOWER_JELLY_CAKE_SLICE.get() || itemstack.getItem() == ModItems.CHORUS_CHROME_CUBE.get()) {
					if (Math.random() < 0.95) {
                        do_effect_have = entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(ModMobEffects.TRANSMIT.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TRANSMIT.get()) ? _livEnt.getEffect(ModMobEffects.TRANSMIT.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TRANSMIT.get()) ? _livEnt.getEffect(ModMobEffects.TRANSMIT.get()).getDuration() : 0;
                        if (org_effect_level <= 6) {
							if (do_effect_have) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.TRANSMIT.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, true));
								if (Math.random() < 0.3) {
                                    if (entity instanceof LivingEntity _livEnt27) {
                                        _livEnt27.hasEffect(ModMobEffects.TRANSMIT.get());
                                    }
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TRANSMIT.get()) ? _livEnt.getEffect(ModMobEffects.TRANSMIT.get()).getAmplifier() : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TRANSMIT.get()) ? _livEnt.getEffect(ModMobEffects.TRANSMIT.get()).getDuration() : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(ModMobEffects.TRANSMIT.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, true));
								}
							} else {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.TRANSMIT.get(), (int) c_type_new_time, 0, false, true));
								if (Math.random() < 0.3) {
                                    if (entity instanceof LivingEntity _livEnt32) {
                                        _livEnt32.hasEffect(ModMobEffects.TRANSMIT.get());
                                    }
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TRANSMIT.get()) ? _livEnt.getEffect(ModMobEffects.TRANSMIT.get()).getAmplifier() : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TRANSMIT.get()) ? _livEnt.getEffect(ModMobEffects.TRANSMIT.get()).getDuration() : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(ModMobEffects.TRANSMIT.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, true));
								}
							}
						}
					}
					{
						double _setval = refined_fruit_cd_time * 0.25;
						entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MB_ChorusFruitFoodsCooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
