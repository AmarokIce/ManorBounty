package com.djinfinite.manors_bounty.block.display;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoItem;

import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import com.djinfinite.manors_bounty.block.renderer.ShirazCarpetDisplayItemRenderer;

import java.util.List;
import java.util.function.Consumer;

public class ShirazCarpetDisplayItem extends BlockItem implements GeoItem {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	public ShirazCarpetDisplayItem(Block block, Properties settings) {
		super(block, settings);
	}

	@Override
	public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
		super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
		if (Screen.hasShiftDown()) {
			pTooltip.add(Component.translatable("tips.manors_bounty.big_carpet_line_1"));
			pTooltip.add(Component.translatable("tips.manors_bounty.big_carpet_line_2"));
			pTooltip.add(Component.translatable("tips.manors_bounty.big_carpet_line_3"));
			pTooltip.add(Component.translatable("tips.manors_bounty.big_carpet_line_4"));
			pTooltip.add(Component.translatable("tips.manors_bounty.big_carpet_line_5"));
		} else {
			pTooltip.add(Component.literal((Component.translatable("tips.manors_bounty.fruit_effect_shift_check").getString())));
		}
	}

	@Override
	public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
		super.initializeClient(consumer);
		consumer.accept(new IClientItemExtensions() {
			private final BlockEntityWithoutLevelRenderer renderer = new ShirazCarpetDisplayItemRenderer();

			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				return renderer;
			}
		});
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController(this, "controller", 0, handler->PlayState.CONTINUE));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
