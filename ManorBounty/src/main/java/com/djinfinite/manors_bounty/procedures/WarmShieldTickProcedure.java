package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class WarmShieldTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("flame_particle", (entity.getPersistentData().getDouble("flame_particle") + 1));
		if (entity.getPersistentData().getDouble("flame_particle") >= 2) {
			{
                if (!entity.level().isClientSide() && entity.getServer() != null) {
					entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
							entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), ("particle minecraft:soul_fire_flame ~ ~" + entity.getBbHeight() / 2 + " ~ 0.25 0.25 0.25 0 1"));
				}
			}
			entity.getPersistentData().putDouble("flame_particle", 0);
		}
	}
}
