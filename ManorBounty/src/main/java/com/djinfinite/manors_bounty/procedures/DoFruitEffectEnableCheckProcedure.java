package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

public class DoFruitEffectEnableCheckProcedure {
	public static boolean execute() {
		return FruitsEffectConfig.FOOD_EFFECT_ENABLED.get();
	}
}
