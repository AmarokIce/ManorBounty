package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.entity.Entity;

import com.djinfinite.manors_bounty.network.ManorsBountyModVariables;

public class BurstingBerryEndProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 1;
			entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.AdditionalDamageMultiplier = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
