
package com.djinfinite.manors_bounty.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.procedures.HoundstoothInfiniteCarpetTransProcedure;
import com.djinfinite.manors_bounty.registries.ModBlockEntities;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Collections;

public class HoundstoothInfiniteCarpetBlock extends BaseEntityBlock implements SimpleWaterloggedBlock, EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 15);
	public static final IntegerProperty ANIMATION = IntegerProperty.create("animation", 0, 1);
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public HoundstoothInfiniteCarpetBlock() {
		super(BlockBehaviour.Properties.of()

				.mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.WOOL).strength(0.1f, 10f).lightLevel(s -> 0).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));
	}

	@Override
	public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
		return RenderShape.ENTITYBLOCK_ANIMATED;
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
		return ModBlockEntities.HOUNDSTOOTH_INFINITE_CARPET.get().create(blockPos, blockState);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, @NotNull BlockGetter reader, @NotNull BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightBlock(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
		return 0;
	}

	@Override
	public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
		if (state.getValue(BLOCKSTATE) == 1) {

			return box(0, 0, 0, 16, 0.001, 16);
		}
		if (state.getValue(BLOCKSTATE) == 2) {

			return box(0, 0, 0, 16, 0.001, 16);
		}
		if (state.getValue(BLOCKSTATE) == 3) {

			return box(0, 0, 0, 16, 0.001, 16);
		}
		if (state.getValue(BLOCKSTATE) == 4) {

			return box(0, 0, 0, 16, 0.001, 16);
		}
		if (state.getValue(BLOCKSTATE) == 5) {

			return box(0, 0, 0, 16, 0.001, 16);
		}
		if (state.getValue(BLOCKSTATE) == 6) {

			return box(0, 0, 0, 16, 0.001, 16);
		}
		if (state.getValue(BLOCKSTATE) == 7) {

			return box(0, 0, 0, 16, 0.001, 16);
		}
		if (state.getValue(BLOCKSTATE) == 8) {

			return box(0, 0, 0, 16, 0.001, 16);
		}
		if (state.getValue(BLOCKSTATE) == 9) {

			return box(0, 0, 0, 16, 0.001, 16);
		}
		if (state.getValue(BLOCKSTATE) == 10) {

			return box(0, 0, 0, 16, 0.001, 16);
		}
		if (state.getValue(BLOCKSTATE) == 11) {

			return box(0, 0, 0, 16, 0.001, 16);
		}
		if (state.getValue(BLOCKSTATE) == 12) {

			return box(0, 0, 0, 16, 0.001, 16);
		}
		if (state.getValue(BLOCKSTATE) == 13) {

			return box(0, 0, 0, 16, 0.001, 16);
		}
		if (state.getValue(BLOCKSTATE) == 14) {

			return box(0, 0, 0, 16, 0.001, 16);
		}
        state.getValue(BLOCKSTATE);

        return box(0, 0, 0, 16, 0.001, 16);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(ANIMATION, WATERLOGGED, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return this.defaultBlockState().setValue(WATERLOGGED, flag);
	}

	@Override
	public @NotNull FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public @NotNull BlockState updateShape(BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor world, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public @NotNull List<ItemStack> getDrops(@NotNull BlockState state, LootParams.@NotNull Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@Override
	public void neighborChanged(@NotNull BlockState blockstate, @NotNull Level world, @NotNull BlockPos pos, @NotNull Block neighborBlock, @NotNull BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		HoundstoothInfiniteCarpetTransProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}

	@Override
	public void setPlacedBy(@NotNull Level world, @NotNull BlockPos pos, @NotNull BlockState blockstate, LivingEntity entity, @NotNull ItemStack itemstack) {
		super.setPlacedBy(world, pos, blockstate, entity, itemstack);
		HoundstoothInfiniteCarpetTransProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}
}
