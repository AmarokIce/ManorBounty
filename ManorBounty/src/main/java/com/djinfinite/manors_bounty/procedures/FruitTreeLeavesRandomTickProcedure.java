package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.configuration.CommonConfig;

public class FruitTreeLeavesRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, ItemStack DropFruit, double DropFruitMax, double DropFruitMin) {
		ItemStack item_stick;
		ItemStack drop_item;
		double chance = 0;
		FruitLeavesTypeCheckProcedure.execute(world, x, y, z, blockstate);
		if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) != 2) {
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
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                Mth.nextInt(RandomSource.create(), 1, 100);
                if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip5 ? blockstate.getValue(_getip5) : -1) == 5) {
					drop_item = DropFruit.copy();
					drop_item.setCount(Mth.nextInt(RandomSource.create(), (int) DropFruitMin, (int) DropFruitMax));
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, drop_item);
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
				item_stick = new ItemStack(Items.STICK).copy();
				item_stick.setCount(Mth.nextInt(RandomSource.create(), 0, 1));
				if (Math.random() < 0.1) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, item_stick);
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else {
				if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip13 ? blockstate.getValue(_getip13) : -1) != 3) {
                    Mth.nextInt(RandomSource.create(), 1, 100);
                    if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip16 ? blockstate.getValue(_getip16) : -1) == 1) {
						if (Math.random() < CommonConfig.FRUIT_TREE_BLOSSOM.get()) {
							FruitTreeLeavesGrowingProcedure.execute(world, x, y, z, blockstate);
						}
					} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip19 ? blockstate.getValue(_getip19) : -1) == 4) {
						if (Math.random() < CommonConfig.FRUIT_TREE_FRUIT.get()) {
							FruitTreeLeavesGrowingProcedure.execute(world, x, y, z, blockstate);
						}
					} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip22 ? blockstate.getValue(_getip22) : -1) == 5) {
						if (CommonConfig.FRUIT_TREE_DROP.get() > 0) {
							if (Math.random() < CommonConfig.FRUIT_TREE_DROP.get()) {
								{
									int _value = 1;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								drop_item = DropFruit.copy();
								drop_item.setCount(Mth.nextInt(RandomSource.create(), (int) DropFruitMin, (int) DropFruitMax));
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, drop_item);
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.sweet_berry_bush.pick_berries")), SoundSource.BLOCKS, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.sweet_berry_bush.pick_berries")), SoundSource.BLOCKS, 1, 1, false);
									}
								}
							}
						} else if (CommonConfig.FRUIT_TREE_DROP.get() < 0) {
							if (Math.random() < CommonConfig.FRUIT_TREE_DROP.get()) {
								{
									int _value = 1;
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
		}
	}
}
