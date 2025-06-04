
package com.djinfinite.manors_bounty.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.world.inventory.OvenGuiMenu;
import com.djinfinite.manors_bounty.procedures.OvenGuiWorkBottonProcedure;
import com.djinfinite.manors_bounty.procedures.OvenGuiBottonAClickProcedure;
import com.djinfinite.manors_bounty.procedures.OvenGuiBotton1ClickProcedure;
import com.djinfinite.manors_bounty.ManorsBountyMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OvenGuiButtonMessage {
	private final int buttonID, x, y, z;

	public OvenGuiButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public OvenGuiButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(OvenGuiButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(OvenGuiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = OvenGuiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OvenGuiBotton1ClickProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			OvenGuiBottonAClickProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			OvenGuiWorkBottonProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ManorsBountyMod.addNetworkMessage(OvenGuiButtonMessage.class, OvenGuiButtonMessage::buffer, OvenGuiButtonMessage::new, OvenGuiButtonMessage::handler);
	}
}
