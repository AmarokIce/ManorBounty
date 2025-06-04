package com.djinfinite.manors_bounty.utils;

import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

public class ModUtils {
    public static boolean chanceToTrigger(double chance) {
        return Math.random() < chance;
    }

    public static boolean fruitEffectEnabled() {
        return FruitsEffectConfig.FOOD_EFFECT_ENABLED.get();
    }

    public static void dropItem(ServerLevel level, BlockPos blockPos, ItemStack itemStack) {
        level.addFreshEntity(new ItemEntity(level,blockPos.getX(),blockPos.getY(),blockPos.getZ(),itemStack));
    }

    public static void playSound(Level level, BlockPos blockPos, SoundEvent soundEvent,SoundSource soundSource){
       if (!level.isClientSide()) {
           level.playSound(null, blockPos, soundEvent, soundSource, 1, 1);
       } else {
           level.playLocalSound(blockPos, soundEvent, soundSource, 1, 1, false);
       }
    }

    public static CompoundTag getBlockEntityData(Level level,BlockPos blockPos){
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if(blockEntity == null){
            return new CompoundTag();
        }
        return blockEntity.getPersistentData();
    }
}
