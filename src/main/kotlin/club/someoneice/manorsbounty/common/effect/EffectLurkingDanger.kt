package club.someoneice.manorsbounty.common.effect

import club.someoneice.manorsbounty.init.ModCapabilitiesRoot
import club.someoneice.manorsbounty.init.ModEffects
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemStack
import net.minecraftforge.event.entity.living.LivingAttackEvent
import net.minecraftforge.event.entity.living.MobEffectEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import java.util.*

@EventBusSubscriber
class EffectLurkingDanger: MobEffect(MobEffectCategory.BENEFICIAL, 0) {
    override fun isDurationEffectTick(pDuration: Int, pAmplifier: Int): Boolean = true
    override fun getCurativeItems(): MutableList<ItemStack> = Collections.emptyList()
    override fun applyEffectTick(pLivingEntity: LivingEntity, pAmplifier: Int) {
        pLivingEntity.getCapability(ModCapabilitiesRoot.MOD_CAPABILITIES).ifPresent {
            val efc = it.getData().turkingEffect

            val flag = efc.counter > (1.5 - pAmplifier * 0.5 + efc.punishment) * 20
            val flagShiftDown = pLivingEntity.isShiftKeyDown

            efc.mark = flag

            if (flag && !flagShiftDown) {
                efc.counter = 0
                efc.mark = false
                pLivingEntity.addEffect(MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 4))
                return@ifPresent
            } else if (!flagShiftDown) {
                return@ifPresent
            }

            efc.counter++
            if (flag) {
                pLivingEntity.addEffect(MobEffectInstance(MobEffects.INVISIBILITY, 20 * 5))
                pLivingEntity.addEffect(MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20 * 5, pAmplifier))
            }
        }
    }

    @SubscribeEvent
    fun onEntityAttack(event: LivingAttackEvent) {
        val entity = event.source.entity ?: return
        if (entity !is LivingEntity || !entity.hasEffect(ModEffects.LURKING_DANGER)) {
            return
        }

        entity.getCapability(ModCapabilitiesRoot.MOD_CAPABILITIES).ifPresent {
            val efc = it.getData().turkingEffect
            if (efc.mark) {
                efc.mark = false
                efc.counter = 0
                efc.punishment += 1
            }
        }
    }

    @SubscribeEvent
    fun onEffectEnd(event: MobEffectEvent.Expired) {
        event.entity.getCapability(ModCapabilitiesRoot.MOD_CAPABILITIES).ifPresent {
            it.getData().turkingEffect.init()
        }
    }

    @SubscribeEvent
    fun onEffectRemove(event: MobEffectEvent.Remove) {
        event.entity.getCapability(ModCapabilitiesRoot.MOD_CAPABILITIES).ifPresent {
            it.getData().turkingEffect.init()
        }
    }
}
