package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

public class HamimelonCropPlantProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, ItemStack itemstack) {
		if (direction == null || entity == null)
			return InteractionResult.PASS;
		if ((new Object() {
			public boolean replaceable(LevelAccessor _world, BlockState _blockState) {
				Level _level = _world instanceof Level ? (Level) _world : null;
				BlockHitResult _pos = new BlockHitResult(Vec3.ZERO, Direction.DOWN, BlockPos.ZERO, false);
				boolean _flag = _blockState.canBeReplaced();
				boolean _flag2 = _level != null && _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.MAIN_HAND, ItemStack.EMPTY, _pos));
				boolean _flag3 = _level != null && _blockState.canBeReplaced(new BlockPlaceContext(_level, null, InteractionHand.OFF_HAND, ItemStack.EMPTY, _pos));
				return _flag || _flag2 || _flag3;
			}
		}).replaceable(world, (world.getBlockState(BlockPos.containing(x, y + 1, z)))) && (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("forge:farmland"))) && direction == Direction.UP) {
			world.setBlock(BlockPos.containing(x, y + 1, z), ModBlocks.HAMIMELON_CROP.get().defaultBlockState(), 3);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crop.plant")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crop.plant")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
			if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
				itemstack.shrink(1);
			}
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("manors_bounty:fruits_delight"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}
}
