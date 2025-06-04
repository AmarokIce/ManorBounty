/*
 * Copyright (c) 2025 fho4565.
 *
 * Licensed under the LGPL v3 License.
 * (you may not receive this file in the LGPL v3 License)
 */

package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;

public enum FoodEffectType {
    A("A", FruitsEffectConfig.FOODS_COOLDOWN_A.get() * 20),
    B("B",FruitsEffectConfig.FOODS_COOLDOWN_B.get() * 20),
    C("C",FruitsEffectConfig.FOODS_COOLDOWN_C.get() * 20),
    XB("XB",FruitsEffectConfig.FOODS_COOLDOWN_X.get() * 20),
    XC("XC",FruitsEffectConfig.FOODS_COOLDOWN_X.get() * 20),
    CUSTOM("custom",0);
    final String name;
    final int cooldownTime;
    FoodEffectType(String name,int cooldownTime){
        this.name = name;
        this.cooldownTime = cooldownTime;
    }
}
