package com.djinfinite.manors_bounty.items;

import com.djinfinite.manors_bounty.configuration.FruitsEffectConfig;
import com.djinfinite.manors_bounty.utils.CapabilityUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BoxedLemonTea extends Item {
    public BoxedLemonTea() {
        super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.1f).alwaysEat().build()));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        if (level.isClientSide()) {
            return itemStack;
        } else {
            if (livingEntity instanceof Player player) {
                CapabilityUtils.getAllCooldownKeys(player).forEach(s -> CapabilityUtils.getAllCooldownKeys(player)
                        .forEach(key -> {
                                    int oldValue = CapabilityUtils.getModCooldown(key, player);
                                    int min = FruitsEffectConfig.BOX_TEA_MIN.get();
                                    int max = FruitsEffectConfig.BOX_TEA_MAX.get();
                                    int toReduce = ThreadLocalRandom.current().nextInt(min, max + 1);
                                    System.out.println(oldValue + " : " + toReduce);
                                    CapabilityUtils.setModCooldown(key, player, Math.max(0, oldValue - toReduce*20));
                                }
                        )
                );
            }
        }
        return super.finishUsingItem(itemStack, level, livingEntity);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltips, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, tooltips, pIsAdvanced);
        if (Screen.hasShiftDown()) {
            tooltips.add(Component.translatable("tips.manors_bounty.boxed_lemon_tea_line_1",FruitsEffectConfig.BOX_TEA_MIN.get(),FruitsEffectConfig.BOX_TEA_MAX.get()).withStyle(ChatFormatting.BLUE));
        } else {
            tooltips.add(Component.translatable("tips.manors_bounty.fruit_effect_shift_check").withStyle(ChatFormatting.BLUE));
        }
    }
}
