
package com.djinfinite.manors_bounty.fluid;

import com.djinfinite.manors_bounty.registries.ModFluids;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import com.djinfinite.manors_bounty.registries.ModFluidTypes;
import com.djinfinite.manors_bounty.registries.ModBlocks;
import org.jetbrains.annotations.NotNull;

public abstract class BubbleTeaFluidFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(ModFluidTypes.BUBBLE_TEA_FLUID_TYPE, ModFluids.BUBBLE_TEA_FLUID,
            ModFluids.FLOWING_BUBBLE_TEA_FLUID).explosionResistance(100f).block(() -> (LiquidBlock) ModBlocks.BUBBLE_TEA_FLUID.get());

	private BubbleTeaFluidFluid() {
		super(PROPERTIES);
	}

	public static class Source extends BubbleTeaFluidFluid {
		public int getAmount(@NotNull FluidState state) {
			return 8;
		}

		public boolean isSource(@NotNull FluidState state) {
			return true;
		}
	}

	public static class Flowing extends BubbleTeaFluidFluid {
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
