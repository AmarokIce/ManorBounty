package club.someoneice.manorsbounty.init

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.common.effect.EffectCherryBlossomsWeeping
import club.someoneice.manorsbounty.common.effect.EffectLurkingDanger
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.item.ItemStack
import net.minecraftforge.common.ForgeMod
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject
import java.util.*

@Suppress("unused")
object ModEffects {
    val REGISTRY: DeferredRegister<MobEffect> = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ManorsBounty.ID)

    val BURSTING_BERRY by REGISTRY.registerObject("bursting_berry") { createDefaultEffect() }
    val ROSA_HEDGE by REGISTRY.registerObject("rosa_hedge") { createDefaultEffect() }
    val RUTIN_LEMONENE by REGISTRY.registerObject("rutin_lemonene") { createDefaultEffect() }
    val CHERRY_BLOSSOMS_WEEPING by REGISTRY.registerObject("cherry_blossoms_weeping", ::EffectCherryBlossomsWeeping)
    val MOMENTARY_METEOR by REGISTRY.registerObject("momentary_meteor") { createDefaultEffect() }
    val SUMMER_HEATWAVE by REGISTRY.registerObject("summer_heatwave", ::summerHeatwave)
    val ORIGINAL_EVOLUTION by REGISTRY.registerObject("original_evolution") { createDefaultEffect() }
    val ORIGINAL_EVOLUTION_METAMORPHOSIS by REGISTRY.registerObject("original_evolution_metamorphosis") { createDefaultEffect() }
    val MELON_GRAVITY by REGISTRY.registerObject("melon_gravity", ::melonGravity)
    val SEA_TOUCH by REGISTRY.registerObject("sea_touch", ::seaTouch)
    val HACKED_THORNS by REGISTRY.registerObject("hacked_thorns") { createDefaultEffect() }
    val KIWING_WHEREABOUTS by REGISTRY.registerObject("kiwing_whereabouts") { createDefaultEffect() }
    val LURKING_DANGER by REGISTRY.registerObject("lurking_danger", ::EffectLurkingDanger)

    private fun createDefaultEffect() = object: MobEffect(MobEffectCategory.BENEFICIAL, 0) {
        override fun getCurativeItems(): MutableList<ItemStack> = Collections.emptyList()
        override fun isDurationEffectTick(pDuration: Int, pAmplifier: Int): Boolean = false
    }

    private fun summerHeatwave() = createDefaultEffect()
        .addAttributeModifier(Attributes.MOVEMENT_SPEED, "0378cdb4-432d-4fea-b1b0-083a8d92b35d", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL)
        .addAttributeModifier(ForgeMod.SWIM_SPEED.get(), "c4da594d-8e8f-453e-9195-1c6c9057e70c", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL)

    private fun melonGravity() = createDefaultEffect()
        .addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, "3d3e494e-26ad-4982-9187-3d53c9364d57", 0.08, AttributeModifier.Operation.MULTIPLY_TOTAL)
        .addAttributeModifier(ForgeMod.STEP_HEIGHT_ADDITION.get(), "e2fe9efd-910b-43d0-ac7b-0c7f41536f03", 0.15, AttributeModifier.Operation.MULTIPLY_TOTAL)

    private fun seaTouch() = createDefaultEffect()
        .addAttributeModifier(ForgeMod.ENTITY_REACH.get(), "88d70b63-78c7-4a6a-a0ac-452c1988d142", 0.1, AttributeModifier.Operation.MULTIPLY_BASE)
        .addAttributeModifier(ForgeMod.BLOCK_REACH.get(), "442264d5-13f5-48ca-8baf-69c90009501e", 0.1, AttributeModifier.Operation.MULTIPLY_BASE)
}
