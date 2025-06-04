package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import com.djinfinite.manors_bounty.network.ManorsBountyModVariables;
import com.djinfinite.manors_bounty.registries.ModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HypothermiaHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity, Entity sourceentity) {
		execute(null, world, damagesource, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity, Entity sourceentity) {
		if (damagesource == null || entity == null || sourceentity == null)
			return;
		double hyp;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ModMobEffects.HYPOTHERMIA.get())) {
			if (damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("minecraft:is_fire")))) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(ModMobEffects.HYPOTHERMIA.get());
			}
			if (damagesource.is(DamageTypes.FREEZE)) {
				if (sourceentity instanceof LivingEntity) {
					if (entity instanceof Player livEnt) {
						hyp = 2 + (livEnt.hasEffect(ModMobEffects.HYPOTHERMIA.get()) ? livEnt.getEffect(ModMobEffects.HYPOTHERMIA.get()).getAmplifier() : 0) + 2
								+ Math.floor(entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ManorsBountyModVariables.PlayerVariables()).niflheim_freezing * 0.00034) * 2;
					} else {
						hyp = 2 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.HYPOTHERMIA.get()) ? _livEnt.getEffect(ModMobEffects.HYPOTHERMIA.get()).getAmplifier() : 0) + 2;
					}
					if (hyp > 12) {
						hyp = 12;
					}
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("manors_bounty:frostbite")))), (float) hyp);
				} else {
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					} else if (event != null && event.hasResult()) {
						event.setResult(Event.Result.DENY);
					}
				}
			}
		}
	}
}
