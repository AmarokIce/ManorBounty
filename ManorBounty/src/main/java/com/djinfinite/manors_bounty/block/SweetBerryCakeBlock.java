
package com.djinfinite.manors_bounty.block;

import com.djinfinite.manors_bounty.items.IFoodItem;
import com.djinfinite.manors_bounty.registries.ModBlocks;
import com.djinfinite.manors_bounty.registries.ModItems;
import com.djinfinite.manors_bounty.utils.CapabilityUtils;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class SweetBerryCakeBlock extends CakeBlock {
	public SweetBerryCakeBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.WOOL).strength(0.5f, 10f).lightLevel(s -> 0).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
		return new ItemStack(ModBlocks.SWEET_BERRY_CAKE.get());
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		ItemStack itemstack = pPlayer.getItemInHand(pHand);
		if (pLevel.isClientSide) {
			if (eatCake(pLevel, pPos, pState, pPlayer).consumesAction()) {
				return InteractionResult.SUCCESS;
			}
			if (itemstack.isEmpty()) {
				return InteractionResult.CONSUME;
			}
		}

		return eatCake(pLevel, pPos, pState, pPlayer);
   }

	protected InteractionResult eatCake(LevelAccessor pLevel, BlockPos pPos, BlockState pState, Player player) {
		if (!player.canEat(false)) {
			return InteractionResult.PASS;
		} else {
			player.awardStat(Stats.EAT_CAKE_SLICE);
			if ((player.getAbilities().instabuild) || player.getFoodData().getFoodLevel() < 20) {
				if (!CapabilityUtils.isInModCooldown(ModItems.SWEET_BERRY_CAKE_SLICE.get(), player)) {
					if (((IFoodItem) ModItems.SWEET_BERRY_CAKE.get()).getFoodEffect().apply(player)) {
						CapabilityUtils.addModCooldown(ModItems.SWEET_BERRY_CAKE_SLICE.get(), player);
					}
				}
				player.getFoodData().eat(1, 0.2F);
			}
			player.getFoodData().eat(2, 0.1F);
			int i = pState.getValue(BITES);
			pLevel.gameEvent(player, GameEvent.EAT, pPos);
			if (i < 6) {
				pLevel.setBlock(pPos, pState.setValue(BITES, Integer.valueOf(i + 1)), 3);
			} else {
				pLevel.removeBlock(pPos, false);
				pLevel.gameEvent(player, GameEvent.BLOCK_DESTROY, pPos);
			}

			return InteractionResult.SUCCESS;
		}
	}
}
