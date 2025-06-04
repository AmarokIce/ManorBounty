
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

public class OvenNormalRecipeRecipeCategory implements IRecipeCategory<OvenNormalRecipeRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("manors_bounty", "oven_normal_recipe");
	public final static ResourceLocation TEXTURE = new ResourceLocation("manors_bounty", "textures/screens/oven_jei_background.png");
	private final IDrawable background;
	private final IDrawable icon;

	public OvenNormalRecipeRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 154, 74);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.OVEN.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.@NotNull RecipeType<OvenNormalRecipeRecipe> getRecipeType() {
		return ModJeiPlugin.OvenNormalRecipe_Type;
	}

	@Override
	public @NotNull Component getTitle() {
		return Component.literal("烤箱烹饪");
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
	public void setRecipe(IRecipeLayoutBuilder builder, OvenNormalRecipeRecipe recipe, @NotNull IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 23, 25).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 49, 25).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 23, 49).addIngredients(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.INPUT, 49, 49).addIngredients(recipe.getIngredients().get(3));
		builder.addSlot(RecipeIngredientRole.INPUT, 16, 2).addIngredients(recipe.getIngredients().get(4));
		builder.addSlot(RecipeIngredientRole.INPUT, 122, 2).addIngredients(recipe.getIngredients().get(5));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 106, 37).addItemStack(recipe.getResultItem(null));
	}
}
