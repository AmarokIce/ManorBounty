package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.block.DragonFruitSliceBlockBlock;
import com.djinfinite.manors_bounty.registries.ModBlocks;
import com.djinfinite.manors_bounty.utils.ModUtils;
import net.minecraft.sounds.SoundEvents;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;

public class DragonFruitSliceBlockRightClickProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		int type;
		if (!entity.isShiftKeyDown()) {
			type = Mth.nextInt(RandomSource.create(), 0, 5);
			BlockState sliced = ModBlocks.DRAGON_FRUIT_SLICE_BLOCK.get().defaultBlockState();
			sliced = sliced.setValue(DragonFruitSliceBlockBlock.BLOCKSTATE,type);
			world.setBlock(BlockPos.containing(x, y, z), sliced, 3);
			if (world instanceof Level level) {
				ModUtils.playSound(level,BlockPos.containing(x, y, z), SoundEvents.BAMBOO_PLACE, SoundSource.BLOCKS);
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}
}
