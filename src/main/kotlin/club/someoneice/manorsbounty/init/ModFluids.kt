package club.someoneice.manorsbounty.init

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.init.ModFluids.BLUEBERRY
import club.someoneice.manorsbounty.init.ModFluids.BLUEBERRY_FLOWING
import club.someoneice.manorsbounty.init.ModFluids.CAKE
import club.someoneice.manorsbounty.init.ModFluids.CAKE_FLOWING
import club.someoneice.manorsbounty.init.ModFluids.CHERRIES
import club.someoneice.manorsbounty.init.ModFluids.CHERRIES_FLOWING
import club.someoneice.manorsbounty.init.ModFluids.CHOCOLATE
import club.someoneice.manorsbounty.init.ModFluids.CHOCOLATE_FLOWING
import club.someoneice.manorsbounty.init.ModFluids.HOT_SPRING
import club.someoneice.manorsbounty.init.ModFluids.HOT_SPRING_FLOWING
import club.someoneice.manorsbounty.init.ModFluids.JALAPENO
import club.someoneice.manorsbounty.init.ModFluids.JALAPENO_FLOWING
import club.someoneice.manorsbounty.init.ModFluids.STARFRUIT
import club.someoneice.manorsbounty.init.ModFluids.STARFRUIT_FLOWING
import club.someoneice.manorsbounty.init.ModFluids.VANILLA
import club.someoneice.manorsbounty.init.ModFluids.VANILLA_FLOWING
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.item.Item
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.material.Fluid
import net.minecraft.world.level.material.FluidState
import net.minecraft.world.level.material.WaterFluid
import net.minecraft.world.phys.Vec3
import net.minecraft.world.phys.shapes.Shapes
import net.minecraft.world.phys.shapes.VoxelShape
import net.minecraftforge.fluids.FluidType
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject
import java.util.function.Supplier

object ModFluids {
    val REGISTRY: DeferredRegister<Fluid> = DeferredRegister.create(ForgeRegistries.FLUIDS, ManorsBounty.ID)

    val VANILLA_FLOWING by REGISTRY.registerObject("vanilla_ice_cream_fluid_flowing", Vanilla::Flowing)
    val VANILLA by REGISTRY.registerObject("vanilla_ice_cream_fluid", Vanilla::Source)

    val BLUEBERRY_FLOWING by REGISTRY.registerObject("blueberry_ice_cream_fluid_flowing", Blueberry::Flowing)
    val BLUEBERRY by REGISTRY.registerObject("blueberry_ice_cream_fluid", Blueberry::Source)

    val CHERRIES_FLOWING by REGISTRY.registerObject("cherries_ice_cream_fluid_flowing", Cherries::Flowing)
    val CHERRIES by REGISTRY.registerObject("cherries_ice_cream_fluid", Cherries::Source)

    val CHOCOLATE_FLOWING by REGISTRY.registerObject("chocolate_ice_cream_fluid_flowing", Chocolate::Flowing)
    val CHOCOLATE by REGISTRY.registerObject("chocolate_ice_cream_fluid", Chocolate::Source)

    val STARFRUIT_FLOWING by REGISTRY.registerObject("satrfruit_ice_cream_fluid_flowing", Starfruit::Flowing)
    val STARFRUIT by REGISTRY.registerObject("satrfruit_ice_cream_fluid", Starfruit::Source)

    val JALAPENO_FLOWING by REGISTRY.registerObject("jalapeno_ice_cream_fluid_flowing", Jalapeno::Flowing)
    val JALAPENO by REGISTRY.registerObject("jalapeno_ice_cream_fluid", Jalapeno::Source)

    val CAKE_FLOWING by REGISTRY.registerObject("cake_liquid_flowing", Cake::Flowing)
    val CAKE by REGISTRY.registerObject("cake_liquid", Cake::Source)

    val HOT_SPRING_FLOWING by REGISTRY.registerObject("hot_spring_flowing", HotSpring::Flowing)
    val HOT_SPRING by REGISTRY.registerObject("hot_spring", HotSpring::Source)
}

abstract class ModFluid: WaterFluid() {
    override fun getFluidType(): FluidType = ModFluidType.MODTYPE.get()
    override fun getBucket(): Item = getModBucket().second.get()
    override fun getFlowing(): Fluid = getModFlowing()
    override fun getSource(): Fluid = getModSource()
    override fun isSource(pState: FluidState): Boolean = true
    override fun getAmount(pState: FluidState): Int = 8


    abstract fun getModFlowing(): Fluid
    abstract fun getModSource(): Fluid
    abstract fun getModBucket(): Pair<Supplier<out Block>, Supplier<out Item>>

    override fun getExplosionResistance(): Float = 200f

    override fun canBeReplacedWith(
        pState: FluidState,
        pLevel: BlockGetter,
        pPos: BlockPos,
        pFluid: Fluid,
        pDirection: Direction
    ): Boolean = true

    override fun getFlow(pBlockReader: BlockGetter, pPos: BlockPos, pFluidState: FluidState): Vec3 {
        return Vec3(16.0, 16.0, 16.0)
    }

    override fun getTickDelay(pLevel: LevelReader): Int = 5

    override fun getHeight(pState: FluidState, pLevel: BlockGetter, pPos: BlockPos): Float = 1.0f

    override fun getOwnHeight(pState: FluidState): Float = pState.amount / 9.0F

    override fun createLegacyBlock(pState: FluidState): BlockState {
        return this.getModBucket().first.get().defaultBlockState()
    }

