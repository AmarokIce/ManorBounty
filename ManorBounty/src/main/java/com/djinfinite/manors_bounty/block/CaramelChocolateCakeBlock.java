
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.procedures.CaramelChocolateCakeEatingProcedure;
import org.jetbrains.annotations.NotNull;

public class CaramelChocolateCakeBlock extends Block {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 7);

	public CaramelChocolateCakeBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOL).strength(0.5f, 10f).lightLevel(s -> 0).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
			return box(1, 0, 1, 15, 8, 15);
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return box(3, 0, 1, 15, 8, 15);
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			return box(5, 0, 1, 15, 8, 15);
		}
		if (state.getValue(BLOCKSTATE) == 4) {
			return box(7, 0, 1, 15, 8, 15);
		}
		if (state.getValue(BLOCKSTATE) == 5) {
			return box(9, 0, 1, 15, 8, 15);
		}
		if (state.getValue(BLOCKSTATE) == 6) {
			return box(11, 0, 1, 15, 8, 15);
		}
		if (state.getValue(BLOCKSTATE) == 7) {
			return box(13, 0, 1, 15, 8, 15);
		}
		return box(1, 0, 1, 15, 8, 15);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(BLOCKSTATE);
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
        return CaramelChocolateCakeEatingProcedure.execute(world, x, y, z, blockstate, entity);
	}
}
