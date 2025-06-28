package club.someoneice.manorsbounty.common.network

import club.someoneice.manorsbounty.common.tile.TileIceCreamMachine
import net.minecraft.core.BlockPos
import net.minecraft.network.FriendlyByteBuf
import net.minecraftforge.network.NetworkEvent
import net.minecraftforge.network.NetworkHooks
import java.util.*
import java.util.function.Supplier

data class IceCreamPacket(val pos: BlockPos) {
    constructor(buf: FriendlyByteBuf): this(buf.readBlockPos())

    fun encodec(buf: FriendlyByteBuf) {
        buf.writeBlockPos(this.pos)
    }

    fun onMessage(ctx: Supplier<NetworkEvent.Context>) {
        val c = ctx.get()
        c.enqueueWork {
            val player = c.sender!!
            val tile = player.level().getBlockEntity(this.pos) as TileIceCreamMachine
            if (tile.icecream < 1) {
                return@enqueueWork
            }

            val itemInputA = tile.inventory.getStackInSlot(1)
            val itemInputB = tile.inventory.getStackInSlot(2)

            val recipe = TileIceCreamMachine.RECIPES.firstOrNull() {
                ((it.item1.isEmpty && itemInputA.isEmpty) || it.item1.`is`(itemInputA.item)) &&
                        ((it.item2.isEmpty && itemInputB.isEmpty) || it.item2.`is`(itemInputB.item))
            }

            if (Objects.isNull(recipe)) {
                return@enqueueWork
            }

            tile.icecream--

            if (!itemInputA.isEmpty) itemInputA.shrink(1)
            if (!itemInputB.isEmpty) itemInputB.shrink(1)

            val out = recipe!!.output.copy()
            tile.inventory.setStackInSlot(0, out)

            player.connection.send(tile.updatePacket)
            NetworkHooks.openScreen(player, tile, this.pos)
        }
    }
}
