package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.NonNullList;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.jei_recipes.OvenNormalRecipeRecipe;

import java.util.concurrent.atomic.AtomicReference;
import java.util.List;

public class GetOvenCookResultProcedure {
	public static ItemStack execute(LevelAccessor world, double x, double y, double z) {
		ItemStack result_item;
		final ItemStack tem;
		final ItemStack time;
		tem = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((("manors_bounty:tem_item_" + new java.text.DecimalFormat("##").format(new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "tem")))).toLowerCase(java.util.Locale.ENGLISH))));
		time = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((("manors_bounty:time_item_" + new java.text.DecimalFormat("##").format(new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "cook_time")))).toLowerCase(java.util.Locale.ENGLISH))));
		result_item = (new Object() {
			public ItemStack getResult() {
				if (world instanceof Level _lvl) {
					net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
					List<OvenNormalRecipeRecipe> recipes = rm.getAllRecipesFor(OvenNormalRecipeRecipe.Type.INSTANCE);
					for (OvenNormalRecipeRecipe recipe : recipes) {
						NonNullList<Ingredient> ingredients = recipe.getIngredients();
						if (!ingredients.get(0).test((new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0))))
							continue;
						if (!ingredients.get(1).test((new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 1))))
							continue;
						if (!ingredients.get(2).test((new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 2))))
							continue;
						if (!ingredients.get(3).test((new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 3))))
							continue;
						if (!ingredients.get(4).test(tem))
							continue;
						if (!ingredients.get(5).test(time))
							continue;
						return recipe.getResultItem(null);
					}
				}
				return ItemStack.EMPTY;
			}
		}.getResult());
		if (!(result_item.getItem() == Blocks.AIR.asItem())) {
			return result_item;
		}
		return new ItemStack(Items.CHARCOAL);
	}
}
