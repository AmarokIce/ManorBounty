package club.someoneice.manorsbounty.common.block

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.common.tile.SimpleGeoBlock
import club.someoneice.manorsbounty.common.tile.SimpleGeoBlockTile
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ShovelItem
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.Mirror
import net.minecraft.world.level.block.Rotation
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.minecraft.world.level.block.state.properties.BooleanProperty
import net.minecraft.world.phys.BlockHitResult
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.VoxelShape
import software.bernie.geckolib.model.GeoModel
import software.bernie.geckolib.renderer.GeoBlockRenderer

class BlockCarpet: Block(Properties.copy(Blocks.WHITE_CARPET).noOcclusion()) {
    override fun getShape(pState: BlockState, pLevel: BlockGetter, pPos: BlockPos, pContext: CollisionContext): VoxelShape {
        return box(0.0, 0.0, 0.0, 0.0, 15.0, 0.0)
    }
}

class BlockBigCarpet(val name: String): SimpleGeoBlock(Properties.copy(Blocks.WHITE_CARPET)) {
    companion object {
        val UP: BooleanProperty = BooleanProperty.create("up")
        val FACING = BlockStateProperties.FACING
    }

    init {
        this.registerDefaultState(
            this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(UP, false)
        )
    }

    override fun getStateForPlacement(pContext: BlockPlaceContext): BlockState {
        return this.defaultBlockState().setValue(FACING, pContext.horizontalDirection.opposite)
    }

    override fun use(pState: BlockState, pLevel: Level, pPos: BlockPos, pPlayer: Player, pHand: InteractionHand, pHit: BlockHitResult): InteractionResult {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS
        }

        val item = pPlayer.getItemInHand(pHand)
        if (item.item !is ShovelItem) {
            return InteractionResult.CONSUME
        }

        val flag = !pState.getValue(UP)
        pLevel.setBlockAndUpdate(pPos, pState.setValue(UP, flag))
        return InteractionResult.SUCCESS
    }

    override fun getShape(pState: BlockState, pLevel: BlockGetter, pPos: BlockPos, pContext: CollisionContext): VoxelShape {
        val flag = pState.getValue(UP)
        return box(0.0, if (flag) 15.0 else 0.0, 0.0, 16.0, if (flag) 16.0 else 1.0, 16.0)
    }

    override fun rotate(pState: BlockState, pRotation: Rotation): BlockState {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)))
    }

    override fun mirror(pState: BlockState, pMirror: Mirror): BlockState {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)))
    }

    override fun createBlockStateDefinition(pBuilder: StateDefinition.Builder<Block, BlockState>) {
        pBuilder.add(FACING, UP)
    }
}

class CarpetModel: GeoModel<SimpleGeoBlockTile>() {
    override fun getModelResource(tile: SimpleGeoBlockTile): ResourceLocation {
        val state = tile.blockState
        val name = (state.block as BlockBigCarpet).name
        val flag = state.getValue(BlockBigCarpet.UP)
        val append = if (!flag) "_down" else ""
        return ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, "geo/${name}${append}.geo.json")
    }

    override fun getTextureResource(tile: SimpleGeoBlockTile): ResourceLocation {
        return ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, "textures/block/${(tile.blockState.block as BlockBigCarpet).name}.png")
    }

    override fun getAnimationResource(tile: SimpleGeoBlockTile): ResourceLocation? {
        return null
    }
}

class RendererCarpet: GeoBlockRenderer<SimpleGeoBlockTile>(CarpetModel()),
    BlockEntityRendererProvider<SimpleGeoBlockTile> {
    override fun create(pContext: BlockEntityRendererProvider.Context): BlockEntityRenderer<SimpleGeoBlockTile> {
        return this
    }
}
