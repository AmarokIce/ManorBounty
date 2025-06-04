package club.someoneice.manorsbounty.common.block

import club.someoneice.manorsbounty.asStack
import net.minecraft.core.BlockPos
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.SweetBerryBushBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.gameevent.GameEvent
import net.minecraft.world.phys.BlockHitResult

class BlockBush(): SweetBerryBushBlock(Properties.copy(Blocks.SWEET_BERRY_BUSH).noOcclusion()) {
    override fun use(pState: BlockState, pLevel: Level, pPos: BlockPos, pPlayer: Player, pHand: InteractionHand, pHit: BlockHitResult): InteractionResult {
        val i = pState.getValue(AGE)
        val flag = i == 3

        if (!flag && pPlayer.getItemInHand(pHand).`is`(Items.BONE_MEAL)) {
            return InteractionResult.PASS
        }

        if (i <= 1) {
            return InteractionResult.FAIL
        }

        val j = 1 + pLevel.random.nextInt(2)
        popResource(pLevel, pPos, this.asStack(j + (if (flag) 1 else 0)))
        pLevel.playSound(null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0f, 0.8f + pLevel.random.nextFloat() * 0.4f)
        val blockState = pState.setValue(AGE, 1)
        pLevel.setBlock(pPos, blockState, 2)
        pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, blockState))
        return InteractionResult.SUCCESS
    }

    override fun getCloneItemStack(pLevel: BlockGetter, pPos: BlockPos, pState: BlockState): ItemStack = this.asStack()
}