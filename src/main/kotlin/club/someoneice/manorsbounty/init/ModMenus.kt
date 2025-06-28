package club.someoneice.manorsbounty.init

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.common.menu.FryerMenu
import club.someoneice.manorsbounty.common.menu.IceCreamMachineMenu
import club.someoneice.manorsbounty.common.menu.OvenMenu
import net.minecraftforge.common.extensions.IForgeMenuType
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object ModMenus {
    val REGISTER = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ManorsBounty.ID)

    val FRYER by REGISTER.registerObject("fryer") { IForgeMenuType.create(::FryerMenu) }
    val OVEN by REGISTER.registerObject("oven") { IForgeMenuType.create(::OvenMenu) }
    val ICE_CREAM by REGISTER.registerObject("ice_cream") { IForgeMenuType.create(::IceCreamMachineMenu) }
}
