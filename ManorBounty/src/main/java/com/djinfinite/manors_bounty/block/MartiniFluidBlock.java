
package com.djinfinite.manors_bounty.block;

import com.djinfinite.manors_bounty.registries.ModFluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;

public class MartiniFluidBlock extends LiquidBlock {
	public MartiniFluidBlock() {
		super(ModFluids.MARTINI_FLUID, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}
}
