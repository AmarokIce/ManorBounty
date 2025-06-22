package club.someoneice.manorsbounty.common.tile

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.asStack
import club.someoneice.manorsbounty.init.ModBlocks
import club.someoneice.manorsbounty.init.ModTile
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.block.*
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BlockStateProperties
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

// TODO: Rename the classes. These are all in based not the object!
class SimpleGeoBlockTile(tile: BlockEntityType<out SimpleGeoBlockTile>, pPos: BlockPos, pBlockState: BlockState) : BlockEntity(tile, pPos, pBlockState, ), GeoBlockEntity {
    constructor(pPos: BlockPos, pBlockState: BlockState): this(ModTile.BORSCHT.get(), pPos, pBlockState)

    private val cache: AnimatableInstanceCache = GeckoLibUtil.createInstanceCache(this)

    override fun registerControllers(controllers: AnimatableManager.ControllerRegistrar) {
    }

    override fun getAnimatableInstanceCache(): AnimatableInstanceCache = cache
}

open class SimpleGeoBlock(properties: Properties = Properties.copy(Blocks.STONE).noOcclusion()): BaseEntityBlock(properties) {
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

open class SimpleGeoBlockWithFacing(properties: Properties = Properties.copy(Blocks.STONE).noOcclusion()): SimpleGeoBlock(properties) {
    companion object {
        val FACING = BlockStateProperties.FACING
    }

    init {
        this.registerDefaultState(
            this.stateDefinition.any().setValue(FACING, Direction.NORTH)
        )
    }

    override fun getStateForPlacement(pContext: BlockPlaceContext): BlockState {
        return this.defaultBlockState().setValue(FACING, pContext.horizontalDirection.opposite)
    }

    override fun rotate(pState: BlockState, pRotation: Rotation): BlockState {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)))
    }

    override fun mirror(pState: BlockState, pMirror: Mirror): BlockState {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)))
    }

    override fun createBlockStateDefinition(pBuilder: StateDefinition.Builder<Block, BlockState>) {
        pBuilder.add(FACING)
    }

    override fun getShape(pState: BlockState, pLevel: BlockGetter, pPos: BlockPos, pContext: CollisionContext): VoxelShape {
        val facing = pState.getValue(FACING)
        return when (facing) {
            Direction.EAST -> box(0.0, 0.0, 0.0, 4.0, 16.0, 16.0)
            Direction.SOUTH -> box(0.0, 0.0, 0.0, 16.0, 16.0, 4.0)
            Direction.WEST -> box(12.0, 0.0, 0.0, 16.0, 16.0, 16.0)
            Direction.NORTH -> box(0.0, 0.0, 12.0, 16.0, 16.0, 16.0)
            else -> box(0.0, 0.0, 0.0, 4.0, 16.0, 16.0)
        }
    }
}

class SimpleGeoModel(val name: String): GeoModel<SimpleGeoBlockTile>() {
    override fun getModelResource(animatable: SimpleGeoBlockTile?): ResourceLocation {
        return ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, "geo/${name}.geo.json")
    }

    override fun getTextureResource(animatable: SimpleGeoBlockTile?): ResourceLocation? {
        return ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, "textures/block/${name}.png")
    }

    override fun getAnimationResource(animatable: SimpleGeoBlockTile?): ResourceLocation {
        return ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, "geo/anim/${name}.animation.json")
    }
}

class SimpleGeoBlockRenderer(name: String) : GeoBlockRenderer<SimpleGeoBlockTile>(SimpleGeoModel(name)), BlockEntityRendererProvider<SimpleGeoBlockTile> {
    override fun create(pContext: BlockEntityRendererProvider.Context): BlockEntityRenderer<SimpleGeoBlockTile?> {
        return this
    }
}

val GEO_BLOCK_RENDERER_MAP = HashMap<RegistryObject<out Block>, BlockEntityRendererProvider<SimpleGeoBlockTile>>()
val GEO_BLOCK_MAP = HashMap<RegistryObject<out Block>, BlockEntityType<SimpleGeoBlockTile>>()

fun findTile(block: Block): BlockEntityType<SimpleGeoBlockTile> {
    for (dat in GEO_BLOCK_MAP.keys) {
        if (dat.get() == block) {
            return GEO_BLOCK_MAP[dat]!!
        }
    }

    throw NoSuchElementException("Can't find the tile from block. Did you forget to register to the GEO BLOCK MAP?")
}
