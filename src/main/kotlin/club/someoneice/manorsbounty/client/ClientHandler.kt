package club.someoneice.manorsbounty.client

import club.someoneice.manorsbounty.client.gui.FryerScreen
import club.someoneice.manorsbounty.client.gui.OvenScreen
import club.someoneice.manorsbounty.common.tile.GEO_BLOCK_MAP
import club.someoneice.manorsbounty.common.tile.GEO_BLOCK_RENDERER_MAP
import club.someoneice.manorsbounty.common.tile.SimpleGeoBlockRenderer
import club.someoneice.manorsbounty.init.ModMenus
import net.minecraft.client.gui.screens.MenuScreens
import net.minecraft.client.renderer.ItemBlockRenderTypes
import net.minecraft.client.renderer.RenderType
import net.minecraft.world.item.BlockItem
import net.minecraftforge.client.event.EntityRenderersEvent
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import java.util.*

object ClientHandler {
    internal val RENDER_LIST = Stack<BlockItem>()

    fun BlockItem.sendToRenderList(): BlockItem {
        RENDER_LIST.push(this)
        return this
    }

    fun onClientSetup(event: FMLClientSetupEvent) {
        event.enqueueWork {
            while (ClientHandler.RENDER_LIST.isNotEmpty()) {
                ItemBlockRenderTypes.setRenderLayer(ClientHandler.RENDER_LIST.pop().block, RenderType.translucent())
            }

            MenuScreens.register(ModMenus.FRYER, ::FryerScreen)
            MenuScreens.register(ModMenus.OVEN, ::OvenScreen)
        }
    }

    fun initRender(event: EntityRenderersEvent.RegisterRenderers) {
        GEO_BLOCK_MAP.forEach { (k, v) ->
            event.registerBlockEntityRenderer(v, GEO_BLOCK_RENDERER_MAP[k] ?: SimpleGeoBlockRenderer(k.id.path))
        }
    }
}
