package club.someoneice.manorsbounty.common.network

import club.someoneice.manorsbounty.common.tile.TileFryer
import net.minecraft.core.BlockPos
import net.minecraft.network.FriendlyByteBuf
import net.minecraftforge.network.NetworkEvent
import net.minecraftforge.network.NetworkHooks
import java.util.function.Supplier

data class FryerPacket(val pos: BlockPos) {
    constructor(buf: FriendlyByteBuf): this(buf.readBlockPos())

    fun encodec(buf: FriendlyByteBuf) {
        buf.writeBlockPos(this.pos)
    }

    fun onMessage(ctx: Supplier<NetworkEvent.Context>) {
        val c = ctx.get()
        c.enqueueWork {
            val player = c.sender!!
            val tile = player.level().getBlockEntity(this.pos) as TileFryer
            tile.changedWorkingState()
            player.connection.send(tile.updatePacket)
            NetworkHooks.openScreen(player, tile, this.pos)
        }
    }
}
