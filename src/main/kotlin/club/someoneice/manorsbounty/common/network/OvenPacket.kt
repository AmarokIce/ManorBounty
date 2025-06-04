package club.someoneice.manorsbounty.common.network

import club.someoneice.manorsbounty.common.tile.TileFryer
import club.someoneice.manorsbounty.common.tile.TileOven
import net.minecraft.core.BlockPos
import net.minecraft.network.FriendlyByteBuf
import net.minecraftforge.network.NetworkEvent
import net.minecraftforge.network.NetworkHooks
import java.util.function.Supplier

data class OvenPacket(val pos: BlockPos, val command: Int) {
    constructor(buf: FriendlyByteBuf): this(buf.readBlockPos(), buf.readInt())

    fun encodec(buf: FriendlyByteBuf) {
        buf.writeBlockPos(this.pos)
        buf.writeInt(this.command)
    }

    fun onMessage(ctx: Supplier<NetworkEvent.Context>) {
        val c = ctx.get()
        c.enqueueWork {
            val player = c.sender!!
            val tile = player.level().getBlockEntity(this.pos) as TileOven
            when(command) {
                0 -> {
                    if (++tile.temperature > 3) {
                        tile.temperature = 0
                    }
                }
                1 -> {
                    if (++tile.timer > 3) {
                        tile.timer = 0
                    }
                }
                2 -> tile.changedState()
            }

            player.connection.send(tile.updatePacket)
            NetworkHooks.openScreen(player, tile, this.pos)
        }
    }
}
