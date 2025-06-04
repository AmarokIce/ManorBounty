
package com.djinfinite.manors_bounty.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.procedures.DownBlockPlaceCheckProcedure;
import com.djinfinite.manors_bounty.procedures.CherriesPieRightClickProcedure;
import com.djinfinite.manors_bounty.procedures.BigPiePlaceProcedure;
import com.djinfinite.manors_bounty.registries.ModBlockEntities;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class CherriesPieBlock extends BaseEntityBlock implements EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 4);
	public static final IntegerProperty ANIMATION = IntegerProperty.create("animation", 0, 1);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public CherriesPieBlock() {
		super(BlockBehaviour.Properties.of()

				.sound(SoundType.WOOL).strength(0.2f).lightLevel(s -> (new Object() {
					public int getLightLevel() {
						if (s.getValue(BLOCKSTATE) == 1)
							return 0;
						if (s.getValue(BLOCKSTATE) == 2)
							return 0;
						if (s.getValue(BLOCKSTATE) == 3)
							return 0;
                        s.getValue(BLOCKSTATE);
                        return 0;
					}
				}.getLightLevel())).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
		return RenderShape.ENTITYBLOCK_ANIMATED;
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
		return ModBlockEntities.CHERRIES_PIE.get().create(blockPos, blockState);
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
	public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
		if (state.getValue(BLOCKSTATE) == 1) {

			return switch (state.getValue(FACING)) {
                case NORTH -> box(3, 0, 3, 16, 6, 16);
				case EAST -> box(0, 0, 3, 13, 6, 16);
				case WEST -> box(3, 0, 0, 16, 6, 13);
                default -> box(0, 0, 0, 13, 6, 13);
            };
		}
		if (state.getValue(BLOCKSTATE) == 2) {

			return switch (state.getValue(FACING)) {
                case NORTH -> box(0, 0, 3, 13, 6, 16);
				case EAST -> box(0, 0, 0, 13, 6, 13);
				case WEST -> box(3, 0, 3, 16, 6, 16);
                default -> box(3, 0, 0, 16, 6, 13);
            };
		}
		if (state.getValue(BLOCKSTATE) == 3) {

			return switch (state.getValue(FACING)) {
                case NORTH -> box(3, 0, 0, 16, 6, 13);
				case EAST -> box(3, 0, 3, 16, 6, 16);
				case WEST -> box(0, 0, 0, 13, 6, 13);
                default -> box(0, 0, 3, 13, 6, 16);
            };
		}
		if (state.getValue(BLOCKSTATE) == 4) {

			return switch (state.getValue(FACING)) {
                case NORTH -> box(0, 0, 0, 13, 6, 13);
				case EAST -> box(3, 0, 0, 16, 6, 13);
				case WEST -> box(0, 0, 3, 13, 6, 16);
                default -> box(3, 0, 3, 16, 6, 16);
            };
		}

		return switch (state.getValue(FACING)) {
            case NORTH -> box(1, 0, 1, 14, 6, 14);
			case EAST -> box(2, 0, 1, 15, 6, 14);
			case WEST -> box(1, 0, 2, 14, 6, 15);
            default -> box(2, 0, 2, 15, 6, 15);
        };
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(ANIMATION, FACING, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
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
			return DownBlockPlaceCheckProcedure.execute(world, x, y, z);
		}
		return super.canSurvive(blockstate, worldIn, pos);
	}

	@Override
	public @NotNull BlockState updateShape(BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor world, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos) {
		return !state.canSurvive(world, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public void setPlacedBy(@NotNull Level world, @NotNull BlockPos pos, @NotNull BlockState blockstate, LivingEntity entity, @NotNull ItemStack itemstack) {
		super.setPlacedBy(world, pos, blockstate, entity, itemstack);
		BigPiePlaceProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity);
	}

	@Override
	public @NotNull InteractionResult use(@NotNull BlockState blockstate, @NotNull Level world, @NotNull BlockPos pos, @NotNull Player entity, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();

		CherriesPieRightClickProcedure.execute(world, x, y, z, blockstate, entity);
		return InteractionResult.SUCCESS;
	}
}
