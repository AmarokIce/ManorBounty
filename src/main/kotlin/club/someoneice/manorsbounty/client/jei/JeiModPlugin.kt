package club.someoneice.manorsbounty.client.jei

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.asStack
import club.someoneice.manorsbounty.init.ModBlocks
import mezz.jei.api.IModPlugin
import mezz.jei.api.JeiPlugin
import mezz.jei.api.registration.IRecipeCatalystRegistration
import mezz.jei.api.registration.IRecipeCategoryRegistration
import mezz.jei.api.registration.IRecipeRegistration
import net.minecraft.resources.ResourceLocation

@JeiPlugin
class JeiModPlugin: IModPlugin {
    override fun getPluginUid(): ResourceLocation {
        return ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, "jei_plugin")
    }

    override fun registerCategories(registration: IRecipeCategoryRegistration) {
        val helper = registration.jeiHelpers.guiHelper

        registration.addRecipeCategories(
            Fryer(helper, true),
            Fryer(helper, false),
            Oven(helper)
        )
    }

    override fun registerRecipes(registration: IRecipeRegistration) {
        registration.addRecipes(Fryer.FRIED, Fryer.build())
        registration.addRecipes(Fryer.COOKED, Fryer.build())
        registration.addRecipes(Oven.TYPE, Oven.build())
    }

    override fun registerRecipeCatalysts(registration: IRecipeCatalystRegistration) {
        registration.addRecipeCatalyst(ModBlocks.FRYER.asStack(), Fryer.FRIED, Fryer.COOKED)
        registration.addRecipeCatalyst(ModBlocks.OVEN.asStack(), Oven.TYPE)
    }

}
