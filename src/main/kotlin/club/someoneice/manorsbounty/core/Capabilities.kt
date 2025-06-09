package club.someoneice.manorsbounty.core

import club.someoneice.manorsbounty.common.capability.Turking
import club.someoneice.manorsbounty.init.ModCapabilitiesRoot
import net.minecraft.nbt.CompoundTag
import net.minecraftforge.common.util.INBTSerializable

class Capabilities: ModCapabilitiesRoot, INBTSerializable<CompoundTag> {
    val turkingEffect = Turking()

    override fun getData() = this
    override fun serializeNBT() = CompoundTag().also {
            it.put("turkingEffect", this.turkingEffect.serializeNBT())
    }

    override fun deserializeNBT(nbt: CompoundTag?) {
        nbt ?: return
        this.turkingEffect.deserializeNBT(nbt.getCompound("turkingEffect"))
    }
}
