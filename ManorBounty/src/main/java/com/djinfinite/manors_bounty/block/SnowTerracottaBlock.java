
package com.djinfinite.manors_bounty.block;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.NotNull;

public class SnowTerracottaBlock extends Block {
	public SnowTerracottaBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.DIAMOND)
				.sound(new ForgeSoundType(1.0f, 1.0f, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.place")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lodestone.hit")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.fall"))))
				.strength(1.25f, 4.2f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
		return 15;
	}
}
