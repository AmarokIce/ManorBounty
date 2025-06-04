
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

public abstract class StrawberryShakeFluidFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(ModFluidTypes.STRAWBERRY_SHAKE_FLUID_TYPE, ModFluids.STRAWBERRY_SHAKE_FLUID,
            ModFluids.FLOWING_STRAWBERRY_SHAKE_FLUID).explosionResistance(100f).block(() -> (LiquidBlock) ModBlocks.STRAWBERRY_SHAKE_FLUID.get());

	private StrawberryShakeFluidFluid() {
		super(PROPERTIES);
	}

	public static class Source extends StrawberryShakeFluidFluid {
		public int getAmount(@NotNull FluidState state) {
			return 8;
		}

		public boolean isSource(@NotNull FluidState state) {
			return true;
		}
	}

	public static class Flowing extends StrawberryShakeFluidFluid {
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
