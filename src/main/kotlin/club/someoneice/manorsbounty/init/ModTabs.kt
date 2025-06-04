package club.someoneice.manorsbounty.init

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.addAndReturnValue
import club.someoneice.manorsbounty.asStack
import club.someoneice.manorsbounty.asSupplier
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.forge.registerObject

@Suppress("unused")
object ModTabs {
    class TabList: ArrayList<Item>()

    val DEFAULT_TAB = TabList()
    val BUILDING_TAB = TabList()

    fun Item.addToTab(list: TabList = DEFAULT_TAB) = list.addAndReturnValue(this)

    val REGISTRY: DeferredRegister<CreativeModeTab> = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ManorsBounty.ID)
    val MOD_TAB_DEFAULT: CreativeModeTab by REGISTRY.registerObject("${ManorsBounty.ID}.main") {
        CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.${ManorsBounty.ID}.main"))
            .icon(ModItems.MAIN_ICON_ITEM.asStack().asSupplier())
            .displayItems { _, display -> DEFAULT_TAB.forEach(display::accept) }
            .build()
    }

    val MOD_TAB_BUILDING: CreativeModeTab by REGISTRY.registerObject("${ManorsBounty.ID}.building") {
        CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.${ManorsBounty.ID}.build"))
            .icon(ModItems.BUILDING_ICON_ITEM.asStack().asSupplier())
            .displayItems { _, display -> BUILDING_TAB.forEach(display::accept) }
            .build()
    }
}
