package club.someoneice.manorsbounty.common.block

import club.someoneice.manorsbounty.asStack
import club.someoneice.manorsbounty.giveOrDropItemStack
import net.minecraft.core.BlockPos
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.RenderShape
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.IntegerProperty
import net.minecraft.world.phys.BlockHitResult
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.VoxelShape
import java.util.function.Supplier

class BlockBigPie(private val pieSlice: Supplier<Item>): Block(Properties.copy(Blocks.CAKE)) {
    companion object {
        val SLICE: IntegerProperty = IntegerProperty.create("slice", 0, 3)
    }

    // TODO
    override fun getShape(
        pState: BlockState,
        pLevel: BlockGetter,
        pPos: BlockPos,
        pContext: CollisionContext
    ): VoxelShape {
        return super.getShape(pState, pLevel, pPos, pContext)
    }

    init {
        this.registerDefaultState(this.stateDefinition.any().setValue(SLICE, 0))
    }

    // TODO - Should testing.
    override fun onPlace(pState: BlockState, pLevel: Level, pPos: BlockPos, pOldState: BlockState, pMovedByPiston: Boolean) {
        if (pState.getValue(SLICE) != 0) {
            return
        }

        val pos1 = pPos.offset(0, 0, 1)
        val pos2 = pPos.offset(1, 0, 0)
        val pos3 = pPos.offset(1, 0, 1)

        var count =0

        if (pLevel.getBlockState(pos1).isAir) {
            pLevel.setBlockAndUpdate(pos1, pState.setValue(SLICE, 1))
        } else count++

        if (pLevel.getBlockState(pos2).isAir) {
            pLevel.setBlockAndUpdate(pos2, pState.setValue(SLICE, 2))
        } else count++

        if (pLevel.getBlockState(pos3).isAir) {
            pLevel.setBlockAndUpdate(pos3, pState.setValue(SLICE, 3))
        } else count++

        val itemEntity = ItemEntity(pLevel, pPos.x.toDouble(), pPos.y.toDouble(), pPos.z.toDouble(), pieSlice.asStack(count))
        pLevel.addFreshEntity(itemEntity)
    }

    override fun use(pState: BlockState, pLevel: Level, pPos: BlockPos, pPlayer: Player, pHand: InteractionHand, pHit: BlockHitResult): InteractionResult {
        super.use(pState, pLevel, pPos, pPlayer, pHand, pHit)

        pPlayer.giveOrDropItemStack(this.pieSlice.asStack())
        pLevel.removeBlock(pPos, false)

        return InteractionResult.SUCCESS
    }

    override fun createBlockStateDefinition(pBuilder: StateDefinition.Builder<Block, BlockState>) {
        pBuilder.add(SLICE)
    }

    override fun getRenderShape(pState: BlockState): RenderShape = RenderShape.MODEL
}
