package club.someoneice.manorsbounty.common.block

import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.storage.loot.LootParams

open class BlockBase(pProperties: Properties = Properties.copy(Blocks.GLASS)) : Block(pProperties) {
    override fun getDrops(pState: BlockState, pParams: LootParams.Builder): List<ItemStack?> {
        return super.getDrops(pState, pParams).also { it.add(Item.byBlock(this).defaultInstance) }
    }
}
