package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.entity.Entity;

import com.djinfinite.manors_bounty.network.ManorsBountyModVariables;

public class TransmitStartProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables())).transmit_time <= 1) {
			{
				double _setval = entity.getX();
				entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ccc_eat_x = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = entity.getY();
				entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ccc_eat_y = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = entity.getZ();
				entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ccc_eat_z = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
