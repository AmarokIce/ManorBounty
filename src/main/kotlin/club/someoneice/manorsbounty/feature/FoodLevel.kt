package club.someoneice.manorsbounty.feature

import club.someoneice.manorsbounty.ModConfig
import club.someoneice.manorsbounty.odds
import net.minecraft.network.chat.Component
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.LivingEntity
import kotlin.math.max
import kotlin.math.min


sealed class FoodLevel {
    fun applyTo(target: LivingEntity) = if (!ModConfig.useFoodEffects) false else applyEffect(target)

    // abstract fun getCooldown(): Int

    internal abstract fun applyEffect(target: LivingEntity): Boolean
    abstract fun getTooltipData(): Component

    companion object {
        // val cooldownA = ModConfig.foodCooldownTimeA * 20
        // val cooldownB = ModConfig.foodCooldownTimeB * 20
        // val cooldownC = ModConfig.foodCooldownTimeC * 20
        // val cooldownX = ModConfig.foodCooldownTimeX * 20
    }

    data object EMPTY: FoodLevel() {
        override fun applyEffect(target: LivingEntity): Boolean = false
        override fun getTooltipData(): Component = Component.empty()
    }

    class A(private val odds: Double = 1.0, private val level: Int = 1, private vararg val effects: MobEffect) : FoodLevel() {
        constructor(odds: Double, vararg effect: MobEffect): this(odds, effects = effect)
        constructor(vararg effect: MobEffect): this(effects = effect)

        override fun applyEffect(target: LivingEntity): Boolean {
            effects.filter(target::hasEffect).forEach { effect ->
                if (!odds.odds()) {
                    return@forEach
                }

                val effectIn = target.getEffect(effect)!!
                val amplifier = if (effectIn.amplifier >= 3) effectIn.amplifier else min(effectIn.amplifier + level, 3)

                effectIn.update(MobEffectInstance(effect, effectIn.duration, amplifier))
            }
            return true
        }

        override fun getTooltipData(): Component {
            val sb = StringBuilder()
            this.effects.map(MobEffect::getDisplayName).map(Component::getString).forEach { sb.append("$it, ") }

            return Component.translatable("tooltip.manorsbounty.foodEffect.A", sb.substring(0, sb.length - 2), odds * 100, level)
        }

        // override fun getCooldown(): Int = cooldownA
    }

    class B(
        private val seconds: Int = 300,
        private vararg val effects: MobEffect
    ) : FoodLevel() {
        constructor(vararg effect: MobEffect): this(effects = effect)

        override fun applyEffect(target: LivingEntity): Boolean {
            effects.filter(target::hasEffect).forEach { effect ->
                val effectIn = target.getEffect(effect)!!

                val duration = effectIn.duration + seconds * 20
                val amplifier = max(effectIn.amplifier, effectIn.amplifier)

                effectIn.update(MobEffectInstance(effect, duration, amplifier))
            }

            return true
        }

        override fun getTooltipData(): Component {
            val sb = StringBuilder()
            this.effects.map(MobEffect::getDisplayName).map(Component::getString).forEach { sb.append("$it, ") }

            return Component.translatable("tooltip.manorsbounty.foodEffect.B", sb.substring(0, sb.length - 2), seconds)
        }
    }

    class C(
        private val second: Int = 300,
        private val level: Int = 1,
        private vararg val effects: MobEffect
    ) : FoodLevel() {
        constructor(vararg effect: MobEffect): this(effects = effect)

        override fun applyEffect(target: LivingEntity): Boolean {
            effects.forEach { effect ->
                if (!target.hasEffect(effect)) {
                    target.addEffect(MobEffectInstance(effect, second * 20, 0))
                    return@forEach
                }

                val effectIn = target.getEffect(effect)!!
                val amplifier = if (effectIn.amplifier >= 7) effectIn.amplifier else
                    min(effectIn.amplifier + level, 7)

                effectIn.update(MobEffectInstance(effect, effectIn.duration, amplifier))
            }
            return true
        }

        override fun getTooltipData(): Component {
            val sb = StringBuilder()
            this.effects.map(MobEffect::getDisplayName).map(Component::getString).forEach { sb.append("$it, ") }

            return Component.translatable("tooltip.manorsbounty.foodEffect.C", sb.substring(0, sb.length - 2), level, second)
        }
        // override fun getCooldown(): Int = if (levelX) cooldownX else cooldownC
    }
}
