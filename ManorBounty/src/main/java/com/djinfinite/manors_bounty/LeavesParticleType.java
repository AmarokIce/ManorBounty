package com.djinfinite.manors_bounty;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class LeavesParticleType extends TextureSheetParticle {
    public static LeavesParticleProvider provider(SpriteSet spriteSet) {
        return new LeavesParticleProvider(spriteSet);
    }


    public static class LeavesParticleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public LeavesParticleProvider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double x, double y, double z, double pXSpeed, double pYSpeed, double pZSpeed) {
            return new LeavesParticleType(pLevel,x, y, z, pXSpeed, pYSpeed, pZSpeed);
        }
    }



    protected LeavesParticleType(ClientLevel pLevel, double pX, double pY, double pZ) {
        super(pLevel, pX, pY, pZ);
    }

    protected LeavesParticleType(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }
}
