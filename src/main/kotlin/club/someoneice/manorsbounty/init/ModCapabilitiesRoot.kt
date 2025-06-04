package club.someoneice.manorsbounty.init

import club.someoneice.manorsbounty.core.Capabilities
import net.minecraft.core.Direction
import net.minecraft.nbt.CompoundTag
import net.minecraftforge.common.capabilities.*
import net.minecraftforge.common.util.INBTSerializable
import net.minecraftforge.common.util.LazyOptional

@AutoRegisterCapability
interface ModCapabilitiesRoot: INBTSerializable<CompoundTag> {
    fun getData(): Capabilities

    companion object {
        val MOD_CAPABILITIES: Capability<ModCapabilitiesRoot> =
            CapabilityManager.get(object : CapabilityToken<ModCapabilitiesRoot>() {})
    }

    class ModCapabilitiesProvider: ICapabilityProvider, INBTSerializable<CompoundTag> {
        val root: ModCapabilitiesRoot = Capabilities()

        override fun <T : Any?> getCapability(cap: Capability<T>, side: Direction?): LazyOptional<T> =
            if (cap == MOD_CAPABILITIES) LazyOptional.of(this::root).cast() else LazyOptional.empty()

        override fun serializeNBT(): CompoundTag = this.root.serializeNBT()

        override fun deserializeNBT(nbt: CompoundTag?) {
            this.root.deserializeNBT(nbt)
        }
    }
}
