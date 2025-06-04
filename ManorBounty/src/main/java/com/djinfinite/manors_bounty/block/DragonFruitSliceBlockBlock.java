
package com.djinfinite.manors_bounty.block;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import com.djinfinite.manors_bounty.registries.ModItems;
import com.djinfinite.manors_bounty.utils.ModUtils;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.material.MapColor;
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
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.procedures.DownBlockPlaceCheckProcedure;
import com.djinfinite.manors_bounty.registries.ModBlockEntities;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Collections;

public class DragonFruitSliceBlockBlock extends BaseEntityBlock implements EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 5);
	public static final IntegerProperty ANIMATION = IntegerProperty.create("animation", 0, 1);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public DragonFruitSliceBlockBlock() {
		super(BlockBehaviour.Properties.of()

				.mapColor(MapColor.QUARTZ).sound(SoundType.BAMBOO).instabreak().lightLevel(s -> 0).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
		return RenderShape.ENTITYBLOCK_ANIMATED;
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
		return ModBlockEntities.DRAGON_FRUIT_SLICE_BLOCK.get().create(blockPos, blockState);
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

            state.getValue(FACING);
            return box(4.5, 0, 4.5, 11.5, 7, 11.5);
		}
		if (state.getValue(BLOCKSTATE) == 2) {

            state.getValue(FACING);
            return box(4.5, 0, 4.5, 11.5, 7, 11.5);
		}
		if (state.getValue(BLOCKSTATE) == 3) {

            state.getValue(FACING);
            return box(4.5, 0, 4.5, 11.5, 7, 11.5);
		}
		if (state.getValue(BLOCKSTATE) == 4) {

            state.getValue(FACING);
            return box(4.5, 0, 4.5, 11.5, 7, 11.5);
		}
        state.getValue(BLOCKSTATE);

        state.getValue(FACING);
        return box(4.5, 0, 4.5, 11.5, 7, 11.5);
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
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
		return new ItemStack(ModItems.DRAGON_FRUIT_SLICE.get());
	}

	@Override
	public @NotNull List<ItemStack> getDrops(@NotNull BlockState state, LootParams.@NotNull Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(ModItems.DRAGON_FRUIT_SLICE.get()));
	}

	@Override
	public @NotNull InteractionResult use(@NotNull BlockState blockstate, @NotNull Level world, @NotNull BlockPos pos, @NotNull Player entity, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		if(world.isClientSide){
			return super.use(blockstate, world, pos, entity, hand, hit);
		}
		int type;
		if (!entity.isShiftKeyDown()) {
			type = Mth.nextInt(RandomSource.create(), 0, 5);
			BlockState sliced = ModBlocks.DRAGON_FRUIT_SLICE_BLOCK.get().defaultBlockState();
			sliced = sliced.setValue(DragonFruitSliceBlockBlock.BLOCKSTATE,type);
			world.setBlock(pos, sliced, 2);
			ModUtils.playSound(world,pos, SoundEvents.BAMBOO_PLACE, SoundSource.BLOCKS);
			return InteractionResult.CONSUME;
		}
		return InteractionResult.PASS;
	}
}
