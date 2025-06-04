package com.djinfinite.manors_bounty.events;


import com.djinfinite.manors_bounty.ManorsBountyMod;
import com.djinfinite.manors_bounty.items.*;
import com.djinfinite.manors_bounty.utils.CapabilityUtils;
import com.djinfinite.manors_bounty.world.capability.provider.ModCapabilitiesProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = ManorsBountyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeCommonEvents {
    @SubscribeEvent
    public static void onLivingEntityUseItemFinish(LivingEntityUseItemEvent.Finish event) {
        LivingEntity entity = event.getEntity();
        ItemStack itemStack = event.getItem();
        IFoodItem foodItem = null;

        if(itemStack.is(Items.APPLE)){
            foodItem = new Apple.Self();
        }else if(itemStack.is(Items.SWEET_BERRIES)){
            foodItem = new SweetBerries.Self();
        }else if(itemStack.is(Items.GLOW_BERRIES)){
            foodItem = new GlowBerries.Self();
        }else if(itemStack.is(Items.CHORUS_FRUIT)){
            foodItem = new ChorusFruit.Self();
        }else if(itemStack.is(Items.ENCHANTED_GOLDEN_APPLE)){
            foodItem = new Apple.Enchanted();
        }else if(itemStack.is(Items.GOLDEN_APPLE)){
            foodItem = new Apple.Golden();
        }else if(itemStack.is(Items.MELON_SLICE)){
            foodItem = new WaterMelon.Self();
        }
        if(foodItem != null){
            if (foodItem.getFoodEffect().apply(entity)) {
                if(entity instanceof Player player) {
                    foodItem.cooldown(player, itemStack.getItem(),foodItem);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onAttachCaps(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player player) {
            if (!player.getCapability(ModCapabilitiesProvider.OH_ATTRIBUTE).isPresent()) {
                event.addCapability(ManorsBountyMod.createModResourceLocation("attribute"), new ModCapabilitiesProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onTickPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.phase == TickEvent.Phase.END) {
            if (!event.player.level().isClientSide()) {
                CapabilityUtils.tickCooldowns(event.player);
            }
        }
    }
}
