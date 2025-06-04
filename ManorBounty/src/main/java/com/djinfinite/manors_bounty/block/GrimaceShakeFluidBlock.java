
package com.djinfinite.manors_bounty.block;

import com.djinfinite.manors_bounty.registries.ModFluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;

public class GrimaceShakeFluidBlock extends LiquidBlock {
	public GrimaceShakeFluidBlock() {
		super(ModFluids.GRIMACE_SHAKE_FLUID,
				BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}
}
