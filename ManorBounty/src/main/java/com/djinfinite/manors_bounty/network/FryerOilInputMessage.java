
package com.djinfinite.manors_bounty.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.procedures.FryerGuiOilPutProcedure;
import com.djinfinite.manors_bounty.ManorsBountyMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FryerOilInputMessage {
	private final int x, y, z;

	public FryerOilInputMessage(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public FryerOilInputMessage(FriendlyByteBuf buffer) {
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public static void buffer(FryerOilInputMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(FryerOilInputMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player player = context.getSender();
            int x = message.x;
			int y = message.y;
			int z = message.z;
			handleFryerOilInput(player, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleFryerOilInput(Player player, int x, int y, int z) {
		Level world = player.level();
		if (world.hasChunkAt(new BlockPos(x, y, z))){
            FryerGuiOilPutProcedure.execute(world, x, y, z, player);
        }
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ManorsBountyMod.addNetworkMessage(FryerOilInputMessage.class, FryerOilInputMessage::buffer, FryerOilInputMessage::new, FryerOilInputMessage::handler);
	}
}
