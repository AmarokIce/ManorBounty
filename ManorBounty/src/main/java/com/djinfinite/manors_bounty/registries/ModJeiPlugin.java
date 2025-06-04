
package com.djinfinite.manors_bounty.registries;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import com.djinfinite.manors_bounty.jei_recipes.OvenNormalRecipeRecipeCategory;
import com.djinfinite.manors_bounty.jei_recipes.OvenNormalRecipeRecipe;
import com.djinfinite.manors_bounty.jei_recipes.IceCreamMachineRecipesRecipeCategory;
import com.djinfinite.manors_bounty.jei_recipes.IceCreamMachineRecipesRecipe;
import com.djinfinite.manors_bounty.jei_recipes.FryRecipesRecipeCategory;
import com.djinfinite.manors_bounty.jei_recipes.FryRecipesRecipe;
import com.djinfinite.manors_bounty.jei_recipes.FryCookRecipeRecipeCategory;
import com.djinfinite.manors_bounty.jei_recipes.FryCookRecipe;
import com.djinfinite.manors_bounty.jei_recipes.CuttingRecipeCategory;
import com.djinfinite.manors_bounty.jei_recipes.CuttingRecipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.List;
@SuppressWarnings("unused")
@JeiPlugin
public class ModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<IceCreamMachineRecipesRecipe> IceCreamMachineRecipes_Type = new mezz.jei.api.recipe.RecipeType<>(IceCreamMachineRecipesRecipeCategory.UID, IceCreamMachineRecipesRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<FryRecipesRecipe> FryRecipes_Type = new mezz.jei.api.recipe.RecipeType<>(FryRecipesRecipeCategory.UID, FryRecipesRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<CuttingRecipe> Cutting_Type = new mezz.jei.api.recipe.RecipeType<>(CuttingRecipeCategory.UID, CuttingRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<FryCookRecipe> FryCookRecipe_Type = new mezz.jei.api.recipe.RecipeType<>(FryCookRecipeRecipeCategory.UID, FryCookRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<OvenNormalRecipeRecipe> OvenNormalRecipe_Type = new mezz.jei.api.recipe.RecipeType<>(OvenNormalRecipeRecipeCategory.UID, OvenNormalRecipeRecipe.class);

	@Override
	public @NotNull ResourceLocation getPluginUid() {
		return new ResourceLocation("manors_bounty:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new IceCreamMachineRecipesRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new FryRecipesRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new CuttingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new FryCookRecipeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new OvenNormalRecipeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<IceCreamMachineRecipesRecipe> IceCreamMachineRecipesRecipes = recipeManager.getAllRecipesFor(IceCreamMachineRecipesRecipe.Type.INSTANCE);
		registration.addRecipes(IceCreamMachineRecipes_Type, IceCreamMachineRecipesRecipes);
		List<FryRecipesRecipe> FryRecipesRecipes = recipeManager.getAllRecipesFor(FryRecipesRecipe.Type.INSTANCE);
		registration.addRecipes(FryRecipes_Type, FryRecipesRecipes);
		List<CuttingRecipe> CuttingRecipes = recipeManager.getAllRecipesFor(CuttingRecipe.Type.INSTANCE);
		registration.addRecipes(Cutting_Type, CuttingRecipes);
		List<FryCookRecipe> fryCookRecipes = recipeManager.getAllRecipesFor(FryCookRecipe.Type.INSTANCE);
		registration.addRecipes(FryCookRecipe_Type, fryCookRecipes);
		List<OvenNormalRecipeRecipe> OvenNormalRecipeRecipes = recipeManager.getAllRecipesFor(OvenNormalRecipeRecipe.Type.INSTANCE);
		registration.addRecipes(OvenNormalRecipe_Type, OvenNormalRecipeRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(ModBlocks.ICE_CREAM_MACHINE.get().asItem()), IceCreamMachineRecipes_Type);
		registration.addRecipeCatalyst(new ItemStack(ModBlocks.FRYER.get().asItem()), FryRecipes_Type);
		registration.addRecipeCatalyst(new ItemStack(ModBlocks.FRYER.get().asItem()), FryCookRecipe_Type);
		registration.addRecipeCatalyst(new ItemStack(ModBlocks.OVEN.get().asItem()), OvenNormalRecipe_Type);
	}
}
