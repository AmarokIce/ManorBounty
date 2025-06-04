package com.djinfinite.manors_bounty;

import com.djinfinite.manors_bounty.registries.*;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;

import com.djinfinite.manors_bounty.world.features.StructureFeature;

import java.util.*;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.concurrent.ConcurrentLinkedQueue;

@Mod("manors_bounty")
public class ManorsBountyMod {
	public static final String MOD_ID = "manors_bounty";

	public ManorsBountyMod() {
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		MinecraftForge.EVENT_BUS.register(this);
		modBus.addListener(this::gatherData);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		ModFeatures.FEATURES.register(bus);
		ModSounds.REGISTRY.register(bus);
		ModBlocks.REGISTRY.register(bus);
		ModBlockEntities.REGISTRY.register(bus);
		ModItems.REGISTRY.register(bus);

		ModEntities.REGISTRY.register(bus);

		ModTabs.REGISTRY.register(bus);

		StructureFeature.REGISTRY.register(bus);
		ModMobEffects.REGISTRY.register(bus);
		ModPotions.REGISTRY.register(bus);

		ModParticleTypes.REGISTRY.register(bus);

		ModMenus.REGISTRY.register(bus);
		ModFluids.REGISTRY.register(bus);
		ModFluidTypes.REGISTRY.register(bus);
	}
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MOD_ID, MOD_ID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
	}

	public static ResourceLocation createModResourceLocation(String string) {
		return new ResourceLocation(MOD_ID,string);
	}

    @SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setValue(work.getValue() - 1);
				if (work.getValue() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getKey().run());
			workQueue.removeAll(actions);
		}
	}

	private void gatherData(GatherDataEvent event) {
		PackOutput output = event.getGenerator().getPackOutput();
		event.getGenerator().addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(output, event.getLookupProvider(), WorldGen.BUILDER, Set.of(MOD_ID)));
	}
}
