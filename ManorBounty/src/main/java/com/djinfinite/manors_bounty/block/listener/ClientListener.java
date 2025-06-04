package com.djinfinite.manors_bounty.block.listener;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import com.djinfinite.manors_bounty.registries.ModBlockEntities;
import com.djinfinite.manors_bounty.block.renderer.TrufflePieTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.ShirazCarpetTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.PrawnAndCornSoupBlockTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.PicnicMatTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.PicnicMatInfiniteTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.PancakeBlockTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.MisoSoupBlockTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.MarbleBowlTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.MagicCircleCarpetTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.HoundstoothInfiniteCarpetTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.HoundstoothCarpetTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.GiftTallRedTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.GiftTallPinkTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.GiftTallLuckyTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.GiftTallGreenTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.GiftTallBlueTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.GiftShortRedTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.GiftShortPinkTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.GiftShortLuckyTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.GiftShortGreenTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.GiftShortBlueTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.DragonFruitSliceBlockTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.CreamWithMushroomSoupBlockTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.ChristmasWreathsTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.ChristmasSockTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.ChristmasRibbonYellowTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.ChristmasRibbonWhiteTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.ChristmasRibbonRedTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.ChristmasRibbonBlueTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.ChristmasMiniGiftsYellowTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.ChristmasMiniGiftsWhiteTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.ChristmasMiniGiftsRedTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.ChristmasMiniGiftsBlueTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.ChristmasBaublesYellowTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.ChristmasBaublesWhiteTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.ChristmasBaublesRedTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.ChristmasBaublesBlueTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.CherriesPieTileRenderer;
import com.djinfinite.manors_bounty.block.renderer.BorschtBlockTileRenderer;
import com.djinfinite.manors_bounty.ManorsBountyMod;

@Mod.EventBusSubscriber(modid = ManorsBountyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(ModBlockEntities.CHRISTMAS_SOCK.get(), context -> new ChristmasSockTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.GIFT_SHORT_RED.get(), context -> new GiftShortRedTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.GIFT_SHORT_GREEN.get(), context -> new GiftShortGreenTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.GIFT_SHORT_BLUE.get(), context -> new GiftShortBlueTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.GIFT_SHORT_PINK.get(), context -> new GiftShortPinkTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.GIFT_SHORT_LUCKY.get(), context -> new GiftShortLuckyTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.GIFT_TALL_RED.get(), context -> new GiftTallRedTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.GIFT_TALL_GREEN.get(), context -> new GiftTallGreenTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.GIFT_TALL_BLUE.get(), context -> new GiftTallBlueTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.GIFT_TALL_PINK.get(), context -> new GiftTallPinkTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.GIFT_TALL_LUCKY.get(), context -> new GiftTallLuckyTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.CHRISTMAS_WREATHS.get(), context -> new ChristmasWreathsTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.CHERRIES_PIE.get(), context -> new CherriesPieTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.TRUFFLE_PIE.get(), context -> new TrufflePieTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.MARBLE_BOWL.get(), context -> new MarbleBowlTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.PRAWN_AND_CORN_SOUP_BLOCK.get(), context -> new PrawnAndCornSoupBlockTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.BORSCHT_BLOCK.get(), context -> new BorschtBlockTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.MISO_SOUP_BLOCK.get(), context -> new MisoSoupBlockTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.CREAM_WITH_MUSHROOM_SOUP_BLOCK.get(), context -> new CreamWithMushroomSoupBlockTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.DRAGON_FRUIT_SLICE_BLOCK.get(), context -> new DragonFruitSliceBlockTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.PANCAKE_BLOCK.get(), context -> new PancakeBlockTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.CHRISTMAS_RIBBON_RED.get(), context -> new ChristmasRibbonRedTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.CHRISTMAS_RIBBON_YELLOW.get(), context -> new ChristmasRibbonYellowTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.CHRISTMAS_RIBBON_BLUE.get(), context -> new ChristmasRibbonBlueTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.CHRISTMAS_RIBBON_WHITE.get(), context -> new ChristmasRibbonWhiteTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.CHRISTMAS_MINI_GIFTS_RED.get(), context -> new ChristmasMiniGiftsRedTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.CHRISTMAS_MINI_GIFTS_YELLOW.get(), context -> new ChristmasMiniGiftsYellowTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.CHRISTMAS_MINI_GIFTS_BLUE.get(), context -> new ChristmasMiniGiftsBlueTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.CHRISTMAS_MINI_GIFTS_WHITE.get(), context -> new ChristmasMiniGiftsWhiteTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.CHRISTMAS_BAUBLES_RED.get(), context -> new ChristmasBaublesRedTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.CHRISTMAS_BAUBLES_YELLOW.get(), context -> new ChristmasBaublesYellowTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.CHRISTMAS_BAUBLES_BLUE.get(), context -> new ChristmasBaublesBlueTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.CHRISTMAS_BAUBLES_WHITE.get(), context -> new ChristmasBaublesWhiteTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.HOUNDSTOOTH_CARPET.get(), context -> new HoundstoothCarpetTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.MAGIC_CIRCLE_CARPET.get(), context -> new MagicCircleCarpetTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.SHIRAZ_CARPET.get(), context -> new ShirazCarpetTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.HOUNDSTOOTH_INFINITE_CARPET.get(), context -> new HoundstoothInfiniteCarpetTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.PICNIC_MAT.get(), context -> new PicnicMatTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.PICNIC_MAT_INFINITE.get(), context -> new PicnicMatInfiniteTileRenderer());
	}
}
