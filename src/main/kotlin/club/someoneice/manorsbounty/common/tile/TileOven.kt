package club.someoneice.manorsbounty.common.tile

import club.someoneice.manorsbounty.asStack
import club.someoneice.manorsbounty.common.menu.OvenMenu
import club.someoneice.manorsbounty.init.ModItems
import club.someoneice.manorsbounty.init.ModTile
import net.minecraft.core.BlockPos
import net.minecraft.core.NonNullList
import net.minecraft.core.registries.Registries
import net.minecraft.nbt.CompoundTag
import net.minecraft.network.chat.Component
import net.minecraft.network.protocol.Packet
import net.minecraft.network.protocol.game.ClientGamePacketListener
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.MenuProvider
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraftforge.common.util.RecipeMatcher
import net.minecraftforge.items.ItemStackHandler

class TileOven(pPos: BlockPos, pBlockState: BlockState) : BlockEntity(ModTile.OVEN.get(), pPos, pBlockState), MenuProvider {
    val inventory = object: ItemStackHandler(5) {
        override fun getSlotLimit(slot: Int): Int = if (slot == 4) 64 else 1
    }

    internal var working = false
    internal var temperature = 0
    internal var timer = 0
    internal var cookingTime = 0

    fun isWorking() = this.working
    fun getTemperatureSetting() = this.temperature
    fun getCookingTime() = this.cookingTime

    fun changedState() {
        if (!this.working) {
            if (!this.inventory.getStackInSlot(4).isEmpty
                || this.timer == 0
                || this.temperature == 0) {
                return
            }

            for(i in 0 .. 3) {
                if (!this.inventory.getStackInSlot(i).isEmpty) {
                    this.working = true
                    return
                }
            }

            return
        }

        val out = RECIPES.firstOrNull(::match)?.out?.copy() ?: Items.CHARCOAL.asStack()
        for(i in 0..3) {
            val item = this.inventory.getStackInSlot(i)
            if (item.isEmpty) {
                continue
            }
            item.shrink(1)
        }

        this.inventory.setStackInSlot(4, out)
        this.working = false
    }

    fun addTime() {
        if (this.cookingTime <= timer * 5) {
            this.cookingTime++
        }

        changedState()
    }

    private fun match(recipe: Recipe): Boolean = recipe.match(this)

    override fun saveAdditional(pTag: CompoundTag) {
        super.saveAdditional(pTag)
        pTag.put("inventory", inventory.serializeNBT())
        pTag.putBoolean("isWorking", this.working)
        pTag.putInt("cookingTime", this.cookingTime)
        pTag.putInt("timer", this.timer)
        pTag.putInt("temperature", this.temperature)
    }

    override fun load(pTag: CompoundTag) {
        super.load(pTag)
        inventory.deserializeNBT(pTag.getCompound("inventory"))
        this.working = pTag.getBoolean("isWorking")
        this.cookingTime = pTag.getInt("cookingTime")
        this.timer = pTag.getInt("timer")
        this.temperature = pTag.getInt("temperature")
    }

    override fun getUpdatePacket(): Packet<ClientGamePacketListener> {
        return ClientboundBlockEntityDataPacket.create(this)
    }

    override fun getUpdateTag(): CompoundTag = CompoundTag().apply(::saveAdditional)
    override fun getDisplayName(): Component = Component.empty()

    override fun createMenu(pContainerId: Int, pPlayerInventory: Inventory, pPlayer: Player): AbstractContainerMenu =
        OvenMenu(pContainerId, this, pPlayerInventory)

    companion object {
        data class Recipe(
            val out: ItemStack,
            val items: NonNullList<Ingredient>,
            val time: Int,
            val temp: Int
        ) {
            fun match(tile: TileOven): Boolean {
                val time = tile.getCookingTime()
                val temp = tile.getTemperatureSetting()

                if (time != this.time || temp != this.temp) {
                    return false
                }

                val input = arrayListOf<ItemStack>()
                for(i in 0 ..3 ) {
                    val item = tile.inventory.getStackInSlot(i)
                    input.add(item)
                }
                return RecipeMatcher.findMatches(input, this.items) != null
            }
        }

        val RECIPES = HashSet<Recipe>()

        @Suppress("unused")
        fun tick(world: Level, pos: BlockPos, state: BlockState, tile: TileOven) {
            if (world.isClientSide || !tile.isWorking()) {
                return
            }

            tile.addTime()
        }

        fun initRecipes() {
            RECIPES.add(Recipe(
                ModItems.BLUEBERRY_COOKIE.asStack(6),
                NonNullList.of(Ingredient.EMPTY,
                    Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.parse("forge:dough/wheat"))),
                    Ingredient.of(ModItems.BLUEBERRY.asStack())
                ),
                2, 2
            ))
            RECIPES.add(Recipe(
                Items.BREAD.asStack(2),
                NonNullList.of(Ingredient.EMPTY,
                    Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.parse("forge:dough/wheat")))),
                1, 1
            ))
            RECIPES.add(Recipe(
                Items.CAKE.asStack(),
                NonNullList.of(Ingredient.EMPTY,
                    Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.parse("forge:dough/wheat"))),
                    Ingredient.of(Items.MILK_BUCKET.asStack()),
                    Ingredient.of(Items.SUGAR.asStack())
                ),
                1, 3
            ))
            RECIPES.add(Recipe(
                Items.COOKIE.asStack(12),
                NonNullList.of(Ingredient.EMPTY,
                    Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.parse("forge:dough/wheat"))),
                    Ingredient.of(Items.COCOA_BEANS.asStack())
                ),
                2, 2
            ))
            RECIPES.add(Recipe(
                ModItems.CRANBERRY_COOKIE.asStack(6),
                NonNullList.of(Ingredient.EMPTY,
                    Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.parse("forge:dough/wheat"))),
                    Ingredient.of(ModItems.CRANBERRY.asStack())
                ),
                2, 2
            ))
            RECIPES.add(Recipe(
                ModItems.LEMON_COOKIE.asStack(6),
                NonNullList.of(Ingredient.EMPTY,
                    Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.parse("forge:dough/wheat"))),
                    Ingredient.of(ModItems.LEMON_SLICE.asStack())
                ),
                2, 2
            ))
            RECIPES.add(Recipe(
                Items.PUMPKIN_PIE.asStack(2),
                NonNullList.of(Ingredient.EMPTY,
                    Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.parse("forge:egg"))),
                    Ingredient.of(Items.PUMPKIN),
                    Ingredient.of(Items.PUMPKIN),
                    Ingredient.of(Items.SUGAR)
                ),
                2, 3
            ))
        }
    }
}
