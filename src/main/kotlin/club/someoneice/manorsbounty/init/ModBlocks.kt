package club.someoneice.manorsbounty.init

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.addAndReturnSelf
import club.someoneice.manorsbounty.asStack
import club.someoneice.manorsbounty.client.ClientHandler.sendToRenderList
import club.someoneice.manorsbounty.common.block.BlockDragonFruit
import club.someoneice.manorsbounty.common.block.BlockFryer
import club.someoneice.manorsbounty.common.block.BlockOven
import club.someoneice.manorsbounty.common.block.WoodBlocks
import club.someoneice.manorsbounty.common.tile.SimpleGeoBlock
import club.someoneice.manorsbounty.giveOrDropItemStack
import club.someoneice.manorsbounty.init.ModTabs.addToTab
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
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.CakeBlock
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

    fun createBlockWithItem(name: String): Supplier<Block> {
        val block = REGISTRY.registerObject(name) { Block(BlockBehaviour.Properties.copy(Blocks.STONE)) }
        ITEMS.registerObject(name) { BlockItem(block.get(), Properties()).addToTab() }
        return block
    }

    fun createBlockWithItem(name: String, sup: () -> Block): Block {
        val block by REGISTRY.registerObject(name, sup)

        ITEMS.registerObject(name) { BlockItem(block, Properties()) }
        return block
    }

    fun blockWithFood(name: String, hunger: Int, saturation: Float, itemBack: ItemStack = ItemStack.EMPTY, maxStack: Int = 16, boxIndex: Rectangle= Rectangle(0, 0, 16, 16)): Block {
        val block by REGISTRY.registerObject(name) { object: Block(BlockBehaviour.Properties.copy(Blocks.STONE)) {
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

}
