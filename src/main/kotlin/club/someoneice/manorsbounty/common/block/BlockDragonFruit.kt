package club.someoneice.manorsbounty.common.block

import club.someoneice.manorsbounty.asStack
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.*
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.DirectionProperty
import net.minecraft.world.level.block.state.properties.IntegerProperty
import net.minecraft.world.level.storage.loot.LootParams
import net.minecraft.world.level.storage.loot.parameters.LootContextParams
import net.minecraft.world.phys.BlockHitResult
import kotlin.random.Random

class BlockDragonFruit: Block(Properties.copy(Blocks.SLIME_BLOCK)) {
    companion object {
        val FACING: DirectionProperty = HorizontalDirectionalBlock.FACING
        val COUNT: IntegerProperty = IntegerProperty.create("blockstate", 0, 5)
    }

    init {
        this.registerDefaultState(this.stateDefinition.any()
            .setValue(FACING, Direction.EAST)
            .setValue(COUNT, 0)
        )
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

    override fun getStateForPlacement(pContext: BlockPlaceContext): BlockState =
        defaultBlockState()
            .setValue(FACING, pContext.horizontalDirection.opposite)
            .setValue(COUNT, Random.nextInt(0, 6))

    override fun use(pState: BlockState, pLevel: Level, pPos: BlockPos, pPlayer: Player, pHand: InteractionHand, pHit: BlockHitResult): InteractionResult {
        val state = this.defaultBlockState()
            .setValue(FACING, pState.getValue(FACING))
            .setValue(COUNT, Random.nextInt(0, 6))
        pLevel.setBlockAndUpdate(pPos, state)

        return InteractionResult.SUCCESS
    }

    override fun rotate(pState: BlockState, pRot: Rotation): BlockState {
        return pState.setValue(
            FACING,
            pRot.rotate(pState.getValue(FACING))
        )
    }

    override fun mirror(pState: BlockState, pMirror: Mirror): BlockState {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)))
    }

    override fun createBlockStateDefinition(pBuilder: StateDefinition.Builder<Block?, BlockState?>) {
        pBuilder.add(FACING, COUNT)
    }

    override fun getRenderShape(pState: BlockState): RenderShape = RenderShape.MODEL
}
