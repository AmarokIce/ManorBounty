package club.someoneice.manorsbounty.common.block

import club.someoneice.manorsbounty.init.ModParticle
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.util.ParticleUtils
import net.minecraft.util.RandomSource
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.LeavesBlock
import net.minecraft.world.level.block.state.BlockState

class FlowerLeaves(private val isPear: Boolean): LeavesBlock(Properties.copy(Blocks.CHERRY_LEAVES)) {
    override fun animateTick(state: BlockState, world: Level, pos: BlockPos, random: RandomSource) {
        super.animateTick(state, world, pos, random)
        if (random.nextInt(10) != 0) {
            return
        }

        val blockpos = pos.below()
        val blockstate = world.getBlockState(blockpos)
        if (!isFaceFull(blockstate.getCollisionShape(world, blockpos), Direction.UP)) {
            ParticleUtils.spawnParticleBelow(world, pos, random, if (isPear) ModParticle.PEAR else ModParticle.PEACH)
        }
    }
}