package club.someoneice.manorsbounty.event

import club.someoneice.manorsbounty.core.FoodLevelRegister
import club.someoneice.manorsbounty.feature.FoodLevel
import net.minecraftforge.event.entity.player.ItemTooltipEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber
object ItemEvent {
    @SubscribeEvent
    fun itemTooltipEvent(event: ItemTooltipEvent) {
        val item = event.itemStack
        if (item.isEmpty) {
            return
        }

        val level = FoodLevelRegister.find(item.item)
        if (level == FoodLevel.EMPTY) {
            return
        }

        event.toolTip.add(level.getTooltipData())
    }
}
