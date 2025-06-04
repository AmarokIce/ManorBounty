
package com.djinfinite.manors_bounty.item;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import com.djinfinite.manors_bounty.utils.ModUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public class AlfalfaSeedItem extends Item {
	public AlfalfaSeedItem() {
		super(new Item.Properties());
	}

	@Override
	public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
		super.useOn(context);
		Direction direction = context.getClickedFace();
		Level level = context.getLevel();
		Player entity = context.getPlayer();
		ItemStack itemstack = context.getItemInHand();
		BlockPos blockPos = context.getClickedPos();
		if (entity == null) {
			return InteractionResult.PASS;
		}
		if ((level.getBlockState(blockPos.above())).getBlock() == Blocks.AIR && (level.getBlockState(blockPos)).getBlock() == ModBlocks.RICH_BLACK_DIRT_FARMLAND.get() && direction == Direction.UP) {
			level.setBlock(blockPos.above(), ModBlocks.ALFALFA_CROP.get().defaultBlockState(), 3);
			ModUtils.playSound(level,blockPos.above(), SoundEvents.CROP_PLANTED,SoundSource.BLOCKS);
			if (!(entity.getAbilities().instabuild)) {
				itemstack.shrink(1);
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}
}
