package club.someoneice.manorsbounty.common.item

import club.someoneice.manorsbounty.init.ModBlocks
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockState

class PineappleCrop: BlockItem(ModBlocks.PINEAPPLE_CROP, Properties()) {
    override fun canPlace(pContext: BlockPlaceContext, pState: BlockState): Boolean {
        val pos = pContext.clickedPos
        val level = pContext.level
        val state = level.getBlockState(pos.below())
        return state.`is`(Blocks.FARMLAND)
    }
}
