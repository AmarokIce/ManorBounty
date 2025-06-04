package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class JalapenoCropBonemealUseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (blockstate.getBlock() == ModBlocks.JALAPENO_CROP_TOP.get()) {
			if (world instanceof Level _level) {
				BlockPos _bp = BlockPos.containing(x, y - 1, z);
				if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
					if (!_level.isClientSide())
						_level.levelEvent(2005, _bp, 0);
				}
			}
		} else {
			if ((new Object() {
				public boolean replaceable(LevelAccessor _world, BlockState _blockState) {
					Level _level = _world instanceof Level ? (Level) _world : null;
					BlockHitResult _pos = new BlockHitResult(Vec3.ZERO, Direction.DOWN, BlockPos.ZERO, false);
					boolean _flag = _blockState.canBeReplaced();
					boolean _flag2 = _level != null && _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.MAIN_HAND, ItemStack.EMPTY, _pos));
					boolean _flag3 = _level != null && _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.OFF_HAND, ItemStack.EMPTY, _pos));
					return _flag || _flag2 || _flag3;
				}
			}).replaceable(world, (world.getBlockState(BlockPos.containing(x, y + 1, z)))) || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ModBlocks.JALAPENO_CROP_TOP.get()) {
				if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip8 ? blockstate.getValue(_getip8) : -1) == 1) {
					{
						int _value = 2;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					world.setBlock(BlockPos.containing(x, y + 1, z), ModBlocks.JALAPENO_CROP_TOP.get().defaultBlockState(), 3);
				} else {
					{
						int _value = (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip12 ? blockstate.getValue(_getip12) : -1) + 1;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
				}
			}
		}
	}
}
