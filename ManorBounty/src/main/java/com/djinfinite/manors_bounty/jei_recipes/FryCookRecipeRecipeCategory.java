
package com.djinfinite.manors_bounty.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import com.djinfinite.manors_bounty.registries.ModJeiPlugin;
import com.djinfinite.manors_bounty.registries.ModBlocks;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;
import org.jetbrains.annotations.NotNull;

public class FryCookRecipeRecipeCategory implements IRecipeCategory<FryCookRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("manors_bounty", "fry_cook_recipe");
	public final static ResourceLocation TEXTURE = new ResourceLocation("manors_bounty", "textures/screens/fryer_cook_recipe_jei_background.png");
	private final IDrawable background;
	private final IDrawable icon;

	public FryCookRecipeRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 154, 74);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.FRYER.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.@NotNull RecipeType<FryCookRecipe> getRecipeType() {
		return ModJeiPlugin.FryCookRecipe_Type;
	}

	@Override
	public @NotNull Component getTitle() {
		return Component.literal("炸锅烹饪(短时)");
	}

	@Override
	public @NotNull IDrawable getBackground() {
		return this.background;
	}

	@Override
	public @NotNull IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, FryCookRecipe recipe, @NotNull IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 40, 27).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 108, 27).addItemStack(recipe.getResultItem(null));
	}
}
