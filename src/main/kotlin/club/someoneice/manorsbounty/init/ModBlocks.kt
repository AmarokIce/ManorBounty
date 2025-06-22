package club.someoneice.manorsbounty.init

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.addAndReturnSelf
import club.someoneice.manorsbounty.asStack
import club.someoneice.manorsbounty.client.ClientHandler.sendToRenderList
import club.someoneice.manorsbounty.common.block.*
import club.someoneice.manorsbounty.common.tile.SimpleGeoBlock
import club.someoneice.manorsbounty.common.tile.SimpleGeoBlockTile
import club.someoneice.manorsbounty.common.tile.SimpleGeoBlockWithFacing
import club.someoneice.manorsbounty.giveOrDropItemStack
import club.someoneice.manorsbounty.init.ModTabs.BUILDING_TAB
import club.someoneice.manorsbounty.init.ModTabs.DEFAULT_TAB
import club.someoneice.manorsbounty.init.ModTabs.TabList
import club.someoneice.manorsbounty.init.ModTabs.addToTab
import club.someoneice.manorsbounty.init.ModTile.push
import net.minecraft.core.BlockPos
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.Item.Properties
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.*
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.storage.loot.LootParams
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.VoxelShape
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject
import java.awt.Rectangle
import java.util.function.Supplier
import kotlin.random.Random

