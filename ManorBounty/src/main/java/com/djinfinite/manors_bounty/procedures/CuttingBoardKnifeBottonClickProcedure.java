package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.NonNullList;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.jei_recipes.CuttingRecipe;
import com.djinfinite.manors_bounty.ManorsBountyMod;

import java.util.function.Supplier;
import java.util.Map;
import java.util.List;

public class CuttingBoardKnifeBottonClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((new Object() {
			public ItemStack getResult() {
				if (world instanceof Level _lvl) {
					net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
					List<CuttingRecipe> recipes = rm.getAllRecipesFor(CuttingRecipe.Type.INSTANCE);
					for (CuttingRecipe recipe : recipes) {
						NonNullList<Ingredient> ingredients = recipe.getIngredients();
						if (!ingredients.get(0).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)))
							continue;
						return recipe.getResultItem(null);
					}
				}
				return ItemStack.EMPTY;
			}
		}.getResult()).getItem() == Blocks.AIR.asItem())
				&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == (new Object() {
							public ItemStack getResult() {
								if (world instanceof Level _lvl) {
									net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
									List<CuttingRecipe> recipes = rm.getAllRecipesFor(CuttingRecipe.Type.INSTANCE);
									for (CuttingRecipe recipe : recipes) {
										NonNullList<Ingredient> ingredients = recipe.getIngredients();
										if (!ingredients.get(0)
												.test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)))
											continue;
										return recipe.getResultItem(null);
									}
								}
								return ItemStack.EMPTY;
							}
						}.getResult()).getItem())) {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo.break")), SoundSource.NEUTRAL, 1, 1);
                } else {
                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo.break")), SoundSource.NEUTRAL, 1, 1, false);
                }
            }
            ManorsBountyMod.queueServerWork(5, () -> {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo.break")), SoundSource.NEUTRAL, 1, 1);
                    } else {
                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo.break")), SoundSource.NEUTRAL, 1, 1, false);
                    }
                }
            });
            ManorsBountyMod.queueServerWork(10, () -> {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo.break")), SoundSource.NEUTRAL, 1, 1);
                    } else {
                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo.break")), SoundSource.NEUTRAL, 1, 1, false);
                    }
                }
            });
            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = (new Object() {
					public ItemStack getResult() {
						if (world instanceof Level _lvl) {
							net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
							List<CuttingRecipe> recipes = rm.getAllRecipesFor(CuttingRecipe.Type.INSTANCE);
							for (CuttingRecipe recipe : recipes) {
								NonNullList<Ingredient> ingredients = recipe.getIngredients();
								if (!ingredients.get(0).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)))
									continue;
								return recipe.getResultItem(null);
							}
						}
						return ItemStack.EMPTY;
					}
				}.getResult()).copy();
				_setstack.setCount(new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
                            return stack.getCount();
						}
						return 0;
					}
				}.getAmount(1) + (new Object() {
					public ItemStack getResult() {
						if (world instanceof Level _lvl) {
							net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
							List<CuttingRecipe> recipes = rm.getAllRecipesFor(CuttingRecipe.Type.INSTANCE);
							for (CuttingRecipe recipe : recipes) {
								NonNullList<Ingredient> ingredients = recipe.getIngredients();
								if (!ingredients.get(0).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)))
									continue;
								return recipe.getResultItem(null);
							}
						}
						return ItemStack.EMPTY;
					}
				}.getResult()).getCount());
				((Slot) _slots.get(1)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(0)).remove(1);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}
