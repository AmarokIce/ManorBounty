
package com.djinfinite.manors_bounty.fluid;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import com.djinfinite.manors_bounty.registries.ModFluids;
import com.djinfinite.manors_bounty.registries.ModFluidTypes;
import org.jetbrains.annotations.NotNull;

public abstract class MelonSodaFluidFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(ModFluidTypes.MELON_SODA_FLUID_TYPE, ModFluids.MELON_SODA_FLUID,
            ModFluids.FLOWING_MELON_SODA_FLUID).explosionResistance(100f).block(() -> (LiquidBlock) ModBlocks.MELON_SODA_FLUID.get());

	private MelonSodaFluidFluid() {
		super(PROPERTIES);
	}

	public static class Source extends MelonSodaFluidFluid {
		public int getAmount(@NotNull FluidState state) {
			return 8;
		}

		public boolean isSource(@NotNull FluidState state) {
			return true;
		}
	}

	public static class Flowing extends MelonSodaFluidFluid {
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
