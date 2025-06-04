package com.djinfinite.manors_bounty.registries;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeSerializer;

import com.djinfinite.manors_bounty.jei_recipes.OvenNormalRecipeRecipe;
import com.djinfinite.manors_bounty.jei_recipes.IceCreamMachineRecipesRecipe;
import com.djinfinite.manors_bounty.jei_recipes.FryRecipesRecipe;
import com.djinfinite.manors_bounty.jei_recipes.FryCookRecipe;
import com.djinfinite.manors_bounty.jei_recipes.CuttingRecipe;
import com.djinfinite.manors_bounty.ManorsBountyMod;
@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = ManorsBountyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "manors_bounty");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		event.enqueueWork(() -> {
			SERIALIZERS.register(bus);
			SERIALIZERS.register("ice_cream_machine_recipes", () -> IceCreamMachineRecipesRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("fry_recipes", () -> FryRecipesRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("cutting", () -> CuttingRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("fry_cook_recipe", () -> FryCookRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("oven_normal_recipe", () -> OvenNormalRecipeRecipe.Serializer.INSTANCE);

		});
	}
}
