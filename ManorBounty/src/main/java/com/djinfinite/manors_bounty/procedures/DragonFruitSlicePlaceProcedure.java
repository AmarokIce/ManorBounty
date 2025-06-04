package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;


public class DragonFruitSlicePlaceProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, ItemStack itemstack) {
		if (direction == null || entity == null)
			return InteractionResult.PASS;
		double type = 0;
		if (world.getBlockState(BlockPos.containing(x, y, z)).isFaceSturdy(world, BlockPos.containing(x, y, z), Direction.UP) && (new Object() {
			public boolean replaceable(LevelAccessor _world, BlockState _blockState) {
				Level _level = _world instanceof Level ? (Level) _world : null;
				BlockHitResult _pos = new BlockHitResult(Vec3.ZERO, Direction.DOWN, BlockPos.ZERO, false);
				boolean _flag = _blockState.canBeReplaced();
				boolean _flag2 = _level == null ? false : _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.MAIN_HAND, ItemStack.EMPTY, _pos));
				boolean _flag3 = _level == null ? false : _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.OFF_HAND, ItemStack.EMPTY, _pos));
				return _flag || _flag2 || _flag3;
			}
		}).replaceable(world, (world.getBlockState(BlockPos.containing(x, y + 1, z)))) && entity.isShiftKeyDown() && direction == Direction.UP) {
			type = Mth.nextInt(RandomSource.create(), 0, 5);
			world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, int _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
				}
			}.with(ModBlocks.DRAGON_FRUIT_SLICE_BLOCK.get().defaultBlockState(), "blockstate", (int) type)), 3);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo_wood.place")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo_wood.place")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
			if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
				itemstack.shrink(1);
			}
			return InteractionResult.SUCCESS;
		} else if (world.getBlockState(BlockPos.containing(x, y - 1, z)).isFaceSturdy(world, BlockPos.containing(x, y - 1, z), Direction.UP) && (new Object() {
			public boolean replaceable(LevelAccessor _world, BlockState _blockState) {
				Level _level = _world instanceof Level ? (Level) _world : null;
				BlockHitResult _pos = new BlockHitResult(Vec3.ZERO, Direction.DOWN, BlockPos.ZERO, false);
				boolean _flag = _blockState.canBeReplaced();
				boolean _flag2 = _level == null ? false : _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.MAIN_HAND, ItemStack.EMPTY, _pos));
				boolean _flag3 = _level == null ? false : _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.OFF_HAND, ItemStack.EMPTY, _pos));
				return _flag || _flag2 || _flag3;
			}
		}).replaceable(world, (world.getBlockState(BlockPos.containing(x, y, z)))) && entity.isShiftKeyDown()) {
			world.setBlock(BlockPos.containing(x, y, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, int _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
				}
			}.with(ModBlocks.DRAGON_FRUIT_SLICE_BLOCK.get().defaultBlockState(), "blockstate", (int) type)), 3);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo_wood.place")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo_wood.place")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
			if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
				itemstack.shrink(1);
			}
		}
		return InteractionResult.PASS;
	}
}
