package club.someoneice.manorsbounty.common.block

import club.someoneice.manorsbounty.init.ModBlocks
import club.someoneice.manorsbounty.init.ModTabs.BUILDING_TAB
import club.someoneice.manorsbounty.init.ModTabs.addToTab
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.*
import net.minecraft.world.level.block.state.BlockBehaviour.Properties
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.properties.BlockSetType
import net.minecraft.world.level.block.state.properties.WoodType
import net.minecraft.world.level.storage.loot.LootParams
import thedarkcolour.kotlinforforge.forge.registerObject
import java.util.function.Supplier

@Suppress("unused")
class WoodBlocks(val name: String, private val fruit: Supplier<Item>? = null) {
    val LOG = "log".toRGName()
    val WOOD = "wood".toRGName()
    val STRIPPED_LOG = "log".toRGName("stripped")
    val STRIPPED_WOOD = "wood".toRGName("stripped")
    val LEAVES = "leaves".toRGName()

    val PLANK = "planks".toRGName()
    val STAIRS = "stairs".toRGName()
    val SLAB = "slab".toRGName()

    val DOOR = "door".toRGName()
    val TRAPDOOR = "trapdoor".toRGName()
    val FENCE = "fence".toRGName()
    val FENCE_GATE = "fence_gate".toRGName()
    val PRESSURE_PLATE = "pressure_plate".toRGName()
    val BUTTON = "button".toRGName()

    val LOG_BLOCK by ModBlocks.REGISTRY.registerObject(LOG, ::getWoodBlock)
    val WOOD_BLOCK by ModBlocks.REGISTRY.registerObject(WOOD, ::getWoodBlock)
    val STRIPPED_LOG_BLOCK by ModBlocks.REGISTRY.registerObject(STRIPPED_LOG, ::getWoodBlock)
    val STRIPPED_WOOD_BLOCK by ModBlocks.REGISTRY.registerObject(STRIPPED_WOOD, ::getWoodBlock)
    val LEAVES_BLOCK by ModBlocks.REGISTRY.registerObject(LEAVES, ::getLeaves)
    val PLANK_BLOCK by ModBlocks.REGISTRY.registerObject(PLANK, ::getPlank)
    val STAIR_BLOCK by ModBlocks.REGISTRY.registerObject(STAIRS, ::getStairs)
    val SLAB_BLOCK by ModBlocks.REGISTRY.registerObject(SLAB, ::getSlab)
    val DOOR_BLOCK by ModBlocks.REGISTRY.registerObject(DOOR, ::getDoor)
    val TRAPDOOR_BLOCK by ModBlocks.REGISTRY.registerObject(TRAPDOOR, ::getTrapdoor)
    val FENCE_BLOCK by ModBlocks.REGISTRY.registerObject(FENCE, ::getFence)
    val FENCE_GATE_BLOCK by ModBlocks.REGISTRY.registerObject(FENCE_GATE, ::getFenceGate)
    val PRESSURE_PLATE_BLOCK by ModBlocks.REGISTRY.registerObject(PRESSURE_PLATE, ::getPressurePlate)
    val BUTTON_BLOCK by ModBlocks.REGISTRY.registerObject(BUTTON, ::getButton)

