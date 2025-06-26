package club.someoneice.manorsbounty.common.block

import club.someoneice.manorsbounty.common.block.BlockFryer.Companion.OIL
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.block.*
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.DirectionProperty

class IceCreamMachine: BaseEntityBlock(Properties.copy(Blocks.STONE)) {
    companion object {
        var FACING: DirectionProperty = HorizontalDirectionalBlock.FACING
    }

    init {
        this.registerDefaultState(
            this.stateDefinition.any().setValue(BlockFryer.FACING, Direction.NORTH).setValue(OIL, false)
        )
    }

    override fun getStateForPlacement(pContext: BlockPlaceContext): BlockState {
        return this.defaultBlockState().setValue(BlockOven.FACING, pContext.horizontalDirection.opposite)
    }

    override fun rotate(pState: BlockState, pRotation: Rotation): BlockState {
        return pState.setValue(BlockOven.FACING, pRotation.rotate(pState.getValue(BlockOven.FACING)))
    }

    override fun mirror(pState: BlockState, pMirror: Mirror): BlockState {
        return pState.rotate(pMirror.getRotation(pState.getValue(BlockOven.FACING)))
    }

    override fun createBlockStateDefinition(pBuilder: StateDefinition.Builder<Block, BlockState>) {
        pBuilder.add(BlockOven.FACING)
    }

    override fun newBlockEntity(pPos: BlockPos, pState: BlockState): BlockEntity {

    }
}
