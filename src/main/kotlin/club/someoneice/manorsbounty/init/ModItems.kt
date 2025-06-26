package club.someoneice.manorsbounty.init

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.asInstance
import club.someoneice.manorsbounty.asStack
import club.someoneice.manorsbounty.common.block.BlockBase
import club.someoneice.manorsbounty.common.block.BlockBush
import club.someoneice.manorsbounty.common.item.ItemFoodBlock
import club.someoneice.manorsbounty.giveOrDropItemStack
import club.someoneice.manorsbounty.init.ModBlocks.MARBLE_BOWL
import club.someoneice.manorsbounty.init.ModTabs.addToTab
import net.minecraft.core.BlockPos
import net.minecraft.network.chat.Component
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.*
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.VoxelShape
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import thedarkcolour.kotlinforforge.forge.registerObject
import java.util.function.Supplier

@Suppress("unused")
object ModItems {
    val REGISTRY: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, ManorsBounty.ID)

    val MAIN_ICON_ITEM by REGISTRY.registerObject("main_icon_item", ::itemWithoutAddToTab)
    val BUILDING_ICON_ITEM by REGISTRY.registerObject("building_icon_item", ::itemWithoutAddToTab)

    val PINEAPPLE by REGISTRY.registerObject("pineapple") { block(ModBlocks.PINEAPPLE) }
    val MUSANG_KING_DURIAN by REGISTRY.registerObject("musang_king_durian") { block(ModBlocks.MUSANG_KING_DURIAN) }
    val HAMIMELON by REGISTRY.registerObject("hamimelon") { block(ModBlocks.HAMIMELON) }
    val STARFRUIT by REGISTRY.registerObject("starfruit", ::foodFruit)
    val MANGO by REGISTRY.registerObject("mango", ::foodFruit)
    val KIWIFRUIT by REGISTRY.registerObject("kiwifruit", ::item)
    val AVOCADO by REGISTRY.registerObject("avocado", ::item)
    val ORANGE by REGISTRY.registerObject("orange", ::foodFruit)
    val LEMON by REGISTRY.registerObject("lemon", ::foodFruit)
    val PEACH by REGISTRY.registerObject("peach", ::foodFruit)
    val PEAR by REGISTRY.registerObject("pear", ::foodFruit)
    val DRAGON_FRUIT by REGISTRY.registerObject("dragon_fruit", ::item)

    val PINEAPPLE_SLICE by REGISTRY.registerObject("pineapple_slice") { foodFruit(3, 0.1f) }
    val HALF_OF_MUSANG_KING_DURIAN by REGISTRY.registerObject("half_of_musang_king_durian", ::foodFruit)
    val HAMIMELON_SLICE by REGISTRY.registerObject("hamimelon_slice") { foodFruit(2, 0.1f) }
    val STARFRUIT_SLICE by REGISTRY.registerObject("starfruit_slice") { foodFruit(2, 0.1f) }
    val MANGO_SLICE by REGISTRY.registerObject("mango_slice") { foodFruit(3, 0.1f) }
    val HALF_OF_KIWIFRUIT by REGISTRY.registerObject("half_of_kiwifruit") { foodFruit(4, 0.3f) }
    val KIWIFRUIT_SLICE by REGISTRY.registerObject("kiwifruit_slice") { foodFruit(2, 0.1f) }
    val HALF_OF_AVOCADO by REGISTRY.registerObject("half_of_avocado") { foodFruit(3, 0.1f) }
    val AVOCADO_SLICE by REGISTRY.registerObject("avocado_slice") { foodFruit(2, 0.1f) }
    val ORANGE_SEGMENT by REGISTRY.registerObject("orange_segment") { foodFruit(2, 0.1f) }
    val LEMON_SLICE by REGISTRY.registerObject("lemon_slice") { foodFruit(2, 0.1f) }
    val PEACH_SLICE by REGISTRY.registerObject("peach_slice") { foodFruit(2, 0.1f) }
    val PEAR_SLICE by REGISTRY.registerObject("pear_slice") { foodFruit(2, 0.1f) }
    val DRAGON_FRUIT_SLICE by REGISTRY.registerObject("dragon_fruit_slice", ::dragonFruit)
    val APPLE_SLICE by REGISTRY.registerObject("apple_slice") { foodFruit(2, 0.1f) }

    val STRAWBERRY by REGISTRY.registerObject("strawberry") { foodBerry(3) }
    val WHITE_STRAWBERRY by REGISTRY.registerObject("white_strawberry") { foodBerry(3) }
    val BLUEBERRY = foodBerry("blueberry")
    val CRANBERRY= foodBerry("cranberry")
    val CHERRY by REGISTRY.registerObject("cherry", ::foodBerry)
    val OLIVE by REGISTRY.registerObject("olive_fruit", ::foodBerry)

    val GLASS_CUP by REGISTRY.registerObject("deformed_glass_bottle", ::item)
    val MELON_SODA = drinkWithBlock("melon_soda", 4)
    val BUBBLE_TEA by REGISTRY.registerObject("bubble_tea") { foodDrink(4) }
    val GRIMACE_SHAKE = drinkWithBlock("grimace_shake")
    val ORANGE_JUICE= drinkWithBlock("orange_juice")
    val LEMONADE = lemonade()
    val APPLE_JUICE = drinkWithBlock("apple_juice")
    val SUGAR_PEAR = drinkWithBlock("sugar_pear_juice")
    val BELLINI_BASE = drinkWithBlock("bellini_base", 2)
    val STRAWBERRY_SHAKE = drinkWithBlock("strawberry_shake")
    val MANGO_JUICE = drinkWithBlock("mango_juice")
    val PINEAPPLE_JUICE = drinkWithBlock("pineapple_juice", 4)
    val WATERMELON_JUICE = drinkWithBlock("watermelon_juice")
    val MARTINI = drinkWithBlock("martini", 2)
    val CHORUS_JUICE by REGISTRY.registerObject("chorus_fruit_juice", ::foodDrink)
    val FRUIT_PUNCH by REGISTRY.registerObject("fruit_punch") { foodDrink(5) }
    val BLUEBERRY_YOGURT = drinkWithBlock("blueberry_yogurt", 1)
    val MANGO_PUDDING = drinkWithBlock("mango_pudding")
    val RISALAMANDE = drinkWithBlock("risalamande", 2)
    val ETON_MESS = drinkWithBlock("eton_mess", 3, 0.3f)
    val MARMALADE by REGISTRY.registerObject("marmalade") { foodDrink(12, 0.3f) }
    val BOXED_COCO_MILK by REGISTRY.registerObject("boxed_chocolate_milk") { foodBase(3, 0.1f, true, useAnim = UseAnim.DRINK, maxStack = 16) }
    val BOXED_LEMON_TEA by REGISTRY.registerObject("boxed_lemon_tea", ::boxedLemonade)

    val BORSCHT = foodWithBlock(ModBlocks.BORSCHT, 20, 1.6f, effects = arrayOf(MobEffects.REGENERATION.asInstance(20 * 60 * 20)))
    val CREAM_WITH_MUSHROOM_SOUP = foodWithBlock(ModBlocks.CREAM_WITH_MUSHROOM_SOUP, 16, 1.3f, effects = arrayOf(MobEffects.MOVEMENT_SPEED.asInstance(20 * 60 * 16)))
    val MISO_SOUP = foodWithBlock(ModBlocks.MISO_SOUP, 16, 1.3f, effects = arrayOf(MobEffects.DAMAGE_RESISTANCE.asInstance(20 * 60 * 16)))
    val PRAWN_AND_CORN_SOUP = foodWithBlock(ModBlocks.PRAWN_AND_CORN_SOUP, 16, 1.3f, effects = arrayOf(MobEffects.DAMAGE_BOOST.asInstance(20 * 60 * 16)))
    val COSMIC_DRAGON_SALAD = foodWithBlock(ModBlocks.COSMIC_DRAGON_SALAD, 9, 0.5f)
    val ROSA_SALAD = foodWithBlock(ModBlocks.ROSA_SALAD, 7, 0.5f)
    val SEA_PEARL_SALAD = foodWithBlock(ModBlocks.SEA_PEARL_SALAD, 8, 0.5f)
    val MELON_SALAD = foodWithBlock(ModBlocks.MELON_SALAD, 8, 0.5f)
    // val COFFEE by REGISTRY.registerObject("coffee") { foodBase(2, 0.1f, craftingItem = MARBLE_BOWL.asStack()) }

    val POWSICLE_PALETERIA by REGISTRY.registerObject("powsicle_paleteria") { foodBase(8, 0.3f) }
    val LUAU_PALETERIA by REGISTRY.registerObject("luau_paleteria") { foodBase(12, 0.5f) }
    val WATERMELON_PALETERIA by REGISTRY.registerObject("watermelon_paleteria") { foodBase(8, 0.3f) }
    val PINK_SNOWMAN_PALETERIA by REGISTRY.registerObject("pink_snowman_paleteria") { foodBase(12, 0.5f) }
    val HEART_CRUSH_PALETERIA by REGISTRY.registerObject("heart_crush_paleteria") { foodBase(10, 0.4f) }
    val PINEAPPLE_PALETERIA by REGISTRY.registerObject("pineapple_paleteria") { foodBase(10, 0.4f) }
    val HAMIMELON_PALETERIA by REGISTRY.registerObject("hamimelon_paleteria") { foodBase(8, 0.3f) }

    val PANCAKE by REGISTRY.registerObject("pancake") { foodBase(6, 0.7f) }
    val DURIAN_MILE_CREPE_CALE by REGISTRY.registerObject("durian_mile_crepe_cake") { foodBase(8, 0.5f) }
    val DURIAN_MILE_CREPE_CAKE_SLICE by REGISTRY.registerObject("durian_mile_crepe_cake_slice") { foodBase(2, 0.1f) }
    val MUFFIN by REGISTRY.registerObject("muffin") { foodBase(5, 0.6f) }
    val BLUEBERRY_MUFFIN by REGISTRY.registerObject("blueberry_muffin") { foodBase(5, 0.6f) }
    val CRANBERRY_MUFFIN by REGISTRY.registerObject("cranberry_muffin") { foodBase(5, 0.6f) }
    val CHOCOLATE_MUFFIN by REGISTRY.registerObject("chocolate_muffin") { foodBase(5, 0.6f) }
    val ORANGE_MUFFIN by REGISTRY.registerObject("orange_muffin") { foodBase(5, 0.6f) }

    val TACO by REGISTRY.registerObject("taco") { foodBase(10, 1.1f) }
    val HANAMI_DANGO by REGISTRY.registerObject("hanami_dango") { foodBase(6, 0.7f) }
    val SAKURA_MOCHI by REGISTRY.registerObject("sakura_mochi") { foodBase(6, 0.7f) }
    val CHOCOLATE by REGISTRY.registerObject("chocolate") { foodBase(6, 0.3f) }
    val JALPENO by REGISTRY.registerObject("jalapeno") { foodBase(2, 0.1f) }

    val RAW_PRAWN by REGISTRY.registerObject("raw_prawn") { foodBase(2, 0.1f) }
    val COOKED_PRAWN by REGISTRY.registerObject("cooked_prawn") { foodBase(4, 0.5f) }

    val FRIED_CHICKEN by REGISTRY.registerObject("fried_chicken") { foodBase(8, 1.1f) }
    val FRIED_DRUMSTICK by REGISTRY.registerObject("fried_drumstick") { foodBase(2, 0.3f) }
    val FRIED_PORKCHOP by REGISTRY.registerObject("fried_porkchop") { foodBase(10, 1.7f) }
    val FRIED_STEAK by REGISTRY.registerObject("fried_steak") { foodBase(10, 1.3f) }
    val FRIED_FISH by REGISTRY.registerObject("fried_fish") { foodBase(7, 0.9f) }
    val FRIED_TENPURA by REGISTRY.registerObject("fried_tenpura") { foodBase(6, 0.7f) }
    val DONUT by REGISTRY.registerObject("donut") { foodBase(7, 0.9f) }
    val CHOCOLATE_DONUT by REGISTRY.registerObject("chocolate_donut") { foodBase(9, 1.1f) }
    val STRAWBERRY_DONUT by REGISTRY.registerObject("strawberry_donut") { foodBase(7, 0.9f) }
    val WHITE_CHOCOLATE_DONUT by REGISTRY.registerObject("white_chocolate_donut") { foodBase(9, 1.1f) }
    val LEMON_DONUT by REGISTRY.registerObject("lemon_donut") { foodBase(7, 0.9f) }
    val SNOW_DONUT by REGISTRY.registerObject("snow_donut") { foodBase(9, 1.1f) }

    val CRANBERRY_COOKIE by REGISTRY.registerObject("cranberry_cookie") { foodBase(4, 0.1f) }
    val BLUEBERRY_COOKIE by REGISTRY.registerObject("blueberry_cookie") { foodBase(4, 0.1f) }
    val LEMON_COOKIE by REGISTRY.registerObject("lemon_cookie") { foodBase(4, 0.1f) }

    val PINEAPPLE_PASTRIES by REGISTRY.registerObject("pineapple_pastries") { foodBase(5, 0.6f) }
    val PINEAPPLE_PIE by REGISTRY.registerObject("pineapple_pie") { foodBase(5, 0.3f) }
    val COOKED_DURIAN_FLESH by REGISTRY.registerObject("cooked_durian_flesh") { foodBase(4, 0.3f) }
    val DURIAN_CRISP by REGISTRY.registerObject("durian_crisp") { foodBase(6, 0.5f) }

    val ICE_CREAM_CONE by REGISTRY.registerObject("ice_cream_cone") { foodBase(2, 0.3f) }
    val VANILLA_ICE_CREAM by REGISTRY.registerObject("vanilla_ice_cream") { foodBase(6, 0.3f) }
    val CHOCOLATE_ICE_CREAM by REGISTRY.registerObject("chocolate_ice_cream") { foodBase(6, 0.3f) }
    val BLUEBERRY_ICE_CREAM by REGISTRY.registerObject("blueberry_ice_cream") { foodBase(6, 0.3f) }
    val CHERRIES_ICE_CREAM by REGISTRY.registerObject("cherries_ice_cream") { foodBase(6, 0.3f) }
    val STARFRUIT_ICE_CREAM by REGISTRY.registerObject("starfruit_ice_cream") { foodBase(6, 0.3f) }
    val JALAPENO_ICE_CREAM by REGISTRY.registerObject("jalapeno_ice_cream") { foodBase(6, 0.3f) }
    val VANILLA_CHOCOLATE_ICE_CREAM by REGISTRY.registerObject("vanilla_chocolate_ice_cream") { foodBase(6, 0.3f) }
    val BLUEBERRY_CHERRIES_ICE_CREAM by REGISTRY.registerObject("blueberry_cherries_ice_cream") { foodBase(6, 0.3f) }
    val STARFRUIT_JALAPENO_ICE_CREAM by REGISTRY.registerObject("starfruit_jalapeno_ice_cream") { foodBase(6, 0.3f) }

    val OIL_BUCKET by REGISTRY.registerObject("olive_oil_bucket") { Item(Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)).addToTab() }
    val OIL by REGISTRY.registerObject("bottled_olive_oil") { Item(Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(1)).addToTab() }

    val VANILLA_CAKE_SLICE by REGISTRY.registerObject("vanilla_cake_slice") { foodBase(2, 0.1f, fastEat = true) }
    val CARAMEL_CHOCOLATE_CAKE_SLICE by REGISTRY.registerObject("caramel_chocolate_cake_slice") { foodBase(2, 0.1f, fastEat = true) }
    val SWEET_BERRY_CAKE_SLICE by REGISTRY.registerObject("sweet_berry_cake_slice") { foodBase(2, 0.1f, fastEat = true) }
    val CHORUS_FLOWER_JELLY_CAKE_SLICE by REGISTRY.registerObject("chorus_flower_jelly_cake_slice") { foodBase(2, 0.1f, fastEat = true) }
    val NETHER_WART_SOUL_CAKE_SLICE by REGISTRY.registerObject("nether_wart_soul_cake_slice") { foodBase(2, 0.1f, fastEat = true) }

    val CHERRIES_PIE_SLICE by REGISTRY.registerObject("cherries_pie_slice") { foodBase(8, 0.5f) }
    val TRUFFLE_PIE_SLICE by REGISTRY.registerObject("truffle_pie_slice") { foodBase(6, 0.3f) }

    val TRUFFLE by REGISTRY.registerObject("truffle", ::item)
    val PEARL_ROCK by REGISTRY.registerObject("pearl_rock", ::item)
    val BUTTON_MUSHROOM by REGISTRY.registerObject("button_mushroom", ::item)
    val COOKED_BUTTON_MUSHROOM by REGISTRY.registerObject("cooked_button_mushroom", ::item)
    val WOOD_MUSHROOM by REGISTRY.registerObject("wood_mushroom", ::item)
    val CORN by REGISTRY.registerObject("corn", ::item)

    val CREATIVITY_MECHANISM by REGISTRY.registerObject("creativity_mechanism", ::item)
    val SNOW_DYE by REGISTRY.registerObject("snow_dye", ::item)


    private fun itemWithoutAddToTab() = Item(Item.Properties())
    private fun item() = Item(Item.Properties()).addToTab()
    private fun block(block: Block) = BlockItem(block, Item.Properties()).addToTab()

    private fun foodBase(
        hunger: Int, saturation: Float, alwaysEat: Boolean = false, fastEat: Boolean = false,
        useAnim: UseAnim = UseAnim.EAT, craftingItem: ItemStack = ItemStack.EMPTY, maxStack: Int = 64,
        tooltips: List<Component> = listOf(), onUse: (ItemStack, Level, Player) -> Unit = { _, _, _ -> }
    ): Item {
        val properties = Item.Properties()
        val foodProperties = FoodProperties.Builder()
        foodProperties.nutrition(hunger).saturationMod(saturation)
        if (alwaysEat) foodProperties.alwaysEat()
        if (fastEat) foodProperties.fast()

        properties.food(foodProperties.build())
        properties.stacksTo(maxStack)
        if (!craftingItem.isEmpty) {
            properties.craftRemainder(craftingItem.item)
        }

        return object: Item(properties) {
            override fun getUseAnimation(pStack: ItemStack) = useAnim
            override fun appendHoverText(item: ItemStack, world: Level?, list: MutableList<Component>, flag: TooltipFlag) {
                list.addAll(tooltips)
            }
            override fun finishUsingItem(pStack: ItemStack, pLevel: Level, pLivingEntity: LivingEntity): ItemStack {
                if (pLivingEntity !is Player) {
                    return super.finishUsingItem(pStack, pLevel, pLivingEntity)
                }
                onUse(pStack, pLevel, pLivingEntity)

                pLivingEntity.giveOrDropItemStack(craftingItem.copy())
                return super.finishUsingItem(pStack, pLevel, pLivingEntity)
            }
        }.addToTab()
    }

    private fun foodFruit(hunger: Int = 5, saturation: Float = 0.3f) = foodBase(hunger, saturation)
    private fun foodBerry(hunger: Int = 2, saturation: Float = 0.1f) = foodBase(hunger, saturation, true, fastEat = true)
    private fun foodDrink(hunger: Int = 3, saturation: Float = 0.1f) = foodBase(hunger, saturation, true, fastEat = false,
        useAnim = UseAnim.DRINK,
        craftingItem = GLASS_CUP.asStack(),
        maxStack = 16)
    private fun foodBowl(hunger: Int, saturation: Float, vararg effect: MobEffectInstance) = foodBase(hunger, saturation,
        craftingItem = MARBLE_BOWL.asStack()) { _, _, player -> effect.map(::MobEffectInstance).forEach(player::addEffect) }

    private fun dragonFruit() = ItemFoodBlock(ModBlocks.DRAGON_FRUIT_SLICE, FoodProperties.Builder()
        .nutrition(5)
        .saturationMod(0.4f)
        .build())

    private fun foodBerry(name: String, hunger: Int = 2, saturation: Float = 0.1f): RegistryObject<Item> {
        val block = ModBlocks.REGISTRY.register(name, ::BlockBush)
        return REGISTRY.register(name) {
            ItemFoodBlock(block.get(),
                FoodProperties.Builder().nutrition(hunger).saturationMod(saturation).build())
        }
    }

    private fun drinkWithBlock(name: String, hunger: Int = 3, saturation: Float = 0.1f): Supplier<Item> {
        val block =  ModBlocks.REGISTRY.register(name) { object: BlockBase() {
            override fun getShape(pState: BlockState, pLevel: BlockGetter, pPos: BlockPos, pContext: CollisionContext): VoxelShape {
                val boxIndex = ModBlocks.DRINK_FOOD_BOX
                return box(0.0 + boxIndex.x, 0.0 + boxIndex.y, 0.0 + boxIndex.x, 0.0 + boxIndex.width, 0.0 + boxIndex.height, 0.0 + boxIndex.width)
            }
        }}
        val item: Supplier<Item> = REGISTRY.register(name) {
            ItemFoodBlock(block.get(), FoodProperties.Builder()
                .nutrition(hunger).saturationMod(saturation).alwaysEat().build(), UseAnim.DRINK, craftingItem = GLASS_CUP.asStack())
        }
        return item
    }

    private fun foodWithBlock(block: RegistryObject<out Block>, hunger: Int = 3, saturation: Float = 0.1f, vararg effects: MobEffectInstance, geoModule: Boolean = true): RegistryObject<out Item> {
        val item = REGISTRY.register(block.id.path) {
            ItemFoodBlock(block.get(), FoodProperties.Builder()
                .nutrition(hunger).saturationMod(saturation).alwaysEat().build(), craftingItem = MARBLE_BOWL.asStack(), effects = effects)
        }
        return item
    }

    private fun lemonade(): Supplier<Item> {
        val block =  ModBlocks.REGISTRY.register("lemonade") { object: BlockBase() {
            override fun getShape(pState: BlockState, pLevel: BlockGetter, pPos: BlockPos, pContext: CollisionContext): VoxelShape {
                val boxIndex = ModBlocks.DRINK_FOOD_BOX
                return box(0.0 + boxIndex.x, 0.0 + boxIndex.y, 0.0 + boxIndex.x, 0.0 + boxIndex.width, 0.0 + boxIndex.height, 0.0 + boxIndex.width)
            }
        }}
        val item: Supplier<Item> = REGISTRY.register("lemonade") {
            object : ItemFoodBlock(block.get(), FoodProperties.Builder()
                .nutrition(5).saturationMod(0.1f).alwaysEat().build(), UseAnim.DRINK, craftingItem = GLASS_CUP.asStack()) {
                override fun finishUsingItem(pStack: ItemStack, pLevel: Level, pLivingEntity: LivingEntity): ItemStack {
                    ModEffects.REGISTRY.entries.stream()
                        .map(Supplier<MobEffect>::get)
                        .filter(pLivingEntity::hasEffect)
                        .forEach(pLivingEntity::removeEffect)
                    return super.finishUsingItem(pStack, pLevel, pLivingEntity)
                }
            }
        }
        return item
    }

    private fun boxedLemonade() = foodBase(2, 0.1f, true, maxStack = 16)
}
