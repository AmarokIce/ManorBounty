package club.someoneice.manorsbounty.common.tile

import club.someoneice.manorsbounty.asStack
import club.someoneice.manorsbounty.common.menu.IceCreamMachineMenu
import club.someoneice.manorsbounty.init.ModBlocks
import club.someoneice.manorsbounty.init.ModItems
import club.someoneice.manorsbounty.init.ModTile
import com.google.common.collect.Sets
import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag
import net.minecraft.network.chat.Component
import net.minecraft.network.protocol.Packet
import net.minecraft.network.protocol.game.ClientGamePacketListener
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket
import net.minecraft.world.MenuProvider
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraftforge.items.ItemStackHandler
import kotlin.math.min

class TileIceCreamMachine(pPos: BlockPos, pBlockState: BlockState): BlockEntity(ModTile.ICE_CREAM.get(), pPos, pBlockState), MenuProvider {
    var icecream = 0
    val inventory = object: ItemStackHandler(4) {
        override fun getSlotLimit(slot: Int): Int = if (slot == 0) 1 else 64
        override fun isItemValid(slot: Int, stack: ItemStack): Boolean {
            return when(slot){
                0 -> stack.`is`(ModItems.ICE_CREAM_CONE)
                3 -> stack.`is`(ModBlocks.VANILLA_ICE_CREAM.second.get())
                else -> true
            }
        }
    }

    override fun saveAdditional(pTag: CompoundTag) {
        super.saveAdditional(pTag)

        pTag.put("inventory", inventory.serializeNBT())
        pTag.putInt("icecream", icecream)
    }

    override fun load(pTag: CompoundTag) {
        super.load(pTag)
        inventory.deserializeNBT(pTag.getCompound("inventory"))
        icecream = pTag.getInt("icecream")
    }

    override fun getUpdatePacket(): Packet<ClientGamePacketListener> {
        return ClientboundBlockEntityDataPacket.create(this)
    }

    override fun getUpdateTag(): CompoundTag = CompoundTag().apply(::saveAdditional)

    override fun createMenu(pContainerId: Int, pPlayerInventory: Inventory, pPlayer: Player): AbstractContainerMenu =
        IceCreamMachineMenu(pContainerId, this, pPlayerInventory)

    override fun getDisplayName(): Component = Component.empty()


    companion object {
        data class Recipe(
            val item1: ItemStack = ItemStack.EMPTY,
            val item2: ItemStack = ItemStack.EMPTY,
            val output: ItemStack = ModItems.VANILLA_ICE_CREAM.defaultInstance
        )

        val RECIPES = Sets.newHashSet(
            Recipe(),
            Recipe(ModItems.CHOCOLATE.asStack(), output = ModItems.CHOCOLATE_ICE_CREAM.asStack()),
            Recipe(ModItems.STARFRUIT_SLICE.asStack(), output = ModItems.STARFRUIT_ICE_CREAM.asStack()),
            Recipe(ModItems.CHERRY.asStack(), output = ModItems.CHERRIES_ICE_CREAM.asStack()),
            Recipe(ModItems.BLUEBERRY.asStack(), output = ModItems.BLUEBERRY_ICE_CREAM.asStack()),
            Recipe(ModItems.JALPENO.asStack(), output = ModItems.JALAPENO_ICE_CREAM.asStack()),
            Recipe(item2 = ModItems.CHOCOLATE.asStack(), output = ModItems.VANILLA_CHOCOLATE_ICE_CREAM.asStack()),
            Recipe(ModItems.BLUEBERRY.asStack(), ModItems.CHERRY.asStack(), ModItems.BLUEBERRY_CHERRIES_ICE_CREAM.asStack()),
            Recipe(ModItems.STARFRUIT_SLICE.asStack(), ModItems.JALPENO.asStack(), ModItems.STARFRUIT_JALAPENO_ICE_CREAM.asStack()),
        )

        fun tick(world: Level, pos: BlockPos, state: BlockState, tile: TileIceCreamMachine) {
            val item = tile.inventory.getStackInSlot(3)
            if (item.isEmpty || !item.`is`(ModBlocks.VANILLA_ICE_CREAM.second.get()) || tile.icecream == 15) {
                return
            }

            tile.inventory.setStackInSlot(3, Items.BUCKET.defaultInstance)
            tile.icecream = min(15, tile.icecream + 5)
        }
    }
}
