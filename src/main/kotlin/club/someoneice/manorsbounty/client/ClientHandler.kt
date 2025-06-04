package club.someoneice.manorsbounty.client

import club.someoneice.manorsbounty.common.tile.GEO_BLOCK_MAP
import club.someoneice.manorsbounty.common.tile.SimpleGeoBlockRenderer
import net.minecraft.world.item.BlockItem
import net.minecraftforge.client.event.EntityRenderersEvent
import java.util.*

object ClientHandler {
    internal val RENDER_LIST = Stack<BlockItem>()

    fun BlockItem.sendToRenderList(): BlockItem {
        RENDER_LIST.push(this)
        return this
    }

    fun initRender(event: EntityRenderersEvent.RegisterRenderers) {
        GEO_BLOCK_MAP.forEach { k, v ->
            event.registerBlockEntityRenderer(v, SimpleGeoBlockRenderer(k.id.path))
        }
    }
}
