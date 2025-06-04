package club.someoneice.manorsbounty.common.capability

import club.someoneice.manorsbounty.api.IModCapability
import net.minecraft.nbt.CompoundTag

class Turking: IModCapability {
    var counter: Int = 0
    var punishment: Int = 0
    var mark = false

    fun init() {
        this.counter = 0
        this.punishment = 0
        this.mark = false
    }

    override fun serializeNBT(): CompoundTag {
        val nbt = CompoundTag()
        nbt.putInt("counter", counter)
        nbt.putInt("punishment", punishment)
        nbt.putBoolean("mark", mark)
        return nbt
    }

    override fun deserializeNBT(nbt: CompoundTag?) {
        nbt?.let {
            counter = it.getInt("counter")
            punishment = it.getInt("punishment")
            mark = it.getBoolean("mark")
        }
    }
}
