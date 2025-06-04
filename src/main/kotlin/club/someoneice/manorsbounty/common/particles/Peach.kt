package club.someoneice.manorsbounty.common.particles

import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.particle.*
import net.minecraft.core.particles.SimpleParticleType
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn

@OnlyIn(Dist.CLIENT)
class Peach(world: ClientLevel, x: Double, y: Double, z: Double, spriteSet: SpriteSet): TextureSheetParticle(world, x, y, z) {
    class ParticleProviderPeach(private val spriteSet: SpriteSet) : ParticleProvider<SimpleParticleType> {
        override fun createParticle(typeIn: SimpleParticleType, worldIn: ClientLevel, x: Double, y: Double, z: Double, xSpeed: Double, ySpeed: Double, zSpeed: Double): Particle = Peach(worldIn, x, y, z, spriteSet)
    }

    init {
        setSize(0.2f, 0.2f)
        lifetime = 20
        gravity = 0f
        hasPhysics = true
        xd = 0.0
        yd = 0.5
        zd = 0.0
        pickSprite(spriteSet)
    }

    override fun getRenderType(): ParticleRenderType = ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT

    companion object {
        @JvmStatic
        fun provider(spriteSet: SpriteSet) = ParticleProviderPeach(spriteSet)
    }
}