@Suppress("unused")
object ModBlocks {
    val REGISTRY: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, ManorsBounty.ID)
    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, ManorsBounty.ID)

    val BOWL_FOOD_BOX = Rectangle(2, 0, 14, 8)
    val DRINK_FOOD_BOX = Rectangle(5, 0, 11, 14)

    val PINEAPPLE by REGISTRY.registerObject("pineapple", ::createFruitBlock)
    val MUSANG_KING_DURIAN by REGISTRY.registerObject("musang_king_durian", ::createFruitBlock)
    val HAMIMELON by REGISTRY.registerObject("hamimelon", ::blockHamimelon)

    val DRAGON_FRUIT_SLICE  by REGISTRY.registerObject("dragon_fruit_slice_block", ::BlockDragonFruit)

    val MARBLE_BOWL = createBlockWithItem("marble_bowl")
    val BORSCHT = REGISTRY.register("borscht_block", ::SimpleGeoBlock)
    val CREAM_WITH_MUSHROOM_SOUP = REGISTRY.register("cream_with_mushroom_soup_block", ::SimpleGeoBlock)
    val MISO_SOUP = REGISTRY.register("miso_soup_block", ::SimpleGeoBlock)
    val PRAWN_AND_CORN_SOUP = REGISTRY.register("prawn_and_corn_soup_block", ::SimpleGeoBlock)
    val COSMIC_DRAGON_SALAD = REGISTRY.register("cosmic_dragon_salad", ::SimpleGeoBlock)
    val ROSA_SALAD = REGISTRY.register("rosa_salad", ::SimpleGeoBlock)
    val SEA_PEARL_SALAD = REGISTRY.register("sea_pearl_salad", ::SimpleGeoBlock)
    val MELON_SALAD = REGISTRY.register("melon_salad", ::SimpleGeoBlock)

    val FRYER = REGISTRY.register("fryer", ::BlockFryer)
    val OVEN = REGISTRY.register("oven", ::BlockOven)
    val FRYER_ITEM = ITEMS.register("fryer") { BlockItem(FRYER.get(), Properties()).sendToRenderList().addToTab() }
    val OVEN_ITEM = ITEMS.register("oven") { BlockItem(OVEN.get(), Properties()).sendToRenderList().addToTab() }

    val CARAMEL_CHOCOLATE_CAKE = REGISTRY.register("caramel_chocolate_cake") { CakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)) }
    val SWEET_BERRY_CAKE = REGISTRY.register("sweet_berry_cake") { CakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)) }
    val CHORUS_FLOWER_JELLY_CAKE = REGISTRY.register("chorus_flower_jelly_cake") { CakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)) }
    val NETHER_WART_SOUL_CAKE = REGISTRY.register("nether_wart_soul_cake") { CakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)) }
    val CARAMEL_CHOCOLATE_CAKE_ITEM = ITEMS.register("caramel_chocolate_cake") { BlockItem(CARAMEL_CHOCOLATE_CAKE.get(), Properties()).addToTab() }
    val SWEET_BERRY_CAKE_ITEM = ITEMS.register("sweet_berry_cake") { BlockItem(SWEET_BERRY_CAKE.get(), Properties()).addToTab() }
    val CHORUS_FLOWER_JELLY_CAKE_ITEM = ITEMS.register("chorus_flower_jelly_cake") { BlockItem(CHORUS_FLOWER_JELLY_CAKE.get(), Properties()).addToTab() }
    val NETHER_WART_SOUL_CAKE_ITEM = ITEMS.register("nether_wart_soul_cake") { BlockItem(NETHER_WART_SOUL_CAKE.get(), Properties()).addToTab() }

    val SCOTS_PINE = WoodBlocks("scots_pine")
    val CHERRIES = WoodBlocks("cherries_tree")
    val STARFRUIT = WoodBlocks("starfruit_tree")
    val OLIVE = WoodBlocks("olive_tree")
    val RUTECEAE = WoodBlocks("rutaceae_tree")
    val ROASCEAE = WoodBlocks("rosaceae_tree")
    val DURIAN = WoodBlocks("durian_tree")
    val MANGO = WoodBlocks("mango_tree")
    val KIWI = WoodBlocks("kiwifruit_tree")
    val AVOCADO = WoodBlocks("avocado_tree")

    val CHERRIES_PIE = REGISTRY.register("cherries_pie") { BlockBigPie("cherries_pie") { ModItems.CHERRIES_PIE_SLICE } }
    val CHERRIES_PIE_ITEM = ITEMS.register("cherries_pie") { BlockItem(CHERRIES_PIE.get(), Properties()).sendToRenderList().addToTab() }

    val TRUFFLE_PIE = REGISTRY.register("truffle_pie") { BlockBigPie("truffle_pie") { ModItems.TRUFFLE_PIE_SLICE } }
    val TRUFFLE_PIE_ITEM = ITEMS.register("truffle_pie") { BlockItem(TRUFFLE_PIE.get(), Properties()).sendToRenderList().addToTab() }

    val HOUNDSTOOTH_CARPET = REGISTRY.register("houndstooth_carpet") { BlockBigCarpet("houndstooth_carpet") }
    val SHIRAZ_CARPET = REGISTRY.register("shiraz_carpet") { BlockBigCarpet("shiraz_carpet") }
    val MAGIC_CIRCLE_CARPET = REGISTRY.register("magic_circle_carpet") { BlockBigCarpet("magic_circle_carpet") }
    val PICNIC_MAT = REGISTRY.register("picnic_mat") { BlockBigCarpet("picnic_mat") }
    val ITEM_HOUNDSTOOTH_CARPET = ITEMS.register("houndstooth_carpet") { BlockItem(HOUNDSTOOTH_CARPET.get(), Properties()).sendToRenderList().addToTab(BUILDING_TAB) }
    val ITEM_SHIRAZ_CARPET = ITEMS.register("shiraz_carpet") { BlockItem(SHIRAZ_CARPET.get(), Properties()).sendToRenderList().addToTab(BUILDING_TAB) }
    val ITEM_MAGIC_CIRCLE_CARPET = ITEMS.register("magic_circle_carpet") { BlockItem(MAGIC_CIRCLE_CARPET.get(), Properties()).sendToRenderList().addToTab(BUILDING_TAB) }
    val ITEM_PICNIC_MAT = ITEMS.register("picnic_mat") { BlockItem(PICNIC_MAT.get(), Properties()).sendToRenderList().addToTab(BUILDING_TAB) }

    val MARBLE = createBlockWithItem("marble", BUILDING_TAB)
    val POLISHED_MARBLE = createBlockWithItem("polished_marble", BUILDING_TAB)
    val POLISHED_MARBLE_BRICK = createBlockWithItem("polished_marble_brick", BUILDING_TAB)
    val MARBLE_WALL = createBlockWithItem("marble_wall", BUILDING_TAB) { WallBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_WALL)) }
    val POLISHED_MARBLE_WALL = createBlockWithItem("polished_marble_wall", BUILDING_TAB) { WallBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_WALL)) }
    val POLISHED_MARBLE_BRICK_WALL = createBlockWithItem("polished_marble_brick_wall", BUILDING_TAB) { WallBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_WALL)) }
    val MARBLE_SLAB = createBlockWithItem("marble_slab", BUILDING_TAB) { SlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_SLAB)) }
    val POLISHED_MARBLE_SLAB = createBlockWithItem("polished_marble_slab", BUILDING_TAB) { SlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_SLAB)) }
    val POLISHED_MARBLE_BRICK_SLAB = createBlockWithItem("polished_marble_brick_slab", BUILDING_TAB) { SlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_SLAB)) }
    val MARBLE_STAIRS = createBlockWithItem("marble_stairs", BUILDING_TAB) { StairBlock({ MARBLE.get().defaultBlockState() }, BlockBehaviour.Properties.copy(Blocks.BRICK_STAIRS)) }
    val POLISHED_MARBLE_STAIRS = createBlockWithItem("polished_marble_stairs", BUILDING_TAB) { StairBlock({ POLISHED_MARBLE.get().defaultBlockState() }, BlockBehaviour.Properties.copy(Blocks.BRICK_STAIRS)) }
    val POLISHED_MARBLE_BRICK_STAIRS = createBlockWithItem("polished_marble_brick_stairs", BUILDING_TAB) { StairBlock({ POLISHED_MARBLE_BRICK.get().defaultBlockState() }, BlockBehaviour.Properties.copy(Blocks.BRICK_STAIRS)) }

    val SNOW_TERRACOTTA = createBlockWithItem("snow_terracotta", BUILDING_TAB)
    val SNOW_GLAZED_TERRACOTTA = createBlockWithItem("snow_glazed_terracotta", BUILDING_TAB)
    val SNOW_CONCRETE_POWDER = createBlockWithItem("snow_concrete_powder", BUILDING_TAB)
    val SNOW_CONCRETE = createBlockWithItem("snow_concrete", BUILDING_TAB)

    val GIFT_TALL_RED = createGiftWithItem("gift_tall_red", false)
    val GIFT_TALL_GREEN = createGiftWithItem("gift_tall_green", false)
    val GIFT_TALL_BLUE = createGiftWithItem("gift_tall_blue", false)
    val GIFT_TALL_PINK = createGiftWithItem("gift_tall_pink", false)
    val GIFT_TALL_LUCKY = createGiftWithItem("gift_tall_lucky", false)
    val GIFT_SHORT_RED = createGiftWithItem("gift_short_red", true)
    val GIFT_SHORT_GREEN = createGiftWithItem("gift_short_green", true)
    val GIFT_SHORT_BLUE = createGiftWithItem("gift_short_blue", true)
    val GIFT_SHORT_PINK = createGiftWithItem("gift_short_pink", true)
    val GIFT_SHORT_LUCKY = createGiftWithItem("gift_short_lucky", true)

    val CHRISTMAS_WREATHS = createSimpleGeoBlockWithFacing("christmas_wreaths")
    val CHRISTMAS_SOCK = createSimpleGeoBlockWithFacing("christmas_sock")
    val CHRISTMAS_RIBBON_WHITE = createSimpleGeoBlockWithFacing("christmas_ribbon_white")
    val CHRISTMAS_RIBBON_BLUE = createSimpleGeoBlockWithFacing("christmas_ribbon_blue")
    val CHRISTMAS_RIBBON_YELLOW = createSimpleGeoBlockWithFacing("christmas_ribbon_yellow")
    val CHRISTMAS_RIBBON_RED = createSimpleGeoBlockWithFacing("christmas_ribbon_red")


    fun createBlockWithItem(name: String, tab: TabList = DEFAULT_TAB): Supplier<out Block> {
        val block = REGISTRY.register(name, ::BlockBase)
        ITEMS.registerObject(name) { BlockItem(block.get(), Properties()).addToTab(tab) }
        return block
    }

    fun createBlockWithItem(name: String, tab: TabList = DEFAULT_TAB, sup: () -> Block): Supplier<out Block> {
        val block = REGISTRY.registerObject(name, sup)

        ITEMS.registerObject(name) { BlockItem(block.get(), Properties()).addToTab(tab) }
        return block
    }

    fun blockWithFood(name: String, hunger: Int, saturation: Float, itemBack: ItemStack = ItemStack.EMPTY, maxStack: Int = 16, boxIndex: Rectangle= Rectangle(0, 0, 16, 16)): Block {
        val block by REGISTRY.registerObject(name) { object: Block(Properties.copy(Blocks.STONE)) {
            override fun getShape(pState: BlockState, pLevel: BlockGetter, pPos: BlockPos, pContext: CollisionContext): VoxelShape {
                return box(0.0 + boxIndex.x, 0.0 + boxIndex.y, 0.0 + boxIndex.x, 0.0 + boxIndex.width, 0.0 + boxIndex.height, 0.0 + boxIndex.width)
            }
        }}
        ITEMS.registerObject(name) { object: BlockItem(block, Properties().food(
            FoodProperties.Builder()
                .nutrition(hunger)
                .saturationMod(saturation)
                .build())
            .stacksTo(maxStack)) {
                override fun finishUsingItem(pStack: ItemStack, pLevel: Level, pLivingEntity: LivingEntity): ItemStack {
                    if (pLivingEntity is Player) {
                        pLivingEntity.giveOrDropItemStack(itemBack)
                    }
                    return super.finishUsingItem(pStack, pLevel, pLivingEntity)
                }
            }
        }
        return block
    }

    fun createFruitBlock() = object: Block(Properties.copy(Blocks.MELON).instabreak().noOcclusion()) {
        override fun getDrops(pState: BlockState, pParams: LootParams.Builder): MutableList<ItemStack> =
            super.getDrops(pState, pParams).addAndReturnSelf(this.asItem().asStack())
    }

    fun blockHamimelon() = object: Block(Properties.copy(Blocks.MELON).noOcclusion()) {
        override fun getDrops(pState: BlockState, pParams: LootParams.Builder): MutableList<ItemStack> =
            super.getDrops(pState, pParams).addAndReturnSelf(ModItems.HAMIMELON_SLICE.asStack(Random.nextInt(2, 6)))
    }

    private fun createGiftWithItem(name: String, isShort: Boolean): Supplier<out Block> {
        val block = REGISTRY.register(name) { object: SimpleGeoBlock() {
            override fun getShape(pState: BlockState, pLevel: BlockGetter, pPos: BlockPos, pContext: CollisionContext): VoxelShape {
                return box(1.0, 0.0, 1.0, 15.0, if (isShort) 8.0 else 16.0, 15.0)
            }
        }}

        ModTile.REGISTRY.register(name) { BlockEntityType.Builder.of(::SimpleGeoBlockTile, block.get()).build(null).push(block) }
        ITEMS.registerObject(name) { BlockItem(block.get(), Properties()).addToTab(BUILDING_TAB) }
        return block
    }

    private fun createSimpleGeoBlockWithFacing(name: String): Supplier<out Block> {
        val block = REGISTRY.register(name, ::SimpleGeoBlockWithFacing)
        ModTile.REGISTRY.register(name) { BlockEntityType.Builder.of(::SimpleGeoBlockTile, block.get()).build(null).push(block) }

        ITEMS.registerObject(name) { BlockItem(block.get(), Properties()).addToTab(BUILDING_TAB) }
        return block
    }
}
