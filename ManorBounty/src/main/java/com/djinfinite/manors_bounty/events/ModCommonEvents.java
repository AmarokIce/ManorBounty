package com.djinfinite.manors_bounty.events;

import com.djinfinite.manors_bounty.ManorsBountyMod;
import com.djinfinite.manors_bounty.network.network.NetworkHandler;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = ManorsBountyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonEvents {
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(NetworkHandler::register);
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {


    }
}
