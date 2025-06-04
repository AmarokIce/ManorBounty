package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import com.djinfinite.manors_bounty.network.ManorsBountyModVariables;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

public class OliveFruitFoodsEffectUsingProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean do_effect_have = false;
		double raw_fruit_cd_time = 0;
		double rough_fruit_cd_time;
		double refined_fruit_cd_time = 0;
		double org_effect_level = 0;
		double org_effect_time = 0;
		double b_type_add_time = 0;
		double c_type_new_time = 0;
		double b_type_new_time = 0;
		if (DoFruitEffectEnableCheckProcedure.execute()) {
            raw_fruit_cd_time = FruitsEffectConfig.FOODS_COOLDOWN_A.get() * 20;
            FruitsEffectConfig.FOODS_COOLDOWN_B.get();
            FruitsEffectConfig.FOODS_COOLDOWN_C.get();
            b_type_add_time = FruitsEffectConfig.FOODS_ADD_TIME_B.get() * 20;
            b_type_new_time = FruitsEffectConfig.FOODS_NEW_TIME_B.get() * 20;
            FruitsEffectConfig.FOODS_NEW_TIME_C.get();
            rough_fruit_cd_time = FruitsEffectConfig.FOODS_COOLDOWN_X.get() * 20;
            FruitsEffectConfig.FOODS_COOLDOWN_X.get();
            if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_OliveFruitCooldown <= 0) {
				if (itemstack.getItem() == ModItems.OLIVE_FRUIT.get()) {
                    do_effect_have = entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(ModMobEffects.SEA_TOUCH.get());
                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SEA_TOUCH.get()) ? _livEnt.getEffect(ModMobEffects.SEA_TOUCH.get()).getAmplifier() : 0;
                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SEA_TOUCH.get()) ? _livEnt.getEffect(ModMobEffects.SEA_TOUCH.get()).getDuration() : 0;
                    if (do_effect_have && org_effect_level <= 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(ModMobEffects.SEA_TOUCH.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
						{
							double _setval = raw_fruit_cd_time;
							entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MB_OliveFruitCooldown = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
			if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_OliveFruitFoodsCooldown <= 0) {
				if (itemstack.getItem() == ModItems.MARTINI.get()) {
					if (Math.random() < 0.7) {
                        do_effect_have = entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(ModMobEffects.SEA_TOUCH.get());
                        org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SEA_TOUCH.get()) ? _livEnt.getEffect(ModMobEffects.SEA_TOUCH.get()).getAmplifier() : 0;
                        org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SEA_TOUCH.get()) ? _livEnt.getEffect(ModMobEffects.SEA_TOUCH.get()).getDuration() : 0;
                        if (do_effect_have) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(ModMobEffects.SEA_TOUCH.get(), (int) (org_effect_time + b_type_add_time), (int) org_effect_level, false, false));
							FruitEffectTimeAddProcedure.execute(entity, 1 + FruitsEffectConfig.FOODS_VALUE_X.get());
							{
                                entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_OliveFruitFoodsCooldown = rough_fruit_cd_time;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else {
                        do_effect_have = entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(ModMobEffects.SEA_TOUCH.get());
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
							FruitEffectTimeAddProcedure.execute(entity, 1 + FruitsEffectConfig.FOODS_VALUE_X.get());
							{
                                entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.MB_OliveFruitFoodsCooldown = rough_fruit_cd_time;
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
