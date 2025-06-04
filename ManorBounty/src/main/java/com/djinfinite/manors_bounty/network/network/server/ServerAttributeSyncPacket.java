package com.djinfinite.manors_bounty.network.network.server;

import com.djinfinite.manors_bounty.network.network.Packet;
import com.djinfinite.manors_bounty.world.capability.ModCapabilities;
import com.djinfinite.manors_bounty.world.capability.provider.ModCapabilitiesProvider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.network.NetworkEvent;

import java.util.Objects;
import java.util.function.Supplier;

public class ServerAttributeSyncPacket implements Packet {
    private final CompoundTag nbt;

    public ServerAttributeSyncPacket(INBTSerializable<CompoundTag> cap) {
        this.nbt = cap.serializeNBT();
    }

    public ServerAttributeSyncPacket(FriendlyByteBuf buf) {
        this.nbt = buf.readNbt();
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeNbt(nbt);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ModCapabilitiesProvider.modCooldowns = nbt;

        ctx.get().enqueueWork(() ->
                ModCapabilities.getModAttribute(Objects.requireNonNull(ctx.get().getSender())).deserializeNBT(nbt)
        );
        ctx.get().setPacketHandled(true);
    }
}
