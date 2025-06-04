
package com.djinfinite.manors_bounty.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.procedures.PeachLeavesRightClickProcedure;
import com.djinfinite.manors_bounty.procedures.PeachLeavesRandomTickProcedure;
import com.djinfinite.manors_bounty.procedures.LeavesPlaceProcedure;
import com.djinfinite.manors_bounty.procedures.FruitTreeLeavesGrowingProcedure;
import com.djinfinite.manors_bounty.procedures.FruitTreeLeavesBonemealCheckProcedure;
import org.jetbrains.annotations.NotNull;

public class PeachLeavesBlock extends Block implements BonemealableBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 6);

	public PeachLeavesBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_PINK).sound(SoundType.GRASS).strength(0.2f).lightLevel(s -> 0).noOcclusion().randomTicks().isRedstoneConductor((bs, br, bp) -> false));
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
			return box(0, 0, 0, 16, 16, 16);
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
		if (state.getValue(BLOCKSTATE) == 5) {
			return box(0, 0, 0, 16, 16, 16);
		}
        state.getValue(BLOCKSTATE);
        return box(0, 0, 0, 16, 16, 16);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(BLOCKSTATE);
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 30;
	}

	@Override
	public void tick(@NotNull BlockState blockstate, @NotNull ServerLevel world, @NotNull BlockPos pos, @NotNull RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		PeachLeavesRandomTickProcedure.execute(world, x, y, z, blockstate);
	}

	@Override
	public void setPlacedBy(@NotNull Level world, @NotNull BlockPos pos, @NotNull BlockState blockstate, LivingEntity entity, @NotNull ItemStack itemstack) {
		super.setPlacedBy(world, pos, blockstate, entity, itemstack);
		LeavesPlaceProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
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
        return PeachLeavesRightClickProcedure.execute(world, x, y, z, blockstate);
	}

	@Override
	public boolean isValidBonemealTarget(@NotNull LevelReader worldIn, @NotNull BlockPos pos, @NotNull BlockState blockstate, boolean clientSide) {
		if (worldIn instanceof LevelAccessor world) {
			return FruitTreeLeavesBonemealCheckProcedure.execute(blockstate);
		}
		return false;
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level world, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState blockstate) {
		return true;
	}

	@Override
	public void performBonemeal(@NotNull ServerLevel world, @NotNull RandomSource random, BlockPos pos, @NotNull BlockState blockstate) {
		FruitTreeLeavesGrowingProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}
}
