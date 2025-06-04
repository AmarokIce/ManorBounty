package com.djinfinite.manors_bounty.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class FruitsEffectConfig {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<Boolean> FOOD_EFFECT_ENABLED;

	public static final ForgeConfigSpec.ConfigValue<Integer> FOODS_ADD_TIME_B;
	public static final ForgeConfigSpec.ConfigValue<Integer> FOODS_NEW_TIME_B;
	public static final ForgeConfigSpec.ConfigValue<Integer> FOODS_NEW_TIME_C;
	public static final ForgeConfigSpec.ConfigValue<Integer> FOODS_VALUE_X;
	public static final ForgeConfigSpec.ConfigValue<Integer> FOODS_COOLDOWN_A;
	public static final ForgeConfigSpec.ConfigValue<Integer> FOODS_COOLDOWN_B;
	public static final ForgeConfigSpec.ConfigValue<Integer> FOODS_COOLDOWN_C;
	public static final ForgeConfigSpec.ConfigValue<Integer> FOODS_COOLDOWN_X;

	public static final ForgeConfigSpec.ConfigValue<Integer> BOX_TEA_MIN;
	public static final ForgeConfigSpec.ConfigValue<Integer> BOX_TEA_MAX;

	public static final ForgeConfigSpec.ConfigValue<Double> ROSA_HEDGE_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> RUTIN_LEMONENE_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Integer> RUTIN_LEMONENE_MAX_LEVEL;
	public static final ForgeConfigSpec.ConfigValue<Double> RUTIN_LEMONENE_LEVEL_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> BURSTING_BERRY_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> TOUGH_AS_NUT_ARMOR_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> TOUGH_AS_NUT_ARMOR_TOUGHNESS_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> CHERRY_BLOSSOMS_WEEPING_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> BERRY_BLOOD_HEAL_AMOUNT_1;
	public static final ForgeConfigSpec.ConfigValue<Double> BERRY_BLOOD_HEAL_AMOUNT_2;
	public static final ForgeConfigSpec.ConfigValue<Double> MOMENTARY_METEOR_CHANCE;
	public static final ForgeConfigSpec.ConfigValue<Integer> MOMENTARY_METEOR_MAX_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> MOMENTARY_METEOR_MINUEND_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> SUMMER_HEATWAVE_MOVEMENT_SPEED_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> SUMMER_HEATWAVE_SWIM_SPEED_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> ORIGINAL_EVOLUTION_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> ORIGINAL_EVOLUTION_METAMORPHOSIS_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> MELON_GRAVITY_KNOCKBACK_RESISTANCE_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> MELON_GRAVITY_STEP_HEIGHT_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> SEA_TOUCH_ENTITY_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> SEA_TOUCH_BLOCK_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> HACKED_THORNS_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> HACKED_THORNS_TIME;
	public static final ForgeConfigSpec.ConfigValue<Double> HACKED_THORNS_KNOCKBACK_CHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> KIWING_WHEREABOUTS_TIME;
	public static final ForgeConfigSpec.ConfigValue<Double> KIWING_WHEREABOUTS_LEVEL;
	public static final ForgeConfigSpec.ConfigValue<Double> KIWING_WHEREABOUTS_FALL_RESISTANCE_AMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> LURKING_DANGER_LURK_TIME;
	public static final ForgeConfigSpec.ConfigValue<Double> LURKING_DANGER_LURK_TIME_REDUCE;
	public static final ForgeConfigSpec.ConfigValue<Double> LURKING_DANGER_LURK_HIDDEN_REACH_RADIUS;
	public static final ForgeConfigSpec.ConfigValue<Double> LURKING_DANGER_LURK_SNEAKING_MOVEMENT_SPEED_BASE;
	public static final ForgeConfigSpec.ConfigValue<Double> LURKING_DANGER_LURK_SNEAKING_MOVEMENT_SPEED_ADD;
	public static final ForgeConfigSpec.ConfigValue<Double> LURKING_DANGER_LURK_STRENGTH_LEVEL;
	public static final ForgeConfigSpec.ConfigValue<Double> LURKING_DANGER_LURK_STRENGTH_TIME;
	public static final ForgeConfigSpec.ConfigValue<Double> LURKING_DANGER_LURK_ATTACKED_PENALTY_TIME;
	static {
		{
			BUILDER.push("food_effect");
			FOOD_EFFECT_ENABLED = BUILDER.comment("Whether the food effect should be enabled").define("enable", true);
			BUILDER.pop();
		}
		{
			BUILDER.push("effect_duration");
			{
				BUILDER.push("b");
				FOODS_ADD_TIME_B = BUILDER.comment("No comments").define("add", 360);
				FOODS_NEW_TIME_B = BUILDER.comment("No comments").define("new", 720);
				BUILDER.pop();
			}
			{
				BUILDER.push("c");
				FOODS_NEW_TIME_C = BUILDER.comment("No comments").define("new", 480);
				BUILDER.pop();
			}
			{
				BUILDER.push("x");
				FOODS_VALUE_X = BUILDER.comment("No comments").define("value", 480);
				BUILDER.pop();
			}
			BUILDER.pop();
		}
		{
			BUILDER.push("foods_cooldown");
			FOODS_COOLDOWN_A = BUILDER.comment("No comments").define("a", 720);
			FOODS_COOLDOWN_B = BUILDER.comment("No comments").define("b", 300);
			FOODS_COOLDOWN_C = BUILDER.comment("No comments").define("c", 480);
			FOODS_COOLDOWN_X = BUILDER.comment("No comments").define("x", 1080);
			BUILDER.pop();
		}
		{
			BUILDER.push("box_tea");
			BOX_TEA_MIN = BUILDER.comment("The least CD that box tea can be reduced").define("mix", 360);
			BOX_TEA_MAX = BUILDER.comment("The most CD that box tea can be reduced").define("max", 480);
			BUILDER.pop();
		}
		BUILDER.push("fruit_effect_amount_config");
		BUILDER.push("RosaHedge");
		ROSA_HEDGE_AMOUNT = BUILDER.comment("每级增加的减伤比例").define("reduce_scale", 0.5);
		BUILDER.pop();
		BUILDER.push("RutinLemonene");
		RUTIN_LEMONENE_AMOUNT = BUILDER.comment("经验加成倍率").define("effect_amplifier_scale", 0.1);
		RUTIN_LEMONENE_MAX_LEVEL = BUILDER.comment("计算时算入的最大玩家等级").define("max_level", 60);
		RUTIN_LEMONENE_LEVEL_AMOUNT = BUILDER.comment("玩家等级加成").define("player_level_scale", 0.0125);
		BUILDER.pop();
		BUILDER.push("BurstingBerry");
		BURSTING_BERRY_AMOUNT = BUILDER.comment("暴击的效果等级加成").define("effect_amplifier_scale", 0.15);
		BUILDER.pop();
		BUILDER.push("ToughAsNut");
		TOUGH_AS_NUT_ARMOR_AMOUNT = BUILDER.comment("WIP").define("armor", 0.03);
		TOUGH_AS_NUT_ARMOR_TOUGHNESS_AMOUNT = BUILDER.comment("WIP").define("armor_toughness", 0.5);
		BUILDER.pop();
		BUILDER.push("CherryBlossomsWeeping");
		CHERRY_BLOSSOMS_WEEPING_AMOUNT = BUILDER.comment("每级增加击退力度").define("weeping_amount", 0.1);
		BUILDER.pop();
		BUILDER.push("BerryBlood");
		BERRY_BLOOD_HEAL_AMOUNT_1 = BUILDER.comment("WIP").define("berry_blood_heal_amount_1", 0.2);
		BERRY_BLOOD_HEAL_AMOUNT_2 = BUILDER.comment("WIP").define("berry_blood_heal_amount_2", 0.02);
		BUILDER.pop();
		BUILDER.push("MomentaryMeteorConfig");
		MOMENTARY_METEOR_CHANCE = BUILDER.comment("每级增加的触发概率").define("chance", 0.01);
		MOMENTARY_METEOR_MAX_AMOUNT = BUILDER.comment("加成的最大伤害").define("max_damage", 100);
		MOMENTARY_METEOR_MINUEND_AMOUNT = BUILDER.comment("WIP").define("momentary_meteor_minuend_amount", (double) 25);
		BUILDER.pop();
		BUILDER.push("SummerHeatwave");
		SUMMER_HEATWAVE_MOVEMENT_SPEED_AMOUNT = BUILDER.comment("每级增加的移动速度加成").define("movement_speed_amount", 0.02);
		SUMMER_HEATWAVE_SWIM_SPEED_AMOUNT = BUILDER.comment("每级增加的游泳速度加成").define("swim_speed_amount", 0.04);
		BUILDER.pop();
		BUILDER.push("OriginalEvolutionConfig");
		ORIGINAL_EVOLUTION_AMOUNT = BUILDER.comment("每级增加的基础减伤倍率").define("base", 0.05);
		ORIGINAL_EVOLUTION_METAMORPHOSIS_AMOUNT = BUILDER.comment("每级增加的蜕变减伤倍率").define("metamorphosis", 0.08);
		BUILDER.pop();
		BUILDER.push("MelonGravityConfig");
		MELON_GRAVITY_KNOCKBACK_RESISTANCE_AMOUNT = BUILDER.comment("每级增加的击退抗性").define("melon_gravity_knockback_resistance_amount", 0.08);
		MELON_GRAVITY_STEP_HEIGHT_AMOUNT = BUILDER.comment("每级增加的行走高度").define("melon_gravity_step_height_amount", 0.15);
		BUILDER.pop();
		BUILDER.push("SeaTouchConfig");
		SEA_TOUCH_ENTITY_AMOUNT = BUILDER.comment("No comments").define("sea_touch_entity_amount", 0.1);
		SEA_TOUCH_BLOCK_AMOUNT = BUILDER.comment("No comments").define("sea_touch_block_amount", 0.1);
		BUILDER.pop();
		BUILDER.push("HackedThornsConfig");
		HACKED_THORNS_AMOUNT = BUILDER.comment("No comments").define("hacked_thorns_amount", 0.35);
		HACKED_THORNS_TIME = BUILDER.comment("No comments").define("hacked_thorns_time", (double) 16);
		HACKED_THORNS_KNOCKBACK_CHANCE = BUILDER.comment("No comments").define("hacked_thorns_knockback_chance", 0.08);
		BUILDER.push("KiwingWhereabouts");
		KIWING_WHEREABOUTS_TIME = BUILDER.comment("No comments").define("kiwing_whereabouts_time", (double) 2);
		KIWING_WHEREABOUTS_LEVEL = BUILDER.comment("No comments").define("kiwing_whereabouts_level", (double) 2);
		KIWING_WHEREABOUTS_FALL_RESISTANCE_AMOUNT = BUILDER.comment("No comments").define("kiwing_whereabouts_fall_resistance_amount", 0.04);
		BUILDER.pop();
		BUILDER.push("LurkingDanger");
		LURKING_DANGER_LURK_TIME = BUILDER.comment("No comments").define("lurking_danger_lurk_time", (double) 30);
		LURKING_DANGER_LURK_TIME_REDUCE = BUILDER.comment("No comments").define("lurking_danger_lurk_time_reduce", (double) 1);
		LURKING_DANGER_LURK_HIDDEN_REACH_RADIUS = BUILDER.comment("No comments").define("lurking_danger_lurk_hidden_reach_radius", (double) 4);
		LURKING_DANGER_LURK_SNEAKING_MOVEMENT_SPEED_BASE = BUILDER.comment("No comments").define("lurking_danger_lurk_sneaking_movement_speed_base", 0.8);
		LURKING_DANGER_LURK_SNEAKING_MOVEMENT_SPEED_ADD = BUILDER.comment("No comments").define("lurking_danger_lurk_sneaking_movement_speed_add", 0.06);
		LURKING_DANGER_LURK_STRENGTH_LEVEL = BUILDER.comment("No comments").define("lurking_danger_lurk_strength_level", (double) 4);
		LURKING_DANGER_LURK_STRENGTH_TIME = BUILDER.comment("No comments").define("lurking_danger_lurk_strength_time", (double) 20);
		LURKING_DANGER_LURK_ATTACKED_PENALTY_TIME = BUILDER.comment("No comments").define("lurking_danger_lurk_attacked_penalty_time", (double) -10);
		BUILDER.pop();
		BUILDER.pop();
		BUILDER.pop();

		SPEC = BUILDER.build();
	}/*	static {
  {
   BUILDER.push("food_effect");
   FOOD_EFFECT_ENABLED = BUILDER.comment("config.food_effect.enable").define("enable", true);
   BUILDER.pop();
  }
  {
   BUILDER.push("effect_duration");
   {
    BUILDER.push("b");
    FOODS_ADD_TIME_B = BUILDER.comment("config.effect_duration.b.add").define("add", 360);
    FOODS_NEW_TIME_B = BUILDER.comment("config.effect_duration.b.new").define("new", 720);
    BUILDER.pop();
   }
   {
    BUILDER.push("c");
    FOODS_NEW_TIME_C = BUILDER.comment("config.effect_duration.c.new").define("new", 480);
    BUILDER.pop();
   }
   {
    BUILDER.push("x");
    FOODS_VALUE_X = BUILDER.comment("config.effect_duration.x.value").define("value", 0.3);
    BUILDER.pop();
   }
   BUILDER.pop();
  }
  {
   BUILDER.push("foods_cooldown");
   FOODS_COOLDOWN_A = BUILDER.comment("config.foods_cooldown.a").define("a", 720);
   FOODS_COOLDOWN_B = BUILDER.comment("config.foods_cooldown.b").define("b", 300);
   FOODS_COOLDOWN_C = BUILDER.comment("config.foods_cooldown.c").define("c", 480);
   FOODS_COOLDOWN_X = BUILDER.comment("config.foods_cooldown.x").define("x", 1080);
   BUILDER.pop();
  }
  BUILDER.push("fruit_effect_amount_config");
  BUILDER.push("RosaHedge");
  ROSA_HEDGE_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.RosaHedge.reduce_scale").define("reduce_scale", 0.5);
  BUILDER.pop();
  BUILDER.push("RutinLemonene");
  RUTIN_LEMONENE_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.RutinLemonene.effect_amplifier_scale").define("effect_amplifier_scale", 0.1);
  RUTIN_LEMONENE_MAX_LEVEL = BUILDER.comment("config.fruit_effect_amount_config.RutinLemonene.max_level").define("max_level", 60);
  RUTIN_LEMONENE_LEVEL_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.RutinLemonene.player_level_scale").define("player_level_scale", 0.0125);
  BUILDER.pop();
  BUILDER.push("BurstingBerry");
  BURSTING_BERRY_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.BurstingBerry.effect_amplifier_scale").define("effect_amplifier_scale", 0.15);
  BUILDER.pop();
  BUILDER.push("ToughAsNut");
  TOUGH_AS_NUT_ARMOR_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.ToughAsNut.armor").define("armor", 0.03);
  TOUGH_AS_NUT_ARMOR_TOUGHNESS_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.ToughAsNut.armor_toughness").define("armor_toughness", 0.5);
  BUILDER.pop();
  BUILDER.push("CherryBlossomsWeeping");
  CHERRY_BLOSSOMS_WEEPING_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.CherryBlossomsWeeping.weeping_amount").define("weeping_amount", 0.1);
  BUILDER.pop();
  BUILDER.push("BerryBlood");
  BERRY_BLOOD_HEAL_AMOUNT_1 = BUILDER.comment("config.fruit_effect_amount_config.BerryBlood.berry_blood_heal_amount_1").define("berry_blood_heal_amount_1", 0.2);
  BERRY_BLOOD_HEAL_AMOUNT_2 = BUILDER.comment("config.fruit_effect_amount_config.BerryBlood.berry_blood_heal_amount_2").define("berry_blood_heal_amount_2", 0.02);
  BUILDER.pop();
  BUILDER.push("MomentaryMeteorConfig");
  MOMENTARY_METEOR_CHANCE = BUILDER.comment("config.fruit_effect_amount_config.MomentaryMeteorConfig.chance").define("chance", 0.01);
  MOMENTARY_METEOR_MAX_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.MomentaryMeteorConfig.max_damage").define("max_damage", 100);
  MOMENTARY_METEOR_MINUEND_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.MomentaryMeteorConfig.momentary_meteor_minuend_amount").define("momentary_meteor_minuend_amount", (double) 25);
  BUILDER.pop();
  BUILDER.push("SummerHeatwave");
  SUMMER_HEATWAVE_MOVEMENT_SPEED_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.SummerHeatwave.movement_speed_amount").define("movement_speed_amount", 0.02);
  SUMMER_HEATWAVE_SWIM_SPEED_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.SummerHeatwave.swim_speed_amount").define("swim_speed_amount", 0.04);
  BUILDER.pop();
  BUILDER.push("OriginalEvolutionConfig");
  ORIGINAL_EVOLUTION_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.OriginalEvolutionConfig.base").define("base", 0.05);
  ORIGINAL_EVOLUTION_METAMORPHOSIS_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.OriginalEvolutionConfig.metamorphosis").define("metamorphosis", 0.08);
  BUILDER.pop();
  BUILDER.push("MelonGravityConfig");
  MELON_GRAVITY_KNOCKBACK_RESISTANCE_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.MelonGravityConfig.melon_gravity_knockback_resistance_amount").define("melon_gravity_knockback_resistance_amount", 0.08);
  MELON_GRAVITY_STEP_HEIGHT_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.MelonGravityConfig.melon_gravity_step_height_amount").define("melon_gravity_step_height_amount", 0.15);
  BUILDER.pop();
  BUILDER.push("SeaTouchConfig");
  SEA_TOUCH_ENTITY_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.SeaTouchConfig.sea_touch_entity_amount").define("sea_touch_entity_amount", 0.1);
  SEA_TOUCH_BLOCK_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.SeaTouchConfig.sea_touch_block_amount").define("sea_touch_block_amount", 0.1);
  BUILDER.pop();
  BUILDER.push("HackedThornsConfig");
  HACKED_THORNS_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.HackedThornsConfig.hacked_thorns_amount").define("hacked_thorns_amount", 0.35);
  HACKED_THORNS_TIME = BUILDER.comment("config.fruit_effect_amount_config.HackedThornsConfig.hacked_thorns_time").define("hacked_thorns_time", (double) 16);
  HACKED_THORNS_KNOCKBACK_CHANCE = BUILDER.comment("config.fruit_effect_amount_config.HackedThornsConfig.hacked_thorns_knockback_chance").define("hacked_thorns_knockback_chance", 0.08);
  BUILDER.push("KiwingWhereabouts");
  KIWING_WHEREABOUTS_TIME = BUILDER.comment("config.fruit_effect_amount_config.KiwingWhereabouts.kiwing_whereabouts_time").define("kiwing_whereabouts_time", (double) 2);
  KIWING_WHEREABOUTS_LEVEL = BUILDER.comment("config.fruit_effect_amount_config.KiwingWhereabouts.kiwing_whereabouts_level").define("kiwing_whereabouts_level", (double) 2);
  KIWING_WHEREABOUTS_FALL_RESISTANCE_AMOUNT = BUILDER.comment("config.fruit_effect_amount_config.KiwingWhereabouts.kiwing_whereabouts_fall_resistance_amount").define("kiwing_whereabouts_fall_resistance_amount", 0.04);
  BUILDER.pop();
  BUILDER.push("LurkingDanger");
  LURKING_DANGER_LURK_TIME = BUILDER.comment("config.fruit_effect_amount_config.LurkingDanger.lurking_danger_lurk_time").define("lurking_danger_lurk_time", (double) 30);
  LURKING_DANGER_LURK_TIME_REDUCE = BUILDER.comment("config.fruit_effect_amount_config.LurkingDanger.lurking_danger_lurk_time_reduce").define("lurking_danger_lurk_time_reduce", (double) 1);
  LURKING_DANGER_LURK_HIDDEN_REACH_RADIUS = BUILDER.comment("config.fruit_effect_amount_config.LurkingDanger.lurking_danger_lurk_hidden_reach_radius").define("lurking_danger_lurk_hidden_reach_radius", (double) 4);
  LURKING_DANGER_LURK_SNEAKING_MOVEMENT_SPEED_BASE = BUILDER.comment("config.fruit_effect_amount_config.LurkingDanger.lurking_danger_lurk_sneaking_movement_speed_base").define("lurking_danger_lurk_sneaking_movement_speed_base", 0.8);
  LURKING_DANGER_LURK_SNEAKING_MOVEMENT_SPEED_ADD = BUILDER.comment("config.fruit_effect_amount_config.LurkingDanger.lurking_danger_lurk_sneaking_movement_speed_add").define("lurking_danger_lurk_sneaking_movement_speed_add", 0.06);
  LURKING_DANGER_LURK_STRENGTH_LEVEL = BUILDER.comment("config.fruit_effect_amount_config.LurkingDanger.lurking_danger_lurk_strength_level").define("lurking_danger_lurk_strength_level", (double) 4);
  LURKING_DANGER_LURK_STRENGTH_TIME = BUILDER.comment("config.fruit_effect_amount_config.LurkingDanger.lurking_danger_lurk_strength_time").define("lurking_danger_lurk_strength_time", (double) 20);
  LURKING_DANGER_LURK_ATTACKED_PENALTY_TIME = BUILDER.comment("config.fruit_effect_amount_config.LurkingDanger.lurking_danger_lurk_attacked_penalty_time").define("lurking_danger_lurk_attacked_penalty_time", (double) -10);
  BUILDER.pop();
  BUILDER.pop();
  BUILDER.pop();

  SPEC = BUILDER.build();
 }*/

}
