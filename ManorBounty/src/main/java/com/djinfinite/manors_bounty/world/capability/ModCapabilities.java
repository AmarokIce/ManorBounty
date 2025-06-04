package com.djinfinite.manors_bounty.world.capability;


import com.djinfinite.manors_bounty.network.network.NetworkHandler;
import com.djinfinite.manors_bounty.network.network.server.ServerAttributeSyncPacket;
import com.djinfinite.manors_bounty.world.capability.entity.ModAttribute;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class ModCapabilities {
    public static final Capability<ModAttribute> MOD_ATTRIBUTE = CapabilityManager.get(new CapabilityToken<>() {});
    public static ModAttribute getModAttribute(Player player) {
        return player.getCapability(MOD_ATTRIBUTE).orElse(new ModAttribute());
    }
    public static void serverSyncAttribute(Player player) {
        NetworkHandler.sendToPlayer(new ServerAttributeSyncPacket(getModAttribute(player)), player);
    }
}
