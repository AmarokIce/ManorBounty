package com.djinfinite.manors_bounty.jei_recipes;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.SimpleContainer;
import net.minecraft.util.GsonHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.NonNullList;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import org.jetbrains.annotations.NotNull;

public class CuttingRecipe implements Recipe<SimpleContainer> {
	private final ResourceLocation id;
	private final ItemStack output;
	private final NonNullList<Ingredient> recipeItems;

	public CuttingRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
		this.id = id;
		this.output = output;
		this.recipeItems = recipeItems;
	}

	@Override
	public boolean matches(@NotNull SimpleContainer pContainer, @NotNull Level pLevel) {
        return false;
		//return recipeItems.get(0).test(pContainer.getItem(1));
	}

	@Override
	public @NotNull NonNullList<Ingredient> getIngredients() {
		return recipeItems;
	}

	@Override
	public @NotNull ItemStack assemble(@NotNull SimpleContainer pContainer, @NotNull RegistryAccess access) {
		return output;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public @NotNull ItemStack getResultItem(@NotNull RegistryAccess access) {
		return output.copy();
	}

	@Override
	public @NotNull ResourceLocation getId() {
		return id;
	}

	@Override
	public @NotNull RecipeType<?> getType() {
		return Type.INSTANCE;
	}

	@Override
	public @NotNull RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}

	public static class Type implements RecipeType<CuttingRecipe> {
		private Type() {
		}

		public static final Type INSTANCE = new Type();
		public static final String ID = "cutting";
	}

	public static class Serializer implements RecipeSerializer<CuttingRecipe> {
		public static final Serializer INSTANCE = new Serializer();
		public static final ResourceLocation ID = new ResourceLocation("manors_bounty", "cutting");

		@Override
		public @NotNull CuttingRecipe fromJson(@NotNull ResourceLocation pRecipeId, @NotNull JsonObject pSerializedRecipe) {
			ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));
			JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
			NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);
			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
			}
			return new CuttingRecipe(pRecipeId, output, inputs);
		}

		@Override
		public @Nullable CuttingRecipe fromNetwork(@NotNull ResourceLocation id, FriendlyByteBuf buf) {
			NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
            inputs.replaceAll(ignored -> Ingredient.fromNetwork(buf));
			ItemStack output = buf.readItem();
			return new CuttingRecipe(id, output, inputs);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buf, CuttingRecipe recipe) {
			buf.writeInt(recipe.getIngredients().size());
			for (Ingredient ing : recipe.getIngredients()) {
				ing.toNetwork(buf);
			}
			buf.writeItemStack(recipe.getResultItem(null), false);
		}
	}
}
