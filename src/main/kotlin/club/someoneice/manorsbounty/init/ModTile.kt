package club.someoneice.manorsbounty.init

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.common.block.RendererBigPie
import club.someoneice.manorsbounty.common.block.RendererCarpet
import club.someoneice.manorsbounty.common.tile.*
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

@Suppress("unused")
object ModTile {
    val REGISTRY: DeferredRegister<BlockEntityType<*>> =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ManorsBounty.ID)

    val BORSCHT: RegistryObject<BlockEntityType<out SimpleGeoBlockTile>> = REGISTRY.register("borscht_block") { BlockEntityType.Builder.of(::SimpleGeoBlockTile, ModBlocks.BORSCHT.get()).build(null).push(ModBlocks.BORSCHT) }
    val CREAM_WITH_MUSHROOM_SOUP: RegistryObject<BlockEntityType<out SimpleGeoBlockTile>> = REGISTRY.register("cream_with_mushroom_soup_block") { BlockEntityType.Builder.of(::SimpleGeoBlockTile, ModBlocks.CREAM_WITH_MUSHROOM_SOUP.get()).build(null).push(ModBlocks.CREAM_WITH_MUSHROOM_SOUP) }
    val MISO_SOUP: RegistryObject<BlockEntityType<out SimpleGeoBlockTile>> = REGISTRY.register("miso_soup_block") { BlockEntityType.Builder.of(::SimpleGeoBlockTile, ModBlocks.MISO_SOUP.get()).build(null).push(ModBlocks.MISO_SOUP) }
    val PRAWN_AND_CORN_SOUP: RegistryObject<BlockEntityType<out SimpleGeoBlockTile>> = REGISTRY.register("prawn_and_corn_soup_block") { BlockEntityType.Builder.of(::SimpleGeoBlockTile, ModBlocks.PRAWN_AND_CORN_SOUP.get()).build(null).push(ModBlocks.PRAWN_AND_CORN_SOUP) }
    val COSMIC_DRAGON_SALAD: RegistryObject<BlockEntityType<out SimpleGeoBlockTile>> = REGISTRY.register("cosmic_dragon_salad") { BlockEntityType.Builder.of(::SimpleGeoBlockTile, ModBlocks.COSMIC_DRAGON_SALAD.get()).build(null).push(ModBlocks.COSMIC_DRAGON_SALAD) }
    val ROSA_SALAD: RegistryObject<BlockEntityType<out SimpleGeoBlockTile>> = REGISTRY.register("rosa_salad") { BlockEntityType.Builder.of(::SimpleGeoBlockTile, ModBlocks.ROSA_SALAD.get()).build(null).push(ModBlocks.ROSA_SALAD) }
    val SEA_PEARL_SALAD: RegistryObject<BlockEntityType<out SimpleGeoBlockTile>> = REGISTRY.register("sea_pearl_salad") { BlockEntityType.Builder.of(::SimpleGeoBlockTile, ModBlocks.SEA_PEARL_SALAD.get()).build(null).push(ModBlocks.SEA_PEARL_SALAD) }
    val MELON_SALAD: RegistryObject<BlockEntityType<out SimpleGeoBlockTile>> = REGISTRY.register("melon_salad") { BlockEntityType.Builder.of(::SimpleGeoBlockTile, ModBlocks.MELON_SALAD.get()).build(null).push(ModBlocks.MELON_SALAD) }

    val FRYER = REGISTRY.register("fryer_tile") { BlockEntityType.Builder.of(::TileFryer, ModBlocks.FRYER.get()).build(null) }
    val OVEN = REGISTRY.register("oven_tile") { BlockEntityType.Builder.of(::TileOven, ModBlocks.OVEN.get()).build(null) }

    val CHERRIES_PIE: RegistryObject<BlockEntityType<out SimpleGeoBlockTile>> = REGISTRY.register("cherries_pie") { BlockEntityType.Builder.of(::SimpleGeoBlockTile, ModBlocks.CHERRIES_PIE.get()).build(null).push(ModBlocks.CHERRIES_PIE, RendererBigPie()) }
    val TRUFFLE_PIE: RegistryObject<BlockEntityType<out SimpleGeoBlockTile>> = REGISTRY.register("truffle_pie") { BlockEntityType.Builder.of(::SimpleGeoBlockTile, ModBlocks.TRUFFLE_PIE.get()).build(null).push(ModBlocks.TRUFFLE_PIE, RendererBigPie()) }

    val HOUNDSTOOTH_CARPET = REGISTRY.register("houndstooth_carpet") { BlockEntityType.Builder.of(::SimpleGeoBlockTile, ModBlocks.HOUNDSTOOTH_CARPET.get()).build(null).push(ModBlocks.HOUNDSTOOTH_CARPET, RendererCarpet()) }
    val SHIRAZ_CARPET = REGISTRY.register("shiraz_carpet") { BlockEntityType.Builder.of(::SimpleGeoBlockTile, ModBlocks.SHIRAZ_CARPET.get()).build(null).push(ModBlocks.SHIRAZ_CARPET, RendererCarpet()) }
    val MAGIC_CIRCLE_CARPET = REGISTRY.register("magic_circle_carpet") { BlockEntityType.Builder.of(::SimpleGeoBlockTile, ModBlocks.MAGIC_CIRCLE_CARPET.get()).build(null).push(ModBlocks.MAGIC_CIRCLE_CARPET, RendererCarpet()) }
    val PICNIC_MAT = REGISTRY.register("picnic_mat") { BlockEntityType.Builder.of(::SimpleGeoBlockTile, ModBlocks.PICNIC_MAT.get()).build(null).push(ModBlocks.PICNIC_MAT, RendererCarpet()) }

    fun BlockEntityType<SimpleGeoBlockTile>.push(block: RegistryObject<out Block>, render: BlockEntityRendererProvider<SimpleGeoBlockTile>? = null): BlockEntityType<out SimpleGeoBlockTile> {
        GEO_BLOCK_MAP[block] = this
        render?.let {
            GEO_BLOCK_RENDERER_MAP[block] = render
        }
        return this
    }
}
