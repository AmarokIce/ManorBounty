package club.someoneice.manorsbounty.common.block

import club.someoneice.manorsbounty.asStack
import club.someoneice.manorsbounty.giveOrDropItemStack
import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.util.RandomSource
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.level.Level
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.BonemealableBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.IntegerProperty
import net.minecraft.world.phys.BlockHitResult
import java.util.function.Supplier

class FruitLeaf(private val fruit: Supplier<Item>)
    : Block(Properties.copy(Blocks.OAK_LEAVES).randomTicks()), BonemealableBlock {
    init {
        this.registerDefaultState(
            stateDefinition.any().setValue(STATE, 0)
        )
    }

    override fun use(
        pState: BlockState, pLevel: Level, pPos: BlockPos, pPlayer: Player,
        pHand: InteractionHand, pHit: BlockHitResult,
    ): InteractionResult {
        if (pState.getValue(STATE) < 5) {
            return InteractionResult.FAIL
        }

        pPlayer.giveOrDropItemStack(fruit.get().asStack())
        pLevel.setBlockAndUpdate(pPos, pState.setValue(STATE, 0))
        return InteractionResult.SUCCESS
    }

    override fun randomTick(pState: BlockState, pLevel: ServerLevel, pPos: BlockPos, pRandom: RandomSource) {
        if (pState.getValue(STATE) >= 5) {
            return
        }

        pLevel.setBlockAndUpdate(pPos, pState.cycle(STATE))
    }

    override fun isValidBonemealTarget(pLevel: LevelReader, pPos: BlockPos, pState: BlockState, pIsClient: Boolean): Boolean {
        return pState.getValue(STATE) < 2
    }

    override fun isBonemealSuccess(pLevel: Level, pRandom: RandomSource, pPos: BlockPos, pState: BlockState): Boolean {
        return true
    }

    override fun performBonemeal(pLevel: ServerLevel, pRandom: RandomSource, pPos: BlockPos, pState: BlockState) {
        pLevel.setBlockAndUpdate(pPos, pState.cycle(STATE))
    }

    override fun createBlockStateDefinition(pBuilder: StateDefinition.Builder<Block, BlockState>) {
        pBuilder.add(STATE)
    }

    companion object {
        val STATE = IntegerProperty.create("blockstate", 0, 5)
    }
}