    val LOG_ITEM by ModBlocks.ITEMS.registerObject(LOG) { BlockItem(LOG_BLOCK, Item.Properties()).addToTab(BUILDING_TAB) }
    val WOOD_ITEM by ModBlocks.ITEMS.registerObject(WOOD) { BlockItem(WOOD_BLOCK, Item.Properties()).addToTab(BUILDING_TAB) }
    val STRIPPED_LOG_ITEM by ModBlocks.ITEMS.registerObject(STRIPPED_LOG) { BlockItem(STRIPPED_LOG_BLOCK, Item.Properties()).addToTab(BUILDING_TAB) }
    val STRIPPED_WOOD_ITEM by ModBlocks.ITEMS.registerObject(STRIPPED_WOOD) { BlockItem(STRIPPED_WOOD_BLOCK, Item.Properties()).addToTab(BUILDING_TAB) }
    val LEAVES_LEAVES by ModBlocks.ITEMS.registerObject(LEAVES) { BlockItem(LEAVES_BLOCK, Item.Properties()).addToTab(BUILDING_TAB) }
    val PLANK_ITEM by ModBlocks.ITEMS.registerObject(PLANK) { BlockItem(PLANK_BLOCK, Item.Properties()).addToTab(BUILDING_TAB) }
    val STAIR_ITEM by ModBlocks.ITEMS.registerObject(STAIRS) { BlockItem(STAIR_BLOCK, Item.Properties()).addToTab(BUILDING_TAB) }
    val SLAB_ITEM by ModBlocks.ITEMS.registerObject(SLAB) { BlockItem(SLAB_BLOCK, Item.Properties()).addToTab(BUILDING_TAB) }
    val DOOR_ITEM by ModBlocks.ITEMS.registerObject(DOOR) { BlockItem(DOOR_BLOCK, Item.Properties()).addToTab(BUILDING_TAB) }
    val TRAPDOOR_ITEM by ModBlocks.ITEMS.registerObject(TRAPDOOR) { BlockItem(TRAPDOOR_BLOCK, Item.Properties()).addToTab(BUILDING_TAB) }
    val FENCE_ITEM by ModBlocks.ITEMS.registerObject(FENCE) { BlockItem(FENCE_BLOCK, Item.Properties()).addToTab(BUILDING_TAB) }
    val FENCE_GATE_ITEM by ModBlocks.ITEMS.registerObject(FENCE_GATE) { BlockItem(FENCE_GATE_BLOCK, Item.Properties()).addToTab(BUILDING_TAB) }
    val PRESSURE_PLATE_ITEM by ModBlocks.ITEMS.registerObject(PRESSURE_PLATE) { BlockItem(PRESSURE_PLATE_BLOCK, Item.Properties()).addToTab(BUILDING_TAB) }
    val BUTTON_ITEM by ModBlocks.ITEMS.registerObject(BUTTON) { BlockItem(BUTTON_BLOCK, Item.Properties()).addToTab(BUILDING_TAB) }

    private fun getWoodBlock() = RotatedPillarBlock(Properties.copy(Blocks.OAK_WOOD))
    private fun getLeaves() = fruit?.let(::FruitLeaf) ?: LeavesBlock(Properties.copy(Blocks.OAK_LEAVES))

    private fun getPlank() = BlockBase(Properties.copy(Blocks.OAK_PLANKS))

    private fun getStairs() = object: StairBlock(Blocks.AIR::defaultBlockState, Properties.copy(Blocks.OAK_STAIRS)) {
        override fun getDrops(pState: BlockState, pParams: LootParams.Builder): List<ItemStack?> {
            return super.getDrops(pState, pParams).also { it.add(Item.byBlock(this).defaultInstance) }
        }
    }

    private fun getSlab() = object: SlabBlock(Properties.copy(Blocks.OAK_SLAB)) {
        override fun getDrops(pState: BlockState, pParams: LootParams.Builder): List<ItemStack?> {
            return super.getDrops(pState, pParams).also { it.add(Item.byBlock(this).defaultInstance) }
        }
    }

    private fun getDoor() = object: DoorBlock(Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK) {
        override fun getDrops(pState: BlockState, pParams: LootParams.Builder): List<ItemStack?> {
            return super.getDrops(pState, pParams).also { it.add(Item.byBlock(this).defaultInstance) }
        }
    }

    private fun getTrapdoor() = object: TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK) {
        override fun getDrops(pState: BlockState, pParams: LootParams.Builder): List<ItemStack?> {
            return super.getDrops(pState, pParams).also { it.add(Item.byBlock(this).defaultInstance) }
        }
    }

    private fun getFence() = object: FenceBlock(Properties.copy(Blocks.OAK_FENCE)) {
        override fun getDrops(pState: BlockState, pParams: LootParams.Builder): List<ItemStack?> {
            return super.getDrops(pState, pParams).also { it.add(Item.byBlock(this).defaultInstance) }
        }
    }

    private fun getFenceGate() = object: FenceGateBlock(Properties.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK) {
        override fun getDrops(pState: BlockState, pParams: LootParams.Builder): List<ItemStack?> {
            return super.getDrops(pState, pParams).also { it.add(Item.byBlock(this).defaultInstance) }
        }
    }

    private fun getPressurePlate() = object: PressurePlateBlock(Sensitivity.EVERYTHING, Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK) {
        override fun getDrops(pState: BlockState, pParams: LootParams.Builder): List<ItemStack?> {
            return super.getDrops(pState, pParams).also { it.add(Item.byBlock(this).defaultInstance) }
        }
    }

    private fun getButton() = object: ButtonBlock(Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true) {
        override fun getDrops(pState: BlockState, pParams: LootParams.Builder): List<ItemStack?> {
            return super.getDrops(pState, pParams).also { it.add(Item.byBlock(this).defaultInstance) }
        }
    }

    private fun String.toRGName() = "${name}_${this}"
    private fun String.toRGName(first: String) = "${first}_${name}_${this}"

}