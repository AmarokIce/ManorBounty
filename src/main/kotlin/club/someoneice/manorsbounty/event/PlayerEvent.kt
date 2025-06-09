package club.someoneice.manorsbounty.event

import club.someoneice.manorsbounty.core.FoodLevelRegister
import club.someoneice.manorsbounty.init.ModCapabilitiesRoot
import net.minecraft.world.entity.player.Player
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Suppress("unused")
@Mod.EventBusSubscriber
object PlayerEvent {
    @SubscribeEvent
    fun playerFinishUsingItemEvent(event: LivingEntityUseItemEvent.Finish) {
        val player = event.entity
        val item = event.item

        if (player !is Player) {
            return
        }

        val data = FoodLevelRegister.find(item.item)
        player.getCapability(ModCapabilitiesRoot.MOD_CAPABILITIES).ifPresent {
            if (!data.applyTo(player)) {
                return@ifPresent
            }
        }
    }
}
