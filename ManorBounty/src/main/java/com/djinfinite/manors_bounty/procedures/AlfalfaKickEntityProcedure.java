package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.InteractionHand;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.server.level.ServerLevel;

import com.djinfinite.manors_bounty.registries.ModItems;

import javax.annotation.Nullable;


public class AlfalfaKickEntityProcedure {

    public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        execute(event, event.getTarget(), event.getEntity());
    }

    public static void execute(Entity entity, Entity sourceentity) {
        execute(null, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.ALFALFA.get()) {
            if (entity instanceof Animal _animal && sourceentity instanceof Player _player) {
                int timesFed = _animal.getPersistentData().getInt("alfalfaUsed");
                if (_animal.isBaby()) {
                    if (timesFed < 3) {
                        LivingEntity _entity = (LivingEntity) sourceentity;
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                        _animal.setAge(_animal.getAge() + (int) ((-_animal.getAge() / 2.0)));
	                   	{
                            if (!entity.level().isClientSide() && entity.getServer() != null) {
			               	entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
						    entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), ("particle minecraft:happy_villager ~ ~" + entity.getBbHeight() + " ~ 0.25 0.25 0.25 0.5 20"));
			                }
		                }
                        _animal.getPersistentData().putInt("alfalfaUsed", timesFed + 1);
                        if (!(sourceentity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                            LivingEntity _livEnt = (LivingEntity) sourceentity;
                            _livEnt.getMainHandItem().shrink(1);
                        }
                    }
                } else {
                    LivingEntity _entity = (LivingEntity) sourceentity;
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                    _animal.setInLove(_player);
                    if (!(sourceentity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        LivingEntity _livEnt = (LivingEntity) sourceentity;
                        _livEnt.getMainHandItem().shrink(1);
                    }
                }
            }
        }
    }
}
