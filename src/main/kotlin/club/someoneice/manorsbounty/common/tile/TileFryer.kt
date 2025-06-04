package club.someoneice.manorsbounty.common.tile

import club.someoneice.manorsbounty.asStack
import club.someoneice.manorsbounty.common.menu.FryerMenu
import club.someoneice.manorsbounty.common.block.BlockFryer
import club.someoneice.manorsbounty.init.ModItems
import club.someoneice.manorsbounty.init.ModTile
import club.someoneice.manorsbounty.odds
import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag
import net.minecraft.network.chat.Component
import net.minecraft.network.protocol.Packet
import net.minecraft.network.protocol.game.ClientGamePacketListener
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket
import net.minecraft.world.MenuProvider
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraftforge.items.ItemStackHandler
import kotlin.math.min

class TileFryer(pPos: BlockPos, pBlockState: BlockState) : BlockEntity(ModTile.FRYER.get(), pPos, pBlockState), MenuProvider {
    val inventory = object: ItemStackHandler(5) {
        override fun getSlotLimit(slot: Int): Int = if (slot == 4) 64 else  4
    }

    internal var working = false
    internal var cookingTime = 0
    internal var oil = 0

    fun setOil(oil: Int) {
        this.oil = oil
    }

    fun changedWorkingState() {
        if (!this.working) {
            if (this.getOil() < 250) {
                return
            }

            var count = 0
            for( i in 0 .. 3) {
                val item = this.inventory.getStackInSlot(i)
                if (item.isEmpty) continue
                count += item.count
            }


            if (count == 0) {
                return
            }

            if ((count * 0.0625).odds()) {
                this.setOil(this.getOil() - 250)
            }

            this.working = true
            return
        }

        for(i in 0..3) {
            this.inventory.setStackInSlot(i, getItemByRecipe(this, this.inventory.getStackInSlot(i)))
        }

        this.working = false
        this.cookingTime = 0
    }

    fun getOil(): Int = this.oil
    fun isWorking(): Boolean = this.working
    fun getCookingTime() = this.cookingTime

    fun addTime() {
        if (this.cookingTime < 300) {
            this.cookingTime++
        }
    }

    fun getCookingState(): Int {
        return when {
            this.cookingTime < 100 -> 0
            this.cookingTime < 200 -> 1
            this.cookingTime < 300 -> 2
            else -> 3
        }
    }

    override fun saveAdditional(pTag: CompoundTag) {
        super.saveAdditional(pTag)
        pTag.put("inventory", inventory.serializeNBT())
        pTag.putInt("oil", this.oil)
        pTag.putInt("cookingTime", this.cookingTime)
        pTag.putBoolean("isWorking", this.isWorking())
    }

    override fun load(pTag: CompoundTag) {
        super.load(pTag)
        inventory.deserializeNBT(pTag.getCompound("inventory"))
        this.oil = pTag.getInt("oil")
        this.cookingTime = pTag.getInt("cookingTime")
        this.working = pTag.getBoolean("isWorking")
    }

    override fun getUpdatePacket(): Packet<ClientGamePacketListener> {
        return ClientboundBlockEntityDataPacket.create(this)
    }

    override fun getUpdateTag(): CompoundTag = CompoundTag().apply(::saveAdditional)
    override fun getDisplayName(): Component = Component.empty()

    override fun createMenu(pContainerId: Int, pPlayerInventory: Inventory, pPlayer: Player): AbstractContainerMenu? {
        return FryerMenu(pContainerId, this, pPlayerInventory)
    }

    companion object {
        val OIL = HashMap<Item, Int>()
        val RECIPE = HashMap<Item, Pair<ItemStack, ItemStack>>()

        fun initRecipe() {
            OIL.put(ModItems.OIL_BUCKET, 1000)
            OIL.put(ModItems.OIL, 500)

            RECIPE.put(Items.CHICKEN, Pair(Items.COOKED_CHICKEN.asStack(), ModItems.FRIED_CHICKEN.asStack()))
            RECIPE.put(Items.PORKCHOP, Pair(Items.COOKED_PORKCHOP.asStack(), ModItems.FRIED_PORKCHOP.asStack()))
            RECIPE.put(Items.BEEF, Pair(Items.COOKED_BEEF.asStack(), ModItems.FRIED_STEAK.asStack()))
            RECIPE.put(Items.MUTTON, Pair(Items.COOKED_MUTTON.asStack(), ModItems.FRIED_FISH.asStack()))
            RECIPE.put(Items.COD, Pair(Items.COOKED_COD.asStack(), ModItems.FRIED_FISH.asStack()))
            RECIPE.put(Items.BREAD, Pair(Items.BREAD.asStack(), ModItems.DONUT.asStack()))
            RECIPE.put(ModItems.PINEAPPLE_SLICE, Pair(ModItems.PINEAPPLE_PASTRIES.asStack(), ModItems.PINEAPPLE_PIE.asStack()))
            RECIPE.put(ModItems.DURIAN_MILE_CREPE_CAKE_SLICE, Pair(ModItems.COOKED_DURIAN_FLESH.asStack(), ModItems.DURIAN_CRISP.asStack()))
        }

        private fun setOil(tile: TileFryer, world: Level) {
            val state = world.getBlockState(tile.blockPos)
            if (tile.oil == 0 && state.getValue(BlockFryer.OIL)) {
                world.setBlockAndUpdate(tile.blockPos, state.setValue(BlockFryer.OIL, false))
            }

            if (tile.oil == 4000) {
                return
            }

            val item = tile.inventory.getStackInSlot(4)
            val recipe = OIL.get(item.item) ?: return
            tile.oil = min(tile.oil + recipe, 4000)

            if (!state.getValue(BlockFryer.OIL)) {
                world.setBlockAndUpdate(tile.blockPos, state.setValue(BlockFryer.OIL, true))
            }

            item.shrink(1)
            if (!item.hasCraftingRemainingItem()) {
                return
            }

            val bk = item.craftingRemainingItem
            if (item.isEmpty) {
                tile.inventory.setStackInSlot(4, bk)
                return
            }

            val pos = tile.blockPos
            val entity = ItemEntity(world, pos.x.toDouble() + 0.5, pos.y.toDouble() + 1, pos.z.toDouble() + 0.5 ,bk)
            world.addFreshEntity(entity)
        }

        fun getItemByRecipe(tile: TileFryer, item: ItemStack): ItemStack {
            val recipe = RECIPE.get(item.item) ?: return Items.CHARCOAL.asStack(item.count)
            return when(tile.getCookingState()) {
                0 -> item
                1 -> recipe.first.copyWithCount(item.count)
                2 -> recipe.second.copyWithCount(item.count)
                else -> Items.CHARCOAL.asStack(item.count)
            }
        }

        @Suppress("unused")
        fun tick(world: Level, pos: BlockPos, state: BlockState, tile: TileFryer) {
            setOil(tile, world)
            if (tile.isWorking()) {
                tile.addTime()
            }
        }
    }
}