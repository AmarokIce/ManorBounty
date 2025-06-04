package club.someoneice.manorsbounty.common.menu

import club.someoneice.manorsbounty.common.tile.TileFryer
import club.someoneice.manorsbounty.init.ModMenus
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.Slot
import net.minecraft.world.item.ItemStack
import net.minecraftforge.items.SlotItemHandler

class FryerMenu(pContainerId: Int, val tile: TileFryer, val playerInv: Inventory) : AbstractContainerMenu(ModMenus.FRYER, pContainerId) {
    constructor(id: Int, inv: Inventory, buf: FriendlyByteBuf): this(id, inv.player.level().getBlockEntity(buf.readBlockPos()) as TileFryer, inv)

    init {
        if (!tile.working) {
            this.addSlot(SlotItemHandler(this.tile.inventory, 0, 42, 22))
            this.addSlot(SlotItemHandler(this.tile.inventory, 1, 76, 22))
            this.addSlot(SlotItemHandler(this.tile.inventory, 2, 42, 56))
            this.addSlot(SlotItemHandler(this.tile.inventory, 3, 76, 56))
        }

        this.addSlot(SlotItemHandler(this.tile.inventory, 4, 141, 35))
        addPlayerInventory()
        addPlayerHotBar()
    }

    private fun addPlayerInventory() {
        for (i in 0..2) for (l in 0..8) {
            this.addSlot(Slot(playerInv, 9 + l + i * 9, 8 + l * 18, 145 + i * 18))
        }
    }

    private fun addPlayerHotBar() {
        for (i in 0..8) {
            this.addSlot(Slot(playerInv, i, 8 + i * 18, 203))
        }
    }

    override fun quickMoveStack(player: Player, index: Int): ItemStack {
        val sourceSlot = this.slots[index]
        if (!sourceSlot.hasItem()) return ItemStack.EMPTY

        val sourceStack = sourceSlot.item
        val copyOfSourceStack = sourceStack.copy()

        if (index < 36) {
            if (!this.moveItemStackTo(sourceStack, 36, 36, false)) return ItemStack.EMPTY
        } else return ItemStack.EMPTY

        if (sourceStack.count == 0) sourceSlot.set(ItemStack.EMPTY)
        else sourceSlot.setChanged()

        sourceSlot.onTake(player, sourceStack)
        return copyOfSourceStack
    }

    override fun stillValid(pPlayer: Player): Boolean = pPlayer.isAlive && pPlayer.onPos.distSqr(this.tile.blockPos) < 8
}
