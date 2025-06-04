package com.djinfinite.manors_bounty.events;


import com.djinfinite.manors_bounty.ManorsBountyMod;
import com.djinfinite.manors_bounty.items.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = ManorsBountyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeClientEvents {
    @SubscribeEvent
    public static void onClientTick(TickEvent.PlayerTickEvent event) {

    }

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack();
        Item item = itemStack.getItem();
        if(item instanceof IFoodItem iFoodItem){
            event.getToolTip().addAll(iFoodItem.tooltips(itemStack));
        }
        if(itemStack.is(Items.APPLE)){
            Apple.Self self = new Apple.Self();
            event.getToolTip().addAll(self.tooltips(self,itemStack));
        }else if(itemStack.is(Items.SWEET_BERRIES)){
            SweetBerries.Self self = new SweetBerries.Self();
            event.getToolTip().addAll(self.tooltips(self,itemStack));
        }else if(itemStack.is(Items.GLOW_BERRIES)){
            GlowBerries.Self self = new GlowBerries.Self();
            event.getToolTip().addAll(self.tooltips(self,itemStack));
        }else if(itemStack.is(Items.CHORUS_FRUIT)){
            ChorusFruit.Self self = new ChorusFruit.Self();
            event.getToolTip().addAll(self.tooltips(self,itemStack));
        }else if(itemStack.is(Items.ENCHANTED_GOLDEN_APPLE)){
            Apple.Enchanted self = new Apple.Enchanted();
            event.getToolTip().addAll(self.tooltips(self,itemStack));
        }else if(itemStack.is(Items.GOLDEN_APPLE)){
            Apple.Golden self = new Apple.Golden();
            event.getToolTip().addAll(self.tooltips(self,itemStack));
        }else if(itemStack.is(Items.MELON_SLICE)){
            WaterMelon.Self self = new WaterMelon.Self();
            event.getToolTip().addAll(self.tooltips(self,itemStack));
        }
    }

}
