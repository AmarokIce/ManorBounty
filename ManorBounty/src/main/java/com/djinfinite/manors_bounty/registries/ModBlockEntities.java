
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.djinfinite.manors_bounty.registries;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import com.djinfinite.manors_bounty.block.entity.TrufflePieTileEntity;
import com.djinfinite.manors_bounty.block.entity.ShirazCarpetTileEntity;
import com.djinfinite.manors_bounty.block.entity.PrawnAndCornSoupBlockTileEntity;
import com.djinfinite.manors_bounty.block.entity.PicnicMatTileEntity;
import com.djinfinite.manors_bounty.block.entity.PicnicMatInfiniteTileEntity;
import com.djinfinite.manors_bounty.block.entity.PancakeBlockTileEntity;
import com.djinfinite.manors_bounty.block.entity.OvenBlockEntity;
import com.djinfinite.manors_bounty.block.entity.MisoSoupBlockTileEntity;
import com.djinfinite.manors_bounty.block.entity.MarbleBowlTileEntity;
import com.djinfinite.manors_bounty.block.entity.MagicCircleCarpetTileEntity;
import com.djinfinite.manors_bounty.block.entity.IceCreamMachineBlockEntity;
import com.djinfinite.manors_bounty.block.entity.HoundstoothInfiniteCarpetTileEntity;
import com.djinfinite.manors_bounty.block.entity.HoundstoothCarpetTileEntity;
import com.djinfinite.manors_bounty.block.entity.GiftTallRedTileEntity;
import com.djinfinite.manors_bounty.block.entity.GiftTallPinkTileEntity;
import com.djinfinite.manors_bounty.block.entity.GiftTallLuckyTileEntity;
import com.djinfinite.manors_bounty.block.entity.GiftTallGreenTileEntity;
import com.djinfinite.manors_bounty.block.entity.GiftTallBlueTileEntity;
import com.djinfinite.manors_bounty.block.entity.GiftShortRedTileEntity;
import com.djinfinite.manors_bounty.block.entity.GiftShortPinkTileEntity;
import com.djinfinite.manors_bounty.block.entity.GiftShortLuckyTileEntity;
import com.djinfinite.manors_bounty.block.entity.GiftShortGreenTileEntity;
import com.djinfinite.manors_bounty.block.entity.GiftShortBlueTileEntity;
import com.djinfinite.manors_bounty.block.entity.FryerBlockEntity;
import com.djinfinite.manors_bounty.block.entity.DragonFruitSliceBlockTileEntity;
import com.djinfinite.manors_bounty.block.entity.CuttingBoardBlockEntity;
import com.djinfinite.manors_bounty.block.entity.CreamWithMushroomSoupBlockTileEntity;
import com.djinfinite.manors_bounty.block.entity.ChristmasWreathsTileEntity;
import com.djinfinite.manors_bounty.block.entity.ChristmasSockTileEntity;
import com.djinfinite.manors_bounty.block.entity.ChristmasRibbonYellowTileEntity;
import com.djinfinite.manors_bounty.block.entity.ChristmasRibbonWhiteTileEntity;
import com.djinfinite.manors_bounty.block.entity.ChristmasRibbonRedTileEntity;
import com.djinfinite.manors_bounty.block.entity.ChristmasRibbonBlueTileEntity;
import com.djinfinite.manors_bounty.block.entity.ChristmasMiniGiftsYellowTileEntity;
import com.djinfinite.manors_bounty.block.entity.ChristmasMiniGiftsWhiteTileEntity;
import com.djinfinite.manors_bounty.block.entity.ChristmasMiniGiftsRedTileEntity;
import com.djinfinite.manors_bounty.block.entity.ChristmasMiniGiftsBlueTileEntity;
import com.djinfinite.manors_bounty.block.entity.ChristmasBaublesYellowTileEntity;
import com.djinfinite.manors_bounty.block.entity.ChristmasBaublesWhiteTileEntity;
import com.djinfinite.manors_bounty.block.entity.ChristmasBaublesRedTileEntity;
import com.djinfinite.manors_bounty.block.entity.ChristmasBaublesBlueTileEntity;
import com.djinfinite.manors_bounty.block.entity.CherriesPieTileEntity;
import com.djinfinite.manors_bounty.block.entity.BorschtBlockTileEntity;
import com.djinfinite.manors_bounty.ManorsBountyMod;

