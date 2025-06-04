
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package com.djinfinite.manors_bounty.registries;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;
@SuppressWarnings("unused")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModTrades {
	@SubscribeEvent
	public static void registerWanderingTrades(WandererTradesEvent event) {
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 18), new ItemStack(Items.DIAMOND, 8), new ItemStack(ModItems.MISO_SOUP.get(), 2), 1, 0, 0f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 16), new ItemStack(ModItems.PEARL_ROCK.get(), 8), new ItemStack(ModItems.CHRISTMAS_HAT_HELMET.get()), 2, 0, 0f));
	}

	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		// if (event.getType() == VillagerProfession.ARMORER) {
		//	event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12), new ItemStack(ModItems.PEARL_ROCK.get(), 4), new ItemStack(ModItems.MINER_HAT_HELMET.get()), 2, 5, 0f));
		// }
		if (event.getType() == VillagerProfession.FARMER) {
		//	event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12), new ItemStack(ModItems.PEARL_ROCK.get(), 4), new ItemStack(ModItems.CHEF_HAT_HELMET.get()), 2, 5, 0f));
		//	event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ModItems.TRUFFLE.get(), 2),
		//			new ItemStack(Items.EMERALD, 8), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 6), new ItemStack(ModItems.ORANGE.get(), 4), new ItemStack(ModBlocks.LEMON_SEED.get(), 2), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.DIAMOND, 8), new ItemStack(ModItems.STRAWBERRY.get(), 8), new ItemStack(ModItems.PINEBERRY.get(), 2), 4, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(ModItems.OLIVE_FRUIT.get(), 64), new ItemStack(Items.DIAMOND, 4), new ItemStack(ModItems.OLIVE_OIL_BUCKET.get()), 10, 5, 0f));
		}
		// if (event.getType() == VillagerProfession.CLERIC) {
		// 	event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 2),
		// 			new ItemStack(ModItems.PEARL_ROCK.get()), 16, 5, 0.05f));
		// }
		// if (event.getType() == VillagerProfession.LIBRARIAN) {
		// 	event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.GOLD_INGOT, 4), new ItemStack(ModBlocks.SHIRAZ_CARPET.get()), 10, 5, 0f));
		// 	event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Blocks.DIAMOND_BLOCK, 4), new ItemStack(ModBlocks.ICE_CREAM_MACHINE.get()), 10, 5, 0f));
		// 	event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Blocks.DIAMOND_BLOCK, 4), new ItemStack(ModBlocks.FRYER.get()), 10, 5, 0f));
		// 	event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Blocks.DIAMOND_BLOCK, 4), new ItemStack(ModBlocks.OVEN.get()), 10, 5, 0f));
		// }
		if (event.getType() == VillagerProfession.FISHERMAN) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 4),

					new ItemStack(ModItems.RAW_PRAWN.get(), 2), 20, 5, 0f));
		}
	}
}
