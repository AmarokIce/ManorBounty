package com.djinfinite.manors_bounty.network.network;

import com.djinfinite.manors_bounty.ManorsBountyMod;
import com.djinfinite.manors_bounty.network.network.server.ServerAttributeSyncPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;


public class NetworkHandler {
    public static final String PROTOCOL_VERSION = "1.0";
    public static SimpleChannel INSTANCE;
    private static int id;

    public static void register() {
        INSTANCE = NetworkRegistry.newSimpleChannel(
                new ResourceLocation(ManorsBountyMod.MOD_ID, "common"),
                () -> PROTOCOL_VERSION,
                PROTOCOL_VERSION::equals,
                PROTOCOL_VERSION::equals
        );

        INSTANCE.messageBuilder(ServerAttributeSyncPacket.class, id++, NetworkDirection.PLAY_TO_CLIENT)
                .decoder(ServerAttributeSyncPacket::new)
                .encoder(ServerAttributeSyncPacket::encode)
                .consumerMainThread(ServerAttributeSyncPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }


    public static <MSG> void sendToPlayer(MSG message, Player player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) player), message);
    }

}
