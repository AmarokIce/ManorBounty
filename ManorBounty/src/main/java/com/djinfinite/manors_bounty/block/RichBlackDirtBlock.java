
package com.djinfinite.manors_bounty.block;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.procedures.RichBlackDirtChangeProcedure;
import org.jetbrains.annotations.NotNull;

public class RichBlackDirtBlock extends Block {
	public RichBlackDirtBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.TERRACOTTA_GRAY)
				.sound(new ForgeSoundType(1.0f, 1.0f, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.rooted_dirt.break")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.rooted_dirt.step")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.rooted_dirt.place")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.rooted_dirt.hit")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.rooted_dirt.fall"))))
				.strength(1.6f, 0.6f));
	}

	@Override
	public int getLightBlock(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
		return 15;
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
        return RichBlackDirtChangeProcedure.execute(world, x, y, z, entity);
	}
}
