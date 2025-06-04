package club.someoneice.manorsbounty.core

import club.someoneice.manorsbounty.asSupplier
import club.someoneice.manorsbounty.feature.FoodLevel
import club.someoneice.manorsbounty.init.ModEffects
import club.someoneice.manorsbounty.init.ModItems
import com.google.common.collect.Maps
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import java.util.function.Supplier

object FoodLevelRegister {
    private val foodLevelTable: HashMap<Supplier<Item>, FoodLevel> = Maps.newHashMap()

    init {
        register(Items.MELON, FoodLevel.A(ModEffects.MELON_GRAVITY))
        register(ModItems.PINEAPPLE_SLICE, FoodLevel.A(0.25, ModEffects.SUMMER_HEATWAVE))
        register(ModItems.HALF_OF_MUSANG_KING_DURIAN, FoodLevel.A(0.5, ModEffects.HACKED_THORNS, ModEffects.SUMMER_HEATWAVE))
        register(ModItems.HAMIMELON_SLICE, FoodLevel.A(0.11, ModEffects.MELON_GRAVITY))
        register(ModItems.STARFRUIT, FoodLevel.A(ModEffects.MOMENTARY_METEOR, ModEffects.SUMMER_HEATWAVE))
        register(ModItems.STARFRUIT_SLICE, FoodLevel.A(0.33, ModEffects.MOMENTARY_METEOR, ModEffects.SUMMER_HEATWAVE))
        register(ModItems.MANGO, FoodLevel.A(0.33, ModEffects.SUMMER_HEATWAVE, ModEffects.ORIGINAL_EVOLUTION))
        register(ModItems.MANGO_SLICE, FoodLevel.A(0.33, ModEffects.SUMMER_HEATWAVE, ModEffects.ORIGINAL_EVOLUTION))
        register(ModItems.KIWIFRUIT, FoodLevel.A(0.5, ModEffects.KIWING_WHEREABOUTS))
        register(ModItems.HALF_OF_KIWIFRUIT, FoodLevel.A(0.5, ModEffects.KIWING_WHEREABOUTS))
        register(ModItems.KIWIFRUIT_SLICE, FoodLevel.A(0.25, ModEffects.KIWING_WHEREABOUTS))
        register(ModItems.AVOCADO, FoodLevel.A(0.5, ModEffects.LURKING_DANGER, ModEffects.SUMMER_HEATWAVE))
        register(ModItems.HALF_OF_AVOCADO, FoodLevel.A(0.5, ModEffects.LURKING_DANGER, ModEffects.SUMMER_HEATWAVE))
        register(ModItems.AVOCADO_SLICE, FoodLevel.A(0.25, ModEffects.LURKING_DANGER, ModEffects.SUMMER_HEATWAVE))
        register(ModItems.ORANGE, FoodLevel.A(ModEffects.RUTIN_LEMONENE))
        register(ModItems.ORANGE_SEGMENT, FoodLevel.A(0.33, ModEffects.RUTIN_LEMONENE))
        register(ModItems.LEMON, FoodLevel.A(ModEffects.RUTIN_LEMONENE))
        register(ModItems.LEMON_SLICE, FoodLevel.A(0.33, ModEffects.RUTIN_LEMONENE))
        register(ModItems.PEACH, FoodLevel.A(ModEffects.ROSA_HEDGE))
        register(ModItems.PEACH_SLICE, FoodLevel.A(0.33, ModEffects.ROSA_HEDGE))
        register(ModItems.PEAR, FoodLevel.A(ModEffects.ROSA_HEDGE))
        register(ModItems.PEAR_SLICE, FoodLevel.A(0.33, ModEffects.ROSA_HEDGE))
        register(ModItems.DRAGON_FRUIT, FoodLevel.A(ModEffects.HACKED_THORNS, ModEffects.SUMMER_HEATWAVE))
        register(ModItems.DRAGON_FRUIT_SLICE, FoodLevel.A(0.33, ModEffects.HACKED_THORNS, ModEffects.SUMMER_HEATWAVE))
        register(Items.APPLE, FoodLevel.A(ModEffects.ROSA_HEDGE))
        register(ModItems.APPLE_SLICE, FoodLevel.A(0.33, ModEffects.ROSA_HEDGE))

        register(Items.SWEET_BERRIES, FoodLevel.A(ModEffects.BURSTING_BERRY))
        register(Items.GLOW_BERRIES, FoodLevel.A(ModEffects.BURSTING_BERRY))
        register(ModItems.STRAWBERRY, FoodLevel.A(ModEffects.BURSTING_BERRY))
        register(ModItems.WHITE_STRAWBERRY, FoodLevel.A(ModEffects.BURSTING_BERRY))
        register(ModItems.BLUEBERRY, FoodLevel.A(ModEffects.BURSTING_BERRY))
        register(ModItems.CRANBERRY, FoodLevel.A(ModEffects.BURSTING_BERRY))
        register(ModItems.CHERRY, FoodLevel.A(ModEffects.BURSTING_BERRY))

        register(ModItems.MELON_SODA, FoodLevel.B(ModEffects.MELON_GRAVITY))
        register(ModItems.GRIMACE_SHAKE, FoodLevel.B(ModEffects.BURSTING_BERRY, ModEffects.CHERRY_BLOSSOMS_WEEPING))
        register(ModItems.ORANGE_JUICE, FoodLevel.B(ModEffects.RUTIN_LEMONENE))
        register(ModItems.APPLE_JUICE, FoodLevel.B(ModEffects.ROSA_HEDGE))
        register(ModItems.SUGAR_PEAR, FoodLevel.B(ModEffects.ROSA_HEDGE))
        register(ModItems.BELLINI_BASE, FoodLevel.B(ModEffects.ROSA_HEDGE))
        register(ModItems.STRAWBERRY_SHAKE, FoodLevel.B(ModEffects.BURSTING_BERRY))
        register(ModItems.MANGO_JUICE, FoodLevel.B(ModEffects.SUMMER_HEATWAVE, ModEffects.ORIGINAL_EVOLUTION))
        register(ModItems.PINEAPPLE_JUICE, FoodLevel.B(ModEffects.SUMMER_HEATWAVE))
        register(ModItems.WATERMELON_JUICE, FoodLevel.B(ModEffects.MELON_GRAVITY))
        register(ModItems.MARTINI, FoodLevel.B(ModEffects.SEA_TOUCH))
        register(ModItems.BLUEBERRY_YOGURT, FoodLevel.C(ModEffects.BURSTING_BERRY))
        register(ModItems.MANGO_PUDDING, FoodLevel.C(ModEffects.SUMMER_HEATWAVE, ModEffects.ORIGINAL_EVOLUTION))
        register(ModItems.RISALAMANDE, FoodLevel.C(ModEffects.CHERRY_BLOSSOMS_WEEPING))
        register(ModItems.ETON_MESS, FoodLevel.C(ModEffects.BURSTING_BERRY))
        register(ModItems.MARMALADE, FoodLevel.C(ModEffects.RUTIN_LEMONENE))
        register(ModItems.BLUEBERRY_ICE_CREAM, FoodLevel.C(ModEffects.BURSTING_BERRY))
        register(ModItems.CHERRIES_ICE_CREAM, FoodLevel.C(ModEffects.CHERRY_BLOSSOMS_WEEPING))
        register(ModItems.STARFRUIT_ICE_CREAM, FoodLevel.C(ModEffects.MOMENTARY_METEOR, ModEffects.SUMMER_HEATWAVE))
        register(ModItems.BLUEBERRY_CHERRIES_ICE_CREAM, FoodLevel.C(ModEffects.BURSTING_BERRY, ModEffects.CHERRY_BLOSSOMS_WEEPING))
        register(ModItems.STARFRUIT_JALAPENO_ICE_CREAM, FoodLevel.C(ModEffects.MOMENTARY_METEOR, ModEffects.SUMMER_HEATWAVE))
        register(ModItems.POWSICLE_PALETERIA, FoodLevel.C(ModEffects.BURSTING_BERRY))
        register(ModItems.LUAU_PALETERIA, FoodLevel.C(ModEffects.ORIGINAL_EVOLUTION, ModEffects.SUMMER_HEATWAVE))
        register(ModItems.WATERMELON_PALETERIA, FoodLevel.C(ModEffects.MELON_GRAVITY))
        register(ModItems.PINK_SNOWMAN_PALETERIA, FoodLevel.C(level = 3, effects = arrayOf(ModEffects.BURSTING_BERRY)))
        register(ModItems.HEART_CRUSH_PALETERIA, FoodLevel.C(ModEffects.ROSA_HEDGE, ModEffects.CHERRY_BLOSSOMS_WEEPING))
        register(ModItems.PINEAPPLE_PALETERIA, FoodLevel.C(ModEffects.SUMMER_HEATWAVE))
        register(ModItems.HAMIMELON_PALETERIA, FoodLevel.C(ModEffects.MELON_GRAVITY))
        register(ModItems.DURIAN_MILE_CREPE_CALE, FoodLevel.C(ModEffects.HACKED_THORNS, ModEffects.SUMMER_HEATWAVE))
        register(ModItems.DURIAN_MILE_CREPE_CAKE_SLICE, FoodLevel.C(ModEffects.HACKED_THORNS, ModEffects.SUMMER_HEATWAVE))
        register(ModItems.BLUEBERRY_MUFFIN, FoodLevel.C(ModEffects.BURSTING_BERRY))
        register(ModItems.CRANBERRY_MUFFIN, FoodLevel.C(ModEffects.BURSTING_BERRY))
        register(ModItems.ORANGE_MUFFIN, FoodLevel.C(ModEffects.RUTIN_LEMONENE))
        register(ModItems.STRAWBERRY_DONUT, FoodLevel.C(ModEffects.BURSTING_BERRY))
        register(ModItems.LEMON_DONUT, FoodLevel.C(ModEffects.RUTIN_LEMONENE))
        register(ModItems.CRANBERRY_COOKIE, FoodLevel.C(ModEffects.BURSTING_BERRY))
        register(ModItems.BLUEBERRY_COOKIE, FoodLevel.C(ModEffects.BURSTING_BERRY))
        register(ModItems.LEMON_COOKIE, FoodLevel.C(ModEffects.RUTIN_LEMONENE))
        register(ModItems.HANAMI_DANGO, FoodLevel.C(ModEffects.CHERRY_BLOSSOMS_WEEPING))
        register(ModItems.SAKURA_MOCHI, FoodLevel.C(ModEffects.CHERRY_BLOSSOMS_WEEPING))
    }

    /**
     * Register a new item food level, with raw item. And it will package to supplier for compatible.
     */
    fun register(item: Item, foodEffect: FoodLevel) {
        foodLevelTable[item.asSupplier()] = foodEffect
    }

    /**
     * Register a new item food level. It can push a RegistryObject by forge into register table.
     */
    @Suppress("unused")
    fun register(item: Supplier<Item>, foodEffect: FoodLevel) {
        foodLevelTable[item] = foodEffect
    }

    /**
     * Find the food level by item or supplier with item.
     * These methods are return with nonnull, anything cannot find will make return the empty level.
     */
    fun find(item: Item) = foodLevelTable.entries.firstOrNull { it.key.get() == item }?.value ?: FoodLevel.EMPTY
    fun find(item: Supplier<Item>) = find(item.get())
}
