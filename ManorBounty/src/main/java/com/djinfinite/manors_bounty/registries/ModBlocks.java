
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.djinfinite.manors_bounty.registries;

import com.djinfinite.manors_bounty.ManorsBountyMod;
import com.djinfinite.manors_bounty.block.*;
import com.djinfinite.manors_bounty.blocks.LogBlock;
import com.djinfinite.manors_bounty.blocks.WoodBlock;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModBlocks {
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ManorsBountyMod.MOD_ID);

    public static final RegistryObject<Block> STRIPPED_SCOTS_PINE_LOG = REGISTRY.register("stripped_scots_pine_log", getStrippedLog());
    public static final RegistryObject<Block> SCOTS_PINE_LOG = REGISTRY.register("scots_pine_log", getLog(STRIPPED_SCOTS_PINE_LOG));
    public static final RegistryObject<Block> STRIPPED_ALPINE_TREE_LOG = REGISTRY.register("stripped_alpine_tree_log", getStrippedLog());
    public static final RegistryObject<Block> ALPINE_TREE_LOG = REGISTRY.register("alpine_tree_log", getLog(STRIPPED_ALPINE_TREE_LOG));
    public static final RegistryObject<Block> STRIPPED_CHERRIES_TREE_LOG = REGISTRY.register("stripped_cherries_tree_log", getStrippedLog());
    public static final RegistryObject<Block> CHERRIES_TREE_LOG = REGISTRY.register("cherries_tree_log", getLog(STRIPPED_CHERRIES_TREE_LOG));
    public static final RegistryObject<Block> STRIPPED_STARFRUIT_TREE_LOG = REGISTRY.register("stripped_starfruit_tree_log", getStrippedLog());
    public static final RegistryObject<Block> STARFRUIT_TREE_LOG = REGISTRY.register("starfruit_tree_log", getLog(STRIPPED_STARFRUIT_TREE_LOG));
    public static final RegistryObject<Block> STRIPPED_OLIVE_TREE_LOG = REGISTRY.register("stripped_olive_tree_log", getStrippedLog());
    public static final RegistryObject<Block> OLIVE_TREE_LOG = REGISTRY.register("olive_tree_log", getLog(STRIPPED_OLIVE_TREE_LOG));
    public static final RegistryObject<Block> STRIPPED_SCOTS_PINE_WOOD = REGISTRY.register("stripped_scots_pine_wood", getStrippedWood());
    public static final RegistryObject<Block> SCOTS_PINE_WOOD = REGISTRY.register("scots_pine_wood", getWood(STRIPPED_SCOTS_PINE_WOOD));
    public static final RegistryObject<Block> STRIPPED_ALPINE_TREE_WOOD = REGISTRY.register("stripped_alpine_tree_wood", getStrippedWood());
    public static final RegistryObject<Block> ALPINE_TREE_WOOD = REGISTRY.register("alpine_tree_wood", getWood(STRIPPED_ALPINE_TREE_WOOD));
    public static final RegistryObject<Block> STRIPPED_CHERRIES_TREE_WOOD = REGISTRY.register("stripped_cherries_tree_wood", getStrippedWood());
    public static final RegistryObject<Block> CHERRIES_TREE_WOOD = REGISTRY.register("cherries_tree_wood", getWood(STRIPPED_CHERRIES_TREE_WOOD));
    public static final RegistryObject<Block> STRIPPED_STARFRUIT_TREE_WOOD = REGISTRY.register("stripped_starfruit_tree_wood", getStrippedWood());
    public static final RegistryObject<Block> STARFRUIT_TREE_WOOD = REGISTRY.register("starfruit_tree_wood", getWood(STRIPPED_STARFRUIT_TREE_WOOD));
    public static final RegistryObject<Block> STRIPPED_OLIVE_TREE_WOOD = REGISTRY.register("stripped_olive_tree_wood", getStrippedWood());
    public static final RegistryObject<Block> OLIVE_TREE_WOOD = REGISTRY.register("olive_tree_wood", getWood(STRIPPED_OLIVE_TREE_WOOD));
    public static final RegistryObject<Block> STRIPPED_RUTACEAE_TREE_LOG = REGISTRY.register("stripped_rutaceae_tree_log", getStrippedLog());
    public static final RegistryObject<Block> RUTACEAE_TREE_LOG = REGISTRY.register("rutaceae_tree_log", getLog(STRIPPED_RUTACEAE_TREE_LOG));
    public static final RegistryObject<Block> STRIPPED_RUTACEAE_TREE_WOOD = REGISTRY.register("stripped_rutaceae_tree_wood", getStrippedWood());
    public static final RegistryObject<Block> RUTACEAE_TREE_WOOD = REGISTRY.register("rutaceae_tree_wood", getWood(STRIPPED_RUTACEAE_TREE_WOOD));
    public static final RegistryObject<Block> STRIPPED_ROSACEAE_TREE_LOG = REGISTRY.register("stripped_rosaceae_tree_log", getStrippedLog());
    public static final RegistryObject<Block> ROSACEAE_TREE_LOG = REGISTRY.register("rosaceae_tree_log", getLog(STRIPPED_ROSACEAE_TREE_LOG));
    public static final RegistryObject<Block> STRIPPED_ROSACEAE_TREE_WOOD = REGISTRY.register("stripped_rosaceae_tree_wood", getStrippedWood());
    public static final RegistryObject<Block> ROSACEAE_TREE_WOOD = REGISTRY.register("rosaceae_tree_wood", getWood(STRIPPED_ROSACEAE_TREE_WOOD));
    public static final RegistryObject<Block> STRIPPED_DURIAN_TREE_LOG = REGISTRY.register("stripped_durian_tree_log", getStrippedLog());
    public static final RegistryObject<Block> DURIAN_TREE_LOG = REGISTRY.register("durian_tree_log", getLog(STRIPPED_DURIAN_TREE_LOG));
    public static final RegistryObject<Block> STRIPPED_DURIAN_TREE_WOOD = REGISTRY.register("stripped_durian_tree_wood", getStrippedWood());
    public static final RegistryObject<Block> DURIAN_TREE_WOOD = REGISTRY.register("durian_tree_wood", getWood(STRIPPED_DURIAN_TREE_WOOD));
    public static final RegistryObject<Block> STRIPPED_MANGO_TREE_LOG = REGISTRY.register("stripped_mango_tree_log", getStrippedLog());
    public static final RegistryObject<Block> MANGO_TREE_LOG = REGISTRY.register("mango_tree_log", getLog(STRIPPED_MANGO_TREE_LOG));
    public static final RegistryObject<Block> STRIPPED_MANGO_TREE_WOOD = REGISTRY.register("stripped_mango_tree_wood", getStrippedWood());
    public static final RegistryObject<Block> MANGO_TREE_WOOD = REGISTRY.register("mango_tree_wood", getWood(STRIPPED_MANGO_TREE_WOOD));
    public static final RegistryObject<Block> STRIPPED_KIWIFRUIT_TREE_LOG = REGISTRY.register("stripped_kiwifruit_tree_log", getStrippedLog());
    public static final RegistryObject<Block> KIWIFRUIT_TREE_LOG = REGISTRY.register("kiwifruit_tree_log", getLog(STRIPPED_KIWIFRUIT_TREE_LOG));
    public static final RegistryObject<Block> STRIPPED_KIWIFRUIT_TREE_WOOD = REGISTRY.register("stripped_kiwifruit_tree_wood", getStrippedWood());
    public static final RegistryObject<Block> KIWIFRUIT_TREE_WOOD = REGISTRY.register("kiwifruit_tree_wood", getWood(STRIPPED_KIWIFRUIT_TREE_WOOD));
    public static final RegistryObject<Block> STRIPPED_AVOCADO_TREE_LOG = REGISTRY.register("stripped_avocado_tree_log", getStrippedLog());
    public static final RegistryObject<Block> AVOCADO_TREE_LOG = REGISTRY.register("avocado_tree_log", getLog(STRIPPED_AVOCADO_TREE_LOG));
    public static final RegistryObject<Block> STRIPPED_AVOCADO_TREE_WOOD = REGISTRY.register("stripped_avocado_tree_wood", getStrippedWood());
    public static final RegistryObject<Block> AVOCADO_TREE_WOOD = REGISTRY.register("avocado_tree_wood", getWood(STRIPPED_AVOCADO_TREE_WOOD));
    public static final RegistryObject<Block> CARAMEL_CHOCOLATE_CAKE = REGISTRY.register("caramel_chocolate_cake", CaramelChocolateCakeBlock::new);
    public static final RegistryObject<Block> SWEET_BERRY_CAKE = REGISTRY.register("sweet_berry_cake", SweetBerryCakeBlock::new);
    public static final RegistryObject<Block> CHORUS_FLOWER_JELLY_CAKE = REGISTRY.register("chorus_flower_jelly_cake", ChorusFlowerJellyCakeBlock::new);
    public static final RegistryObject<Block> NETHER_WART_SOUL_CAKE = REGISTRY.register("nether_wart_soul_cake", NetherWartSoulCakeBlock::new);
    public static final RegistryObject<Block> BLACK_DIRT = REGISTRY.register("black_dirt", BlackDirtBlock::new);
    public static final RegistryObject<Block> SNOWY_BLACK_DIRT = REGISTRY.register("snowy_black_dirt", SnowyBlackDirtBlock::new);
    public static final RegistryObject<Block> MARBLE = REGISTRY.register("marble", getStoneBlock());
    public static final RegistryObject<Block> MARBLE_STAIRS = REGISTRY.register("marble_stairs", getStoneStair(MARBLE));
    public static final RegistryObject<Block> POLISHED_MARBLE = REGISTRY.register("polished_marble", getStoneBlock());
    public static final RegistryObject<Block> POLISHED_MARBLE_STAIRS = REGISTRY.register("polished_marble_stairs", getStoneStair(POLISHED_MARBLE));
    public static final RegistryObject<Block> POLISHED_MARBLE_BRICK = REGISTRY.register("polished_marble_brick", getStoneBlock());
    public static final RegistryObject<Block> POLISHED_MARBLE_BRICK_STAIRS = REGISTRY.register("polished_marble_brick_stairs", getStoneStair(POLISHED_MARBLE_BRICK));
    public static final RegistryObject<Block> CORN_CROP_1 = REGISTRY.register("corn_crop_1", CornCrop1Block::new);
    public static final RegistryObject<Block> CORN_CROP_2 = REGISTRY.register("corn_crop_2", CornCrop2Block::new);
    public static final RegistryObject<Block> BOTTON_MUSHROOM = REGISTRY.register("botton_mushroom", BottonMushroomBlock::new);
    public static final RegistryObject<Block> BOTTON_MUSHROOM_2 = REGISTRY.register("botton_mushroom_2", BottonMushroom2Block::new);
    public static final RegistryObject<Block> BOTTON_MUSHROOM_3 = REGISTRY.register("botton_mushroom_3", BottonMushroom3Block::new);
    public static final RegistryObject<Block> WOOD_MUSHROOM = REGISTRY.register("wood_mushroom", WoodMushroomBlock::new);
    public static final RegistryObject<Block> WOOD_MUSHROOM_2 = REGISTRY.register("wood_mushroom_2", WoodMushroom2Block::new);
    public static final RegistryObject<Block> WOOD_MUSHROOM_3 = REGISTRY.register("wood_mushroom_3", WoodMushroom3Block::new);
    public static final RegistryObject<Block> ALFALFA_CROP = REGISTRY.register("alfalfa_crop", AlfalfaCropBlock::new);
    public static final RegistryObject<Block> LAVENDER = REGISTRY.register("lavender", LavenderBlock::new);
    public static final RegistryObject<Block> ALFALFA_PLANT = REGISTRY.register("alfalfa_plant", AlfalfaPlantBlock::new);
    public static final RegistryObject<Block> RICH_BLACK_DIRT = REGISTRY.register("rich_black_dirt", RichBlackDirtBlock::new);
    public static final RegistryObject<Block> RICH_BLACK_DIRT_FARMLAND = REGISTRY.register("rich_black_dirt_farmland", RichBlackDirtFarmlandBlock::new);
    public static final RegistryObject<Block> FRIGID_GRASS = REGISTRY.register("frigid_grass", FrigidGrassBlock::new);
    public static final RegistryObject<Block> SCOTS_PINE_LEAVES = REGISTRY.register("scots_pine_leaves", ScotsPineLeavesBlock::new);
    public static final RegistryObject<Block> SCOTS_PINE_PLANKS = REGISTRY.register("scots_pine_planks", getPlanks());
    public static final RegistryObject<Block> SCOTS_PINE_DOOR = REGISTRY.register("scots_pine_door", getWoodenDoor());
    public static final RegistryObject<Block> SCOTS_PINE_TRAPDOOR = REGISTRY.register("scots_pine_trapdoor", getWoodenTrapdoor());
    public static final RegistryObject<Block> SCOTS_PINE_FENCE = REGISTRY.register("scots_pine_fence", getWoodenFence());
    public static final RegistryObject<Block> SCOTS_PINE_FENCE_GATE = REGISTRY.register("scots_pine_fence_gate", getFenceGate());
    public static final RegistryObject<Block> SCOTS_PINE_SLAB = REGISTRY.register("scots_pine_slab", getWoodenSlab());
    public static final RegistryObject<Block> SCOTS_PINE_STAIRS = REGISTRY.register("scots_pine_stairs", getWoodenStair(SCOTS_PINE_PLANKS));
    public static final RegistryObject<Block> SCOTS_PINE_BOTTON = REGISTRY.register("scots_pine_botton",()-> woodenButton(BlockSetType.OAK));
    public static final RegistryObject<Block> SCOTS_PINE_PRESSURE_PLATE = REGISTRY.register("scots_pine_pressure_plate", getWoodenPressurePlate());
    public static final RegistryObject<Block> SCOTS_PINE_SAPLING = REGISTRY.register("scots_pine_sapling", ScotsPineSaplingBlock::new);
    public static final RegistryObject<Block> BLACK_DIRT_TRUFFLE = REGISTRY.register("black_dirt_truffle", BlackDirtTruffleBlock::new);
    public static final RegistryObject<Block> BLUEBERRY_BUSH = REGISTRY.register("blueberry_bush", BlueberryBushBlock::new);
    public static final RegistryObject<Block> ALPINE_TREE_LEAVES = REGISTRY.register("alpine_tree_leaves", AlpineTreeLeavesBlock::new);
    public static final RegistryObject<Block> ALPINE_TREE_PLANKS = REGISTRY.register("alpine_tree_planks", getPlanks());
    public static final RegistryObject<Block> ALPINE_TREE_STAIRS = REGISTRY.register("alpine_tree_stairs", getWoodenStair(ALPINE_TREE_PLANKS));
    public static final RegistryObject<Block> ALPINE_TREE_DOOR = REGISTRY.register("alpine_tree_door", getWoodenDoor());
    public static final RegistryObject<Block> ALPINE_TREE_TRAPDOOR = REGISTRY.register("alpine_tree_trapdoor", getWoodenTrapdoor());
    public static final RegistryObject<Block> ALPINE_TREE_FENCE = REGISTRY.register("alpine_tree_fence", getWoodenFence());
    public static final RegistryObject<Block> ALPINE_TREE_FENCE_GATE = REGISTRY.register("alpine_tree_fence_gate", getFenceGate());
    public static final RegistryObject<Block> ALPINE_TREE_SLAB = REGISTRY.register("alpine_tree_slab", getWoodenSlab());
    public static final RegistryObject<Block> ALPINE_TREE_BOTTON = REGISTRY.register("alpine_tree_botton", () -> woodenButton(BlockSetType.OAK));
    public static final RegistryObject<Block> ALPINE_TREE_PLATE = REGISTRY.register("alpine_tree_plate", getWoodenPressurePlate());
    public static final RegistryObject<Block> MARBLE_WALL = REGISTRY.register("marble_wall", getStoneWall());
    public static final RegistryObject<Block> POLISHED_MARBLE_WALL = REGISTRY.register("polished_marble_wall", getStoneWall());
    public static final RegistryObject<Block> POLISHED_MARBLE_BRICK_WALL = REGISTRY.register("polished_marble_brick_wall", getStoneWall());
    public static final RegistryObject<Block> MARBLE_SLAB = REGISTRY.register("marble_slab", getStoneSlab());
    public static final RegistryObject<Block> POLISHED_MARBLE_SLAB = REGISTRY.register("polished_marble_slab", getStoneSlab());
    public static final RegistryObject<Block> POLISHED_MARBLE_BRICK_SLAB = REGISTRY.register("polished_marble_brick_slab", getStoneSlab());
    public static final RegistryObject<Block> CHRISTMAS_SOCK = REGISTRY.register("christmas_sock", ChristmasSockBlock::new);
    public static final RegistryObject<Block> GIFT_SHORT_RED = REGISTRY.register("gift_short_red", GiftShortRedBlock::new);
    public static final RegistryObject<Block> GIFT_SHORT_GREEN = REGISTRY.register("gift_short_green", GiftShortGreenBlock::new);
    public static final RegistryObject<Block> GIFT_SHORT_BLUE = REGISTRY.register("gift_short_blue", GiftShortBlueBlock::new);
    public static final RegistryObject<Block> GIFT_SHORT_PINK = REGISTRY.register("gift_short_pink", GiftShortPinkBlock::new);
    public static final RegistryObject<Block> GIFT_SHORT_LUCKY = REGISTRY.register("gift_short_lucky", GiftShortLuckyBlock::new);
    public static final RegistryObject<Block> GIFT_TALL_RED = REGISTRY.register("gift_tall_red", GiftTallRedBlock::new);
    public static final RegistryObject<Block> GIFT_TALL_GREEN = REGISTRY.register("gift_tall_green", GiftTallGreenBlock::new);
    public static final RegistryObject<Block> GIFT_TALL_BLUE = REGISTRY.register("gift_tall_blue", GiftTallBlueBlock::new);
    public static final RegistryObject<Block> GIFT_TALL_PINK = REGISTRY.register("gift_tall_pink", GiftTallPinkBlock::new);
    public static final RegistryObject<Block> GIFT_TALL_LUCKY = REGISTRY.register("gift_tall_lucky", GiftTallLuckyBlock::new);
    public static final RegistryObject<Block> CHRISTMAS_WREATHS = REGISTRY.register("christmas_wreaths", ChristmasWreathsBlock::new);
    public static final RegistryObject<Block> PEARL_ROCK_ORE = REGISTRY.register("pearl_rock_ore", PearlRockOreBlock::new);
    public static final RegistryObject<Block> DEEPSLATE_PEARL_ROCK_ORE = REGISTRY.register("deepslate_pearl_rock_ore", () -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5f, 3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RADDE = REGISTRY.register("radde", RaddeBlock::new);
    public static final RegistryObject<Block> GALANTHUS_NIVALIS = REGISTRY.register("galanthus_nivalis", GalanthusNivalisBlock::new);
    public static final RegistryObject<Block> WINTER_ROSE = REGISTRY.register("winter_rose", WinterRoseBlock::new);
    public static final RegistryObject<Block> SNOWY_MYCELIUM = REGISTRY.register("snowy_mycelium", SnowyMyceliumBlock::new);
    public static final RegistryObject<Block> BOTTON_MUSHROOM_BLOCK = REGISTRY.register("botton_mushroom_block", BottonMushroomBlockBlock::new);
    public static final RegistryObject<Block> DEBRISHROOM = REGISTRY.register("debrishroom", DebrishroomBlock::new);
    public static final RegistryObject<Block> CHERRIES_TREE_LEAVES = REGISTRY.register("cherries_tree_leaves", CherriesTreeLeavesBlock::new);
    public static final RegistryObject<Block> CHERRIES_TREE_PLANKS = REGISTRY.register("cherries_tree_planks", getPlanks());
    public static final RegistryObject<Block> CHERRIES_TREE_STAIRS = REGISTRY.register("cherries_tree_stairs", getStoneStair(CHERRIES_TREE_PLANKS));
    public static final RegistryObject<Block> CHERRIES_TREE_DOOR = REGISTRY.register("cherries_tree_door", getWoodenDoor());
    public static final RegistryObject<Block> CHERRIES_TREE_TRAPDOOR = REGISTRY.register("cherries_tree_trapdoor", getWoodenTrapdoor());
    public static final RegistryObject<Block> CHERRIES_TREE_FENCE = REGISTRY.register("cherries_tree_fence", getWoodenFence());
    public static final RegistryObject<Block> CHERRIES_TREE_FENCE_GATE = REGISTRY.register("cherries_tree_fence_gate", getFenceGate());
    public static final RegistryObject<Block> CHERRIES_TREE_SLAB = REGISTRY.register("cherries_tree_slab", getWoodenSlab());
    public static final RegistryObject<Block> CHERRIES_TREE_BOTTON = REGISTRY.register("cherries_tree_botton", getWoodenButton());
    public static final RegistryObject<Block> CHERRIES_TREE_PRESSURE_PLATE = REGISTRY.register("cherries_tree_pressure_plate", getWoodenPressurePlate());
    public static final RegistryObject<Block> VOLCANIC_MUD = REGISTRY.register("volcanic_mud", VolcanicMudBlock::new);
    public static final RegistryObject<Block> STRAWBERRY_BUSH = REGISTRY.register("strawberry_bush", StrawberryBushBlock::new);
    public static final RegistryObject<Block> STARFRUIT_TREE_LEAVES = REGISTRY.register("starfruit_tree_leaves", StarfruitTreeLeavesBlock::new);
    public static final RegistryObject<Block> STARFRUIT_TREE_PLANKS = REGISTRY.register("starfruit_tree_planks", getPlanks());
    public static final RegistryObject<Block> STARFRUIT_TREE_STAIRS = REGISTRY.register("starfruit_tree_stairs", getWoodenStair(STARFRUIT_TREE_PLANKS));
    public static final RegistryObject<Block> STARFRUIT_TREE_DOOR = REGISTRY.register("starfruit_tree_door", getWoodenDoor());
    public static final RegistryObject<Block> STARFRUIT_TREE_TRAPDOOR = REGISTRY.register("starfruit_tree_trapdoor", getWoodenTrapdoor());
    public static final RegistryObject<Block> STARFRUIT_TREE_FENCE = REGISTRY.register("starfruit_tree_fence", getWoodenFence());
    public static final RegistryObject<Block> STARFRUIT_TREE_FENCE_GATE = REGISTRY.register("starfruit_tree_fence_gate", getFenceGate());
    public static final RegistryObject<Block> STARFRUIT_TREE_SLAB = REGISTRY.register("starfruit_tree_slab", getWoodenSlab());
    public static final RegistryObject<Block> STARFRUIT_TREE_BOTTON = REGISTRY.register("starfruit_tree_botton", getWoodenButton());
    public static final RegistryObject<Block> STARFRUIT_TREE_PRESSURE_PLATE = REGISTRY.register("starfruit_tree_pressure_plate", getWoodenPressurePlate());
    public static final RegistryObject<Block> SNOW_TERRACOTTA = REGISTRY.register("snow_terracotta", SnowTerracottaBlock::new);
    public static final RegistryObject<Block> SNOW_GLAZED_TERRACOTTA = REGISTRY.register("snow_glazed_terracotta", SnowGlazedTerracottaBlock::new);
    public static final RegistryObject<Block> SNOW_CONCRETE_POWDER = REGISTRY.register("snow_concrete_powder", SnowConcretePowderBlock::new);
    public static final RegistryObject<Block> SNOW_CONCRETE = REGISTRY.register("snow_concrete", SnowConcreteBlock::new);
    public static final RegistryObject<Block> SOUL_ROSE = REGISTRY.register("soul_rose", SoulRoseBlock::new);
    public static final RegistryObject<Block> VANILLA_ICE_CREAM_FLUID = REGISTRY.register("vanilla_ice_cream_fluid", VanillaIceCreamFluidBlock::new);
    public static final RegistryObject<Block> BLUEBERRY_ICE_CREAM_FLUID = REGISTRY.register("blueberry_ice_cream_fluid", BlueberryIceCreamFluidBlock::new);
    public static final RegistryObject<Block> CHERRIES_ICE_CREAM_FLUID = REGISTRY.register("cherries_ice_cream_fluid", CherriesIceCreamFluidBlock::new);
    public static final RegistryObject<Block> STARFRUIT_ICE_CREAM_FLUID = REGISTRY.register("starfruit_ice_cream_fluid", StarfruitIceCreamFluidBlock::new);
    public static final RegistryObject<Block> CHOCOLATE_ICE_CREAM_FLUID = REGISTRY.register("chocolate_ice_cream_fluid", ChocolateIceCreamFluidBlock::new);
    public static final RegistryObject<Block> JALAPENO_ICE_CREAM_FLUID = REGISTRY.register("jalapeno_ice_cream_fluid", JalapenoIceCreamFluidBlock::new);
    public static final RegistryObject<Block> ICE_CREAM_MACHINE = REGISTRY.register("ice_cream_machine", IceCreamMachineBlock::new);
    public static final RegistryObject<Block> OLIVE_OIL = REGISTRY.register("olive_oil", OliveOilBlock::new);
    public static final RegistryObject<Block> OLIVE_TREE_LEAVES = REGISTRY.register("olive_tree_leaves", OliveTreeLeavesBlock::new);
    public static final RegistryObject<Block> OLIVE_TREE_PLANKS = REGISTRY.register("olive_tree_planks", getPlanks());
    public static final RegistryObject<Block> OLIVE_TREE_STAIRS = REGISTRY.register("olive_tree_stairs", getWoodenStair(OLIVE_TREE_PLANKS));
    public static final RegistryObject<Block> OLIVE_TREE_DOOR = REGISTRY.register("olive_tree_door", getWoodenDoor());
    public static final RegistryObject<Block> OLIVE_TREE_TRAPDOOR = REGISTRY.register("olive_tree_trapdoor", getWoodenTrapdoor());
    public static final RegistryObject<Block> OLIVE_TREE_FENCE = REGISTRY.register("olive_tree_fence", getWoodenFence());
    public static final RegistryObject<Block> OLIVE_TREE_FENCE_GATE = REGISTRY.register("olive_tree_fence_gate", getFenceGate());
    public static final RegistryObject<Block> OLIVE_TREE_SLAB = REGISTRY.register("olive_tree_slab", getWoodenSlab());
    public static final RegistryObject<Block> OLIVE_TREE_BOTTON = REGISTRY.register("olive_tree_botton", getWoodenButton());
    public static final RegistryObject<Block> OLIVE_TREE_PRESSURE_PLATE = REGISTRY.register("olive_tree_pressure_plate", getWoodenPressurePlate());
    public static final RegistryObject<Block> FRYER = REGISTRY.register("fryer", FryerBlock::new);
    public static final RegistryObject<Block> RUTACEAE_TREE_PLANKS = REGISTRY.register("rutaceae_tree_planks", getPlanks());
    public static final RegistryObject<Block> RUTACEAE_TREE_STAIRS = REGISTRY.register("rutaceae_tree_stairs", getWoodenStair(RUTACEAE_TREE_PLANKS));
    public static final RegistryObject<Block> RUTACEAE_TREE_DOOR = REGISTRY.register("rutaceae_tree_door", getWoodenDoor());
    public static final RegistryObject<Block> RUTACEAE_TREE_TRAPDOOR = REGISTRY.register("rutaceae_tree_trapdoor", getWoodenTrapdoor());
    public static final RegistryObject<Block> RUTACEAE_TREE_FENCE = REGISTRY.register("rutaceae_tree_fence", getWoodenFence());
    public static final RegistryObject<Block> RUTACEAE_TREE_FENCE_GATE = REGISTRY.register("rutaceae_tree_fence_gate", getFenceGate());
    public static final RegistryObject<Block> RUTACEAE_TREE_SLAB = REGISTRY.register("rutaceae_tree_slab", getWoodenSlab());
    public static final RegistryObject<Block> RUTACEAE_TREE_BOTTON = REGISTRY.register("rutaceae_tree_botton", getWoodenButton());
    public static final RegistryObject<Block> RUTACEAE_TREE_PRESSURE_PLATE = REGISTRY.register("rutaceae_tree_pressure_plate", getWoodenPressurePlate());
    public static final RegistryObject<Block> ORANGE_LEAVES = REGISTRY.register("orange_leaves", OrangeLeavesBlock::new);
    public static final RegistryObject<Block> PINEAPPLE = REGISTRY.register("pineapple", PineappleBlock::new);
    public static final RegistryObject<Block> ROSACEAE_TREE_PLANKS = REGISTRY.register("rosaceae_tree_planks", getPlanks());
    public static final RegistryObject<Block> ROSACEAE_TREE_STAIRS = REGISTRY.register("rosaceae_tree_stairs", getWoodenStair(ROSACEAE_TREE_PLANKS));
    public static final RegistryObject<Block> ROSACEAE_TREE_DOOR = REGISTRY.register("rosaceae_tree_door", getWoodenDoor());
    public static final RegistryObject<Block> ROSACEAE_TREE_TRAPDOOR = REGISTRY.register("rosaceae_tree_trapdoor", getWoodenTrapdoor());
    public static final RegistryObject<Block> ROSACEAE_TREE_FENCE = REGISTRY.register("rosaceae_tree_fence", getWoodenFence());
    public static final RegistryObject<Block> ROSACEAE_TREE_FENCE_GATE = REGISTRY.register("rosaceae_tree_fence_gate", getFenceGate());
    public static final RegistryObject<Block> ROSACEAE_TREE_SLAB = REGISTRY.register("rosaceae_tree_slab", getWoodenSlab());
    public static final RegistryObject<Block> ROSACEAE_TREE_BOTTON = REGISTRY.register("rosaceae_tree_botton", getWoodenButton());
    public static final RegistryObject<Block> ROSACEAE_TREE_PRESSURE_PLATE = REGISTRY.register("rosaceae_tree_pressure_plate", getWoodenPressurePlate());
    public static final RegistryObject<Block> APPLE_LEAVES = REGISTRY.register("apple_leaves", AppleLeavesBlock::new);
    public static final RegistryObject<Block> PEACH_LEAVES = REGISTRY.register("peach_leaves", PeachLeavesBlock::new);
    public static final RegistryObject<Block> MUSANG_KING_DURIAN = REGISTRY.register("musang_king_durian", MusangKingDurianBlock::new);
    public static final RegistryObject<Block> DURIAN_TREE_LEAVES = REGISTRY.register("durian_tree_leaves", DurianTreeLeavesBlock::new);
    public static final RegistryObject<Block> DURIAN_TREE_PLANKS = REGISTRY.register("durian_tree_planks", getPlanks());
    public static final RegistryObject<Block> DURIAN_TREE_STAIRS = REGISTRY.register("durian_tree_stairs", getWoodenStair(DURIAN_TREE_PLANKS));
    public static final RegistryObject<Block> DURIAN_TREE_DOOR = REGISTRY.register("durian_tree_door", getWoodenDoor());
    public static final RegistryObject<Block> DURIAN_TREE_TRAPDOOR = REGISTRY.register("durian_tree_trapdoor", getWoodenTrapdoor());
    public static final RegistryObject<Block> DURIAN_TREE_FENCE = REGISTRY.register("durian_tree_fence", getWoodenFence());
    public static final RegistryObject<Block> DURIAN_TREE_FENCE_GATE = REGISTRY.register("durian_tree_fence_gate", getFenceGate());
    public static final RegistryObject<Block> DURIAN_TREE_SLAB = REGISTRY.register("durian_tree_slab", getWoodenSlab());
    public static final RegistryObject<Block> DURIAN_TREE_BOTTON = REGISTRY.register("durian_tree_botton", getWoodenButton());
    public static final RegistryObject<Block> DURIAN_TREE_PRESSURE_PLATE = REGISTRY.register("durian_tree_pressure_plate", getWoodenPressurePlate());
    public static final RegistryObject<Block> DURIAN_FRUIT_1 = REGISTRY.register("durian_fruit_1", DurianFruit1Block::new);
    public static final RegistryObject<Block> DURIAN_FRUIT_2 = REGISTRY.register("durian_fruit_2", DurianFruit2Block::new);
    public static final RegistryObject<Block> CUTTING_BOARD = REGISTRY.register("cutting_board", CuttingBoardBlock::new);
    public static final RegistryObject<Block> GARLIC_CROP = REGISTRY.register("garlic_crop", GarlicCropBlock::new);
    public static final RegistryObject<Block> PINEAPPLE_CROP = REGISTRY.register("pineapple_crop", PineappleCropBlock::new);
    public static final RegistryObject<Block> JALAPENO_CROP_BOTTOM = REGISTRY.register("jalapeno_crop_bottom", JalapenoCropBottomBlock::new);
    public static final RegistryObject<Block> JALAPENO_CROP_TOP = REGISTRY.register("jalapeno_crop_top", JalapenoCropTopBlock::new);
    public static final RegistryObject<Block> SNOW_GLASS_PANE = REGISTRY.register("snow_glass_pane", SnowGlassPaneBlock::new);
    public static final RegistryObject<Block> SNOW_GLASS = REGISTRY.register("snow_glass", SnowGlassBlock::new);
    public static final RegistryObject<Block> CRANBERRY_BUSH = REGISTRY.register("cranberry_bush", CranberryBushBlock::new);
    public static final RegistryObject<Block> LEMON_LEAVES = REGISTRY.register("lemon_leaves", LemonLeavesBlock::new);
    public static final RegistryObject<Block> PEAR_LEAVES = REGISTRY.register("pear_leaves", PearLeavesBlock::new);
    public static final RegistryObject<Block> HOT_SPRING = REGISTRY.register("hot_spring", HotSpringBlock::new);
    public static final RegistryObject<Block> OVEN = REGISTRY.register("oven", OvenBlock::new);
    public static final RegistryObject<Block> CHERRIES_PIE = REGISTRY.register("cherries_pie", CherriesPieBlock::new);
    public static final RegistryObject<Block> TRUFFLE_PIE = REGISTRY.register("truffle_pie", TrufflePieBlock::new);
    public static final RegistryObject<Block> HAMIMELON = REGISTRY.register("hamimelon", HamimelonBlock::new);
    public static final RegistryObject<Block> HAMIMELON_CROP = REGISTRY.register("hamimelon_crop", HamimelonCropBlock::new);
    public static final RegistryObject<Block> MANGO_TREE_LEAVES = REGISTRY.register("mango_tree_leaves", MangoTreeLeavesBlock::new);
    public static final RegistryObject<Block> MANGO_TREE_PLANKS = REGISTRY.register("mango_tree_planks", getPlanks());
    public static final RegistryObject<Block> MANGO_TREE_STAIRS = REGISTRY.register("mango_tree_stairs", getWoodenStair(MANGO_TREE_PLANKS));
    public static final RegistryObject<Block> MANGO_TREE_DOOR = REGISTRY.register("mango_tree_door", getWoodenDoor());
    public static final RegistryObject<Block> MANGO_TREE_TRAPDOOR = REGISTRY.register("mango_tree_trapdoor", getWoodenTrapdoor());
    public static final RegistryObject<Block> MANGO_TREE_FENCE = REGISTRY.register("mango_tree_fence", getWoodenFence());
    public static final RegistryObject<Block> MANGO_TREE_FENCE_GATE = REGISTRY.register("mango_tree_fence_gate", getFenceGate());
    public static final RegistryObject<Block> MANGO_TREE_SLAB = REGISTRY.register("mango_tree_slab", getWoodenSlab());
    public static final RegistryObject<Block> MANGO_TREE_BOTTON = REGISTRY.register("mango_tree_botton", getWoodenButton());
    public static final RegistryObject<Block> MANGO_TREE_PRESSURE_PLATE = REGISTRY.register("mango_tree_pressure_plate", getWoodenPressurePlate());
    public static final RegistryObject<Block> CAKE_LIQUID = REGISTRY.register("cake_liquid", CakeLiquidBlock::new);
    public static final RegistryObject<Block> DRAGON_FRUIT_BLOCK = REGISTRY.register("dragon_fruit_block", DragonFruitBlockBlock::new);
    public static final RegistryObject<Block> DRAGON_FRUIT_CACTUS = REGISTRY.register("dragon_fruit_cactus", DragonFruitCactusBlock::new);
    public static final RegistryObject<Block> DRAGON_FRUIT_CACTUS_FLOWER = REGISTRY.register("dragon_fruit_cactus_flower", DragonFruitCactusFlowerBlock::new);
    public static final RegistryObject<Block> MARBLE_BOWL = REGISTRY.register("marble_bowl", MarbleBowlBlock::new);
    public static final RegistryObject<Block> DRAGON_FRUIT_CROP = REGISTRY.register("dragon_fruit_crop", DragonFruitCropBlock::new);
    public static final RegistryObject<Block> PRAWN_AND_CORN_SOUP_BLOCK = REGISTRY.register("prawn_and_corn_soup_block", PrawnAndCornSoupBlockBlock::new);
    public static final RegistryObject<Block> BORSCHT_BLOCK = REGISTRY.register("borscht_block", BorschtBlockBlock::new);
    public static final RegistryObject<Block> MISO_SOUP_BLOCK = REGISTRY.register("miso_soup_block", MisoSoupBlockBlock::new);
    public static final RegistryObject<Block> CREAM_WITH_MUSHROOM_SOUP_BLOCK = REGISTRY.register("cream_with_mushroom_soup_block", CreamWithMushroomSoupBlockBlock::new);
    public static final RegistryObject<Block> DRAGON_FRUIT_SLICE_BLOCK = REGISTRY.register("dragon_fruit_slice_block", DragonFruitSliceBlockBlock::new);
    public static final RegistryObject<Block> PANCAKE_BLOCK = REGISTRY.register("pancake_block", PancakeBlockBlock::new);
    public static final RegistryObject<Block> COFFEE_FLUID = REGISTRY.register("coffee_fluid", CoffeeFluidBlock::new);
    public static final RegistryObject<Block> MELON_SODA_FLUID = REGISTRY.register("melon_soda_fluid", MelonSodaFluidBlock::new);
    public static final RegistryObject<Block> BUBBLE_TEA_FLUID = REGISTRY.register("bubble_tea_fluid", BubbleTeaFluidBlock::new);
    public static final RegistryObject<Block> GRIMACE_SHAKE_FLUID = REGISTRY.register("grimace_shake_fluid", GrimaceShakeFluidBlock::new);
    public static final RegistryObject<Block> ORANGE_JUICE_FLUID = REGISTRY.register("orange_juice_fluid", OrangeJuiceFluidBlock::new);
    public static final RegistryObject<Block> LEMONADE_FLUID = REGISTRY.register("lemonade_fluid", LemonadeFluidBlock::new);
    public static final RegistryObject<Block> APPLE_JUICE_FLUID = REGISTRY.register("apple_juice_fluid", AppleJuiceFluidBlock::new);
    public static final RegistryObject<Block> PEAR_WITH_ROCK_SUGAR_FLUID = REGISTRY.register("pear_with_rock_sugar_fluid", PearWithRockSugarFluidBlock::new);
    public static final RegistryObject<Block> BELLINI_BASE_FLUID = REGISTRY.register("bellini_base_fluid", BelliniBaseFluidBlock::new);
    public static final RegistryObject<Block> STRAWBERRY_SHAKE_FLUID = REGISTRY.register("strawberry_shake_fluid", StrawberryShakeFluidBlock::new);
    public static final RegistryObject<Block> MANGO_JUICE_FLUID = REGISTRY.register("mango_juice_fluid", MangoJuiceFluidBlock::new);
    public static final RegistryObject<Block> PINEAPPLE_JUICE_FLUID = REGISTRY.register("pineapple_juice_fluid", PineappleJuiceFluidBlock::new);
    public static final RegistryObject<Block> WATERMELON_JUICE_FLUID = REGISTRY.register("watermelon_juice_fluid", WatermelonJuiceFluidBlock::new);
    public static final RegistryObject<Block> CHRISTMAS_RIBBON_RED = REGISTRY.register("christmas_ribbon_red", ChristmasRibbonRedBlock::new);
    public static final RegistryObject<Block> CHRISTMAS_RIBBON_YELLOW = REGISTRY.register("christmas_ribbon_yellow", ChristmasRibbonYellowBlock::new);
    public static final RegistryObject<Block> CHRISTMAS_RIBBON_BLUE = REGISTRY.register("christmas_ribbon_blue", ChristmasRibbonBlueBlock::new);
    public static final RegistryObject<Block> CHRISTMAS_RIBBON_WHITE = REGISTRY.register("christmas_ribbon_white", ChristmasRibbonWhiteBlock::new);
    public static final RegistryObject<Block> CHRISTMAS_MINI_GIFTS_RED = REGISTRY.register("christmas_mini_gifts_red", ChristmasMiniGiftsRedBlock::new);
    public static final RegistryObject<Block> CHRISTMAS_MINI_GIFTS_YELLOW = REGISTRY.register("christmas_mini_gifts_yellow", ChristmasMiniGiftsYellowBlock::new);
    public static final RegistryObject<Block> CHRISTMAS_MINI_GIFTS_BLUE = REGISTRY.register("christmas_mini_gifts_blue", ChristmasMiniGiftsBlueBlock::new);
    public static final RegistryObject<Block> CHRISTMAS_MINI_GIFTS_WHITE = REGISTRY.register("christmas_mini_gifts_white", ChristmasMiniGiftsWhiteBlock::new);
    public static final RegistryObject<Block> CHRISTMAS_BAUBLES_RED = REGISTRY.register("christmas_baubles_red", ChristmasBaublesRedBlock::new);
    public static final RegistryObject<Block> CHRISTMAS_BAUBLES_YELLOW = REGISTRY.register("christmas_baubles_yellow", ChristmasBaublesYellowBlock::new);
    public static final RegistryObject<Block> CHRISTMAS_BAUBLES_BLUE = REGISTRY.register("christmas_baubles_blue", ChristmasBaublesBlueBlock::new);
    public static final RegistryObject<Block> CHRISTMAS_BAUBLES_WHITE = REGISTRY.register("christmas_baubles_white", ChristmasBaublesWhiteBlock::new);
    public static final RegistryObject<Block> MARTINI_FLUID = REGISTRY.register("martini_fluid", MartiniFluidBlock::new);

    public static final RegistryObject<Block> HOUNDSTOOTH_CARPET = REGISTRY.register("houndstooth_carpet", HoundstoothCarpetBlock::new);
    public static final RegistryObject<Block> MAGIC_CIRCLE_CARPET = REGISTRY.register("magic_circle_carpet", MagicCircleCarpetBlock::new);
    public static final RegistryObject<Block> SHIRAZ_CARPET = REGISTRY.register("shiraz_carpet", ShirazCarpetBlock::new);
    public static final RegistryObject<Block> HOUNDSTOOTH_INFINITE_CARPET = REGISTRY.register("houndstooth_infinite_carpet", HoundstoothInfiniteCarpetBlock::new);

    public static final RegistryObject<Block> PICNIC_MAT = REGISTRY.register("picnic_mat", PicnicMatBlock::new);
    public static final RegistryObject<Block> PICNIC_MAT_INFINITE = REGISTRY.register("picnic_mat_infinite", PicnicMatInfiniteBlock::new);
    public static final RegistryObject<Block> CHORUS_FRUIT_JUICE_FLUID = REGISTRY.register("chorus_fruit_juice_fluid", ChorusFruitJuiceFluidBlock::new);
    public static final RegistryObject<Block> KIWIFRUIT_TREE_LEAVES = REGISTRY.register("kiwifruit_tree_leaves", KiwifruitTreeLeavesBlock::new);
    public static final RegistryObject<Block> KIWIFRUIT_TREE_PLANKS = REGISTRY.register("kiwifruit_tree_planks", getPlanks());
    public static final RegistryObject<Block> KIWIFRUIT_TREE_STAIRS = REGISTRY.register("kiwifruit_tree_stairs", getWoodenStair(KIWIFRUIT_TREE_PLANKS));
    public static final RegistryObject<Block> KIWIFRUIT_TREE_DOOR = REGISTRY.register("kiwifruit_tree_door", getWoodenDoor());
    public static final RegistryObject<Block> KIWIFRUIT_TREE_TRAPDOOR = REGISTRY.register("kiwifruit_tree_trapdoor", getWoodenTrapdoor());
    public static final RegistryObject<Block> KIWIFRUIT_TREE_FENCE = REGISTRY.register("kiwifruit_tree_fence", getWoodenFence());
    public static final RegistryObject<Block> KIWIFRUIT_TREE_FENCE_GATE = REGISTRY.register("kiwifruit_tree_fence_gate", getFenceGate());
    public static final RegistryObject<Block> KIWIFRUIT_TREE_SLAB = REGISTRY.register("kiwifruit_tree_slab", getWoodenSlab());
    public static final RegistryObject<Block> KIWIFRUIT_TREE_BOTTON = REGISTRY.register("kiwifruit_tree_botton", getWoodenButton());
    public static final RegistryObject<Block> KIWIFRUIT_TREE_PRESSURE_PLATE = REGISTRY.register("kiwifruit_tree_pressure_plate", getWoodenPressurePlate());
    public static final RegistryObject<Block> CHERRIES_SEED = REGISTRY.register("cherries_seed", CherriesSeedBlock::new);
    public static final RegistryObject<Block> STARFRUIT_SEED = REGISTRY.register("starfruit_seed", StarfruitSeedBlock::new);
    public static final RegistryObject<Block> OLIVE_FRUIT_SEED = REGISTRY.register("olive_fruit_seed", OliveFruitSeedBlock::new);
    public static final RegistryObject<Block> ORANGE_SEED = REGISTRY.register("orange_seed", OrangeSeedBlock::new);
    public static final RegistryObject<Block> APPLE_SEED = REGISTRY.register("apple_seed", AppleSeedBlock::new);
    public static final RegistryObject<Block> PEACH_SEED = REGISTRY.register("peach_seed", PeachSeedBlock::new);
    public static final RegistryObject<Block> DURIAN_SEED = REGISTRY.register("durian_seed", DurianSeedBlock::new);
    public static final RegistryObject<Block> LEMON_SEED = REGISTRY.register("lemon_seed", LemonSeedBlock::new);
    public static final RegistryObject<Block> PEAR_SEED = REGISTRY.register("pear_seed", PearSeedBlock::new);
    public static final RegistryObject<Block> MANGO_SEED = REGISTRY.register("mango_seed", MangoSeedBlock::new);
    public static final RegistryObject<Block> KIWIFRUIT_SEED = REGISTRY.register("kiwifruit_seed", KiwifruitSeedBlock::new);
    public static final RegistryObject<Block> AVOCADO_TREE_PLANKS = REGISTRY.register("avocado_tree_planks", getPlanks());
    public static final RegistryObject<Block> AVOCADO_TREE_STAIRS = REGISTRY.register("avocado_tree_stairs", getWoodenStair(AVOCADO_TREE_PLANKS));
    public static final RegistryObject<Block> AVOCADO_TREE_LEAVES = REGISTRY.register("avocado_tree_leaves", AvocadoTreeLeavesBlock::new);
    public static final RegistryObject<Block> AVOCADO_TREE_SLAB = REGISTRY.register("avocado_tree_slab", getWoodenSlab());
    public static final RegistryObject<Block> AVOCADO_TREE_FENCE = REGISTRY.register("avocado_tree_fence", getWoodenFence());
    public static final RegistryObject<Block> AVOCADO_TREE_FENCE_GATE = REGISTRY.register("avocado_tree_fence_gate", getFenceGate());
    public static final RegistryObject<Block> AVOCADO_TREE_PRESSURE_PLATE = REGISTRY.register("avocado_tree_pressure_plate", getWoodenPressurePlate());
    public static final RegistryObject<Block> AVOCADO_TREE_BUTTON = REGISTRY.register("avocado_tree_button", getWoodenButton());
    public static final RegistryObject<Block> AVOCADO_TREE_DOOR = REGISTRY.register("avocado_tree_door", getWoodenDoor());
    public static final RegistryObject<Block> AVOCADO_TREE_TRAPDOOR = REGISTRY.register("avocado_tree_trapdoor", getWoodenTrapdoor());
    public static final RegistryObject<Block> AVOCADO_SEED = REGISTRY.register("avocado_seed", AvocadoSeedBlock::new);

    private static @NotNull Supplier<Block> getStoneStair(Supplier<Block> base) {
        return () -> new StairBlock(() -> base.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.ANDESITE_STAIRS));
    }

    private static @NotNull Supplier<Block> getStoneBlock() {
        return () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE));
    }

    private static @NotNull Supplier<Block> getLeaves() {
        return () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES));
    }

    private static @NotNull Supplier<Block> getLog(Supplier<Block> stripped) {
        return () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG), stripped.get());
    }

    private static @NotNull Supplier<Block> getStrippedLog() {
        return () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG));
    }

    private static @NotNull Supplier<Block> getWood(Supplier<Block> stripped) {
        return () -> new WoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG), stripped.get());
    }

    private static @NotNull Supplier<Block> getStrippedWood() {
        return () -> new WoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG));
    }

    private static @NotNull Supplier<Block> getWoodenButton() {
        return () -> woodenButton(BlockSetType.OAK);
    }

    private static @NotNull Supplier<Block> getPlanks() {
        return () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));
    }

    private static @NotNull Supplier<Block> getWoodenStair(Supplier<Block> base) {
        return () -> new StairBlock(() -> base.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS));
    }

    private static @NotNull Supplier<Block> getWoodenDoor() {
        return () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK);
    }

    private static @NotNull Supplier<Block> getWoodenTrapdoor() {
        return () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK);
    }

    private static @NotNull Supplier<Block> getWoodenFence() {
        return () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE));
    }

    private static @NotNull Supplier<Block> getFenceGate() {
        return () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK);
    }

    private static @NotNull Supplier<Block> getWoodenSlab() {
        return () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB));
    }

    private static @NotNull Supplier<Block> getWoodenPressurePlate() {
        return () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK);
    }

    private static @NotNull Supplier<Block> getStoneWall() {
        return () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE_WALL));
    }

    private static @NotNull Supplier<Block> getStoneSlab() {
        return () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE_SLAB));
    }

    private static ButtonBlock woodenButton(BlockSetType pSetType, FeatureFlag... pRequiredFeatures) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY);
        if (pRequiredFeatures.length > 0) {
            properties = properties.requiredFeatures(pRequiredFeatures);
        }

        return new ButtonBlock(properties, pSetType, 30, true);
    }
}
