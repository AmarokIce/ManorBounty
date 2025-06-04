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

public class AppleFoodsEffectUsingProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean do_effect_have;
		double raw_fruit_cd_time;
		double rough_fruit_cd_time;
		double refined_fruit_cd_time;
		double org_effect_level;
		double org_effect_time;
		double b_type_add_time;
		double b_type_new_time;
		double c_type_new_time;
		if (DoFruitEffectEnableCheckProcedure.execute()) {
            raw_fruit_cd_time = FruitsEffectConfig.FOODS_COOLDOWN_A.get() * 20;
            rough_fruit_cd_time = FruitsEffectConfig.FOODS_COOLDOWN_B.get() * 20;
            refined_fruit_cd_time = FruitsEffectConfig.FOODS_COOLDOWN_C.get() * 20;
            b_type_add_time = FruitsEffectConfig.FOODS_ADD_TIME_B.get() * 20;
            b_type_new_time = FruitsEffectConfig.FOODS_NEW_TIME_B.get() * 20;
            c_type_new_time = FruitsEffectConfig.FOODS_NEW_TIME_C.get() * 20;
            do_effect_have = entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(ModMobEffects.ROSA_HEDGE.get());
            org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ROSA_HEDGE.get()) ? _livEnt.getEffect(ModMobEffects.ROSA_HEDGE.get()).getAmplifier() : 0;
            org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ROSA_HEDGE.get()) ? _livEnt.getEffect(ModMobEffects.ROSA_HEDGE.get()).getDuration() : 0;
            if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_AppleCooldown <= 0) {
				if (itemstack.getItem() == Items.APPLE) {
					if (do_effect_have && org_effect_level <= 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
						{
                            entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MB_AppleCooldown = raw_fruit_cd_time;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
				if (itemstack.getItem() == ModItems.APPLE_SLICE.get()) {
					if (Math.random() < 0.33 && do_effect_have && org_effect_level <= 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
						{
							double _setval = Math.floor(raw_fruit_cd_time * 0.33);
							entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MB_AppleCooldown = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
			if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_AppleFoodsCooldown <= 0) {
				if (itemstack.getItem() == ModItems.APPLE_JUICE.get()) {
					if (Math.random() < 0.7) {
						if (do_effect_have) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) (org_effect_time + b_type_add_time), (int) org_effect_level, false, false));
							{
                                entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_AppleFoodsCooldown = rough_fruit_cd_time;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else {
						if (org_effect_level <= 4) {
							if (do_effect_have) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) (org_effect_time + b_type_add_time), (int) (org_effect_level + 1), false, false));
							} else {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) b_type_new_time, 0, false, false));
							}
							{
                                entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_AppleFoodsCooldown = rough_fruit_cd_time;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
				if (itemstack.getItem() == Items.GOLDEN_APPLE) {
					if (org_effect_level <= 6) {
						if (Math.random() < 0.9) {
							if (do_effect_have) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
								if (Math.random() < 0.15) {
                                    if (entity instanceof LivingEntity _livEnt23) {
                                        _livEnt23.hasEffect(ModMobEffects.ROSA_HEDGE.get());
                                    }
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ROSA_HEDGE.get()) ? _livEnt.getEffect(ModMobEffects.ROSA_HEDGE.get()).getAmplifier() : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ROSA_HEDGE.get()) ? _livEnt.getEffect(ModMobEffects.ROSA_HEDGE.get()).getDuration() : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
								}
							} else {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) c_type_new_time, 0, false, false));
								if (Math.random() < 0.15) {
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
								}
							}
							{
                                entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_AppleFoodsCooldown = refined_fruit_cd_time;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
				if (itemstack.getItem() == Items.ENCHANTED_GOLDEN_APPLE) {
					if (org_effect_level <= 6) {
						if (Math.random() < 0.9) {
							if (entity instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(ModMobEffects.ROSA_HEDGE.get())) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
								if (Math.random() < 0.15) {
                                    if (entity instanceof LivingEntity _livEnt33) {
                                        _livEnt33.hasEffect(ModMobEffects.ROSA_HEDGE.get());
                                    }
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ROSA_HEDGE.get()) ? _livEnt.getEffect(ModMobEffects.ROSA_HEDGE.get()).getAmplifier() : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ROSA_HEDGE.get()) ? _livEnt.getEffect(ModMobEffects.ROSA_HEDGE.get()).getDuration() : 0;
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
								}
							} else {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) c_type_new_time, 0, false, false));
								if (Math.random() < 0.15) {
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
                                    if (entity instanceof LivingEntity _livEnt39) {
                                        _livEnt39.hasEffect(ModMobEffects.ROSA_HEDGE.get());
                                    }
                                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ROSA_HEDGE.get()) ? _livEnt.getEffect(ModMobEffects.ROSA_HEDGE.get()).getAmplifier() : 0;
                                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ROSA_HEDGE.get()) ? _livEnt.getEffect(ModMobEffects.ROSA_HEDGE.get()).getDuration() : 0;
                                    if (org_effect_level <= 6) {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(ModMobEffects.ROSA_HEDGE.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
									}
								}
							}
							{
                                entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_AppleFoodsCooldown = refined_fruit_cd_time;
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
