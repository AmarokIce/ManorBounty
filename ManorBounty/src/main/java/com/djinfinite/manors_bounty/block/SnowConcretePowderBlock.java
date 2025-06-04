
package com.djinfinite.manors_bounty.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.procedures.SnowConcretePowderSoildifyProcedure;
import org.jetbrains.annotations.NotNull;

public class SnowConcretePowderBlock extends FallingBlock {
	public SnowConcretePowderBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE).mapColor(MapColor.DIAMOND).sound(SoundType.SNOW).strength(0.5f));
	}

	@Override
	public int getLightBlock(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
		return 15;
	}

	@Override
	public void onPlace(@NotNull BlockState blockstate, @NotNull Level world, @NotNull BlockPos pos, @NotNull BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		SnowConcretePowderSoildifyProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void neighborChanged(@NotNull BlockState blockstate, @NotNull Level world, @NotNull BlockPos pos, @NotNull Block neighborBlock, @NotNull BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		SnowConcretePowderSoildifyProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