    override fun getShape(pState: FluidState, pLevel: BlockGetter, pPos: BlockPos): VoxelShape {
        return Shapes.box(0.0, 0.0, 0.0, 1.0, 1.0, 1.0)
    }

    abstract class Flowing : ModFluid() {
        override fun createFluidStateDefinition(pBuilder: StateDefinition.Builder<Fluid, FluidState>) {
            super.createFluidStateDefinition(pBuilder)
            pBuilder.add(LEVEL)
        }

        override fun isSource(pState: FluidState): Boolean = false
        // override fun getAmount(pState: FluidState): Int = pState.getValue(LEVEL)
        override fun getAmount(pState: FluidState): Int = 8
    }

    abstract class Source : ModFluid() {
        override fun isSource(pState: FluidState): Boolean = true
        override fun getAmount(pState: FluidState): Int = 8
    }
}

class Vanilla {
    class Flowing: ModFluid.Flowing() {
        override fun getModFlowing(): Fluid = VANILLA_FLOWING
        override fun getModSource(): Fluid = VANILLA
        override fun getModBucket() = ModBlocks.VANILLA_ICE_CREAM
    }

    class Source: ModFluid.Source() {
        override fun getModFlowing(): Fluid = VANILLA_FLOWING
        override fun getModSource(): Fluid = VANILLA
        override fun getModBucket() = ModBlocks.VANILLA_ICE_CREAM
    }
}

class Blueberry {
    class Flowing: ModFluid.Flowing() {
        override fun getModFlowing(): Fluid = BLUEBERRY_FLOWING
        override fun getModSource(): Fluid = BLUEBERRY
        override fun getModBucket() = ModBlocks.BLUEBERRY_ICE_CREAM
    }

    class Source: ModFluid.Flowing() {
        override fun getModFlowing(): Fluid = BLUEBERRY_FLOWING
        override fun getModSource(): Fluid = BLUEBERRY
        override fun getModBucket() = ModBlocks.BLUEBERRY_ICE_CREAM
    }
}

class Cherries {
    class Flowing: ModFluid.Flowing() {
        override fun getModFlowing(): Fluid = CHERRIES_FLOWING
        override fun getModSource(): Fluid = CHERRIES
        override fun getModBucket() = ModBlocks.CHERRIES_ICE_CREAM
    }

    class Source: ModFluid.Flowing() {
        override fun getModFlowing(): Fluid = CHERRIES_FLOWING
        override fun getModSource(): Fluid = CHERRIES
        override fun getModBucket() = ModBlocks.BLUEBERRY_ICE_CREAM
    }
}

class Chocolate {
    class Flowing: ModFluid.Flowing() {
        override fun getModFlowing(): Fluid = CHOCOLATE_FLOWING
        override fun getModSource(): Fluid = CHOCOLATE
        override fun getModBucket() = ModBlocks.CHOCOLATE_ICE_CREAM
    }

    class Source: ModFluid.Flowing() {
        override fun getModFlowing(): Fluid = CHOCOLATE_FLOWING
        override fun getModSource(): Fluid = CHOCOLATE
        override fun getModBucket() = ModBlocks.CHOCOLATE_ICE_CREAM
    }
}

class Starfruit {
    class Flowing: ModFluid.Flowing() {
        override fun getModFlowing(): Fluid = STARFRUIT_FLOWING
        override fun getModSource(): Fluid = STARFRUIT
        override fun getModBucket() = ModBlocks.STARFRUIT_ICE_CREAM
    }

    class Source: ModFluid.Flowing() {
        override fun getModFlowing(): Fluid = STARFRUIT_FLOWING
        override fun getModSource(): Fluid = STARFRUIT
        override fun getModBucket() = ModBlocks.STARFRUIT_ICE_CREAM
    }
}

class Jalapeno {
    class Flowing: ModFluid.Flowing() {
        override fun getModFlowing(): Fluid = JALAPENO_FLOWING
        override fun getModSource(): Fluid = JALAPENO
        override fun getModBucket() = ModBlocks.JALAPENO_ICE_CREAM
    }

    class Source: ModFluid.Flowing() {
        override fun getModFlowing(): Fluid = JALAPENO_FLOWING
        override fun getModSource(): Fluid = JALAPENO
        override fun getModBucket() = ModBlocks.JALAPENO_ICE_CREAM
    }
}

class Cake {
    class Flowing: ModFluid.Flowing() {
        override fun getModFlowing(): Fluid = CAKE_FLOWING
        override fun getModSource(): Fluid = CAKE
        override fun getModBucket() = ModBlocks.JALAPENO_ICE_CREAM
    }

    class Source: ModFluid.Flowing() {
        override fun getModFlowing(): Fluid = JALAPENO_FLOWING
        override fun getModSource(): Fluid = CAKE
        override fun getModBucket() = ModBlocks.CAKE_LIQUID
    }
}

class HotSpring {
    class Flowing: ModFluid.Flowing() {
        override fun getModFlowing(): Fluid = HOT_SPRING_FLOWING
        override fun getModSource(): Fluid = HOT_SPRING
        override fun getModBucket() = ModBlocks.JALAPENO_ICE_CREAM
    }

    class Source: ModFluid.Flowing() {
        override fun getModFlowing(): Fluid = HOT_SPRING_FLOWING
        override fun getModSource(): Fluid = HOT_SPRING
        override fun getModBucket() = ModBlocks.HOT_SPRING
    }
}
