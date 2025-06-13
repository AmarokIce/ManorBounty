package club.someoneice.manorsbounty.common.block

import club.someoneice.manorsbounty.asStack
import club.someoneice.manorsbounty.common.tile.TileOven
import club.someoneice.manorsbounty.init.ModTile
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.*
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.entity.BlockEntityTicker
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.DirectionProperty
import net.minecraft.world.level.material.FluidState
import net.minecraft.world.level.storage.loot.LootParams
import net.minecraft.world.level.storage.loot.parameters.LootContextParams
import net.minecraft.world.phys.BlockHitResult
import net.minecraftforge.network.NetworkHooks

// Fixme - BlockState.
class BlockOven: BaseEntityBlock(Properties.copy(Blocks.STONE)) {
    companion object {
        var FACING: DirectionProperty = HorizontalDirectionalBlock.FACING
    }

    init {
        this.registerDefaultState(
            this.stateDefinition.any().setValue(FACING, Direction.NORTH)
        )
    }

    override fun getStateForPlacement(pContext: BlockPlaceContext): BlockState {
        return this.defaultBlockState().setValue(FACING, pContext.horizontalDirection.opposite)
    }

    override fun getDrops(pState: BlockState, pParams: LootParams.Builder): List<ItemStack?> {
        val entity = pParams.getOptionalParameter(LootContextParams.THIS_ENTITY)
        val list = super.getDrops(pState, pParams)
        if (entity is Player && entity.isCreative) {
            return list
        }
        list.add(this.asStack())
        return list
    }

    override fun onDestroyedByPlayer(state: BlockState, level: Level, pos: BlockPos, player: Player, willHarvest: Boolean, fluid: FluidState): Boolean {
        super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid)
        val tile = level.getBlockEntity(pos)
        if (tile !is TileOven) {
            return true
        }

        for (i in 0 until tile.inventory.slots) {
            popResource(level, pos, tile.inventory.getStackInSlot(i))
        }

        return true
    }

    override fun use(pState: BlockState, pLevel: Level, pPos: BlockPos, pPlayer: Player, pHand: InteractionHand, pHit: BlockHitResult): InteractionResult {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS
        }

        val tile = pLevel.getBlockEntity(pPos)
        if (tile !is TileOven) {
            return InteractionResult.FAIL
        }

        pPlayer as ServerPlayer
        NetworkHooks.openScreen(pPlayer, tile, pPos)

        return InteractionResult.CONSUME
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

    override fun newBlockEntity(pPos: BlockPos, pState: BlockState): BlockEntity = TileOven(pPos, pState)
    override fun getRenderShape(pState: BlockState): RenderShape = RenderShape.MODEL
    override fun <T : BlockEntity> getTicker(pLevel: Level, pState: BlockState, pBlockEntityType: BlockEntityType<T>): BlockEntityTicker<T>? {
        return createTickerHelper(pBlockEntityType, ModTile.OVEN.get(), TileOven::tick)
    }
}
