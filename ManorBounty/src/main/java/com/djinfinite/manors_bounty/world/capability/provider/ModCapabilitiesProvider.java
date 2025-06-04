package com.djinfinite.manors_bounty.world.capability.provider;

import com.djinfinite.manors_bounty.world.capability.entity.ModAttribute;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.NonNullSupplier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class ModCapabilitiesProvider implements ICapabilityProvider,
        NonNullSupplier<ModAttribute>, ICapabilitySerializable<CompoundTag> {

    public static final Capability<ModAttribute> OH_ATTRIBUTE = CapabilityManager.get(new CapabilityToken<>() {
    });
    public static CompoundTag modCooldowns;
    private ModAttribute modAttribute;
    public final LazyOptional<ModAttribute> lazyOptional = LazyOptional.of(() -> this.modAttribute);

    public ModCapabilitiesProvider() {
        this.modAttribute = new ModAttribute();
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        if (cap == OH_ATTRIBUTE) {
            return lazyOptional.cast();
        } else {
            return LazyOptional.empty();
        }
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return getCapability(cap);
    }

    @Override
    public @NotNull ModAttribute get() {
        return this.modAttribute;
    }

    @Override
    public CompoundTag serializeNBT() {
        return this.modAttribute.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.modAttribute.deserializeNBT(nbt);
    }
}
