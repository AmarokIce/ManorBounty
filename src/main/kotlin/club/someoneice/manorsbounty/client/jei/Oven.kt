package club.someoneice.manorsbounty.client.jei

import club.someoneice.manorsbounty.ManorsBounty
import club.someoneice.manorsbounty.common.tile.TileOven
import club.someoneice.manorsbounty.init.ModBlocks
import com.google.common.collect.Lists
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder
import mezz.jei.api.gui.drawable.IDrawable
import mezz.jei.api.gui.ingredient.IRecipeSlotsView
import mezz.jei.api.helpers.IGuiHelper
import mezz.jei.api.recipe.IFocusGroup
import mezz.jei.api.recipe.RecipeIngredientRole
import mezz.jei.api.recipe.RecipeType
import mezz.jei.api.recipe.category.IRecipeCategory
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.Ingredient
import java.awt.Color
import kotlin.jvm.java

class Oven(private val helper: IGuiHelper): IRecipeCategory<Oven.Recipe> {
    override fun getRecipeType(): RecipeType<Recipe> = TYPE
    override fun getTitle(): Component = Component.literal("油炸")

    override fun getBackground(): IDrawable {
        return helper.createDrawable(TEXTURES, 0, 0, 153, 73)
    }

    override fun getIcon(): IDrawable {
        return helper.createDrawableItemStack(ModBlocks.OVEN_ITEM.get().defaultInstance)
    }

    override fun setRecipe(builder: IRecipeLayoutBuilder, recipe: Recipe, fg: IFocusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 23, 25).addIngredients(recipe.input0)
        builder.addSlot(RecipeIngredientRole.INPUT, 49, 49).addIngredients(recipe.input1)
        builder.addSlot(RecipeIngredientRole.INPUT, 23, 25).addIngredients(recipe.input2)
        builder.addSlot(RecipeIngredientRole.INPUT, 49, 49).addIngredients(recipe.input3)
        builder.addSlot(RecipeIngredientRole.OUTPUT, 106, 37).addItemStack(recipe.output)
    }

    override fun draw(recipe: Recipe, recipeSlotsView: IRecipeSlotsView, gg: GuiGraphics, mouseX: Double, mouseY: Double) {
        super.draw(recipe, recipeSlotsView, gg, mouseX, mouseY)

        val temp = recipe.temp
        val time = recipe.time

        gg.blit(TEXTURES, 26, 0, 160 + temp * 16, 0, 16, 16)
        gg.blit(TEXTURES, 112, 0, 160 + time * 16, 0, 16, 16)

        gg.drawString(Minecraft.getInstance().font, (temp * 50 + 100).toString(), 58, 5, Color.WHITE.rgb)
        gg.drawString(Minecraft.getInstance().font, (time * 5).toString() + "s", 85, 5, Color.WHITE.rgb)
    }


    @JvmRecord
    data class Recipe(
        val input0: Ingredient,
        val input1: Ingredient,
        val input2: Ingredient,
        val input3: Ingredient,
        val output: ItemStack,
        val temp: Int,
        val time: Int
    )

    companion object {
        @JvmStatic
        val TYPE: RecipeType<Recipe> = RecipeType.create<Recipe>(ManorsBounty.ID, "oven", Recipe::class.java)

        val RECIPE = Lists.newArrayList<Recipe>()

        private val TEXTURES = ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, "textures/screens/oven_jei_background.png")

        fun build(): List<Recipe> {
            if (!RECIPE.isNotEmpty()) {
                return RECIPE
            }

            TileOven.initRecipes()
            TileOven.RECIPES.forEach {
                RECIPE.add(Recipe(
                    it.items[0],
                    it.items[1],
                    it.items[2],
                    it.items[3],
                    it.out,
                    it.temp,
                    it.time
                ))
            }

            return RECIPE
        }
    }
}
