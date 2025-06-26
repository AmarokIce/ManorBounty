package club.someoneice.manorsbounty.common.tile

import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag
import net.minecraft.nbt.ListTag
import net.minecraft.network.protocol.Packet
import net.minecraft.network.protocol.game.ClientGamePacketListener
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket
import net.minecraft.world.SimpleContainer
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState

class TileIceCreamMachine(pPos: BlockPos, pBlockState: BlockState): BlockEntity(null, pPos, pBlockState) {
    var icecream = 0
    val inventory = SimpleContainer(4)

    override fun saveAdditional(pTag: CompoundTag) {
        super.saveAdditional(pTag)
        pTag.put("inventory", inventory.createTag())
        pTag.putInt("icecream", icecream)
    }

    override fun load(pTag: CompoundTag) {
        super.load(pTag)
        inventory.fromTag(pTag.get("inventory") as ListTag)
        icecream = pTag.getInt("icecream")
    }

    override fun getUpdatePacket(): Packet<ClientGamePacketListener> {
        return ClientboundBlockEntityDataPacket.create(this)
    }

    override fun getUpdateTag(): CompoundTag = CompoundTag().apply(::saveAdditional)

    companion object {
        fun tick() {

        }
    }
}
