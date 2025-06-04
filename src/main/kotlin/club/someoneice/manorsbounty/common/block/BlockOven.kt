package club.someoneice.manorsbounty.common.block

import club.someoneice.manorsbounty.common.tile.TileOven
import club.someoneice.manorsbounty.init.ModTile
import net.minecraft.core.BlockPos
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.BaseEntityBlock
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.RenderShape
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.entity.BlockEntityTicker
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState

class BlockOven: BaseEntityBlock(Properties.copy(Blocks.STONE)) {
    override fun newBlockEntity(pPos: BlockPos, pState: BlockState): BlockEntity = TileOven(pPos, pState)
    override fun getRenderShape(pState: BlockState): RenderShape = RenderShape.MODEL

    override fun <T : BlockEntity> getTicker(pLevel: Level, pState: BlockState, pBlockEntityType: BlockEntityType<T>): BlockEntityTicker<T>? {
        return createTickerHelper(pBlockEntityType, ModTile.OVEN.get(), TileOven::tick)
    }
}