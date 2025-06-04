/*
 * Copyright (c) 2025 fho4565.
 *
 * Licensed under the LGPL v3 License.
 * (you may not receive this file in the LGPL v3 License)
 */

package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModItems;
import com.djinfinite.manors_bounty.registries.ModMobEffects;
import com.djinfinite.manors_bounty.utils.CapabilityUtils;
import com.djinfinite.manors_bounty.utils.data_struct.Quad;
import com.djinfinite.manors_bounty.utils.data_struct.Quintuple;
import com.djinfinite.manors_bounty.utils.data_struct.Sextuplet;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IFoodItem extends ICooldownItem {
    FoodEffectType getFoodEffectType();

    FoodType getFoodType();

    FoodEffect getFoodEffect();

    @Override
    default ItemStack usedWhenNotInCooldown(Level level, Player player, ItemStack itemStack) {
        if (getFoodEffect().apply(player)) {
            cooldown(player, itemStack.getItem());
        }
        return ICooldownItem.super.usedWhenNotInCooldown(level, player, itemStack);
    }

    @Override
    default int cooldownTime() {
        return getFoodEffectType().cooldownTime;
    }

    default ItemStack returnItem(Player player, ItemStack itemStack, ItemStack toReturn) {
        if (player == null || !player.getAbilities().instabuild) {
            if (itemStack.isEmpty()) {
                return toReturn;
            }

            if (player != null) {
                player.getInventory().add(toReturn);
            }
        }
        return itemStack;
    }

    default ItemStack returnCup(Player player, ItemStack itemStack) {
        return returnItem(player, itemStack, new ItemStack(ModItems.DEFORMED_GLASS_BOTTLE.get()));
    }

    default List<Component> tooltips(ItemStack itemStack) {
        ArrayList<Component> components = new ArrayList<>();
        Item item = itemStack.getItem();
        if (item instanceof IFoodItem iFoodItem) {
            return this.tooltips(iFoodItem, itemStack);
        }
        return components;
    }

    default List<Component> tooltips(IFoodItem iFoodItem, ItemStack itemStack) {
        ArrayList<Component> components = new ArrayList<>();
        Item item = itemStack.getItem();

        if (CapabilityUtils.isInLocalModCooldown(item)) {
            components.add(Component.translatable("tips.manors_bounty.fruit_effect_cooldown_0").withStyle(ChatFormatting.RED));
            components.add(Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_get", CapabilityUtils.getLocalModCooldown(item) / 20).withStyle(ChatFormatting.BLUE));
        }

        if (!Screen.hasShiftDown()) {
            components.add(Component.translatable("tips.manors_bounty.fruit_effect_shift_check").withStyle(ChatFormatting.BLUE));
            return components;
        }

        switch (iFoodItem.getFoodEffectType()) {
            case A -> {
                HashMap<Pair<Double, Integer>, ArrayList<Component>> lines = new HashMap<>();
                (((FoodEffect.A) iFoodItem.getFoodEffect()).mobEffects()).forEach(sextuplet -> {
                    MobEffect mobEffect = sextuplet.getLeft();
                    double chance = sextuplet.getMiddle();
                    int addLevel = sextuplet.getRight();
                    Pair<Double, Integer> key = Pair.of(chance, addLevel);
                    if (lines.containsKey(key)) {
                        lines.get(key).add(Component.translatable(mobEffect.getDescriptionId()));
                    } else {
                        lines.put(key, new ArrayList<>(List.of(Component.translatable(mobEffect.getDescriptionId()))));
                    }
                });
                ArrayList<Triple<Component, Double, Integer>> list = new ArrayList<>();
                lines.forEach((quintuple, componentArrayList) -> {
                    double chance = quintuple.getLeft();
                    int addLevel = quintuple.getRight();
                    MutableComponent mutableComponent = MutableComponent.create(new TranslatableContents("", "", new Object[0])).withStyle(ChatFormatting.BLUE);
                    for (int i = 0; i < componentArrayList.size(); i++) {
                        mutableComponent.append(componentArrayList.get(i));
                        if (i < componentArrayList.size() - 1) {
                            mutableComponent.append(Component.literal("/").withStyle(ChatFormatting.BLUE));
                        }
                    }
                    mutableComponent.withStyle(ChatFormatting.BLUE);
                    list.add(Triple.of(mutableComponent, chance, addLevel));
                });
                list.forEach(triple -> components.add(Component.translatable("tips.manors_bounty.fruit_effect_raw_give", triple.getLeft(), triple.getMiddle(), triple.getRight()).withStyle(ChatFormatting.BLUE)));
                components.add(Component.translatable("tips.manors_bounty.foods_effect_level_limit", "IV").withStyle(ChatFormatting.RED));
                components.add(Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_second", getFoodEffectType(), cooldownTime() / 20).withStyle(ChatFormatting.BLUE));
            }
            case B -> {
                HashMap<Quintuple<Double, Integer, Integer, Integer, Integer>, ArrayList<Component>> lines = new HashMap<>();
                (((FoodEffect.B) iFoodItem.getFoodEffect()).mobEffects()).forEach(sextuplet -> {
                    MobEffect mobEffect = sextuplet.getFirst();
                    double firstChance = sextuplet.getSecond();
                    int firstAddTime = sextuplet.getThird();
                    int addLevel = sextuplet.getFourth();
                    int secondAddTime = sextuplet.getFifth();
                    int newTime = sextuplet.getSixth();
                    Quintuple<Double, Integer, Integer, Integer, Integer> key = Quintuple.of(firstChance, firstAddTime, addLevel, secondAddTime, newTime);
                    if (lines.containsKey(key)) {
                        lines.get(key).add(Component.translatable(mobEffect.getDescriptionId()));
                    } else {
                        lines.put(key, new ArrayList<>(List.of(Component.translatable(mobEffect.getDescriptionId()))));
                    }
                });
                ArrayList<Sextuplet<Component, Double, Integer, Integer, Integer, Integer>> list = new ArrayList<>();
                lines.forEach((quintuple, componentArrayList) -> {
                    double firstChance = quintuple.getFirst();
                    int firstAddTime = quintuple.getSecond();
                    int addLevel = quintuple.getThird();
                    int secondAddTime = quintuple.getFourth();
                    int newTime = quintuple.getFifth();
                    MutableComponent mutableComponent = MutableComponent.create(new TranslatableContents("", "", new Object[0])).withStyle(ChatFormatting.BLUE);
                    for (int i = 0; i < componentArrayList.size(); i++) {
                        mutableComponent.append(componentArrayList.get(i));
                        if (i < componentArrayList.size() - 1) {
                            mutableComponent.append(Component.literal("/"));
                        }
                    }
                    mutableComponent.withStyle(ChatFormatting.BLUE);
                    list.add(Sextuplet.of(mutableComponent, firstChance, firstAddTime, addLevel, secondAddTime, newTime));
                });
                list.forEach(sextuplet -> {
                    double firstChance = sextuplet.getSecond();
                    int firstAddTime = sextuplet.getThird();
                    int addLevel = sextuplet.getFourth();
                    int secondAddTime = sextuplet.getFifth();
                    int newTime = sextuplet.getSixth();
                    components.add(Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_1", firstChance, sextuplet.getFirst(), firstAddTime / 20).withStyle(ChatFormatting.BLUE));
                    components.add(Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_2").withStyle(ChatFormatting.BLUE));
                    components.add(Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_3", 100 - firstChance, addLevel, sextuplet.getFirst()).withStyle(ChatFormatting.BLUE));
                    components.add(Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_4", secondAddTime / 20, newTime / 20).withStyle(ChatFormatting.BLUE));
                });
                components.add(Component.translatable("tips.manors_bounty.foods_effect_level_limit", "VI").withStyle(ChatFormatting.RED));
                components.add(Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_second", getFoodEffectType(), cooldownTime() / 20).withStyle(ChatFormatting.BLUE));
            }
            case C -> {
                HashMap<Quad<Double, Double, Integer, Integer>, ArrayList<Component>> lines = new HashMap<>();
                (((FoodEffect.C) iFoodItem.getFoodEffect()).mobEffects()).forEach(sextuplet -> {
                    MobEffect mobEffect = sextuplet.getFirst();
                    double firstChance = sextuplet.getSecond();
                    double secondChance = sextuplet.getThird();
                    int addLevel = sextuplet.getFourth();
                    int newTime = sextuplet.getFifth();
                    Quad<Double, Double, Integer, Integer> key = Quad.of(firstChance, secondChance, addLevel, newTime);
                    if (lines.containsKey(key)) {
                        lines.get(key).add(Component.translatable(mobEffect.getDescriptionId()));
                    } else {
                        lines.put(key, new ArrayList<>(List.of(Component.translatable(mobEffect.getDescriptionId()))));
                    }
                });
                ArrayList<Quintuple<Component, Double, Double, Integer, Integer>> list = new ArrayList<>();
                lines.forEach((quad, componentArrayList) -> {
                    double firstChance = quad.getValue1();
                    double secondChance = quad.getValue2();
                    int addLevel = quad.getValue3();
                    int newTime = quad.getValue4();
                    MutableComponent mutableComponent = MutableComponent.create(new TranslatableContents("", "", new Object[0]));
                    for (int i = 0; i < componentArrayList.size(); i++) {
                        mutableComponent.append(componentArrayList.get(i));
                        if (i < componentArrayList.size() - 1) {
                            mutableComponent.append(Component.literal("/").withStyle(ChatFormatting.BLUE));
                        }
                    }
                    mutableComponent.withStyle(ChatFormatting.BLUE);
                    list.add(Quintuple.of(mutableComponent, firstChance, secondChance, addLevel, newTime));
                });
                list.forEach(quintuple -> {
                    double firstChance = quintuple.getSecond();
                    double secondChance = quintuple.getThird();
                    int addLevel = quintuple.getFourth();
                    int newTime = quintuple.getFifth();
                    components.add(Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_1", String.valueOf(firstChance), addLevel, quintuple.getFirst()).withStyle(ChatFormatting.BLUE));
                    components.add(Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_2", secondChance, addLevel, quintuple.getFirst()).withStyle(ChatFormatting.BLUE));
                    components.add(Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_3", newTime / 20).withStyle(ChatFormatting.BLUE));
                });
                components.add(Component.translatable("tips.manors_bounty.foods_effect_level_limit", "VIII").withStyle(ChatFormatting.RED));
                components.add(Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_second", getFoodEffectType(), cooldownTime() / 20).withStyle(ChatFormatting.BLUE));
            }
            case XB -> {
                HashMap<Quintuple<Double, Integer, Integer, Integer, Integer>, ArrayList<Component>> lines = new HashMap<>();
                FoodEffect.X.XB x = (FoodEffect.X.XB) iFoodItem.getFoodEffect();
                x.b().mobEffects().forEach(sextuplet -> {
                    MobEffect mobEffect = sextuplet.getFirst();
                    double firstChance = sextuplet.getSecond();
                    int firstAddTime = sextuplet.getThird();
                    int addLevel = sextuplet.getFourth();
                    int secondAddTime = sextuplet.getFifth();
                    int newTime = sextuplet.getSixth();
                    Quintuple<Double, Integer, Integer, Integer, Integer> key = Quintuple.of(firstChance, firstAddTime, addLevel, secondAddTime, newTime);
                    if (lines.containsKey(key)) {
                        lines.get(key).add(Component.translatable(mobEffect.getDescriptionId()));
                    } else {
                        lines.put(key, new ArrayList<>(List.of(Component.translatable(mobEffect.getDescriptionId()))));
                    }
                });
                ArrayList<Sextuplet<Component, Double, Integer, Integer, Integer, Integer>> list = new ArrayList<>();
                lines.forEach((quintuple, componentArrayList) -> {
                    double firstChance = quintuple.getFirst();
                    int firstAddTime = quintuple.getSecond();
                    int addLevel = quintuple.getThird();
                    int secondAddTime = quintuple.getFourth();
                    int newTime = quintuple.getFifth();
                    MutableComponent mutableComponent = MutableComponent.create(new TranslatableContents("", "", new Object[0])).withStyle(ChatFormatting.BLUE);
                    for (int i = 0; i < componentArrayList.size(); i++) {
                        mutableComponent.append(componentArrayList.get(i));
                        if (i < componentArrayList.size() - 1) {
                            mutableComponent.append(Component.literal("/"));
                        }
                    }
                    mutableComponent.withStyle(ChatFormatting.BLUE);
                    list.add(Sextuplet.of(mutableComponent, firstChance, firstAddTime, addLevel, secondAddTime, newTime));
                });
                components.addAll(x.tooltip);
                list.forEach(sextuplet -> {
                    double firstChance = sextuplet.getSecond();
                    int firstAddTime = sextuplet.getThird();
                    int addLevel = sextuplet.getFourth();
                    int secondAddTime = sextuplet.getFifth();
                    int newTime = sextuplet.getSixth();
                    components.add(Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_1", firstChance, sextuplet.getFirst(), firstAddTime / 20).withStyle(ChatFormatting.BLUE));
                    components.add(Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_2").withStyle(ChatFormatting.BLUE));
                    components.add(Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_3", 100 - firstChance, addLevel, sextuplet.getFirst()).withStyle(ChatFormatting.BLUE));
                    components.add(Component.translatable("tips.manors_bounty.fruit_effect_b_type_give_line_4", secondAddTime / 20, newTime / 20).withStyle(ChatFormatting.BLUE));
                });
                components.add(Component.translatable("tips.manors_bounty.foods_effect_level_limit", "IV").withStyle(ChatFormatting.RED));
                components.add(Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_second", getFoodEffectType(), cooldownTime() / 20).withStyle(ChatFormatting.BLUE));
            }
            case XC -> {
                FoodEffect.X.XC x = (FoodEffect.X.XC) iFoodItem.getFoodEffect();
                HashMap<Quad<Double, Double, Integer, Integer>, ArrayList<Component>> lines = new HashMap<>();
                x.c().mobEffects().forEach(sextuplet -> {
                    MobEffect mobEffect = sextuplet.getFirst();
                    double firstChance = sextuplet.getSecond();
                    double secondChance = sextuplet.getThird();
                    int addLevel = sextuplet.getFourth();
                    int newTime = sextuplet.getFifth();
                    Quad<Double, Double, Integer, Integer> key = Quad.of(firstChance, secondChance, addLevel, newTime);
                    if (lines.containsKey(key)) {
                        lines.get(key).add(Component.translatable(mobEffect.getDescriptionId()));
                    } else {
                        lines.put(key, new ArrayList<>(List.of(Component.translatable(mobEffect.getDescriptionId()))));
                    }
                });
                ArrayList<Quintuple<Component, Double, Double, Integer, Integer>> list = new ArrayList<>();
                lines.forEach((quad, componentArrayList) -> {
                    double firstChance = quad.getValue1();
                    double secondChance = quad.getValue2();
                    int addLevel = quad.getValue3();
                    int newTime = quad.getValue4();
                    MutableComponent mutableComponent = MutableComponent.create(new TranslatableContents("", "", new Object[0]));
                    for (int i = 0; i < componentArrayList.size(); i++) {
                        mutableComponent.append(componentArrayList.get(i));
                        if (i < componentArrayList.size() - 1) {
                            mutableComponent.append(Component.literal("/").withStyle(ChatFormatting.BLUE));
                        }
                    }
                    mutableComponent.withStyle(ChatFormatting.BLUE);
                    list.add(Quintuple.of(mutableComponent, firstChance, secondChance, addLevel, newTime));
                });
                list.forEach(sextuplet -> {
                    double firstChance = sextuplet.getSecond();
                    double secondChance = sextuplet.getThird();
                    int addLevel = sextuplet.getFourth();
                    int newTime = sextuplet.getFifth();
                    components.add(Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_1", firstChance, addLevel, sextuplet.getFirst()).withStyle(ChatFormatting.BLUE));
                    components.add(Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_2", secondChance, addLevel, sextuplet.getFirst()).withStyle(ChatFormatting.BLUE));
                    components.add(Component.translatable("tips.manors_bounty.fruit_effect_c_type_give_line_3", newTime / 20).withStyle(ChatFormatting.BLUE));
                });
                components.add(Component.translatable("tips.manors_bounty.foods_effect_level_limit", "VIII").withStyle(ChatFormatting.RED));
                components.add(Component.translatable("tips.manors_bounty.fruit_effect_cooldown_time_second", getFoodEffectType(), cooldownTime() / 20).withStyle(ChatFormatting.BLUE));
            }
        }

        return components;
    }

    default void addAllFruitEffectsDurationPercent(LivingEntity livingEntity, float percent) {
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.EFFECT_HAUNTING.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.HYPOTHERMIA.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.TRANSMIT.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.WARM_SHIELD.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.LAVENDER_MOOD.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.ROSA_HEDGE.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.RUTIN_LEMONENE.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.BURSTING_BERRY.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.TOUGH_AS_NUT.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.BERRY_BLOOD.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.MOMENTARY_METEOR.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.SUMMER_HEATWAVE.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.ORIGINAL_EVOLUTION.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.ORIGINAL_EVOLUTION_METAMORPHOSIS.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.MELON_GRAVITY.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.SEA_TOUCH.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.HACKED_THORNS.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.KIWING_WHEREABOUTS.get(), percent);
        FoodEffect.modifyEffectDurationPercentIfApplyIn(livingEntity, ModMobEffects.LURKING_DANGER.get(), percent);
    }

    default boolean addAllFruitEffectsDuration(LivingEntity livingEntity, int timeToAdd) {
        return FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.EFFECT_HAUNTING.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.HYPOTHERMIA.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.TRANSMIT.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.WARM_SHIELD.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.LAVENDER_MOOD.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.ROSA_HEDGE.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.RUTIN_LEMONENE.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.BURSTING_BERRY.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.TOUGH_AS_NUT.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.BERRY_BLOOD.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.MOMENTARY_METEOR.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.SUMMER_HEATWAVE.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.ORIGINAL_EVOLUTION.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.ORIGINAL_EVOLUTION_METAMORPHOSIS.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.MELON_GRAVITY.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.SEA_TOUCH.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.HACKED_THORNS.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.KIWING_WHEREABOUTS.get(), timeToAdd) ||
                FoodEffect.modifyEffectDurationIfApplyIn(livingEntity, ModMobEffects.LURKING_DANGER.get(), timeToAdd);
    }

    static void removeAllFruitEffects(LivingEntity livingEntity) {
        livingEntity.removeEffect(ModMobEffects.EFFECT_HAUNTING.get());
        livingEntity.removeEffect(ModMobEffects.HYPOTHERMIA.get());
        livingEntity.removeEffect(ModMobEffects.TRANSMIT.get());
        livingEntity.removeEffect(ModMobEffects.WARM_SHIELD.get());
        livingEntity.removeEffect(ModMobEffects.LAVENDER_MOOD.get());
        livingEntity.removeEffect(ModMobEffects.ROSA_HEDGE.get());
        livingEntity.removeEffect(ModMobEffects.RUTIN_LEMONENE.get());
        livingEntity.removeEffect(ModMobEffects.BURSTING_BERRY.get());
        livingEntity.removeEffect(ModMobEffects.TOUGH_AS_NUT.get());
        livingEntity.removeEffect(ModMobEffects.CHERRY_BLOSSOMS_WEEPING.get());
        livingEntity.removeEffect(ModMobEffects.BERRY_BLOOD.get());
        livingEntity.removeEffect(ModMobEffects.MOMENTARY_METEOR.get());
        livingEntity.removeEffect(ModMobEffects.SUMMER_HEATWAVE.get());
        livingEntity.removeEffect(ModMobEffects.ORIGINAL_EVOLUTION.get());
        livingEntity.removeEffect(ModMobEffects.ORIGINAL_EVOLUTION_METAMORPHOSIS.get());
        livingEntity.removeEffect(ModMobEffects.MELON_GRAVITY.get());
        livingEntity.removeEffect(ModMobEffects.SEA_TOUCH.get());
        livingEntity.removeEffect(ModMobEffects.HACKED_THORNS.get());
        livingEntity.removeEffect(ModMobEffects.KIWING_WHEREABOUTS.get());
        livingEntity.removeEffect(ModMobEffects.LURKING_DANGER.get());
    }


}
