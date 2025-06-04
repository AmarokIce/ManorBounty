
package com.djinfinite.manors_bounty.block;

import com.djinfinite.manors_bounty.registries.ModItems;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.procedures.HamimelonCropUpdataProcedure;
import com.djinfinite.manors_bounty.procedures.HamimelonCropRandomTickProcedure;
import com.djinfinite.manors_bounty.procedures.HamimelonCropBonemealUseProcedure;
import com.djinfinite.manors_bounty.procedures.HamimelonCropBonemealCheckProcedure;
import com.djinfinite.manors_bounty.procedures.DownNormalFarmlandCheckProcedure;
import org.jetbrains.annotations.NotNull;

public class HamimelonCropBlock extends Block implements BonemealableBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 6);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public HamimelonCropBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).sound(SoundType.CROP).strength(0f, 10f).lightLevel(s -> 0).requiresCorrectToolForDrops().noCollission().noOcclusion().randomTicks().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(@NotNull BlockState state, @NotNull BlockGetter reader, @NotNull BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
		return 0;
	}

	@Override
	public @NotNull VoxelShape getVisualShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
		if (state.getValue(BLOCKSTATE) == 1) {
            state.getValue(FACING);
            return box(5, 0, 5, 11, 5, 11);
		}
		if (state.getValue(BLOCKSTATE) == 2) {
            state.getValue(FACING);
            return box(4, 0, 4, 12, 8, 12);
		}
		if (state.getValue(BLOCKSTATE) == 3) {
            state.getValue(FACING);
            return box(2, 0, 2, 14, 12, 14);
		}
		if (state.getValue(BLOCKSTATE) == 4) {
            state.getValue(FACING);
            return box(1, 0, 1, 15, 14, 15);
		}
		if (state.getValue(BLOCKSTATE) == 5) {
            state.getValue(FACING);
            return box(1, 0, 1, 15, 15, 15);
		}
		if (state.getValue(BLOCKSTATE) == 6) {
            state.getValue(FACING);
            return box(1, 0, 1, 15, 15, 15);
		}
        state.getValue(FACING);
        return box(5, 0, 5, 11, 4, 11);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public @NotNull BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public @NotNull BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public boolean canSurvive(@NotNull BlockState blockstate, @NotNull LevelReader worldIn, @NotNull BlockPos pos) {
		if (worldIn instanceof LevelAccessor world) {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return DownNormalFarmlandCheckProcedure.execute(world, x, y, z);
		}
		return super.canSurvive(blockstate, worldIn, pos);
	}

	@Override
	public @NotNull BlockState updateShape(BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor world, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos) {
		return !state.canSurvive(world, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
		return new ItemStack(ModItems.HAMIMELON_SEED.get());
	}

	@Override
	public void neighborChanged(@NotNull BlockState blockstate, @NotNull Level world, @NotNull BlockPos pos, @NotNull Block neighborBlock, @NotNull BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		HamimelonCropUpdataProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}

	@Override
	public void tick(@NotNull BlockState blockstate, @NotNull ServerLevel world, @NotNull BlockPos pos, @NotNull RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		HamimelonCropRandomTickProcedure.execute(world, x, y, z, blockstate);
	}

	@Override
	public boolean isValidBonemealTarget(@NotNull LevelReader worldIn, @NotNull BlockPos pos, @NotNull BlockState blockstate, boolean clientSide) {
		if (worldIn instanceof LevelAccessor world) {
			return HamimelonCropBonemealCheckProcedure.execute(blockstate);
		}
		return false;
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level world, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState blockstate) {
		return true;
	}

	@Override
	public void performBonemeal(@NotNull ServerLevel world, @NotNull RandomSource random, BlockPos pos, @NotNull BlockState blockstate) {
		HamimelonCropBonemealUseProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}
}
