package club.someoneice.manorsbounty.common.block

import club.someoneice.manorsbounty.asStack
import club.someoneice.manorsbounty.common.block.BlockDragonFruit.Companion.COUNT
import club.someoneice.manorsbounty.giveOrDropItemStack
import net.minecraft.core.BlockPos
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.RenderShape
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.IntegerProperty
import net.minecraft.world.phys.BlockHitResult
import java.util.function.Supplier

class BlockBigPie(private val pieSlice: Supplier<Item>): Block(Properties.copy(Blocks.CAKE)) {
    companion object {
        val SLICE: IntegerProperty = IntegerProperty.create("slice", 0, 3)
    }

    init {
        this.registerDefaultState(this.stateDefinition.any().setValue(SLICE, 0))
    }

    override fun onPlace(pState: BlockState, pLevel: Level, pPos: BlockPos, pOldState: BlockState, pMovedByPiston: Boolean) {
        if (pState.getValue(SLICE) != 0) {
            return
        }

        val pos1 = pPos.offset(0, 0, 1)
        val pos2 = pPos.offset(1, 0, 0)
        val pos3 = pPos.offset(1, 0, 1)

        pLevel.setBlockAndUpdate(pos1, pState.setValue(SLICE, 1))
        pLevel.setBlockAndUpdate(pos2, pState.setValue(SLICE, 2))
        pLevel.setBlockAndUpdate(pos3, pState.setValue(SLICE, 3))
    }

    override fun use(pState: BlockState, pLevel: Level, pPos: BlockPos, pPlayer: Player, pHand: InteractionHand, pHit: BlockHitResult): InteractionResult {
        super.use(pState, pLevel, pPos, pPlayer, pHand, pHit)

        pPlayer.giveOrDropItemStack(this.pieSlice.asStack())
        pLevel.removeBlock(pPos, false)

        return InteractionResult.SUCCESS
    }

    override fun createBlockStateDefinition(pBuilder: StateDefinition.Builder<Block, BlockState>) {
        pBuilder.add(COUNT)
    }

    override fun getRenderShape(pState: BlockState): RenderShape = RenderShape.MODEL
}
