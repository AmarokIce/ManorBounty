package club.someoneice.manorsbounty.event

import club.someoneice.manorsbounty.core.FoodLevelRegister
import club.someoneice.manorsbounty.init.ModCapabilitiesRoot
import net.minecraft.world.entity.player.Player
import net.minecraftforge.event.TickEvent
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber
object PlayerEvent {
    @SubscribeEvent
    fun playerTick(event: TickEvent.PlayerTickEvent) {
        if (event.phase == TickEvent.Phase.END) {
            return
        }

        val player = event.player
        player.getCapability(ModCapabilitiesRoot.MOD_CAPABILITIES).ifPresent {
            it.getData().foodCooldown.shrinkCooldown()
        }
    }

    @SubscribeEvent
    fun playerFinishUsingItemEvent(event: LivingEntityUseItemEvent.Finish) {
        val player = event.entity
        val item = event.item

        if (player !is Player) {
            return
        }

        val data = FoodLevelRegister.find(item.item)
        player.getCapability(ModCapabilitiesRoot.MOD_CAPABILITIES).ifPresent {
            val cd = it.getData().foodCooldown
            if (cd.getFoodCooldown(item.item) > 0) {
                return@ifPresent
            }

            if (!data.applyTo(player)) {
                return@ifPresent
            }
        }
    }
}
