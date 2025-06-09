package club.someoneice.manorsbounty.client.jei

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.asStack
import club.someoneice.manorsbounty.common.tile.TileFryer
import club.someoneice.manorsbounty.init.ModBlocks
import com.google.common.collect.Lists
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder
import mezz.jei.api.gui.drawable.IDrawable
import mezz.jei.api.helpers.IGuiHelper
import mezz.jei.api.recipe.IFocusGroup
import mezz.jei.api.recipe.RecipeIngredientRole
import mezz.jei.api.recipe.RecipeType
import mezz.jei.api.recipe.category.IRecipeCategory
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.crafting.Ingredient

class Fryer(private val helper: IGuiHelper, private val fried: Boolean): IRecipeCategory<Fryer.Recipe> {
    override fun getRecipeType(): RecipeType<Recipe> = if (fried) FRIED else COOKED
    override fun getTitle(): Component = Component.literal("油炸")

    override fun getBackground(): IDrawable {
        val dat = if (fried) "fryer_fry_recipe_jei_background" else "fryer_cook_recipe_jei_background"
        return helper.createDrawable(ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, "textures/screens/${dat}.png"), 0, 0, 153, 73)
    }

    override fun getIcon(): IDrawable {
        return helper.createDrawableItemStack(ModBlocks.FRYER_ITEM.get().defaultInstance)
    }

    override fun setRecipe(builder: IRecipeLayoutBuilder, recipe: Recipe, fg: IFocusGroup) {
        val output = if (fried) recipe.output else recipe.cooked

        builder.addSlot(RecipeIngredientRole.INPUT, 40, 27).addIngredients(recipe.input)
        builder.addSlot(RecipeIngredientRole.OUTPUT, 108, 27).addIngredients(output)
    }

    data class Recipe(val input: Ingredient, val cooked: Ingredient, val output: Ingredient)

    companion object {
        @JvmStatic
        val FRIED: RecipeType<Recipe> = RecipeType.create<Recipe>(ManorsBounty.ID, "fryer_fried", Recipe::class.java)

        @JvmStatic
        val COOKED: RecipeType<Recipe> = RecipeType.create<Recipe>(ManorsBounty.ID, "fryer_cooked", Recipe::class.java)

        @JvmStatic
        val RECIPE_LIST = Lists.newArrayList<Recipe>()

        fun build(): List<Recipe> {
            if (RECIPE_LIST.isNotEmpty()) {
                return RECIPE_LIST
            }

            TileFryer.initRecipe()
            TileFryer.RECIPE.forEach { k, v ->
                RECIPE_LIST.add(Recipe(Ingredient.of(k.asStack()), Ingredient.of(v.first), Ingredient.of(v.second)))
            }

            return RECIPE_LIST
        }
    }
}
