package com.djinfinite.manors_bounty.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import com.djinfinite.manors_bounty.ManorsBountyMod;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ManorsBountyModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ManorsBountyMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables());
			PlayerVariables clone = event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables());
			if (!event.isWasDeath()) {
				clone.ccc_eat_x = original.ccc_eat_x;
				clone.ccc_eat_y = original.ccc_eat_y;
				clone.ccc_eat_z = original.ccc_eat_z;
				clone.niflheim_freezing = original.niflheim_freezing;
				clone.BerryBloodHeal = original.BerryBloodHeal;
				clone.AdditionalDamageMultiplier = original.AdditionalDamageMultiplier;
				clone.MB_AppleFoodsCooldown = original.MB_AppleFoodsCooldown;
				clone.MB_PeachFoodsCooldown = original.MB_PeachFoodsCooldown;
				clone.MB_PearFoodsCooldown = original.MB_PearFoodsCooldown;
				clone.MB_CherriesFoodsCooldown = original.MB_CherriesFoodsCooldown;
				clone.MB_OrangeFoodsCooldown = original.MB_OrangeFoodsCooldown;
				clone.MB_LemonFoodsCooldown = original.MB_LemonFoodsCooldown;
				clone.MB_StrawberryFoodsCooldown = original.MB_StrawberryFoodsCooldown;
				clone.MB_BlueberryFoodsCooldown = original.MB_BlueberryFoodsCooldown;
				clone.MB_CranberryFoodsCooldown = original.MB_CranberryFoodsCooldown;
				clone.MB_AcornFoodsCooldown = original.MB_AcornFoodsCooldown;
				clone.MB_FilbertFoodsCooldown = original.MB_FilbertFoodsCooldown;
				clone.MB_CherryBlossomsFoodsCooldown = original.MB_CherryBlossomsFoodsCooldown;
				clone.MB_StarfruitFoodsCooldown = original.MB_StarfruitFoodsCooldown;
				clone.MB_SweetBerriesFoodsCooldown = original.MB_SweetBerriesFoodsCooldown;
				clone.MB_GlowBerriesFoodsCooldown = original.MB_GlowBerriesFoodsCooldown;
				clone.MB_MangoFoodsCooldown = original.MB_MangoFoodsCooldown;
				clone.MB_DurianFoodsCooldown = original.MB_DurianFoodsCooldown;
				clone.MB_PineappleFoodsCooldown = original.MB_PineappleFoodsCooldown;
				clone.MB_WatermelonFoodsCooldown = original.MB_WatermelonFoodsCooldown;
				clone.MB_HamimelonFoodsCooldown = original.MB_HamimelonFoodsCooldown;
				clone.MB_AppleCooldown = original.MB_AppleCooldown;
				clone.MB_PeachCooldown = original.MB_PeachCooldown;
				clone.MB_PearCooldown = original.MB_PearCooldown;
				clone.MB_CherriesCooldown = original.MB_CherriesCooldown;
				clone.MB_OrangeCooldown = original.MB_OrangeCooldown;
				clone.MB_LemonCooldown = original.MB_LemonCooldown;
				clone.MB_StrawberryCooldown = original.MB_StrawberryCooldown;
				clone.MB_BlueberryCooldown = original.MB_BlueberryCooldown;
				clone.MB_CranberryCooldown = original.MB_CranberryCooldown;
				clone.MB_AcornCooldown = original.MB_AcornCooldown;
				clone.MB_FilbertCooldown = original.MB_FilbertCooldown;
				clone.MB_CherryBlossomsCooldown = original.MB_CherryBlossomsCooldown;
				clone.MB_StarfruitCooldown = original.MB_StarfruitCooldown;
				clone.MB_SweetBerriesCooldown = original.MB_SweetBerriesCooldown;
				clone.MB_GlowBerriesCooldown = original.MB_GlowBerriesCooldown;
				clone.MB_MangoCooldown = original.MB_MangoCooldown;
				clone.MB_DurianCooldown = original.MB_DurianCooldown;
				clone.MB_PineappleCooldown = original.MB_PineappleCooldown;
				clone.MB_WatermelonCooldown = original.MB_WatermelonCooldown;
				clone.MB_HamimelonCooldown = original.MB_HamimelonCooldown;
				clone.MB_DragonFruitFoodsCooldown = original.MB_DragonFruitFoodsCooldown;
				clone.MB_DragonFruitCooldown = original.MB_DragonFruitCooldown;
				clone.MB_OliveFruitFoodsCooldown = original.MB_OliveFruitFoodsCooldown;
				clone.MB_OliveFruitCooldown = original.MB_OliveFruitCooldown;
				clone.MB_ChorusFruitFoodsCooldown = original.MB_ChorusFruitFoodsCooldown;
				clone.MB_ChorusFruitCooldown = original.MB_ChorusFruitCooldown;
				clone.transmit_time = original.transmit_time;
				clone.LurkingDangerSneakingTick = original.LurkingDangerSneakingTick;
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
    });

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("manors_bounty", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double ccc_eat_x = 0.0;
		public double ccc_eat_y = 0;
		public double ccc_eat_z = 0;
		public double niflheim_freezing = 0;
		public double BerryBloodHeal = 0;
		public double AdditionalDamageMultiplier = 1.0;
		public double MB_AppleFoodsCooldown = 0;
		public double MB_PeachFoodsCooldown = 0;
		public double MB_PearFoodsCooldown = 0;
		public double MB_CherriesFoodsCooldown = 0;
		public double MB_OrangeFoodsCooldown = 0;
		public double MB_LemonFoodsCooldown = 0;
		public double MB_StrawberryFoodsCooldown = 0;
		public double MB_BlueberryFoodsCooldown = 0;
		public double MB_CranberryFoodsCooldown = 0;
		public double MB_AcornFoodsCooldown = 0;
		public double MB_FilbertFoodsCooldown = 0;
		public double MB_CherryBlossomsFoodsCooldown = 0;
		public double MB_StarfruitFoodsCooldown = 0;
		public double MB_SweetBerriesFoodsCooldown = 0;
		public double MB_GlowBerriesFoodsCooldown = 0;
		public double MB_MangoFoodsCooldown = 0;
		public double MB_DurianFoodsCooldown = 0;
		public double MB_PineappleFoodsCooldown = 0;
		public double MB_WatermelonFoodsCooldown = 0;
		public double MB_HamimelonFoodsCooldown = 0;
		public double MB_AppleCooldown = 0;
		public double MB_PeachCooldown = 0;
		public double MB_PearCooldown = 0;
		public double MB_CherriesCooldown = 0;
		public double MB_OrangeCooldown = 0;
		public double MB_LemonCooldown = 0;
		public double MB_StrawberryCooldown = 0;
		public double MB_BlueberryCooldown = 0;
		public double MB_CranberryCooldown = 0;
		public double MB_AcornCooldown = 0;
		public double MB_FilbertCooldown = 0;
		public double MB_CherryBlossomsCooldown = 0;
		public double MB_StarfruitCooldown = 0;
		public double MB_SweetBerriesCooldown = 0;
		public double MB_GlowBerriesCooldown = 0;
		public double MB_MangoCooldown = 0;
		public double MB_DurianCooldown = 0;
		public double MB_PineappleCooldown = 0;
		public double MB_WatermelonCooldown = 0;
		public double MB_HamimelonCooldown = 0;
		public double MB_DragonFruitFoodsCooldown = 0;
		public double MB_DragonFruitCooldown = 0;
		public double MB_OliveFruitFoodsCooldown = 0;
		public double MB_OliveFruitCooldown = 0;
		public double MB_ChorusFruitFoodsCooldown = 0;
		public double MB_ChorusFruitCooldown = 0;
		public double transmit_time = 0;
		public double LurkingDangerSneakingTick = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				ManorsBountyMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("ccc_eat_x", ccc_eat_x);
			nbt.putDouble("ccc_eat_y", ccc_eat_y);
			nbt.putDouble("ccc_eat_z", ccc_eat_z);
			nbt.putDouble("niflheim_freezing", niflheim_freezing);
			nbt.putDouble("BerryBloodHeal", BerryBloodHeal);
			nbt.putDouble("AdditionalDamageMultiplier", AdditionalDamageMultiplier);
			nbt.putDouble("MB_AppleFoodsCooldown", MB_AppleFoodsCooldown);
			nbt.putDouble("MB_PeachFoodsCooldown", MB_PeachFoodsCooldown);
			nbt.putDouble("MB_PearFoodsCooldown", MB_PearFoodsCooldown);
			nbt.putDouble("MB_CherriesFoodsCooldown", MB_CherriesFoodsCooldown);
			nbt.putDouble("MB_OrangeFoodsCooldown", MB_OrangeFoodsCooldown);
			nbt.putDouble("MB_LemonFoodsCooldown", MB_LemonFoodsCooldown);
			nbt.putDouble("MB_StrawberryFoodsCooldown", MB_StrawberryFoodsCooldown);
			nbt.putDouble("MB_BlueberryFoodsCooldown", MB_BlueberryFoodsCooldown);
			nbt.putDouble("MB_CranberryFoodsCooldown", MB_CranberryFoodsCooldown);
			nbt.putDouble("MB_AcornFoodsCooldown", MB_AcornFoodsCooldown);
			nbt.putDouble("MB_FilbertFoodsCooldown", MB_FilbertFoodsCooldown);
			nbt.putDouble("MB_CherryBlossomsFoodsCooldown", MB_CherryBlossomsFoodsCooldown);
			nbt.putDouble("MB_StarfruitFoodsCooldown", MB_StarfruitFoodsCooldown);
			nbt.putDouble("MB_SweetBerriesFoodsCooldown", MB_SweetBerriesFoodsCooldown);
			nbt.putDouble("MB_GlowBerriesFoodsCooldown", MB_GlowBerriesFoodsCooldown);
			nbt.putDouble("MB_MangoFoodsCooldown", MB_MangoFoodsCooldown);
			nbt.putDouble("MB_DurianFoodsCooldown", MB_DurianFoodsCooldown);
			nbt.putDouble("MB_PineappleFoodsCooldown", MB_PineappleFoodsCooldown);
			nbt.putDouble("MB_WatermelonFoodsCooldown", MB_WatermelonFoodsCooldown);
			nbt.putDouble("MB_HamimelonFoodsCooldown", MB_HamimelonFoodsCooldown);
			nbt.putDouble("MB_AppleCooldown", MB_AppleCooldown);
			nbt.putDouble("MB_PeachCooldown", MB_PeachCooldown);
			nbt.putDouble("MB_PearCooldown", MB_PearCooldown);
			nbt.putDouble("MB_CherriesCooldown", MB_CherriesCooldown);
			nbt.putDouble("MB_OrangeCooldown", MB_OrangeCooldown);
			nbt.putDouble("MB_LemonCooldown", MB_LemonCooldown);
			nbt.putDouble("MB_StrawberryCooldown", MB_StrawberryCooldown);
			nbt.putDouble("MB_BlueberryCooldown", MB_BlueberryCooldown);
			nbt.putDouble("MB_CranberryCooldown", MB_CranberryCooldown);
			nbt.putDouble("MB_AcornCooldown", MB_AcornCooldown);
			nbt.putDouble("MB_FilbertCooldown", MB_FilbertCooldown);
			nbt.putDouble("MB_CherryBlossomsCooldown", MB_CherryBlossomsCooldown);
			nbt.putDouble("MB_StarfruitCooldown", MB_StarfruitCooldown);
			nbt.putDouble("MB_SweetBerriesCooldown", MB_SweetBerriesCooldown);
			nbt.putDouble("MB_GlowBerriesCooldown", MB_GlowBerriesCooldown);
			nbt.putDouble("MB_MangoCooldown", MB_MangoCooldown);
			nbt.putDouble("MB_DurianCooldown", MB_DurianCooldown);
			nbt.putDouble("MB_PineappleCooldown", MB_PineappleCooldown);
			nbt.putDouble("MB_WatermelonCooldown", MB_WatermelonCooldown);
			nbt.putDouble("MB_HamimelonCooldown", MB_HamimelonCooldown);
			nbt.putDouble("MB_DragonFruitFoodsCooldown", MB_DragonFruitFoodsCooldown);
			nbt.putDouble("MB_DragonFruitCooldown", MB_DragonFruitCooldown);
			nbt.putDouble("MB_OliveFruitFoodsCooldown", MB_OliveFruitFoodsCooldown);
			nbt.putDouble("MB_OliveFruitCooldown", MB_OliveFruitCooldown);
			nbt.putDouble("MB_ChorusFruitFoodsCooldown", MB_ChorusFruitFoodsCooldown);
			nbt.putDouble("MB_ChorusFruitCooldown", MB_ChorusFruitCooldown);
			nbt.putDouble("transmit_time", transmit_time);
			nbt.putDouble("LurkingDangerSneakingTick", LurkingDangerSneakingTick);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			ccc_eat_x = nbt.getDouble("ccc_eat_x");
			ccc_eat_y = nbt.getDouble("ccc_eat_y");
			ccc_eat_z = nbt.getDouble("ccc_eat_z");
			niflheim_freezing = nbt.getDouble("niflheim_freezing");
			BerryBloodHeal = nbt.getDouble("BerryBloodHeal");
			AdditionalDamageMultiplier = nbt.getDouble("AdditionalDamageMultiplier");
			MB_AppleFoodsCooldown = nbt.getDouble("MB_AppleFoodsCooldown");
			MB_PeachFoodsCooldown = nbt.getDouble("MB_PeachFoodsCooldown");
			MB_PearFoodsCooldown = nbt.getDouble("MB_PearFoodsCooldown");
			MB_CherriesFoodsCooldown = nbt.getDouble("MB_CherriesFoodsCooldown");
			MB_OrangeFoodsCooldown = nbt.getDouble("MB_OrangeFoodsCooldown");
			MB_LemonFoodsCooldown = nbt.getDouble("MB_LemonFoodsCooldown");
			MB_StrawberryFoodsCooldown = nbt.getDouble("MB_StrawberryFoodsCooldown");
			MB_BlueberryFoodsCooldown = nbt.getDouble("MB_BlueberryFoodsCooldown");
			MB_CranberryFoodsCooldown = nbt.getDouble("MB_CranberryFoodsCooldown");
			MB_AcornFoodsCooldown = nbt.getDouble("MB_AcornFoodsCooldown");
			MB_FilbertFoodsCooldown = nbt.getDouble("MB_FilbertFoodsCooldown");
			MB_CherryBlossomsFoodsCooldown = nbt.getDouble("MB_CherryBlossomsFoodsCooldown");
			MB_StarfruitFoodsCooldown = nbt.getDouble("MB_StarfruitFoodsCooldown");
			MB_SweetBerriesFoodsCooldown = nbt.getDouble("MB_SweetBerriesFoodsCooldown");
			MB_GlowBerriesFoodsCooldown = nbt.getDouble("MB_GlowBerriesFoodsCooldown");
			MB_MangoFoodsCooldown = nbt.getDouble("MB_MangoFoodsCooldown");
			MB_DurianFoodsCooldown = nbt.getDouble("MB_DurianFoodsCooldown");
			MB_PineappleFoodsCooldown = nbt.getDouble("MB_PineappleFoodsCooldown");
			MB_WatermelonFoodsCooldown = nbt.getDouble("MB_WatermelonFoodsCooldown");
			MB_HamimelonFoodsCooldown = nbt.getDouble("MB_HamimelonFoodsCooldown");
			MB_AppleCooldown = nbt.getDouble("MB_AppleCooldown");
			MB_PeachCooldown = nbt.getDouble("MB_PeachCooldown");
			MB_PearCooldown = nbt.getDouble("MB_PearCooldown");
			MB_CherriesCooldown = nbt.getDouble("MB_CherriesCooldown");
			MB_OrangeCooldown = nbt.getDouble("MB_OrangeCooldown");
			MB_LemonCooldown = nbt.getDouble("MB_LemonCooldown");
			MB_StrawberryCooldown = nbt.getDouble("MB_StrawberryCooldown");
			MB_BlueberryCooldown = nbt.getDouble("MB_BlueberryCooldown");
			MB_CranberryCooldown = nbt.getDouble("MB_CranberryCooldown");
			MB_AcornCooldown = nbt.getDouble("MB_AcornCooldown");
			MB_FilbertCooldown = nbt.getDouble("MB_FilbertCooldown");
			MB_CherryBlossomsCooldown = nbt.getDouble("MB_CherryBlossomsCooldown");
			MB_StarfruitCooldown = nbt.getDouble("MB_StarfruitCooldown");
			MB_SweetBerriesCooldown = nbt.getDouble("MB_SweetBerriesCooldown");
			MB_GlowBerriesCooldown = nbt.getDouble("MB_GlowBerriesCooldown");
			MB_MangoCooldown = nbt.getDouble("MB_MangoCooldown");
			MB_DurianCooldown = nbt.getDouble("MB_DurianCooldown");
			MB_PineappleCooldown = nbt.getDouble("MB_PineappleCooldown");
			MB_WatermelonCooldown = nbt.getDouble("MB_WatermelonCooldown");
			MB_HamimelonCooldown = nbt.getDouble("MB_HamimelonCooldown");
			MB_DragonFruitFoodsCooldown = nbt.getDouble("MB_DragonFruitFoodsCooldown");
			MB_DragonFruitCooldown = nbt.getDouble("MB_DragonFruitCooldown");
			MB_OliveFruitFoodsCooldown = nbt.getDouble("MB_OliveFruitFoodsCooldown");
			MB_OliveFruitCooldown = nbt.getDouble("MB_OliveFruitCooldown");
			MB_ChorusFruitFoodsCooldown = nbt.getDouble("MB_ChorusFruitFoodsCooldown");
			MB_ChorusFruitCooldown = nbt.getDouble("MB_ChorusFruitCooldown");
			transmit_time = nbt.getDouble("transmit_time");
			LurkingDangerSneakingTick = nbt.getDouble("LurkingDangerSneakingTick");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables());
					variables.ccc_eat_x = message.data.ccc_eat_x;
					variables.ccc_eat_y = message.data.ccc_eat_y;
					variables.ccc_eat_z = message.data.ccc_eat_z;
					variables.niflheim_freezing = message.data.niflheim_freezing;
					variables.BerryBloodHeal = message.data.BerryBloodHeal;
					variables.AdditionalDamageMultiplier = message.data.AdditionalDamageMultiplier;
					variables.MB_AppleFoodsCooldown = message.data.MB_AppleFoodsCooldown;
					variables.MB_PeachFoodsCooldown = message.data.MB_PeachFoodsCooldown;
					variables.MB_PearFoodsCooldown = message.data.MB_PearFoodsCooldown;
					variables.MB_CherriesFoodsCooldown = message.data.MB_CherriesFoodsCooldown;
					variables.MB_OrangeFoodsCooldown = message.data.MB_OrangeFoodsCooldown;
					variables.MB_LemonFoodsCooldown = message.data.MB_LemonFoodsCooldown;
					variables.MB_StrawberryFoodsCooldown = message.data.MB_StrawberryFoodsCooldown;
					variables.MB_BlueberryFoodsCooldown = message.data.MB_BlueberryFoodsCooldown;
					variables.MB_CranberryFoodsCooldown = message.data.MB_CranberryFoodsCooldown;
					variables.MB_AcornFoodsCooldown = message.data.MB_AcornFoodsCooldown;
					variables.MB_FilbertFoodsCooldown = message.data.MB_FilbertFoodsCooldown;
					variables.MB_CherryBlossomsFoodsCooldown = message.data.MB_CherryBlossomsFoodsCooldown;
					variables.MB_StarfruitFoodsCooldown = message.data.MB_StarfruitFoodsCooldown;
					variables.MB_SweetBerriesFoodsCooldown = message.data.MB_SweetBerriesFoodsCooldown;
					variables.MB_GlowBerriesFoodsCooldown = message.data.MB_GlowBerriesFoodsCooldown;
					variables.MB_MangoFoodsCooldown = message.data.MB_MangoFoodsCooldown;
					variables.MB_DurianFoodsCooldown = message.data.MB_DurianFoodsCooldown;
					variables.MB_PineappleFoodsCooldown = message.data.MB_PineappleFoodsCooldown;
					variables.MB_WatermelonFoodsCooldown = message.data.MB_WatermelonFoodsCooldown;
					variables.MB_HamimelonFoodsCooldown = message.data.MB_HamimelonFoodsCooldown;
					variables.MB_AppleCooldown = message.data.MB_AppleCooldown;
					variables.MB_PeachCooldown = message.data.MB_PeachCooldown;
					variables.MB_PearCooldown = message.data.MB_PearCooldown;
					variables.MB_CherriesCooldown = message.data.MB_CherriesCooldown;
					variables.MB_OrangeCooldown = message.data.MB_OrangeCooldown;
					variables.MB_LemonCooldown = message.data.MB_LemonCooldown;
					variables.MB_StrawberryCooldown = message.data.MB_StrawberryCooldown;
					variables.MB_BlueberryCooldown = message.data.MB_BlueberryCooldown;
					variables.MB_CranberryCooldown = message.data.MB_CranberryCooldown;
					variables.MB_AcornCooldown = message.data.MB_AcornCooldown;
					variables.MB_FilbertCooldown = message.data.MB_FilbertCooldown;
					variables.MB_CherryBlossomsCooldown = message.data.MB_CherryBlossomsCooldown;
					variables.MB_StarfruitCooldown = message.data.MB_StarfruitCooldown;
					variables.MB_SweetBerriesCooldown = message.data.MB_SweetBerriesCooldown;
					variables.MB_GlowBerriesCooldown = message.data.MB_GlowBerriesCooldown;
					variables.MB_MangoCooldown = message.data.MB_MangoCooldown;
					variables.MB_DurianCooldown = message.data.MB_DurianCooldown;
					variables.MB_PineappleCooldown = message.data.MB_PineappleCooldown;
					variables.MB_WatermelonCooldown = message.data.MB_WatermelonCooldown;
					variables.MB_HamimelonCooldown = message.data.MB_HamimelonCooldown;
					variables.MB_DragonFruitFoodsCooldown = message.data.MB_DragonFruitFoodsCooldown;
					variables.MB_DragonFruitCooldown = message.data.MB_DragonFruitCooldown;
					variables.MB_OliveFruitFoodsCooldown = message.data.MB_OliveFruitFoodsCooldown;
					variables.MB_OliveFruitCooldown = message.data.MB_OliveFruitCooldown;
					variables.MB_ChorusFruitFoodsCooldown = message.data.MB_ChorusFruitFoodsCooldown;
					variables.MB_ChorusFruitCooldown = message.data.MB_ChorusFruitCooldown;
					variables.transmit_time = message.data.transmit_time;
					variables.LurkingDangerSneakingTick = message.data.LurkingDangerSneakingTick;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
