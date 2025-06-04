
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

public class IceCreamMachineRecipesRecipeCategory implements IRecipeCategory<IceCreamMachineRecipesRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("manors_bounty", "ice_cream_machine_recipes");
	public final static ResourceLocation TEXTURE = new ResourceLocation("manors_bounty", "textures/screens/ice_cream_machine_jei_background.png");
	private final IDrawable background;
	private final IDrawable icon;

	public IceCreamMachineRecipesRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 154, 74);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.ICE_CREAM_MACHINE.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.@NotNull RecipeType<IceCreamMachineRecipesRecipe> getRecipeType() {
		return ModJeiPlugin.IceCreamMachineRecipes_Type;
	}

	@Override
	public @NotNull Component getTitle() {
		return Component.literal("冰淇淋机");
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
	public void setRecipe(IRecipeLayoutBuilder builder, IceCreamMachineRecipesRecipe recipe, @NotNull IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 7, 28).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 54, 28).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 54, 50).addIngredients(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 109, 28).addItemStack(recipe.getResultItem(null));
		builder.addSlot(RecipeIngredientRole.INPUT, 30, 28).addIngredients(recipe.getIngredients().get(3));
	}
}
