
package com.djinfinite.manors_bounty.jei_recipes;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import com.djinfinite.manors_bounty.registries.ModJeiPlugin;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;
import org.jetbrains.annotations.NotNull;

public class CuttingRecipeCategory implements IRecipeCategory<CuttingRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("manors_bounty", "cutting");
	public final static ResourceLocation TEXTURE = new ResourceLocation("manors_bounty", "textures/screens/cutting_board_gui_knife.png");
	private final IDrawable background;
	private final IDrawable icon;

	public CuttingRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 0, 0);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CUTTING_BOARD.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.@NotNull RecipeType<CuttingRecipe> getRecipeType() {
		return ModJeiPlugin.Cutting_Type;
	}

	@Override
	public @NotNull Component getTitle() {
		return Component.literal("砧板切割");
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
	public void setRecipe(IRecipeLayoutBuilder builder, CuttingRecipe recipe, @NotNull IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 0, 0).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 20, 0).addItemStack(recipe.getResultItem(null));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 40, 0).addItemStack(recipe.getResultItem(null));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 60, 0).addItemStack(recipe.getResultItem(null));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 20, 10).addItemStack(recipe.getResultItem(null));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 40, 10).addItemStack(recipe.getResultItem(null));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 60, 10).addItemStack(recipe.getResultItem(null));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 20, 20).addItemStack(recipe.getResultItem(null));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 40, 20).addItemStack(recipe.getResultItem(null));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 60, 20).addItemStack(recipe.getResultItem(null));
	}
}
