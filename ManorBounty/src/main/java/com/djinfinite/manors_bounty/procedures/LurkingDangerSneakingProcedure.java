package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import com.djinfinite.manors_bounty.network.ManorsBountyModVariables;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

import java.util.UUID;
import java.util.List;
import java.util.Comparator;

public class LurkingDangerSneakingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double time;
		if (entity.isShiftKeyDown()) {
			time = FruitsEffectConfig.LURKING_DANGER_LURK_TIME.get()
					- (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.LURKING_DANGER.get()) ? _livEnt.getEffect(ModMobEffects.LURKING_DANGER.get()).getAmplifier() : 0)
							* FruitsEffectConfig.LURKING_DANGER_LURK_TIME_REDUCE.get();
			if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).LurkingDangerSneakingTick >= time) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 2, 0, false, false));
				if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
						.hasModifier((new AttributeModifier(UUID.fromString("50e887ba-84fb-438f-a3fc-fc27ed3a7607"), "lurking_danger_speed",
								(FruitsEffectConfig.LURKING_DANGER_LURK_SNEAKING_MOVEMENT_SPEED_BASE.get()
										+ ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.LURKING_DANGER.get()) ? _livEnt.getEffect(ModMobEffects.LURKING_DANGER.get()).getAmplifier() : 0) + 1)
												* FruitsEffectConfig.LURKING_DANGER_LURK_SNEAKING_MOVEMENT_SPEED_ADD.get()),
								AttributeModifier.Operation.MULTIPLY_TOTAL)))))
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
							.addTransientModifier((new AttributeModifier(UUID.fromString("50e887ba-84fb-438f-a3fc-fc27ed3a7607"), "lurking_danger_speed",
									(FruitsEffectConfig.LURKING_DANGER_LURK_SNEAKING_MOVEMENT_SPEED_BASE.get()
											+ ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.LURKING_DANGER.get()) ? _livEnt.getEffect(ModMobEffects.LURKING_DANGER.get()).getAmplifier() : 0) + 1)
													* FruitsEffectConfig.LURKING_DANGER_LURK_SNEAKING_MOVEMENT_SPEED_ADD.get()),
									AttributeModifier.Operation.MULTIPLY_TOTAL)));
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClasAttributeModifiers(Entity.class, new AABB(_center, _center).inflate((FruitsEffectConfig.LURKING_DANGER_LURK_HIDDEN_REACH_RADIUS.get() * 2) / 2d), e -> true).stream()
							.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if ((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entity) {
							if (entityiterator instanceof Mob _entity) {
								_entity.setTarget(null);
							}
						}
					}
				}
			} else {
				{
					double _setval = (entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).LurkingDangerSneakingTick + 1;
					entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.LurkingDangerSneakingTick = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else {
			if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getModifier(UUID.fromString("50e887ba-84fb-438f-a3fc-fc27ed3a7607")) != null) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, (int) (double) FruitsEffectConfig.LURKING_DANGER_LURK_STRENGTH_TIME.get(),
							(int) (double) FruitsEffectConfig.LURKING_DANGER_LURK_STRENGTH_LEVEL.get(), false, true));
				{
					double _setval = 0;
					entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.LurkingDangerSneakingTick = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).LurkingDangerSneakingTick >= 0) {
					{
						double _setval = 0;
						entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LurkingDangerSneakingTick = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).removeModifier(UUID.fromString("50e887ba-84fb-438f-a3fc-fc27ed3a7607"));
		}
	}
}
