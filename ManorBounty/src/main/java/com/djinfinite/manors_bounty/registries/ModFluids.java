
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package com.djinfinite.manors_bounty.registries;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import com.djinfinite.manors_bounty.fluid.WatermelonJuiceFluidFluid;
import com.djinfinite.manors_bounty.fluid.VanillaIceCreamFluidFluid;
import com.djinfinite.manors_bounty.fluid.StrawberryShakeFluidFluid;
import com.djinfinite.manors_bounty.fluid.StarfruitIceCreamFluidFluid;
import com.djinfinite.manors_bounty.fluid.PineappleJuiceFluidFluid;
import com.djinfinite.manors_bounty.fluid.PearWithRockSugarFluidFluid;
import com.djinfinite.manors_bounty.fluid.OrangeJuiceFluidFluid;
import com.djinfinite.manors_bounty.fluid.OliveOilFluid;
import com.djinfinite.manors_bounty.fluid.MelonSodaFluidFluid;
import com.djinfinite.manors_bounty.fluid.MartiniFluidFluid;
import com.djinfinite.manors_bounty.fluid.MangoJuiceFluidFluid;
import com.djinfinite.manors_bounty.fluid.LemonadeFluidFluid;
import com.djinfinite.manors_bounty.fluid.JalapenoIceCreamFluidFluid;
import com.djinfinite.manors_bounty.fluid.HotSpringFluid;
import com.djinfinite.manors_bounty.fluid.GrimaceShakeFluidFluid;
import com.djinfinite.manors_bounty.fluid.CoffeeFluidFluid;
import com.djinfinite.manors_bounty.fluid.ChorusFruitJuiceFluidFluid;
import com.djinfinite.manors_bounty.fluid.ChocolateIceCreamFluidFluid;
import com.djinfinite.manors_bounty.fluid.CherriesIceCreamFluidFluid;
import com.djinfinite.manors_bounty.fluid.CakeLiquidFluid;
import com.djinfinite.manors_bounty.fluid.BubbleTeaFluidFluid;
import com.djinfinite.manors_bounty.fluid.BlueberryIceCreamFluidFluid;
import com.djinfinite.manors_bounty.fluid.BelliniBaseFluidFluid;
import com.djinfinite.manors_bounty.fluid.AppleJuiceFluidFluid;
import com.djinfinite.manors_bounty.ManorsBountyMod;
@SuppressWarnings("unused")
public class ModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, ManorsBountyMod.MOD_ID);
	public static final RegistryObject<FlowingFluid> VANILLA_ICE_CREAM_FLUID = REGISTRY.register("vanilla_ice_cream_fluid", VanillaIceCreamFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_VANILLA_ICE_CREAM_FLUID = REGISTRY.register("flowing_vanilla_ice_cream_fluid", VanillaIceCreamFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> BLUEBERRY_ICE_CREAM_FLUID = REGISTRY.register("blueberry_ice_cream_fluid", BlueberryIceCreamFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_BLUEBERRY_ICE_CREAM_FLUID = REGISTRY.register("flowing_blueberry_ice_cream_fluid", BlueberryIceCreamFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> CHERRIES_ICE_CREAM_FLUID = REGISTRY.register("cherries_ice_cream_fluid", CherriesIceCreamFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_CHERRIES_ICE_CREAM_FLUID = REGISTRY.register("flowing_cherries_ice_cream_fluid", CherriesIceCreamFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> STARFRUIT_ICE_CREAM_FLUID = REGISTRY.register("starfruit_ice_cream_fluid", StarfruitIceCreamFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_STARFRUIT_ICE_CREAM_FLUID = REGISTRY.register("flowing_starfruit_ice_cream_fluid", StarfruitIceCreamFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> CHOCOLATE_ICE_CREAM_FLUID = REGISTRY.register("chocolate_ice_cream_fluid", ChocolateIceCreamFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_CHOCOLATE_ICE_CREAM_FLUID = REGISTRY.register("flowing_chocolate_ice_cream_fluid", ChocolateIceCreamFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> JALAPENO_ICE_CREAM_FLUID = REGISTRY.register("jalapeno_ice_cream_fluid", JalapenoIceCreamFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_JALAPENO_ICE_CREAM_FLUID = REGISTRY.register("flowing_jalapeno_ice_cream_fluid", JalapenoIceCreamFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> OLIVE_OIL = REGISTRY.register("olive_oil", OliveOilFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_OLIVE_OIL = REGISTRY.register("flowing_olive_oil", OliveOilFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> HOT_SPRING = REGISTRY.register("hot_spring", HotSpringFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_HOT_SPRING = REGISTRY.register("flowing_hot_spring", HotSpringFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> CAKE_LIQUID = REGISTRY.register("cake_liquid", CakeLiquidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_CAKE_LIQUID = REGISTRY.register("flowing_cake_liquid", CakeLiquidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> COFFEE_FLUID = REGISTRY.register("coffee_fluid", CoffeeFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_COFFEE_FLUID = REGISTRY.register("flowing_coffee_fluid", CoffeeFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> MELON_SODA_FLUID = REGISTRY.register("melon_soda_fluid", MelonSodaFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_MELON_SODA_FLUID = REGISTRY.register("flowing_melon_soda_fluid", MelonSodaFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> BUBBLE_TEA_FLUID = REGISTRY.register("bubble_tea_fluid", BubbleTeaFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_BUBBLE_TEA_FLUID = REGISTRY.register("flowing_bubble_tea_fluid", BubbleTeaFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> GRIMACE_SHAKE_FLUID = REGISTRY.register("grimace_shake_fluid", GrimaceShakeFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_GRIMACE_SHAKE_FLUID = REGISTRY.register("flowing_grimace_shake_fluid", GrimaceShakeFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> ORANGE_JUICE_FLUID = REGISTRY.register("orange_juice_fluid", OrangeJuiceFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_ORANGE_JUICE_FLUID = REGISTRY.register("flowing_orange_juice_fluid", OrangeJuiceFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> LEMONADE_FLUID = REGISTRY.register("lemonade_fluid", LemonadeFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_LEMONADE_FLUID = REGISTRY.register("flowing_lemonade_fluid", LemonadeFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> APPLE_JUICE_FLUID = REGISTRY.register("apple_juice_fluid", AppleJuiceFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_APPLE_JUICE_FLUID = REGISTRY.register("flowing_apple_juice_fluid", AppleJuiceFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> PEAR_WITH_ROCK_SUGAR_FLUID = REGISTRY.register("pear_with_rock_sugar_fluid", PearWithRockSugarFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_PEAR_WITH_ROCK_SUGAR_FLUID = REGISTRY.register("flowing_pear_with_rock_sugar_fluid", PearWithRockSugarFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> BELLINI_BASE_FLUID = REGISTRY.register("bellini_base_fluid", BelliniBaseFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_BELLINI_BASE_FLUID = REGISTRY.register("flowing_bellini_base_fluid", BelliniBaseFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> STRAWBERRY_SHAKE_FLUID = REGISTRY.register("strawberry_shake_fluid", StrawberryShakeFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_STRAWBERRY_SHAKE_FLUID = REGISTRY.register("flowing_strawberry_shake_fluid", StrawberryShakeFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> MANGO_JUICE_FLUID = REGISTRY.register("mango_juice_fluid", MangoJuiceFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_MANGO_JUICE_FLUID = REGISTRY.register("flowing_mango_juice_fluid", MangoJuiceFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> PINEAPPLE_JUICE_FLUID = REGISTRY.register("pineapple_juice_fluid", PineappleJuiceFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_PINEAPPLE_JUICE_FLUID = REGISTRY.register("flowing_pineapple_juice_fluid", PineappleJuiceFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> WATERMELON_JUICE_FLUID = REGISTRY.register("watermelon_juice_fluid", WatermelonJuiceFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_WATERMELON_JUICE_FLUID = REGISTRY.register("flowing_watermelon_juice_fluid", WatermelonJuiceFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> MARTINI_FLUID = REGISTRY.register("martini_fluid", MartiniFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_MARTINI_FLUID = REGISTRY.register("flowing_martini_fluid", MartiniFluidFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> CHORUS_FRUIT_JUICE_FLUID = REGISTRY.register("chorus_fruit_juice_fluid", ChorusFruitJuiceFluidFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_CHORUS_FRUIT_JUICE_FLUID = REGISTRY.register("flowing_chorus_fruit_juice_fluid", ChorusFruitJuiceFluidFluid.Flowing::new);

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(VANILLA_ICE_CREAM_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_VANILLA_ICE_CREAM_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(BLUEBERRY_ICE_CREAM_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_BLUEBERRY_ICE_CREAM_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(CHERRIES_ICE_CREAM_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_CHERRIES_ICE_CREAM_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(STARFRUIT_ICE_CREAM_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_STARFRUIT_ICE_CREAM_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(CHOCOLATE_ICE_CREAM_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_CHOCOLATE_ICE_CREAM_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(JALAPENO_ICE_CREAM_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_JALAPENO_ICE_CREAM_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(OLIVE_OIL.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_OLIVE_OIL.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(HOT_SPRING.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_HOT_SPRING.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(CAKE_LIQUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_CAKE_LIQUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(COFFEE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_COFFEE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(MELON_SODA_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_MELON_SODA_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(BUBBLE_TEA_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_BUBBLE_TEA_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(GRIMACE_SHAKE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_GRIMACE_SHAKE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(ORANGE_JUICE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_ORANGE_JUICE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(LEMONADE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_LEMONADE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(APPLE_JUICE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_APPLE_JUICE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(PEAR_WITH_ROCK_SUGAR_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_PEAR_WITH_ROCK_SUGAR_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(BELLINI_BASE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_BELLINI_BASE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(STRAWBERRY_SHAKE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_STRAWBERRY_SHAKE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(MANGO_JUICE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_MANGO_JUICE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(PINEAPPLE_JUICE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_PINEAPPLE_JUICE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(WATERMELON_JUICE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_WATERMELON_JUICE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(MARTINI_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_MARTINI_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(CHORUS_FRUIT_JUICE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_CHORUS_FRUIT_JUICE_FLUID.get(), RenderType.translucent());
		}
	}
}
