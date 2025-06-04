package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.djinfinite.manors_bounty.network.ManorsBountyModVariables;
import com.djinfinite.manors_bounty.registries.ModMobEffects;

public class TransmitTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double level;
		{
			double _setval = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TRANSMIT.get()) ? _livEnt.getEffect(ModMobEffects.TRANSMIT.get()).getDuration() : 0;
			entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.transmit_time = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TRANSMIT.get()) ? _livEnt.getEffect(ModMobEffects.TRANSMIT.get()).getAmplifier() : 0) > 0
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TRANSMIT.get()) ? _livEnt.getEffect(ModMobEffects.TRANSMIT.get()).getDuration() : 0) <= 2) {
			level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TRANSMIT.get()) ? _livEnt.getEffect(ModMobEffects.TRANSMIT.get()).getAmplifier() : 0;
			{
				double _setval = 200;
				entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.transmit_time = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(ModMobEffects.TRANSMIT.get());
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ModMobEffects.TRANSMIT.get(), 200, (int) (level - 1), false, true));
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TRANSMIT.get()) ? _livEnt.getEffect(ModMobEffects.TRANSMIT.get()).getAmplifier() : 0) > 0
				|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TRANSMIT.get()) ? _livEnt.getEffect(ModMobEffects.TRANSMIT.get()).getDuration() : 0) > 36) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands()
						.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
								new Vec3(((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).ccc_eat_x),
										((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).ccc_eat_y),
										((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).ccc_eat_z)),
								Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("particle minecraft:portal ~ ~" + entity.getBbHeight() / 2 + " ~ 0 0 0 10 5"));
		}
	}
}
