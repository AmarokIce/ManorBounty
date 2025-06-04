package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import com.djinfinite.manors_bounty.network.ManorsBountyModVariables;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

public class GlowBerriesFoodsEffectUsingProcedure {
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
            FruitsEffectConfig.FOODS_COOLDOWN_B.get();
            FruitsEffectConfig.FOODS_COOLDOWN_C.get();
            FruitsEffectConfig.FOODS_ADD_TIME_B.get();
            FruitsEffectConfig.FOODS_NEW_TIME_B.get();
            FruitsEffectConfig.FOODS_NEW_TIME_C.get();
            if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).MB_GlowBerriesCooldown <= 0) {
				if (itemstack.getItem() == Items.GLOW_BERRIES) {
                    do_effect_have = entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(ModMobEffects.BURSTING_BERRY.get());
                    org_effect_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier() : 0;
                    org_effect_time = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getDuration() : 0;
                    if (do_effect_have && org_effect_level <= 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(ModMobEffects.BURSTING_BERRY.get(), (int) org_effect_time, (int) (org_effect_level + 1), false, false));
						{
							double _setval = raw_fruit_cd_time;
							entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MB_GlowBerriesCooldown = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
		}
	}
}
