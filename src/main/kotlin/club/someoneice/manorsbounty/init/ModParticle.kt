package club.someoneice.manorsbounty.init

import club.someoneice.manorsbounty.ManorsBounty
import net.minecraft.core.particles.SimpleParticleType
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object ModParticle {
    internal val PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ManorsBounty.ID)

    val PEAR by PARTICLES.registerObject("pear") { SimpleParticleType(false) }
    val PEACH by PARTICLES.registerObject("peach") { SimpleParticleType(false) }
}