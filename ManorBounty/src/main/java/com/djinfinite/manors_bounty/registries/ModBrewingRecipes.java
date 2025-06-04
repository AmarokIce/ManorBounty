
package com.djinfinite.manors_bounty.registries;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.ArrayList;
@SuppressWarnings("unused")
@JeiPlugin
public class ModBrewingRecipes implements IModPlugin {
	@Override
	public @NotNull ResourceLocation getPluginUid() {
		return new ResourceLocation("manors_bounty:brewing_recipes");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();
		List<IJeiBrewingRecipe> brewingRecipes = new ArrayList<>();
		ItemStack potion = new ItemStack(Items.POTION);
		ItemStack potion2 = new ItemStack(Items.POTION);
		List<ItemStack> ingredientStack = new ArrayList<>();
		List<ItemStack> inputStack = new ArrayList<>();
		registration.addRecipes(RecipeTypes.BREWING, brewingRecipes);
	}
}
