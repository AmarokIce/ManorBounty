
package com.djinfinite.manors_bounty.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import com.djinfinite.manors_bounty.registries.ModItems;
import com.djinfinite.manors_bounty.registries.ModFluids;
import com.djinfinite.manors_bounty.registries.ModFluidTypes;
import com.djinfinite.manors_bounty.registries.ModBlocks;
import org.jetbrains.annotations.NotNull;

public abstract class CherriesIceCreamFluidFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(ModFluidTypes.CHERRIES_ICE_CREAM_FLUID_TYPE, ModFluids.CHERRIES_ICE_CREAM_FLUID,
            ModFluids.FLOWING_CHERRIES_ICE_CREAM_FLUID).explosionResistance(100f).tickRate(30).levelDecreasePerBlock(2).slopeFindDistance(1).bucket(ModItems.CHERRIES_ICE_CREAM_FLUID_BUCKET)
			.block(() -> (LiquidBlock) ModBlocks.CHERRIES_ICE_CREAM_FLUID.get());

	private CherriesIceCreamFluidFluid() {
		super(PROPERTIES);
	}

	public static class Source extends CherriesIceCreamFluidFluid {
		public int getAmount(@NotNull FluidState state) {
			return 8;
		}

		public boolean isSource(@NotNull FluidState state) {
			return true;
		}
	}

	public static class Flowing extends CherriesIceCreamFluidFluid {
		protected void createFluidStateDefinition(StateDefinition.@NotNull Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(@NotNull FluidState state) {
			return false;
		}
	}
}
