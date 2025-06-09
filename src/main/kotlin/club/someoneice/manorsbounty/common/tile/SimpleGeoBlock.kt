package club.someoneice.manorsbounty.common.tile

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.asStack
import club.someoneice.manorsbounty.init.ModBlocks
import club.someoneice.manorsbounty.init.ModTile
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
import net.minecraft.core.BlockPos
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.block.BaseEntityBlock
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.storage.loot.LootParams
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.VoxelShape
import net.minecraftforge.registries.RegistryObject
import software.bernie.geckolib.animatable.GeoBlockEntity
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.core.animation.AnimatableManager
import software.bernie.geckolib.model.GeoModel
import software.bernie.geckolib.renderer.GeoBlockRenderer
import software.bernie.geckolib.util.GeckoLibUtil

class SimpleGeoBlockTile(tile: BlockEntityType<out SimpleGeoBlockTile>, pPos: BlockPos, pBlockState: BlockState) : BlockEntity(tile, pPos, pBlockState, ), GeoBlockEntity {
    constructor(pPos: BlockPos, pBlockState: BlockState): this(ModTile.BORSCHT.get(), pPos, pBlockState)

    private val cache: AnimatableInstanceCache = GeckoLibUtil.createInstanceCache(this)

    override fun registerControllers(controllers: AnimatableManager.ControllerRegistrar) {
    }

    override fun getAnimatableInstanceCache(): AnimatableInstanceCache = cache
}

class SimpleGeoBlock(): BaseEntityBlock(Properties.copy(Blocks.STONE).noOcclusion()) {
    override fun newBlockEntity(pPos: BlockPos, pState: BlockState): BlockEntity =
        SimpleGeoBlockTile(findTile(this), pPos, pState)

    override fun getDrops(pState: BlockState, pParams: LootParams.Builder): List<ItemStack?> {
        val list = super.getDrops(pState, pParams)
        list.add(this.asStack())
        return list
    }

    override fun getShape(pState: BlockState, pLevel: BlockGetter, pPos: BlockPos, pContext: CollisionContext): VoxelShape {
        val boxIndex = ModBlocks.BOWL_FOOD_BOX
        return box(0.0 + boxIndex.x, 0.0 + boxIndex.y, 0.0 + boxIndex.x, 0.0 + boxIndex.width, 0.0 + boxIndex.height, 0.0 + boxIndex.width)
    }
}

class SimpleGeoModel(val name: String): GeoModel<SimpleGeoBlockTile>() {
    override fun getModelResource(animatable: SimpleGeoBlockTile?): ResourceLocation {
        return ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, "geo/model/block/${name}.geo.json")
    }

    override fun getTextureResource(animatable: SimpleGeoBlockTile?): ResourceLocation? {
        return ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, "geo/texture/block/${name}.png")
    }

    override fun getAnimationResource(animatable: SimpleGeoBlockTile?): ResourceLocation {
        return ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, "geo/anim/block/${name}.animation.json")
    }
}

class SimpleGeoBlockRenderer(name: String) : GeoBlockRenderer<SimpleGeoBlockTile>(SimpleGeoModel(name)), BlockEntityRendererProvider<SimpleGeoBlockTile> {
    override fun create(pContext: BlockEntityRendererProvider.Context): BlockEntityRenderer<SimpleGeoBlockTile?> {
        return this
    }
}

val GEO_BLOCK_MAP = HashMap<RegistryObject<out Block>, BlockEntityType<SimpleGeoBlockTile>>()

fun findTile(block: Block): BlockEntityType<SimpleGeoBlockTile> {
    for (dat in GEO_BLOCK_MAP.keys) {
        if (dat.get() == block) {
            return GEO_BLOCK_MAP[dat]!!
        }
    }

    throw NoSuchElementException("Here will not happen.")
}
