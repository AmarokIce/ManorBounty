package club.someoneice.manorsbounty.common.effect

import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.item.ItemStack
import java.util.*

class EffectCherryBlossomsWeeping: MobEffect(MobEffectCategory.BENEFICIAL, 0) {
    init {
        this.addAttributeModifier(Attributes.ATTACK_KNOCKBACK, "d702e5ad-ca59-4659-b0ab-d55e215d5689", 0.1, AttributeModifier.Operation.MULTIPLY_BASE)
    }

    override fun getCurativeItems(): MutableList<ItemStack> = Collections.emptyList()
    override fun isDurationEffectTick(pDuration: Int, pAmplifier: Int): Boolean = true
    override fun applyEffectTick(pLivingEntity: LivingEntity, pAmplifier: Int) {
        super.applyEffectTick(pLivingEntity, pAmplifier)
        // TODO - 粒子效果
    }
}
