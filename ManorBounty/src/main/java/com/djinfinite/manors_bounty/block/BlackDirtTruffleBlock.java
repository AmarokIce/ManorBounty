
package com.djinfinite.manors_bounty.block;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.NotNull;

public class BlackDirtTruffleBlock extends Block {
	public BlackDirtTruffleBlock() {
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
}
