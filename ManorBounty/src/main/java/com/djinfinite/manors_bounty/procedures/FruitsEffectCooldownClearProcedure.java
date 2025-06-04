package com.djinfinite.manors_bounty.procedures;

import net.minecraft.world.entity.Entity;
import com.djinfinite.manors_bounty.network.ManorsBountyModVariables;

public class FruitsEffectCooldownClearProcedure {

    public enum FruitEffect {
        APPLE("MB_AppleCooldown", "MB_AppleFoodsCooldown"),
        PEACH("MB_PeachCooldown", "MB_PeachFoodsCooldown"),
        PEAR("MB_PearCooldown", "MB_PearFoodsCooldown"),
        CHERRIES("MB_CherriesCooldown", "MB_CherriesFoodsCooldown"),
        ORANGE("MB_OrangeCooldown", "MB_OrangeFoodsCooldown"),
        LEMON("MB_LemonCooldown", "MB_LemonFoodsCooldown"),
        STRAWBERRY("MB_StrawberryCooldown", "MB_StrawberryFoodsCooldown"),
        BLUEBERRY("MB_BlueberryCooldown", "MB_BlueberryFoodsCooldown"),
        CRANBERRY("MB_CranberryCooldown", "MB_CranberryFoodsCooldown"),
        ACORN("MB_AcornCooldown", "MB_AcornFoodsCooldown"),
        FILBERT("MB_FilbertCooldown", "MB_FilbertFoodsCooldown"),
        CHERRY_BLOSSOMS("MB_CherryBlossomsCooldown", "MB_CherryBlossomsFoodsCooldown"),
        STARFRUIT("MB_StarfruitCooldown", "MB_StarfruitFoodsCooldown"),
        SWEET_BERRIES("MB_SweetBerriesCooldown", "MB_SweetBerriesFoodsCooldown"),
        GLOW_BERRIES("MB_GlowBerriesCooldown", "MB_GlowBerriesFoodsCooldown"),
        MANGO("MB_MangoCooldown", "MB_MangoFoodsCooldown"),
        DURIAN("MB_DurianCooldown", "MB_DurianFoodsCooldown"),
        PINEAPPLE("MB_PineappleCooldown", "MB_PineappleFoodsCooldown"),
        WATERMELON("MB_WatermelonCooldown", "MB_WatermelonFoodsCooldown"),
        HAMIMELON("MB_HamimelonCooldown", "MB_HamimelonFoodsCooldown"),
        DRAGON_FRUIT("MB_DragonFruitCooldown", "MB_DragonFruitFoodsCooldown"),
        OLIVE_FRUIT("MB_OliveFruitCooldown", "MB_OliveFruitFoodsCooldown"),
        CHORUS_FRUIT("MB_ChorusFruitCooldown", "MB_ChorusFruitFoodsCooldown");

        private final String basicCooldownField;
        private final String foodCooldownField;

        FruitEffect(String basicCooldownField, String foodCooldownField) {
            this.basicCooldownField = basicCooldownField;
            this.foodCooldownField = foodCooldownField;
        }

        public String getBasicCooldownField() {
            return basicCooldownField;
        }

        public String getFoodCooldownField() {
            return foodCooldownField;
        }
    }

    public static void execute(Entity entity) {
        if (entity == null) return;

        ManorsBountyModVariables.PlayerVariables playerVariables = entity.getCapability(ManorsBountyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElseThrow(() -> new IllegalStateException("Player does not have the required capability!"));

        for (FruitEffect effect : FruitEffect.values()) {
            updateCooldown(playerVariables, effect.getBasicCooldownField(), entity);
            updateCooldown(playerVariables, effect.getFoodCooldownField(), entity);
        }
    }

    private static void updateCooldown(ManorsBountyModVariables.PlayerVariables playerVariables, String cooldownField, Entity entity) {
        try {
            java.lang.reflect.Field field = ManorsBountyModVariables.PlayerVariables.class.getDeclaredField(cooldownField);
            field.setAccessible(true);
            field.set(playerVariables, 0.0);
            playerVariables.syncPlayerVariables(entity);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}