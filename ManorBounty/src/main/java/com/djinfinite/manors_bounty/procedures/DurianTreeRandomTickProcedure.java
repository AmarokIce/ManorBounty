package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.configuration.CommonConfig;

public class DurianTreeRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double chance;
		ItemStack item_stick = ItemStack.EMPTY;
		ItemStack drop_item = ItemStack.EMPTY;
		if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) == 0) {
			chance = Mth.nextInt(RandomSource.create(), 1, 100);
			if (chance <= 30) {
				{
					int _value = 3;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			} else {
				{
					int _value = 1;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			}
		}
		if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip6 ? blockstate.getValue(_getip6) : -1) != 2) {
			boolean isConnectedToLog = false;
			for (int dx = -4; dx <= 4; dx++) {
				for (int dy = -4; dy <= 4; dy++) {
					for (int dz = -4; dz <= 4; dz++) {
						if (world.getBlockState(BlockPos.containing(x + dx, y + dy, z + dz)).is(BlockTags.create(new ResourceLocation("minecraft:logs")))) {
							isConnectedToLog = true;
							break;
						}
					}
					if (isConnectedToLog)
						break;
				}
				if (isConnectedToLog)
					break;
			}
			if (!isConnectedToLog) {
				chance = Mth.nextInt(RandomSource.create(), 1, 100);
				if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip9 ? blockstate.getValue(_getip9) : -1) == 6) {
					world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, (y - 1), z, new ItemStack(ModBlocks.MUSANG_KING_DURIAN.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (chance <= 1) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.STICK));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
				} else if (chance <= 5) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.STICK));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else {
				if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip16 ? blockstate.getValue(_getip16) : -1) != 3) {
					if ((new Object() {
						public boolean replaceable(LevelAccessor _world, BlockState _blockState) {
							Level _level = _world instanceof Level ? (Level) _world : null;
							BlockHitResult _pos = new BlockHitResult(Vec3.ZERO, Direction.DOWN, BlockPos.ZERO, false);
							boolean _flag = _blockState.canBeReplaced();
							boolean _flag2 = _level != null && _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.MAIN_HAND, ItemStack.EMPTY, _pos));
							boolean _flag3 = _level != null && _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.OFF_HAND, ItemStack.EMPTY, _pos));
							return _flag || _flag2 || _flag3;
						}
					}).replaceable(world, (world.getBlockState(BlockPos.containing(x, y - 1, z)))) || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ModBlocks.DURIAN_FRUIT_1.get()
							|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ModBlocks.DURIAN_FRUIT_2.get()) {
						chance = Mth.nextInt(RandomSource.create(), 1, 100);
						if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip25 ? blockstate.getValue(_getip25) : -1) == 1) {
							if (chance <= 30) {
								DurianTreeGrowProcedure.execute(world, x, y, z, blockstate);
							}
						} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip27 ? blockstate.getValue(_getip27) : -1) == 4) {
							if (chance <= 5) {
								DurianTreeGrowProcedure.execute(world, x, y, z, blockstate);
							}
						} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip29 ? blockstate.getValue(_getip29) : -1) == 5) {
							if (chance <= 5) {
								DurianTreeGrowProcedure.execute(world, x, y, z, blockstate);
							}
						} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip31 ? blockstate.getValue(_getip31) : -1) == 6) {
							if (chance <= 5) {
								DurianTreeGrowProcedure.execute(world, x, y, z, blockstate);
							}
						} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip33 ? blockstate.getValue(_getip33) : -1) == 7) {
							if (CommonConfig.FRUIT_TREE_DROP.get() > 0) {
								if (Math.random() < CommonConfig.FRUIT_TREE_DROP.get()) {
									{
										int _value = 4;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, x, (y - 1), z, new ItemStack(ModBlocks.MUSANG_KING_DURIAN.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								}
							} else if (CommonConfig.FRUIT_TREE_DROP.get() < 0) {
								if (Math.random() < CommonConfig.FRUIT_TREE_DROP.get()) {
									{
										int _value = 4;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
								}
							}
						}
					}
				}
			}
		}
	}
}