public class ModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ManorsBountyMod.MOD_ID);
	public static final RegistryObject<BlockEntityType<ChristmasSockTileEntity>> CHRISTMAS_SOCK = REGISTRY.register("christmas_sock",
			() -> BlockEntityType.Builder.of(ChristmasSockTileEntity::new, ModBlocks.CHRISTMAS_SOCK.get()).build(null));
	public static final RegistryObject<BlockEntityType<GiftShortRedTileEntity>> GIFT_SHORT_RED = REGISTRY.register("gift_short_red",
			() -> BlockEntityType.Builder.of(GiftShortRedTileEntity::new, ModBlocks.GIFT_SHORT_RED.get()).build(null));
	public static final RegistryObject<BlockEntityType<GiftShortGreenTileEntity>> GIFT_SHORT_GREEN = REGISTRY.register("gift_short_green",
			() -> BlockEntityType.Builder.of(GiftShortGreenTileEntity::new, ModBlocks.GIFT_SHORT_GREEN.get()).build(null));
	public static final RegistryObject<BlockEntityType<GiftShortBlueTileEntity>> GIFT_SHORT_BLUE = REGISTRY.register("gift_short_blue",
			() -> BlockEntityType.Builder.of(GiftShortBlueTileEntity::new, ModBlocks.GIFT_SHORT_BLUE.get()).build(null));
	public static final RegistryObject<BlockEntityType<GiftShortPinkTileEntity>> GIFT_SHORT_PINK = REGISTRY.register("gift_short_pink",
			() -> BlockEntityType.Builder.of(GiftShortPinkTileEntity::new, ModBlocks.GIFT_SHORT_PINK.get()).build(null));
	public static final RegistryObject<BlockEntityType<GiftShortLuckyTileEntity>> GIFT_SHORT_LUCKY = REGISTRY.register("gift_short_lucky",
			() -> BlockEntityType.Builder.of(GiftShortLuckyTileEntity::new, ModBlocks.GIFT_SHORT_LUCKY.get()).build(null));
	public static final RegistryObject<BlockEntityType<GiftTallRedTileEntity>> GIFT_TALL_RED = REGISTRY.register("gift_tall_red", () -> BlockEntityType.Builder.of(GiftTallRedTileEntity::new, ModBlocks.GIFT_TALL_RED.get()).build(null));
	public static final RegistryObject<BlockEntityType<GiftTallGreenTileEntity>> GIFT_TALL_GREEN = REGISTRY.register("gift_tall_green",
			() -> BlockEntityType.Builder.of(GiftTallGreenTileEntity::new, ModBlocks.GIFT_TALL_GREEN.get()).build(null));
	public static final RegistryObject<BlockEntityType<GiftTallBlueTileEntity>> GIFT_TALL_BLUE = REGISTRY.register("gift_tall_blue",
			() -> BlockEntityType.Builder.of(GiftTallBlueTileEntity::new, ModBlocks.GIFT_TALL_BLUE.get()).build(null));
	public static final RegistryObject<BlockEntityType<GiftTallPinkTileEntity>> GIFT_TALL_PINK = REGISTRY.register("gift_tall_pink",
			() -> BlockEntityType.Builder.of(GiftTallPinkTileEntity::new, ModBlocks.GIFT_TALL_PINK.get()).build(null));
	public static final RegistryObject<BlockEntityType<GiftTallLuckyTileEntity>> GIFT_TALL_LUCKY = REGISTRY.register("gift_tall_lucky",
			() -> BlockEntityType.Builder.of(GiftTallLuckyTileEntity::new, ModBlocks.GIFT_TALL_LUCKY.get()).build(null));
	public static final RegistryObject<BlockEntityType<ChristmasWreathsTileEntity>> CHRISTMAS_WREATHS = REGISTRY.register("christmas_wreaths",
			() -> BlockEntityType.Builder.of(ChristmasWreathsTileEntity::new, ModBlocks.CHRISTMAS_WREATHS.get()).build(null));
	public static final RegistryObject<BlockEntityType<?>> ICE_CREAM_MACHINE = register("ice_cream_machine", ModBlocks.ICE_CREAM_MACHINE, IceCreamMachineBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> FRYER = register("fryer", ModBlocks.FRYER, FryerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CUTTING_BOARD = register("cutting_board", ModBlocks.CUTTING_BOARD, CuttingBoardBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> OVEN = register("oven", ModBlocks.OVEN, OvenBlockEntity::new);
	public static final RegistryObject<BlockEntityType<CherriesPieTileEntity>> CHERRIES_PIE = REGISTRY.register("cherries_pie", () -> BlockEntityType.Builder.of(CherriesPieTileEntity::new, ModBlocks.CHERRIES_PIE.get()).build(null));
	public static final RegistryObject<BlockEntityType<TrufflePieTileEntity>> TRUFFLE_PIE = REGISTRY.register("truffle_pie", () -> BlockEntityType.Builder.of(TrufflePieTileEntity::new, ModBlocks.TRUFFLE_PIE.get()).build(null));
	public static final RegistryObject<BlockEntityType<MarbleBowlTileEntity>> MARBLE_BOWL = REGISTRY.register("marble_bowl", () -> BlockEntityType.Builder.of(MarbleBowlTileEntity::new, ModBlocks.MARBLE_BOWL.get()).build(null));
	public static final RegistryObject<BlockEntityType<PrawnAndCornSoupBlockTileEntity>> PRAWN_AND_CORN_SOUP_BLOCK = REGISTRY.register("prawn_and_corn_soup_block",
			() -> BlockEntityType.Builder.of(PrawnAndCornSoupBlockTileEntity::new, ModBlocks.PRAWN_AND_CORN_SOUP_BLOCK.get()).build(null));
	public static final RegistryObject<BlockEntityType<BorschtBlockTileEntity>> BORSCHT_BLOCK = REGISTRY.register("borscht_block", () -> BlockEntityType.Builder.of(BorschtBlockTileEntity::new, ModBlocks.BORSCHT_BLOCK.get()).build(null));
	public static final RegistryObject<BlockEntityType<MisoSoupBlockTileEntity>> MISO_SOUP_BLOCK = REGISTRY.register("miso_soup_block",
			() -> BlockEntityType.Builder.of(MisoSoupBlockTileEntity::new, ModBlocks.MISO_SOUP_BLOCK.get()).build(null));
	public static final RegistryObject<BlockEntityType<CreamWithMushroomSoupBlockTileEntity>> CREAM_WITH_MUSHROOM_SOUP_BLOCK = REGISTRY.register("cream_with_mushroom_soup_block",
			() -> BlockEntityType.Builder.of(CreamWithMushroomSoupBlockTileEntity::new, ModBlocks.CREAM_WITH_MUSHROOM_SOUP_BLOCK.get()).build(null));
	public static final RegistryObject<BlockEntityType<DragonFruitSliceBlockTileEntity>> DRAGON_FRUIT_SLICE_BLOCK = REGISTRY.register("dragon_fruit_slice_block",
			() -> BlockEntityType.Builder.of(DragonFruitSliceBlockTileEntity::new, ModBlocks.DRAGON_FRUIT_SLICE_BLOCK.get()).build(null));
	public static final RegistryObject<BlockEntityType<PancakeBlockTileEntity>> PANCAKE_BLOCK = REGISTRY.register("pancake_block", () -> BlockEntityType.Builder.of(PancakeBlockTileEntity::new, ModBlocks.PANCAKE_BLOCK.get()).build(null));
	public static final RegistryObject<BlockEntityType<ChristmasRibbonRedTileEntity>> CHRISTMAS_RIBBON_RED = REGISTRY.register("christmas_ribbon_red",
			() -> BlockEntityType.Builder.of(ChristmasRibbonRedTileEntity::new, ModBlocks.CHRISTMAS_RIBBON_RED.get()).build(null));
	public static final RegistryObject<BlockEntityType<ChristmasRibbonYellowTileEntity>> CHRISTMAS_RIBBON_YELLOW = REGISTRY.register("christmas_ribbon_yellow",
			() -> BlockEntityType.Builder.of(ChristmasRibbonYellowTileEntity::new, ModBlocks.CHRISTMAS_RIBBON_YELLOW.get()).build(null));
	public static final RegistryObject<BlockEntityType<ChristmasRibbonBlueTileEntity>> CHRISTMAS_RIBBON_BLUE = REGISTRY.register("christmas_ribbon_blue",
			() -> BlockEntityType.Builder.of(ChristmasRibbonBlueTileEntity::new, ModBlocks.CHRISTMAS_RIBBON_BLUE.get()).build(null));
	public static final RegistryObject<BlockEntityType<ChristmasRibbonWhiteTileEntity>> CHRISTMAS_RIBBON_WHITE = REGISTRY.register("christmas_ribbon_white",
			() -> BlockEntityType.Builder.of(ChristmasRibbonWhiteTileEntity::new, ModBlocks.CHRISTMAS_RIBBON_WHITE.get()).build(null));
	public static final RegistryObject<BlockEntityType<ChristmasMiniGiftsRedTileEntity>> CHRISTMAS_MINI_GIFTS_RED = REGISTRY.register("christmas_mini_gifts_red",
			() -> BlockEntityType.Builder.of(ChristmasMiniGiftsRedTileEntity::new, ModBlocks.CHRISTMAS_MINI_GIFTS_RED.get()).build(null));
	public static final RegistryObject<BlockEntityType<ChristmasMiniGiftsYellowTileEntity>> CHRISTMAS_MINI_GIFTS_YELLOW = REGISTRY.register("christmas_mini_gifts_yellow",
			() -> BlockEntityType.Builder.of(ChristmasMiniGiftsYellowTileEntity::new, ModBlocks.CHRISTMAS_MINI_GIFTS_YELLOW.get()).build(null));
	public static final RegistryObject<BlockEntityType<ChristmasMiniGiftsBlueTileEntity>> CHRISTMAS_MINI_GIFTS_BLUE = REGISTRY.register("christmas_mini_gifts_blue",
			() -> BlockEntityType.Builder.of(ChristmasMiniGiftsBlueTileEntity::new, ModBlocks.CHRISTMAS_MINI_GIFTS_BLUE.get()).build(null));
	public static final RegistryObject<BlockEntityType<ChristmasMiniGiftsWhiteTileEntity>> CHRISTMAS_MINI_GIFTS_WHITE = REGISTRY.register("christmas_mini_gifts_white",
			() -> BlockEntityType.Builder.of(ChristmasMiniGiftsWhiteTileEntity::new, ModBlocks.CHRISTMAS_MINI_GIFTS_WHITE.get()).build(null));
	public static final RegistryObject<BlockEntityType<ChristmasBaublesRedTileEntity>> CHRISTMAS_BAUBLES_RED = REGISTRY.register("christmas_baubles_red",
			() -> BlockEntityType.Builder.of(ChristmasBaublesRedTileEntity::new, ModBlocks.CHRISTMAS_BAUBLES_RED.get()).build(null));
	public static final RegistryObject<BlockEntityType<ChristmasBaublesYellowTileEntity>> CHRISTMAS_BAUBLES_YELLOW = REGISTRY.register("christmas_baubles_yellow",
			() -> BlockEntityType.Builder.of(ChristmasBaublesYellowTileEntity::new, ModBlocks.CHRISTMAS_BAUBLES_YELLOW.get()).build(null));
	public static final RegistryObject<BlockEntityType<ChristmasBaublesBlueTileEntity>> CHRISTMAS_BAUBLES_BLUE = REGISTRY.register("christmas_baubles_blue",
			() -> BlockEntityType.Builder.of(ChristmasBaublesBlueTileEntity::new, ModBlocks.CHRISTMAS_BAUBLES_BLUE.get()).build(null));
	public static final RegistryObject<BlockEntityType<ChristmasBaublesWhiteTileEntity>> CHRISTMAS_BAUBLES_WHITE = REGISTRY.register("christmas_baubles_white",
			() -> BlockEntityType.Builder.of(ChristmasBaublesWhiteTileEntity::new, ModBlocks.CHRISTMAS_BAUBLES_WHITE.get()).build(null));
	public static final RegistryObject<BlockEntityType<HoundstoothCarpetTileEntity>> HOUNDSTOOTH_CARPET = REGISTRY.register("houndstooth_carpet",
			() -> BlockEntityType.Builder.of(HoundstoothCarpetTileEntity::new, ModBlocks.HOUNDSTOOTH_CARPET.get()).build(null));
	public static final RegistryObject<BlockEntityType<MagicCircleCarpetTileEntity>> MAGIC_CIRCLE_CARPET = REGISTRY.register("magic_circle_carpet",
			() -> BlockEntityType.Builder.of(MagicCircleCarpetTileEntity::new, ModBlocks.MAGIC_CIRCLE_CARPET.get()).build(null));
	public static final RegistryObject<BlockEntityType<ShirazCarpetTileEntity>> SHIRAZ_CARPET = REGISTRY.register("shiraz_carpet", () -> BlockEntityType.Builder.of(ShirazCarpetTileEntity::new, ModBlocks.SHIRAZ_CARPET.get()).build(null));
	public static final RegistryObject<BlockEntityType<HoundstoothInfiniteCarpetTileEntity>> HOUNDSTOOTH_INFINITE_CARPET = REGISTRY.register("houndstooth_infinite_carpet",
			() -> BlockEntityType.Builder.of(HoundstoothInfiniteCarpetTileEntity::new, ModBlocks.HOUNDSTOOTH_INFINITE_CARPET.get()).build(null));
	public static final RegistryObject<BlockEntityType<PicnicMatTileEntity>> PICNIC_MAT = REGISTRY.register("picnic_mat", () -> BlockEntityType.Builder.of(PicnicMatTileEntity::new, ModBlocks.PICNIC_MAT.get()).build(null));
	public static final RegistryObject<BlockEntityType<PicnicMatInfiniteTileEntity>> PICNIC_MAT_INFINITE = REGISTRY.register("picnic_mat_infinite",
			() -> BlockEntityType.Builder.of(PicnicMatInfiniteTileEntity::new, ModBlocks.PICNIC_MAT_INFINITE.get()).build(null));

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
