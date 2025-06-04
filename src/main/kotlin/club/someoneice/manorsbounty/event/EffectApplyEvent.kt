package club.someoneice.manorsbounty.event

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.init.ModEffects
import club.someoneice.manorsbounty.odds
import net.minecraft.util.Mth
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.entity.projectile.Projectile
import net.minecraftforge.event.entity.living.LivingAttackEvent
import net.minecraftforge.event.entity.living.LivingDamageEvent
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import kotlin.math.min

@Suppress("unused")
@EventBusSubscriber(modid = ManorsBounty.ID)
object EffectApplyEvent {
    private val eventLivingAttack = arrayOf<(LivingAttackEvent) -> Unit>(
        applyRosaHedge@{ event ->
            val damageEntity = event.entity
            val effect = damageEntity.getEffect(ModEffects.ROSA_HEDGE) ?: return@applyRosaHedge

            if (event.amount < (effect.amplifier + 1) * 0.5) {
                event.isCanceled = true
            }
        },
        applyHackedThorns@{ event ->
            val attackEntity = event.source.entity
            val damageEntity = event.entity
            val effect = damageEntity.getEffect(ModEffects.HACKED_THORNS) ?: return@applyHackedThorns
            val lv = effect.amplifier

            if (attackEntity is Projectile) {
                if (!(lv * 0.08).odds()) {
                    return@applyHackedThorns
                }

                event.isCanceled = true
                return@applyHackedThorns
            }

            if (attackEntity !is LivingEntity) {
                return@applyHackedThorns
            }

            val effectSlow = MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, Mth.floor(0.8 * 20), min(3, lv))
            attackEntity.knockback(lv * 0.35, attackEntity.x - damageEntity.x, attackEntity.z - damageEntity.z)
            attackEntity.addEffect(effectSlow)
        }
    )

    @SubscribeEvent
    fun onEntityAttackBy(event: LivingAttackEvent) {
        eventLivingAttack.forEach {
            if (event.apply(it).isCanceled) {
                return@onEntityAttackBy
            }
        }
    }

    private val eventLivingDamage = arrayOf<(LivingDamageEvent) -> Unit>(
        applyBurstingBerry@{ event ->
            val attackEntity = event.source.entity

            if (attackEntity !is Player
                || attackEntity.getAttackStrengthScale(0.5f) < 0.9
                || attackEntity.fallDistance <= 0
                || attackEntity.isPassenger) {
                return@applyBurstingBerry
            }

            val effect = attackEntity.getEffect(ModEffects.BURSTING_BERRY) ?: return@applyBurstingBerry

            event.amount *= 1 + (effect.amplifier + 1) * 0.15f
        },
        applyMonentaryMeteor@{ event ->
            val attackEntity = event.source.entity.let {
                it as? LivingEntity ?: return@applyMonentaryMeteor
            }

            val effect = attackEntity.getEffect(ModEffects.MOMENTARY_METEOR) ?: return@applyMonentaryMeteor
            val odds = (effect.amplifier + 1) * 0.01
            if (!odds.odds()) {
                return@applyMonentaryMeteor
            }

            if (event.amount < 100) {
                event.amount = min(100.0f, event.amount * 5.0f)
            }
        },
        applyOriginalEvolution@{ event ->
            val damageEntity = event.entity
            val attackEntity = event.source.entity.let {
                it as? LivingEntity ?: return@applyOriginalEvolution
            }

            val effect = damageEntity.getEffect(ModEffects.ORIGINAL_EVOLUTION) ?: return@applyOriginalEvolution
            val lv = damageEntity.getEffect(ModEffects.ORIGINAL_EVOLUTION_METAMORPHOSIS)?.amplifier ?: 0

            val damageNew = event.amount * effect.amplifier * 0.05 + event.amount * lv * 0.08
            event.amount -= Mth.floor(min(event.amount * 0.9, damageNew))

            damageEntity.addEffect(MobEffectInstance(ModEffects.ORIGINAL_EVOLUTION_METAMORPHOSIS, 15 * 20, 0))
        },
        applyKiwingWhereabouts@{ event ->
            val damageEntity = event.entity
            val attackEntity = event.source.entity.let {
                it as? LivingEntity ?: return@applyKiwingWhereabouts
            }

            val effect = damageEntity.getEffect(ModEffects.KIWING_WHEREABOUTS) ?: return@applyKiwingWhereabouts
            if (event.source == damageEntity.damageSources().fall()) {
                event.amount -= Mth.floor(0.4 + 0.04 * effect.amplifier)
                return@applyKiwingWhereabouts
            }

            val time = Mth.floor(0.5 * 20 + 0.1 * effect.amplifier * 20)
            damageEntity.addEffect(MobEffectInstance(MobEffects.MOVEMENT_SPEED, time, 2))
            damageEntity.addEffect(MobEffectInstance(MobEffects.INVISIBILITY, time, 0))
            event.amount = 0f
            event.isCanceled = true
        }
    )

    @SubscribeEvent
    fun onEntityDamage(event: LivingDamageEvent) {
        eventLivingDamage.forEach {
            if (event.apply(it).isCanceled) {
                return@onEntityDamage
            }
        }
    }

    @SubscribeEvent
    fun onDropExp(event: LivingExperienceDropEvent) {
        val player = event.attackingPlayer ?: return

        fun applyRutinLemonene() {
            val effect = player.getEffect(ModEffects.RUTIN_LEMONENE) ?: return

            val exp = event.originalExperience
            event.droppedExperience +=
                Mth.floor(exp * 0.1 * (5 + (effect.amplifier + 1) * 0.25) + exp * min(80, player.experienceLevel) * 0.0125)
        }

        applyRutinLemonene()
    }
}
