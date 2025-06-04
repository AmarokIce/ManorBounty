
package com.djinfinite.manors_bounty.block;

import com.djinfinite.manors_bounty.registries.ModItems;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.procedures.DownNormalDirtCheckProcedure;
import com.djinfinite.manors_bounty.procedures.BlueberryBushRightClickProcedure;
import com.djinfinite.manors_bounty.procedures.BlueberryBushRandomTickProcedure;
import com.djinfinite.manors_bounty.procedures.BlueberryBushBonemealUseProcedure;
import com.djinfinite.manors_bounty.procedures.BlueberryBushBonemealCheckProcedure;
import org.jetbrains.annotations.NotNull;

public class BlueberryBushBlock extends Block implements BonemealableBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 4);

	public BlueberryBushBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.WARPED_WART_BLOCK).sound(SoundType.SWEET_BERRY_BUSH).instabreak().lightLevel(s -> 0).noCollission().speedFactor(0.3f).noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY).isRedstoneConductor((bs, br, bp) -> false));
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
			return box(1, 0, 1, 15, 13, 15);
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return box(0, 0, 0, 16, 16, 16);
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			return box(0, 0, 0, 16, 16, 16);
		}
		if (state.getValue(BLOCKSTATE) == 4) {
			return box(0, 0, 0, 16, 16, 16);
		}
		return box(3, 0, 3, 13, 10, 13);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(BLOCKSTATE);
	}

	@Override
	public boolean canSurvive(@NotNull BlockState blockstate, @NotNull LevelReader worldIn, @NotNull BlockPos pos) {
		if (worldIn instanceof LevelAccessor world) {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return DownNormalDirtCheckProcedure.execute(world, x, y, z);
		}
		return super.canSurvive(blockstate, worldIn, pos);
	}

	@Override
	public @NotNull BlockState updateShape(BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor world, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos) {
		return !state.canSurvive(world, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
		return new ItemStack(ModItems.BLUEBERRY.get());
	}

	@Override
	public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return BlockPathTypes.OPEN;
	}

	@Override
	public void tick(@NotNull BlockState blockstate, @NotNull ServerLevel world, @NotNull BlockPos pos, @NotNull RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		BlueberryBushRandomTickProcedure.execute(world, x, y, z, blockstate);
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
        return BlueberryBushRightClickProcedure.execute(world, x, y, z, blockstate);
	}

	@Override
	public boolean isValidBonemealTarget(@NotNull LevelReader worldIn, @NotNull BlockPos pos, @NotNull BlockState blockstate, boolean clientSide) {
		return true;
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level world, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState blockstate) {
		return BlueberryBushBonemealCheckProcedure.execute(blockstate);
	}

	@Override
	public void performBonemeal(@NotNull ServerLevel world, @NotNull RandomSource random, BlockPos pos, @NotNull BlockState blockstate) {
		BlueberryBushBonemealUseProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}
}
