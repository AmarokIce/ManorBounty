package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class CornCrop2RandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double chance = 0;
		if (Math.random() < 0.05) {
			if ((new Object() {
				public boolean replaceable(LevelAccessor _world, BlockState _blockState) {
					Level _level = _world instanceof Level ? (Level) _world : null;
					BlockHitResult _pos = new BlockHitResult(Vec3.ZERO, Direction.DOWN, BlockPos.ZERO, false);
					boolean _flag = _blockState.canBeReplaced();
					boolean _flag2 = _level != null && _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.MAIN_HAND, ItemStack.EMPTY, _pos));
					boolean _flag3 = _level != null && _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.OFF_HAND, ItemStack.EMPTY, _pos));
					return _flag || _flag2 || _flag3;
				}
			}).replaceable(world, (world.getBlockState(BlockPos.containing(x, y + 1, z)))) && !((world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == ModBlocks.CORN_CROP_1.get())) {
				{
					int _value = 2;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				world.setBlock(BlockPos.containing(x, y + 1, z), ModBlocks.CORN_CROP_2.get().defaultBlockState(), 3);
			}
		}
	}
}
