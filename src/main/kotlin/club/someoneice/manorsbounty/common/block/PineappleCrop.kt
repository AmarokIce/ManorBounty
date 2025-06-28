package club.someoneice.manorsbounty.common.block

import club.someoneice.manorsbounty.asStack
import club.someoneice.manorsbounty.init.ModItems
import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.util.RandomSource
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.Level
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.BonemealableBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.minecraft.world.phys.BlockHitResult
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.VoxelShape

class PineappleCrop: Block(Properties.copy(Blocks.GRASS)), BonemealableBlock {
    companion object {
        val AGE = BlockStateProperties.AGE_5
    }

    override fun getShape(pState: BlockState, pLevel: BlockGetter, pPos: BlockPos, pContext: CollisionContext): VoxelShape {
        return super.getShape(pState, pLevel, pPos, pContext)
    }

    init {
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0))
    }

    override fun use(pState: BlockState, pLevel: Level, pPos: BlockPos, pPlayer: Player, pHand: InteractionHand, pHit: BlockHitResult): InteractionResult {
        if (pState.getValue(AGE) == 5) {
            pLevel.setBlockAndUpdate(pPos, pState.setValue(AGE, 1))
            popResource(pLevel, pPos, ModItems.PINEAPPLE.asStack())
            return InteractionResult.SUCCESS
        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit)
    }

    override fun createBlockStateDefinition(pBuilder: StateDefinition.Builder<Block, BlockState>) {
        pBuilder.add(AGE)
    }

    override fun isValidBonemealTarget(pLevel: LevelReader, pPos: BlockPos, pState: BlockState, pIsClient: Boolean) = pState.getValue(AGE) < 5
    override fun isBonemealSuccess(pLevel: Level, pRandom: RandomSource, pPos: BlockPos, pState: BlockState): Boolean = pRandom.nextBoolean()
    override fun performBonemeal(pLevel: ServerLevel, pRandom: RandomSource, pPos: BlockPos, pState: BlockState) {
        pLevel.setBlockAndUpdate(pPos, pState.cycle(AGE))
    }
}
