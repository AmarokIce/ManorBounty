package club.someoneice.manorsbounty.client.gui

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.common.menu.OvenMenu
import club.someoneice.manorsbounty.common.network.FryerPacket
import club.someoneice.manorsbounty.common.network.OvenPacket
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.player.Inventory
import java.awt.Color

class OvenScreen(pMenu: OvenMenu, pPlayerInventory: Inventory, pTitle: Component = Component.empty()) : AbstractContainerScreen<OvenMenu>(pMenu,
    pPlayerInventory, pTitle, ) {
    companion object {
        fun String.toPath(): ResourceLocation = ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, this)

        val BG = "textures/screens/oven_gui_background.png".toPath()
        val DOOR = "textures/screens/oven_gui_door.png".toPath()
        val SLOTS = "textures/screens/oven_gui_slot.png".toPath()

        val G0 = "textures/screens/fryer_gui_0.png".toPath()

        fun getButton(i: Int): ResourceLocation {
            return "textures/screens/oven_gui_botton${i + 1}.png".toPath()
        }
    }

    init {
        this.imageWidth = 176
        this.imageHeight = 227
    }


    override fun renderBg(gg: GuiGraphics, pPartialTick: Float, pMouseX: Int, pMouseY: Int) {
        gg.setColor(1.0f, 1.0f, 1.0f, 1.0f)

        val baseX = (this.width - this.xSize) / 2
        val baseY = (this.height - this.ySize) / 2
        val tile = this.menu.tile

        fun blit(tx: ResourceLocation, x: Int, y: Int, sizeX: Int, sizeY: Int) {
            gg.blit(tx, baseX + x, baseY + y, 0f, 0f, sizeX, sizeY, sizeX, sizeY)
        }

        blit(BG, 0, 0, 176, 227)

        blit(getButton(tile.temperature), 30, 3, 24, 24)

        if (!tile.isWorking()) {
            blit(getButton(tile.timer), 122, 3, 24, 24)
            blit(SLOTS, 63, 50, 50, 44)
            return
        }

        blit(DOOR, 15, 28, 144, 108)
        blit(getButton(tile.timer - tile.cookingTime / 100), 122, 3, 24, 24)
    }

    override fun mouseClicked(pMouseX: Double, pMouseY: Double, pButton: Int): Boolean {
        if (this.menu.tile.isWorking()) {
            return super.mouseClicked(pMouseX, pMouseY, pButton)
        }

        val baseX = (this.width - this.xSize) / 2
        val baseY = (this.height - this.ySize) / 2

        val mouseX = pMouseX - baseX
        val mouseY = pMouseY - baseY

        if (mouseY > 9 && mouseY < 22) {
            if (mouseX > 34 && mouseX < 49) {
                ManorsBounty.MESSAGE_INSTANCE.sendToServer(OvenPacket(this.menu.tile.blockPos, 0))
            } else if (mouseX > 126 && mouseX < 141) {
                ManorsBounty.MESSAGE_INSTANCE.sendToServer(OvenPacket(this.menu.tile.blockPos, 1))
            }

            return true
        }

        if (mouseX > 56 && mouseX < 118 && mouseY > 31 && mouseY < 41) {
            ManorsBounty.MESSAGE_INSTANCE.sendToServer(OvenPacket(this.menu.tile.blockPos, 2))
            return true
        }

        return super.mouseClicked(pMouseX, pMouseY, pButton)
    }

    override fun render(pGuiGraphics: GuiGraphics, pMouseX: Int, pMouseY: Int, pPartialTick: Float) {
        this.renderBackground(pGuiGraphics)
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick)
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY)
    }

    override fun renderLabels(gg: GuiGraphics, pMouseX: Int, pMouseY: Int) {
        gg.drawString(this.font, (this.menu.tile.temperature * 50 + 100).toString(), 70, 10, Color.WHITE.rgb)
        gg.drawString(this.font, (this.menu.tile.timer * 5).toString() + "s", 94, 10, Color.WHITE.rgb)
    }
}