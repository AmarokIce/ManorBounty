package com.djinfinite.manors_bounty.utils;


import com.djinfinite.manors_bounty.items.FoodEffectType;
import com.djinfinite.manors_bounty.items.ICooldownItem;
import com.djinfinite.manors_bounty.items.IFoodItem;
import com.djinfinite.manors_bounty.world.capability.ModCapabilities;
import com.djinfinite.manors_bounty.world.capability.entity.ModAttribute;
import com.djinfinite.manors_bounty.world.capability.provider.ModCapabilitiesProvider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

public class CapabilityUtils {
    public static void tickCooldowns(Player player){
        ModAttribute modAttribute = ModCapabilities.getModAttribute(player);
        ArrayList<String> toDelete = new ArrayList<>();
        modAttribute.allKeys().forEach(key -> {
            int value = modAttribute.getCooldownValue(key);
            if (value > 0) {
                modAttribute.setCooldownValue(key,value-1);
            } else {
                toDelete.add(key);
            }
        });
        toDelete.forEach(modAttribute::removeCooldownValue);
        ModCapabilities.serverSyncAttribute(player);
    }
    public static void addModCooldown(Item item, Player player){
        ResourceLocation key = ForgeRegistries.ITEMS.getKey(item);
        ModAttribute modAttribute = ModCapabilities.getModAttribute(player);
        if(item instanceof IFoodItem iFoodItem && key != null){
            if(iFoodItem.getFoodEffectType() == FoodEffectType.A) {
                modAttribute.setCooldownValue(iFoodItem.getFoodType().name() + "_" + iFoodItem.getFoodEffectType().name(), iFoodItem.cooldownTime());
            }else{
                modAttribute.setCooldownValue(key.toString(), iFoodItem.cooldownTime());
            }
            return;
        }
        if(item instanceof ICooldownItem cooldownItem && key != null) {
            modAttribute.setCooldownValue(key.toString(), cooldownItem.cooldownTime());
        }
    }
    public static void setModCooldown(String key,Player player,int newValue){
        ModCapabilities.getModAttribute(player).setCooldownValue(key,newValue);
        ModCapabilities.serverSyncAttribute(player);
    }
    public static void addModCooldown(Item item,IFoodItem iFoodItem, Player player){
        ResourceLocation key = ForgeRegistries.ITEMS.getKey(item);
        ModAttribute modAttribute = ModCapabilities.getModAttribute(player);
        if(key != null){
            if(iFoodItem.getFoodEffectType() == FoodEffectType.A) {
                modAttribute.setCooldownValue(iFoodItem.getFoodType().name() + "_" + iFoodItem.getFoodEffectType().name(), iFoodItem.cooldownTime());
            }else{
                modAttribute.setCooldownValue(key.toString(), iFoodItem.cooldownTime());
            }
        }
    }
    public static boolean isInModCooldown(Item item, Player player){
        return getModCooldown(item, player) != 0;
    }
    public static boolean isInLocalModCooldown(Item item){
        return getLocalModCooldown(item) != 0;
    }
    public static int getModCooldown(Item item,Player player){
        ResourceLocation key = ForgeRegistries.ITEMS.getKey(item);
        if(key != null) {
            ModAttribute modAttribute = ModCapabilities.getModAttribute(player);
            if(item instanceof IFoodItem iFoodItem){
                if(iFoodItem.getFoodEffectType() == FoodEffectType.A) {
                    return modAttribute.getCooldownValue(iFoodItem.getFoodType().name() + "_" + iFoodItem.getFoodEffectType().name());
                }else{
                    return modAttribute.getCooldownValue(key.toString());
                }
            }
            return modAttribute.getCooldownValue(key.toString());
        }
        return 0;
    }
    public static int getModCooldown(String key,Player player){
        return ModCapabilities.getModAttribute(player).getCooldownValue(key);
    }
    public static int getModCooldown(IFoodItem iFoodItem,Item item,Player player){
        ResourceLocation key = ForgeRegistries.ITEMS.getKey(item);
        if(key != null) {
            ModAttribute modAttribute = ModCapabilities.getModAttribute(player);
            if(iFoodItem.getFoodEffectType() == FoodEffectType.A) {
                return modAttribute.getCooldownValue(iFoodItem.getFoodType().name() + "_" + iFoodItem.getFoodEffectType().name());
            }else{
                return modAttribute.getCooldownValue(key.toString());
            }
        }
        return 0;
    }
    public static List<String> getAllCooldownKeys(Player player){
        return ModCapabilities.getModAttribute(player).allKeys();
    }
    public static int getLocalModCooldown(Item item){
        ResourceLocation key = ForgeRegistries.ITEMS.getKey(item);
        if(key != null) {
            CompoundTag cdTag = ModCapabilitiesProvider.modCooldowns;
            if(item instanceof IFoodItem iFoodItem){
                if(iFoodItem.getFoodEffectType() == FoodEffectType.A) {
                    return cdTag.getInt(iFoodItem.getFoodType().name() + "_" + iFoodItem.getFoodEffectType().name());
                }else{
                    return cdTag.getInt(key.toString());
                }
            }
            return cdTag.getInt(key.toString());
        }
        return 0;
    }
    public static int getLocalModCooldown(Item item,IFoodItem iFoodItem){
        ResourceLocation key = ForgeRegistries.ITEMS.getKey(item);
        if(key != null) {
            CompoundTag cdTag = ModCapabilitiesProvider.modCooldowns;
            if(cdTag != null) {
                if (iFoodItem.getFoodEffectType() == FoodEffectType.A) {
                    return cdTag.getInt(iFoodItem.getFoodType().name() + "_" + iFoodItem.getFoodEffectType().name());
                } else {
                    return cdTag.getInt(key.toString());
                }
            }
        }
        return 0;
    }
    public static void emptyModCooldown(Player player){
        ModCapabilities.getModAttribute(player).clearCooldownValue();
        ModCapabilities.serverSyncAttribute(player);
    }
}
