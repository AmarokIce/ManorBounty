/*
 * Copyright (c) 2025 fho4565.
 *
 * Licensed under the LGPL v3 License.
 * (you may not receive this file in the LGPL v3 License)
 */

package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.utils.CapabilityUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
/**
 * 模组的物品冷却时间实现
 * */
public interface ICooldownItem {
    /**
     * 获取物品的冷却时间
     *
     * @return 冷却时间，以tick为单位
     */
    int cooldownTime();

    default void cooldown(Player player, Item item){
        CapabilityUtils.addModCooldown(item, player);
    }

    default void cooldown(Player player, Item item, IFoodItem iFoodItem){
        CapabilityUtils.addModCooldown(item,iFoodItem, player);
    }

    /**
     * 当物品处于冷却状态被使用时调用此方法
     *
     * @param level 玩家所在的维度
     * @param player 使用物品的玩家
     * @param itemStack 被使用的物品堆栈
     * @return itemStack数量-1的新物品堆栈，finishUsingItem会使用此方法返回值
     */
    default ItemStack usedWhenInCooldown(Level level, Player player, ItemStack itemStack){
        if (!player.getAbilities().instabuild) {
            itemStack.shrink(1);
        }
        return itemStack;
    }

    /**
     * 当物品不处于冷却状态被使用时调用此方法
     *
     * @param level 玩家所在的维度
     * @param player 使用物品的玩家
     * @param itemStack 被使用的物品堆栈
     * @return itemStack数量-1的新物品堆栈，finishUsingItem会使用此方法返回值，而不使用eat方法
     */
    default ItemStack usedWhenNotInCooldown(Level level, Player player, ItemStack itemStack){
        return itemStack;
    }
}
