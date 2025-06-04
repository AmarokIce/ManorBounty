package club.someoneice.manorsbounty.core

import club.someoneice.manorsbounty.common.capability.FoodCooldown
import club.someoneice.manorsbounty.common.capability.Turking
import club.someoneice.manorsbounty.init.ModCapabilitiesRoot
import net.minecraft.nbt.CompoundTag
import net.minecraftforge.common.util.INBTSerializable

class Capabilities: ModCapabilitiesRoot, INBTSerializable<CompoundTag> {
    val foodCooldown = FoodCooldown()
    val turkingEffect = Turking()

    override fun getData() = this
    override fun serializeNBT() = CompoundTag().also {
            it.put("foodcooldown", this.foodCooldown.serializeNBT())
            it.put("turkingEffect", this.turkingEffect.serializeNBT())
    }

    override fun deserializeNBT(nbt: CompoundTag?) {
        nbt ?: return
        this.foodCooldown.deserializeNBT(nbt.getCompound("foodcooldown"))
        this.turkingEffect.deserializeNBT(nbt.getCompound("turkingEffect"))
    }
}
