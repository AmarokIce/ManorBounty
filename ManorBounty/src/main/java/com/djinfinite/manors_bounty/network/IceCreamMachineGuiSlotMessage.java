
package com.djinfinite.manors_bounty.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.world.inventory.IceCreamMachineGuiMenu;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineSlotSoundProcedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFluidPutProcedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineConeSoundProcedure;
import com.djinfinite.manors_bounty.ManorsBountyMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IceCreamMachineGuiSlotMessage {
	private final int slotID, x, y, z, changeType, meta;

	public IceCreamMachineGuiSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) {
		this.slotID = slotID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.changeType = changeType;
		this.meta = meta;
	}

	public IceCreamMachineGuiSlotMessage(FriendlyByteBuf buffer) {
		this.slotID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.changeType = buffer.readInt();
		this.meta = buffer.readInt();
	}

	public static void buffer(IceCreamMachineGuiSlotMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}

	public static void handler(IceCreamMachineGuiSlotMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int slotID = message.slotID;
			int changeType = message.changeType;
			int meta = message.meta;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleSlotAction(entity, slotID, changeType, meta, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = IceCreamMachineGuiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slot == 0 && changeType == 0) {

			IceCreamMachineConeSoundProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 1 && changeType == 0) {

			IceCreamMachineSlotSoundProcedure.execute(world, x, y, z);
		}
		if (slot == 2 && changeType == 0) {

			IceCreamMachineSlotSoundProcedure.execute(world, x, y, z);
		}
		if (slot == 3 && changeType == 0) {

			IceCreamMachineGuiFluidPutProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ManorsBountyMod.addNetworkMessage(IceCreamMachineGuiSlotMessage.class, IceCreamMachineGuiSlotMessage::buffer, IceCreamMachineGuiSlotMessage::new, IceCreamMachineGuiSlotMessage::handler);
	}
}
