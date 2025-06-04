package club.someoneice.manorsbounty.client

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.common.tile.GEO_BLOCK_MAP
import club.someoneice.manorsbounty.common.tile.SimpleGeoBlockRenderer
import net.minecraft.world.item.BlockItem
import net.minecraftforge.client.event.EntityRenderersEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import java.util.*

@Mod.EventBusSubscriber(modid = ManorsBounty.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
object ClientHandler {
    internal val RENDER_LIST = Stack<BlockItem>()

    fun BlockItem.sendToRenderList(): BlockItem {
        RENDER_LIST.push(this)
        return this
    }

    @SubscribeEvent
    fun initRender(event: EntityRenderersEvent.RegisterRenderers) {
        GEO_BLOCK_MAP.forEach { k, v ->
            event.registerBlockEntityRenderer(v, SimpleGeoBlockRenderer(k.id.path))
        }
    }
}