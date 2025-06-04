package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import com.djinfinite.manors_bounty.registries.ModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EffectAdvancementGetProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ModMobEffects.BURSTING_BERRY.get())) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("manors_bounty:berry_bomb"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(ModMobEffects.ROSA_HEDGE.get())) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("manors_bounty:rose_with_thorns"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(ModMobEffects.RUTIN_LEMONENE.get())) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("manors_bounty:genetic_research"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("manors_bounty:deadly_tenderness"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(ModMobEffects.MOMENTARY_METEOR.get())) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("manors_bounty:overlapping_tactics"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get())) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("manors_bounty:summer_special_offer"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get())) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("manors_bounty:natural_resistance"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(ModMobEffects.MELON_GRAVITY.get())) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("manors_bounty:walk_steadily"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(ModMobEffects.SEA_TOUCH.get())) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("manors_bounty:touching_abyss"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(ModMobEffects.HACKED_THORNS.get())) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("manors_bounty:knee_jerk_reflex"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(ModMobEffects.TRANSMIT.get())) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("manors_bounty:void_cycle"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (!(entity instanceof ServerPlayer _plr22 && _plr22.level() instanceof ServerLevel
				&& _plr22.getAdvancements().getOrStartProgress(_plr22.server.getAdvancements().getAdvancement(new ResourceLocation("manors_bounty:a_insane_cocktail"))).isDone())) {
			if (entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(ModMobEffects.BURSTING_BERRY.get()) && entity instanceof LivingEntity _livEnt24 && _livEnt24.hasEffect(ModMobEffects.ROSA_HEDGE.get())
					&& entity instanceof LivingEntity _livEnt25 && _livEnt25.hasEffect(ModMobEffects.RUTIN_LEMONENE.get()) && entity instanceof LivingEntity _livEnt26
					&& _livEnt26.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()) && entity instanceof LivingEntity _livEnt27 && _livEnt27.hasEffect(ModMobEffects.MOMENTARY_METEOR.get())
					&& entity instanceof LivingEntity _livEnt28 && _livEnt28.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get()) && entity instanceof LivingEntity _livEnt29
					&& _livEnt29.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get()) && entity instanceof LivingEntity _livEnt30 && _livEnt30.hasEffect(ModMobEffects.MELON_GRAVITY.get())
					&& entity instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(ModMobEffects.SEA_TOUCH.get()) && entity instanceof LivingEntity _livEnt32 && _livEnt32.hasEffect(ModMobEffects.HACKED_THORNS.get())
					&& entity instanceof LivingEntity _livEnt33 && _livEnt33.hasEffect(ModMobEffects.TRANSMIT.get())) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("manors_bounty:a_insane_cocktail"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (!(entity instanceof ServerPlayer _plr35 && _plr35.level() instanceof ServerLevel
				&& _plr35.getAdvancements().getOrStartProgress(_plr35.server.getAdvancements().getAdvancement(new ResourceLocation("manors_bounty:you_need_a_cup_of_lemon_tea"))).isDone())) {
			if (entity instanceof LivingEntity _livEnt36 && _livEnt36.hasEffect(ModMobEffects.BURSTING_BERRY.get()) || entity instanceof LivingEntity _livEnt37 && _livEnt37.hasEffect(ModMobEffects.ROSA_HEDGE.get())
					|| entity instanceof LivingEntity _livEnt38 && _livEnt38.hasEffect(ModMobEffects.RUTIN_LEMONENE.get())
					|| entity instanceof LivingEntity _livEnt39 && _livEnt39.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get())
					|| entity instanceof LivingEntity _livEnt40 && _livEnt40.hasEffect(ModMobEffects.MOMENTARY_METEOR.get())
					|| entity instanceof LivingEntity _livEnt41 && _livEnt41.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get())
					|| entity instanceof LivingEntity _livEnt42 && _livEnt42.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get())
					|| entity instanceof LivingEntity _livEnt43 && _livEnt43.hasEffect(ModMobEffects.MELON_GRAVITY.get()) || entity instanceof LivingEntity _livEnt44 && _livEnt44.hasEffect(ModMobEffects.SEA_TOUCH.get())
					|| entity instanceof LivingEntity _livEnt45 && _livEnt45.hasEffect(ModMobEffects.HACKED_THORNS.get()) || entity instanceof LivingEntity _livEnt46 && _livEnt46.hasEffect(ModMobEffects.TRANSMIT.get())) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("manors_bounty:you_need_a_cup_of_lemon_tea"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (!(entity instanceof ServerPlayer _plr48 && _plr48.level() instanceof ServerLevel
				&& _plr48.getAdvancements().getOrStartProgress(_plr48.server.getAdvancements().getAdvancement(new ResourceLocation("manors_bounty:fructose_exceeds_the_standard"))).isDone())) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.BURSTING_BERRY.get()) ? _livEnt.getEffect(ModMobEffects.BURSTING_BERRY.get()).getAmplifier() : 0) >= 7
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ROSA_HEDGE.get()) ? _livEnt.getEffect(ModMobEffects.ROSA_HEDGE.get()).getAmplifier() : 0) >= 7
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.RUTIN_LEMONENE.get()) ? _livEnt.getEffect(ModMobEffects.RUTIN_LEMONENE.get()).getAmplifier() : 0) >= 7
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()) ? _livEnt.getEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get()).getAmplifier() : 0) >= 7
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MOMENTARY_METEOR.get()) ? _livEnt.getEffect(ModMobEffects.MOMENTARY_METEOR.get()).getAmplifier() : 0) >= 7
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SUMMER_HEATWAVE.get()) ? _livEnt.getEffect(ModMobEffects.SUMMER_HEATWAVE.get()).getAmplifier() : 0) >= 7
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.ORIGINAL_EVOLUTION.get()) ? _livEnt.getEffect(ModMobEffects.ORIGINAL_EVOLUTION.get()).getAmplifier() : 0) >= 7
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.MELON_GRAVITY.get()) ? _livEnt.getEffect(ModMobEffects.MELON_GRAVITY.get()).getAmplifier() : 0) >= 7
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.SEA_TOUCH.get()) ? _livEnt.getEffect(ModMobEffects.SEA_TOUCH.get()).getAmplifier() : 0) >= 7
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.HACKED_THORNS.get()) ? _livEnt.getEffect(ModMobEffects.HACKED_THORNS.get()).getAmplifier() : 0) >= 7
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ModMobEffects.TRANSMIT.get()) ? _livEnt.getEffect(ModMobEffects.TRANSMIT.get()).getAmplifier() : 0) >= 7) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("manors_bounty:fructose_exceeds_the_standard"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
	}
}
