
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.djinfinite.manors_bounty.registries;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import com.djinfinite.manors_bounty.entity.LoveSpectrumYellowEntity;
import com.djinfinite.manors_bounty.entity.LoveSpectrumRedEntity;
import com.djinfinite.manors_bounty.entity.LoveSpectrumBlueEntity;
import com.djinfinite.manors_bounty.ManorsBountyMod;
@SuppressWarnings("unused")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ManorsBountyMod.MOD_ID);
	public static final RegistryObject<EntityType<LoveSpectrumRedEntity>> LOVE_SPECTRUM_RED = register("love_spectrum_red", EntityType.Builder.<LoveSpectrumRedEntity>of(LoveSpectrumRedEntity::new, MobCategory.MISC)
			.setCustomClientFactory(LoveSpectrumRedEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<LoveSpectrumYellowEntity>> LOVE_SPECTRUM_YELLOW = register("love_spectrum_yellow", EntityType.Builder.<LoveSpectrumYellowEntity>of(LoveSpectrumYellowEntity::new, MobCategory.MISC)
			.setCustomClientFactory(LoveSpectrumYellowEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<LoveSpectrumBlueEntity>> LOVE_SPECTRUM_BLUE = register("love_spectrum_blue", EntityType.Builder.<LoveSpectrumBlueEntity>of(LoveSpectrumBlueEntity::new, MobCategory.MISC)
			.setCustomClientFactory(LoveSpectrumBlueEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
	}
}
