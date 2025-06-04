package com.djinfinite.manors_bounty.mixin;

import com.djinfinite.manors_bounty.items.*;
import com.djinfinite.manors_bounty.utils.CapabilityUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.ItemDecoratorHandler;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.awt.*;
//TODO 用forge注册的方式代替mixin
@Mixin(GuiGraphics.class)
public abstract class GuiGraphicsMixin {
    @Shadow
    @Final
    private PoseStack pose;
    @Shadow
    @Final
    private Minecraft minecraft;

    @Shadow
    public abstract int drawString(Font pFont, @Nullable String pText, int pX, int pY, int pColor, boolean pDropShadow);

    @Shadow
    public abstract void fill(RenderType pRenderType, int pMinX, int pMinY, int pMaxX, int pMaxY, int pColor);

    /**
     * @author fho4565
     * @reason 模组特殊冷却的显示
     */
    @Overwrite
    public void renderItemDecorations(Font pFont, ItemStack itemStack, int pX, int pY, @Nullable String pText) {
        if (!itemStack.isEmpty()) {
            Item item = itemStack.getItem();
            Player player = minecraft.player;
            this.pose.pushPose();
            if (itemStack.getCount() != 1 || pText != null) {
                String s = pText == null ? String.valueOf(itemStack.getCount()) : pText;
                this.pose.translate(0.0F, 0.0F, 200.0F);
                this.drawString(pFont, s, pX + 19 - 2 - pFont.width(s), pY + 6 + 3, 16777215, true);
            }

            if (itemStack.isBarVisible()) {
                int l = itemStack.getBarWidth();
                int i = itemStack.getBarColor();
                int j = pX + 2;
                int k = pY + 13;
                this.fill(RenderType.guiOverlay(), j, k, j + 13, k + 2, -16777216);
                this.fill(RenderType.guiOverlay(), j, k, j + l, k + 1, i | -16777216);
            }

            LocalPlayer localplayer = this.minecraft.player;
            float f = localplayer == null ? 0.0F : localplayer.getCooldowns().getCooldownPercent(itemStack.getItem(), this.minecraft.getFrameTime());
            if (f > 0.0F) {
                int i1 = pY + Mth.floor(16.0F * (1.0F - f));
                int j1 = i1 + Mth.ceil(16.0F * f);
                this.fill(RenderType.guiOverlay(), pX, i1, pX + 16, j1, Integer.MAX_VALUE);
            }
            if(player != null) {
                IFoodItem foodItem = null;
                if(itemStack.is(Items.APPLE)){
                    foodItem = new Apple.Self();
                }else if(itemStack.is(Items.SWEET_BERRIES)){
                    foodItem = new SweetBerries.Self();
                }else if(itemStack.is(Items.GLOW_BERRIES)){
                    foodItem = new GlowBerries.Self();
                }else if(itemStack.is(Items.CHORUS_FRUIT)){
                    foodItem = new ChorusFruit.Self();
                }else if(itemStack.is(Items.ENCHANTED_GOLDEN_APPLE)){
                    foodItem = new Apple.Enchanted();
                }else if(itemStack.is(Items.GOLDEN_APPLE)){
                    foodItem = new Apple.Golden();
                }else if(itemStack.is(Items.MELON_SLICE)){
                    foodItem = new WaterMelon.Self();
                }
                if(item instanceof IFoodItem iFoodItem){
                    foodItem = iFoodItem;
                }
                if(foodItem != null){
                    int color = switch (foodItem.getFoodEffectType()){
                        case A -> new Color(140, 192, 244, 100).getRGB();
                        case B -> new Color(163, 109, 228, 100).getRGB();
                        case C -> new Color(255, 203, 52, 100).getRGB();
                        default -> new Color(216, 240, 99, 100).getRGB();
                    };
                    int cdValue = CapabilityUtils.getLocalModCooldown(item,foodItem);
                    float modCooldownValue = localplayer == null ? 0.0F : (float) cdValue / foodItem.cooldownTime();
                    if (modCooldownValue > 0.0F) {
                        int i1 = pY + Mth.floor(16.0F * (1.0F - modCooldownValue));
                        int j1 = i1 + Mth.ceil(16.0F * modCooldownValue);

                        this.fill(RenderType.guiOverlay(), pX, i1, pX + 16, j1, color);
                    }
                } else if (item instanceof ICooldownItem cooldownItem) {
                    int cdValue = CapabilityUtils.getLocalModCooldown(item);
                    float modCooldownValue = localplayer == null ? 0.0F : (float) cdValue / cooldownItem.cooldownTime();
                    if (modCooldownValue > 0.0F) {
                        int i1 = pY + Mth.floor(16.0F * (1.0F - modCooldownValue));
                        int j1 = i1 + Mth.ceil(16.0F * modCooldownValue);

                        this.fill(RenderType.guiOverlay(), pX, i1, pX + 16, j1, new Color(200, 200, 200, 100).getRGB());
                    }
                }
            }
            this.pose.popPose();
            ItemDecoratorHandler.of(itemStack).render((GuiGraphics) (Object) this, pFont, itemStack, pX, pY);
        }
    }
}
