package club.someoneice.manorsbounty.event

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.init.ModCapabilitiesRoot
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.player.Player
import net.minecraftforge.event.AttachCapabilitiesEvent
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod.EventBusSubscriber

@Suppress("unused")
@EventBusSubscriber
object CapabilitiesInitEvent {
    @SubscribeEvent
    fun onAttachCapabilityEvent(event: AttachCapabilitiesEvent<Entity>) {
        val entity: Entity = event.getObject()
        if (entity is Player) {
            event.addCapability(ResourceLocation.tryBuild(ManorsBounty.ID, "mod_capabilities"),
                ModCapabilitiesRoot.ModCapabilitiesProvider()
            )
        }
    }

    @SubscribeEvent
    fun onPlayerCloned(event: PlayerEvent.Clone) {
        val oldCap = event.original.getCapability(ModCapabilitiesRoot.MOD_CAPABILITIES).resolve()
        val newCap = event.entity.getCapability(ModCapabilitiesRoot.MOD_CAPABILITIES).resolve()

        if (newCap.isEmpty || oldCap.isEmpty) {
            return
        }

        newCap.get().deserializeNBT(oldCap.get().serializeNBT())
    }
}
