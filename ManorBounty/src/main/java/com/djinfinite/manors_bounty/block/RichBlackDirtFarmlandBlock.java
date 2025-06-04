
package com.djinfinite.manors_bounty.block;

import net.minecraft.world.level.block.FarmBlock;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.common.IPlantable;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.procedures.RichBlackDirtFarmlandRandomTickProcedure;
import org.jetbrains.annotations.NotNull;

public class RichBlackDirtFarmlandBlock extends FarmBlock {
	public RichBlackDirtFarmlandBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.TERRACOTTA_GRAY)
				.sound(new ForgeSoundType(1.0f, 1.0f, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.rooted_dirt.break")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.rooted_dirt.step")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.rooted_dirt.place")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.rooted_dirt.hit")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.rooted_dirt.fall"))))
				.strength(1.6f, 0.6f).noOcclusion().randomTicks().isRedstoneConductor((bs, br, bp) -> false));
	}

	@Override
	public int getLightBlock(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
		return 15;
	}

	@Override
	public @NotNull VoxelShape getVisualShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
		return box(0, 0, 0, 16, 15, 16);
	}

	@Override
	public boolean canSustainPlant(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull Direction direction, @NotNull IPlantable plantable) {
		return true;
	}

	@Override
	public void tick(@NotNull BlockState blockstate, @NotNull ServerLevel world, @NotNull BlockPos pos, @NotNull RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		RichBlackDirtFarmlandRandomTickProcedure.execute(world, x, y, z);
	}
}
