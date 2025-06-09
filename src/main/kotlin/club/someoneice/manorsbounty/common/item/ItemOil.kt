package club.someoneice.manorsbounty.common.item

import club.someoneice.manorsbounty.init.ModTabs.addToTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items

class ItemOil: Item(Properties().craftRemainder(Items.BUCKET).stacksTo(1)) {
    init {
        this.addToTab()
    }

    override fun hasCraftingRemainingItem(stack: ItemStack?): Boolean {
        return true
    }

    override fun getCraftingRemainingItem(itemStack: ItemStack?): ItemStack? {
        return super.getCraftingRemainingItem(itemStack)
    }
}
