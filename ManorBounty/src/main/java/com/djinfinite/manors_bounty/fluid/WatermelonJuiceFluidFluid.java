
package com.djinfinite.manors_bounty.fluid;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import com.djinfinite.manors_bounty.registries.ModFluids;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import com.djinfinite.manors_bounty.registries.ModFluidTypes;
import org.jetbrains.annotations.NotNull;

public abstract class WatermelonJuiceFluidFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(ModFluidTypes.WATERMELON_JUICE_FLUID_TYPE, ModFluids.WATERMELON_JUICE_FLUID,
            ModFluids.FLOWING_WATERMELON_JUICE_FLUID).explosionResistance(100f).block(() -> (LiquidBlock) ModBlocks.WATERMELON_JUICE_FLUID.get());

	private WatermelonJuiceFluidFluid() {
		super(PROPERTIES);
	}

	public static class Source extends WatermelonJuiceFluidFluid {
		public int getAmount(@NotNull FluidState state) {
			return 8;
		}

		public boolean isSource(@NotNull FluidState state) {
			return true;
		}
	}

	public static class Flowing extends WatermelonJuiceFluidFluid {
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
