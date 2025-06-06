package club.someoneice.manorsbounty.client.gui

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.common.menu.FryerMenu
import club.someoneice.manorsbounty.common.network.FryerPacket
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.player.Inventory

class FryerScreen(pMenu: FryerMenu, pPlayerInventory: Inventory, pTitle: Component = Component.empty()) : AbstractContainerScreen<FryerMenu>(pMenu, pPlayerInventory, pTitle) {
    companion object {
        fun String.toPath(): ResourceLocation = ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, this)

        val BG = "textures/screens/fryer_gui.png".toPath()
        val HAS_OIL = "textures/screens/fryer_gui_oil_fluid.png".toPath()
        val POT_OUT = "textures/screens/fryer_gui_hob_on.png".toPath()
        val POT_IN = "textures/screens/fryer_gui_hob_in.png".toPath()
        val SLOTS = "textures/screens/fryer_gui_slot.png".toPath()
        val BUTTON = "textures/screens/fryer_gui_still_button.png".toPath()

        val G0 = "textures/screens/fryer_gui_0.png".toPath()

        fun getButton(i: Int): ResourceLocation {
            return if (i >= 8) BUTTON else "textures/screens/fryer_gui_work_botton_${i + 1}.png".toPath()
        }

        fun getOil(i: Int): ResourceLocation {
            return "textures/screens/fryer_gui_oil_${i}.png".toPath()
        }

        fun getAnim(i: Int): ResourceLocation {
            return "textures/screens/fryer_gui_frying_${i + 1}.png".toPath()
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

        fun blit(tx: ResourceLocation, x: Int, y: Int, sizeX: Int, sizeY: Int) {
            gg.blit(tx, baseX + x, baseY + y, 0f, 0f, sizeX, sizeY, sizeX, sizeY)
        }

        blit(BG, 0, 0, 176, 227)

        val oil = this.menu.tile.getOil() / 250
        if (oil > 0) {
            for(i in 1 .. oil) {
                blit(getOil(i), 141, 120 - (i - 1) * 4, 16, 4)
            }
            blit(G0, 140, 59, 7, 61)
        }

        if (this.menu.tile.isWorking() || oil > 0) {
            blit(HAS_OIL, 23, 47, 88, 78)
        }

        if (!this.menu.tile.working) {
            blit(POT_OUT, 25, 5, 84, 132)
            blit(SLOTS, 41, 21, 52, 52)
        } else {
            blit(POT_IN, 25, 25, 84, 102)
            val animTick = this.menu.tile.getCookingTime() / 5
            val tx = getAnim(animTick % 4)
            blit(tx, 51, 68, 32, 32)

            val buttonTick = this.menu.tile.getCookingTime() / 20
            blit(getButton(buttonTick), 140, 4, 18, 18)
        }

        blit(BUTTON, 120, 4, 18, 18)

        val mouseX = pMouseX - baseX
        val mouseY = pMouseY - baseY

        if (mouseX > 140 && mouseX < 158 && mouseY > 56 && mouseY < 123) {
            var count = 0
            for( i in 0 .. 3) {
                val item = this.menu.tile.inventory.getStackInSlot(i)
                if (item.isEmpty) continue
                count += item.count
            }

            val tooltip = Component.translatable("ui.manors_bounty.fryer.oil_amount", this.menu.tile.getOil())
                .append(Component.translatable("\n"))
                .append(Component.translatable("ui.manors_bounty.fryer.oil_consumption", count * 6.25))

            gg.renderTooltip(this.font, tooltip, pMouseX, pMouseY)
        }
    }

    override fun mouseClicked(pMouseX: Double, pMouseY: Double, pButton: Int): Boolean {
        val baseX = (this.width - this.xSize) / 2
        val baseY = (this.height - this.ySize) / 2

        val mouseX = pMouseX - baseX
        val mouseY = pMouseY - baseY

        fun start(): Boolean {
            if (mouseX < 140) {
                return false
            }

            ManorsBounty.MESSAGE_INSTANCE.sendToServer(FryerPacket(this.menu.tile.blockPos))
            return true
        }

        fun end(): Boolean {
            if (mouseX > 137) {
                return false
            }

            ManorsBounty.MESSAGE_INSTANCE.sendToServer(FryerPacket(this.menu.tile.blockPos))
            return true
        }

        if (mouseX > 120 && mouseX < 157 && mouseY > 4 && mouseY < 21) {
            return if (this.menu.tile.isWorking()) end() else start()
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
