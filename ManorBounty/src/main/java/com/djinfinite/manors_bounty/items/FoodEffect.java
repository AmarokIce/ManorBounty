/*
 * Copyright (c) 2025 fho4565.
 *
 * Licensed under the LGPL v3 License.
 * (you may not receive this file in the LGPL v3 License)
 */

package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;
import com.djinfinite.manors_bounty.utils.ModUtils;
import com.djinfinite.manors_bounty.utils.data_struct.Quintuple;
import com.djinfinite.manors_bounty.utils.data_struct.Sextuplet;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public abstract class FoodEffect {
    private FoodEffect() {
    }

    public abstract boolean apply(LivingEntity livingEntity);

    public static void modifyEffectAmplifierIfApplyIn(LivingEntity entity, MobEffect effect, int levelToAdd, int limit) {
        MobEffectInstance effectIn = entity.getEffect(effect);
        if (Objects.isNull(effectIn)) {
            return;
        }

        var duration = effectIn.getDuration();

        int lvl = Math.min(effectIn.getAmplifier() + levelToAdd, limit);
        entity.addEffect(new MobEffectInstance(effect, duration, lvl));
    }

    public static void modifyEffectDurationPercentIfApplyIn(LivingEntity entity, MobEffect effect, float percent) {
        MobEffectInstance effectIn = entity.getEffect(effect);
        if (Objects.isNull(effectIn)) {
            return;
        }

        var duration = effectIn.getDuration();
        var amplifier = effectIn.getAmplifier();

        entity.addEffect(new MobEffectInstance(effect, Math.round(duration * (1 + percent)), amplifier));
    }

    public static boolean modifyEffectDurationIfApplyIn(LivingEntity entity, MobEffect effect, int ticksToAdd) {
        MobEffectInstance effectIn = entity.getEffect(effect);
        if (Objects.isNull(effectIn)) {
            return false;
        }

        var duration = effectIn.getDuration();
        var amplifier = effectIn.getAmplifier();

        entity.addEffect(new MobEffectInstance(effect, duration + ticksToAdd, amplifier));
        return true;
    }

    public static final class A extends FoodEffect {
        private final Table<MobEffect, Double, Integer> mobEffects = HashBasedTable.create();

        private A() {
        }

        public static A of() {
            return new A();
        }

        public A addEffect(MobEffect effect) {
            return addEffect(effect, 1.0, 1);
        }

        public A addEffect(MobEffect effect, double chance) {
            return addEffect(effect, chance, 1);
        }

        public A addEffect(MobEffect effect, double chance, int level) {
            mobEffects.put(effect, chance, level);
            return this;
        }

        @Override
        public boolean apply(LivingEntity livingEntity) {
            if(!ModUtils.fruitEffectEnabled()){
                return false;
            }

            this.mobEffects.cellSet().forEach(it -> {
                MobEffect effect = it.getRowKey();
                MobEffectInstance entityEffect = livingEntity.getEffect(effect);
                if (Objects.isNull(entityEffect) || !ModUtils.chanceToTrigger(it.getColumnKey())) {
                    return;
                }

                modifyEffectAmplifierIfApplyIn(livingEntity, effect, it.getValue(),3);
            });

            return true;
        }

        public Table<MobEffect, Double, Integer> mobEffects() {
            return mobEffects;
        }
    }

    public static final class B extends FoodEffect {
        private final ArrayList<Sextuplet<MobEffect,Double,Integer,Integer,Integer,Integer>> mobEffects = new ArrayList<>();
        int firstAddTime = FruitsEffectConfig.FOODS_ADD_TIME_B.get() * 20;
        int secondAddTime = FruitsEffectConfig.FOODS_ADD_TIME_B.get() * 20;
        int newTime = FruitsEffectConfig.FOODS_NEW_TIME_B.get() * 20;

        private B(){}

        public static B of(){
            return new B();
        }

        public B addEffect(MobEffect effect,double firstChance){
            mobEffects.add(Sextuplet.of(effect,firstChance, firstAddTime,1,secondAddTime,newTime));
            return this;
        }

        public B addEffect(MobEffect effect,double firstChance,int firstAddTime,int addLevel,int secondAddTime,int newTime){
            mobEffects.add(Sextuplet.of(effect,firstChance,firstAddTime,addLevel,secondAddTime,newTime));
            return this;
        }


        @Override
        public boolean apply(LivingEntity livingEntity) {
            if(!ModUtils.fruitEffectEnabled()){
                return false;
            }
            boolean shouldCooldown = false;
            double max = this.mobEffects.stream().mapToDouble(Sextuplet::getSecond).max().orElse(70);
            if (ModUtils.chanceToTrigger(max)) {
                for (Sextuplet<MobEffect,Double,Integer,Integer,Integer,Integer> sextuplet : this.mobEffects) {
                    MobEffect effect = sextuplet.getFirst();
                    if (modifyEffectDurationIfApplyIn(livingEntity, effect, sextuplet.getThird())) {
                        shouldCooldown = true;
                    }
                }

            } else {
                for (Sextuplet<MobEffect,Double,Integer,Integer,Integer,Integer> sextuplet : this.mobEffects) {
                    MobEffect effect = sextuplet.getFirst();
                    MobEffectInstance entityEffect = livingEntity.getEffect(effect);
                    if (entityEffect != null) {
                        modifyEffectAmplifierIfApplyIn(livingEntity, effect, sextuplet.getFourth(),5);
                        modifyEffectDurationIfApplyIn(livingEntity, effect, sextuplet.getFifth());
                    } else {
                        livingEntity.addEffect(new MobEffectInstance(effect, sextuplet.getSixth(), 0));
                    }
                }

                shouldCooldown = true;
            }

            return shouldCooldown;
        }

        public List<Sextuplet<MobEffect,Double,Integer,Integer,Integer,Integer> > mobEffects() {
            return mobEffects;
        }

    }

    public static final class C extends FoodEffect {
        private final List<Quintuple<MobEffect, Double, Double, Integer,Integer>> mobEffects= new ArrayList<>();
        Integer newTime = FruitsEffectConfig.FOODS_NEW_TIME_C.get() * 20;
        private C() {}
        public static C of() {
            return new C();
        }
        public C addEffect(MobEffect effect) {
            return addEffect(effect,90.0,15.0,1, newTime);
        }
        public C addEffect(MobEffect effect, double firstChance, double secondChance, int addLevel, int newTime) {
            mobEffects.add(Quintuple.of(effect, firstChance, secondChance, addLevel,newTime));
            return this;
        }

        @Override
        public boolean apply(LivingEntity livingEntity) {
            if(!ModUtils.fruitEffectEnabled()){
                return false;
            }
            double first = this.mobEffects.stream().mapToDouble(Quintuple::getSecond).max().orElse(90);
            double second = this.mobEffects.stream().mapToDouble(Quintuple::getThird).max().orElse(10);
            if (ModUtils.chanceToTrigger(first)) {
                for (Quintuple<MobEffect, Double, Double, Integer,Integer> quintuple : this.mobEffects) {
                    MobEffect effect = quintuple.getFirst();
                    int addLevel = quintuple.getFourth();
                    int newTime = quintuple.getFifth();
                    MobEffectInstance entityEffect = livingEntity.getEffect(effect);
                    if (entityEffect != null) {
                        modifyEffectAmplifierIfApplyIn(livingEntity, effect, addLevel,7);
                    } else {
                        livingEntity.addEffect(new MobEffectInstance(effect, newTime, 0));
                    }
                }
                if (ModUtils.chanceToTrigger(second)) {
                    for (Quintuple<MobEffect, Double, Double, Integer,Integer> quintuple : this.mobEffects) {
                        MobEffect effect = quintuple.getFirst();
                        int addLevel = quintuple.getFourth();
                        int newTime = quintuple.getFifth();
                        MobEffectInstance entityEffect = livingEntity.getEffect(effect);
                        if (entityEffect != null) {
                            modifyEffectAmplifierIfApplyIn(livingEntity, effect, addLevel,7);
                        } else {
                            livingEntity.addEffect(new MobEffectInstance(effect, newTime, 0));
                        }
                    }
                }
            }
            return true;
        }

        public List<Quintuple<MobEffect, Double, Double, Integer,Integer>> mobEffects() {
            return mobEffects;
        }
    }

    public abstract static class X extends FoodEffect {
        protected final ArrayList<Function<LivingEntity, Boolean>> consumers = new ArrayList<>();
        protected final ArrayList<Component> tooltip = new ArrayList<>();

        public List<Function<LivingEntity, Boolean>> consumers() {
            return consumers;
        }
        public void addTooltip(Component component){
            tooltip.add(component);
        }
        public ArrayList<Component> tooltip(){
            return tooltip;
        }

        public static class XB extends X {
            private final B b;
            private XB(B b){
                this.b = b;
            }
            public static XB of(B b){
                return new XB(b);
            }
            public XB addConsumer(Function<LivingEntity, Boolean> function){
                this.consumers.add(function);
                return this;
            }
            @Override
            public boolean apply(LivingEntity livingEntity) {
                if(!ModUtils.fruitEffectEnabled()){
                    return false;
                }
                boolean shouldCooldownB,shouldCooldownF = false;
                shouldCooldownB = b.apply(livingEntity);
                for (Function<LivingEntity, Boolean> function : consumers) {
                    shouldCooldownF = function.apply(livingEntity);
                }
                return shouldCooldownB || shouldCooldownF;
            }
            public B b(){
                return b;
            }
        }
        public static class XC extends X {
            private final C c;
            private XC(C c){
                this.c = c;
            }
            public static XC of(C c){
                return new XC(c);
            }
            public XC addConsumer(Function<LivingEntity, Boolean> function){
                this.consumers.add(function);
                return this;
            }
            @Override
            public boolean apply(LivingEntity livingEntity) {
                if(!ModUtils.fruitEffectEnabled()){
                    return false;
                }
                boolean shouldCooldownC,shouldCooldownF = false;
                shouldCooldownC = c.apply(livingEntity);
                for (Function<LivingEntity, Boolean> function : consumers) {
                    shouldCooldownF = function.apply(livingEntity);
                }
                return shouldCooldownC || shouldCooldownF;
            }
            public C c(){
                return c;
            }
        }
    }
}
