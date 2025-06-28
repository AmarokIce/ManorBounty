package club.someoneice.manorsbounty.client.gui

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.common.menu.IceCreamMachineMenu
import club.someoneice.manorsbounty.common.network.IceCreamPacket
import club.someoneice.manorsbounty.init.ModItems
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.util.Mth
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.item.Item
import net.minecraftforge.registries.ForgeRegistries
import java.util.*

class IceCreamMachineScreen(pMenu: IceCreamMachineMenu, pPlayerInventory: Inventory, pTitle: Component = Component.empty()): AbstractContainerScreen<IceCreamMachineMenu>(pMenu, pPlayerInventory, pTitle) {
    companion object {
        fun String.toPath(): ResourceLocation = ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, this)

        val BG = "textures/screens/ice_cream_machine_gui.png".toPath()
        val BUTTON = "textures/screens/ice_cream_machine_gui_button_on.png".toPath()
        val ICE_CREAM_CONE = "textures/screens/ice_cream_machine_gui_cone.png".toPath()

        fun getIceCream(i: Item): ResourceLocation {
            val name = ForgeRegistries.ITEMS.getKey(i)
            if (Objects.isNull(name) || !name!!.path.endsWith("_ice_cream")) {
                return "textures/screens/ice_cream_full_vanilla.png".toPath()
            }

            val creamName = name.path.replace("_ice_cream", "")
            return "textures/screens/ice_cream_full_${creamName}.png".toPath()
        }

        fun getIceCreamFluid(i: Int): ResourceLocation {
            val value = Mth.clamp(i + 1, 1, 15)
            return "textures/screens/ice_cream_fluid_${value}.png".toPath()
        }
    }

    init {
        this.imageWidth = 176
        this.imageHeight = 227
    }

    override fun renderBg(gg: GuiGraphics, pPartialTick: Float, pMouseX: Int, pMouseY: Int) {
        gg.setColor(1.0f, 1.0f, 1.0f, 1.0f)

        val tile = this.menu.tile

        val baseX = (this.width - this.xSize) / 2
        val baseY = (this.height - this.ySize) / 2

        fun blit(tx: ResourceLocation, x: Int, y: Int, sizeX: Int, sizeY: Int) {
            gg.blit(tx, baseX + x, baseY + y, 0f, 0f, sizeX, sizeY, sizeX, sizeY)
        }

        blit(BG, 0, 0, 176, 227)

        val itemIceCream = tile.inventory.getStackInSlot(0)
        if (!itemIceCream.isEmpty) {
            blit(ICE_CREAM_CONE, 21, 68, 50, 48)

            if (!itemIceCream.`is`(ModItems.ICE_CREAM_CONE)) {
                val rl = getIceCream(itemIceCream.item)
                blit(rl, 24, 45, 45, 45)
            }
        }

        val icecream = tile.icecream
        if (icecream != 0) {
            val rl = getIceCreamFluid(icecream)
            blit(rl, 100, 15, 32, 45)
        }

        val mouseX = pMouseX - baseX
        val mouseY = pMouseY - baseY

        if (mouseX > 26 && mouseY > 5 && mouseX < 65 && mouseY < 38) {
            blit(BUTTON, 26, 5, 40, 34)
        }
    }

    override fun mouseClicked(pMouseX: Double, pMouseY: Double, pButton: Int): Boolean {
        val baseX = (this.width - this.xSize) / 2
        val baseY = (this.height - this.ySize) / 2

        val mouseX = pMouseX - baseX
        val mouseY = pMouseY - baseY

        if (mouseX > 26 && mouseY > 5 && mouseX < 65 && mouseY < 38) {
            ManorsBounty.MESSAGE_INSTANCE.sendToServer(IceCreamPacket(this.menu.tile.blockPos))
            return true
        }

        return super.mouseClicked(pMouseX, pMouseY, pButton)
    }

    override fun render(pGuiGraphics: GuiGraphics, pMouseX: Int, pMouseY: Int, pPartialTick: Float) {
        this.renderBackground(pGuiGraphics)
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick)
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY)
    }

    override fun renderLabels(pGuiGraphics: GuiGraphics, pMouseX: Int, pMouseY: Int) {
        // Do nothing.
    }
}
