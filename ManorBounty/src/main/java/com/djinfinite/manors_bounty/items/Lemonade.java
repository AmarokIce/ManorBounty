package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.registries.ModItems;
import com.djinfinite.manors_bounty.utils.CapabilityUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Lemonade extends Item {
    public Lemonade() {
        super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.1f).alwaysEat().build()));
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tips.manors_bounty.fruit_effect_clear").withStyle(ChatFormatting.BLUE));
        } else {
            pTooltipComponents.add(Component.translatable("tips.manors_bounty.fruit_effect_shift_check").withStyle(ChatFormatting.BLUE));
        }
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemStack, Level level, @NotNull LivingEntity livingEntity) {
        if(level.isClientSide()){
            return itemStack;
        }
        if(livingEntity instanceof Player player) {
            CapabilityUtils.emptyModCooldown(player);
            IFoodItem.removeAllFruitEffects(player);
            return returnItem(player, itemStack, ModItems.DEFORMED_GLASS_BOTTLE.get().getDefaultInstance());
        }else{
            return ItemStack.EMPTY;
        }
    }
    ItemStack returnItem(Player player, ItemStack itemStack,ItemStack toReturn) {
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
}
