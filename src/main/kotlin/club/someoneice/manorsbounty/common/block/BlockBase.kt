package club.someoneice.manorsbounty.common.block

import club.someoneice.manorsbounty.asStack
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.storage.loot.LootParams
import net.minecraft.world.level.storage.loot.parameters.LootContextParams

open class BlockBase(pProperties: Properties = Properties.copy(Blocks.STONE)) : Block(pProperties) {
    override fun getDrops(pState: BlockState, pParams: LootParams.Builder): List<ItemStack?> {
        val entity = pParams.getOptionalParameter(LootContextParams.THIS_ENTITY)
        val list = super.getDrops(pState, pParams)
        if (entity is Player && entity.isCreative) {
            return list
        }

        list.add(this.asStack())
        return list
    }
}
