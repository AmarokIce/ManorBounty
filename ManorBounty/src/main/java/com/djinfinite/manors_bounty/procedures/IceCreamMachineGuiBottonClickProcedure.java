package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.jei_recipes.IceCreamMachineRecipesRecipe;
import com.djinfinite.manors_bounty.registries.ModItems;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
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
import net.minecraft.client.gui.components.Checkbox;

import java.util.function.Supplier;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class IceCreamMachineGuiBottonClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if ((!((new Object() {
			public ItemStack getResult() {
				if (world instanceof Level _lvl) {
					net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
					List<IceCreamMachineRecipesRecipe> recipes = rm.getAllRecipesFor(IceCreamMachineRecipesRecipe.Type.INSTANCE);
					for (IceCreamMachineRecipesRecipe recipe : recipes) {
						NonNullList<Ingredient> ingredients = recipe.getIngredients();
						if (!ingredients.get(0).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)))
							continue;
						if (!ingredients.get(1).test(new ItemStack(ModItems.SLOT_BAN_ITEM.get())))
							continue;
						if (!ingredients.get(2).test(new ItemStack(ModItems.SLOT_BAN_ITEM.get())))
							continue;
						if (!ingredients.get(3).test(new ItemStack(ModItems.VANILLA_ICE_CREAM_FLUID_BUCKET.get())))
							continue;
						return recipe.getResultItem(null);
					}
				}
				return ItemStack.EMPTY;
			}
		}.getResult()).getItem() == ItemStack.EMPTY.getItem()) || !((new Object() {
			public ItemStack getResult() {
				if (world instanceof Level _lvl) {
					net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
					List<IceCreamMachineRecipesRecipe> recipes = rm.getAllRecipesFor(IceCreamMachineRecipesRecipe.Type.INSTANCE);
					for (IceCreamMachineRecipesRecipe recipe : recipes) {
						NonNullList<Ingredient> ingredients = recipe.getIngredients();
						if (!ingredients.get(0).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)))
							continue;
						if (!ingredients.get(1).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)))
							continue;
						if (!ingredients.get(2).test(new ItemStack(ModItems.SLOT_BAN_ITEM.get())))
							continue;
						if (!ingredients.get(3).test(new ItemStack(ModItems.VANILLA_ICE_CREAM_FLUID_BUCKET.get())))
							continue;
						return recipe.getResultItem(null);
					}
				}
				return ItemStack.EMPTY;
			}
		}.getResult()).getItem() == ItemStack.EMPTY.getItem()) || !((new Object() {
			public ItemStack getResult() {
				if (world instanceof Level _lvl) {
					net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
					List<IceCreamMachineRecipesRecipe> recipes = rm.getAllRecipesFor(IceCreamMachineRecipesRecipe.Type.INSTANCE);
					for (IceCreamMachineRecipesRecipe recipe : recipes) {
						NonNullList<Ingredient> ingredients = recipe.getIngredients();
						if (!ingredients.get(0).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)))
							continue;
						if (!ingredients.get(1).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)))
							continue;
						if (!ingredients.get(2).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)))
							continue;
						if (!ingredients.get(3).test(new ItemStack(ModItems.VANILLA_ICE_CREAM_FLUID_BUCKET.get())))
							continue;
						return recipe.getResultItem(null);
					}
				}
				return ItemStack.EMPTY;
			}
		}.getResult()).getItem() == ItemStack.EMPTY.getItem())) && new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "IceCreamFluid") >= 200) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.powder_snow.break")), SoundSource.BLOCKS, (float) 1.2, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.powder_snow.break")), SoundSource.BLOCKS, (float) 1.2, 1, false);
				}
			}
			if (!(guistate.containsKey("checkbox:IceCreamTypeCheck") && ((Checkbox) guistate.get("checkbox:IceCreamTypeCheck")).selected())) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if (!((new Object() {
						public ItemStack getResult() {
							if (world instanceof Level _lvl) {
								net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
								List<IceCreamMachineRecipesRecipe> recipes = rm.getAllRecipesFor(IceCreamMachineRecipesRecipe.Type.INSTANCE);
								for (IceCreamMachineRecipesRecipe recipe : recipes) {
									NonNullList<Ingredient> ingredients = recipe.getIngredients();
									if (!ingredients.get(0).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)))
										continue;
									if (!ingredients.get(1).test(new ItemStack(ModItems.SLOT_BAN_ITEM.get())))
										continue;
									if (!ingredients.get(2).test(new ItemStack(ModItems.SLOT_BAN_ITEM.get())))
										continue;
									if (!ingredients.get(3).test(new ItemStack(ModItems.VANILLA_ICE_CREAM_FLUID_BUCKET.get())))
										continue;
									return recipe.getResultItem(null);
								}
							}
							return ItemStack.EMPTY;
						}
					}.getResult()).getItem() == ItemStack.EMPTY.getItem())) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = (new Object() {
								public ItemStack getResult() {
									if (world instanceof Level _lvl) {
										net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
										List<IceCreamMachineRecipesRecipe> recipes = rm.getAllRecipesFor(IceCreamMachineRecipesRecipe.Type.INSTANCE);
										for (IceCreamMachineRecipesRecipe recipe : recipes) {
											NonNullList<Ingredient> ingredients = recipe.getIngredients();
											if (!ingredients.get(0)
													.test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)))
												continue;
											if (!ingredients.get(1).test(new ItemStack(ModItems.SLOT_BAN_ITEM.get())))
												continue;
											if (!ingredients.get(2).test(new ItemStack(ModItems.SLOT_BAN_ITEM.get())))
												continue;
											if (!ingredients.get(3).test(new ItemStack(ModItems.VANILLA_ICE_CREAM_FLUID_BUCKET.get())))
												continue;
											return recipe.getResultItem(null);
										}
									}
									return ItemStack.EMPTY;
								}
							}.getResult()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(0)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("IceCreamFluid", ((new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getDouble(tag);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "IceCreamFluid")) - 200));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				} else {
					if (!((new Object() {
						public ItemStack getResult() {
							if (world instanceof Level _lvl) {
								net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
								List<IceCreamMachineRecipesRecipe> recipes = rm.getAllRecipesFor(IceCreamMachineRecipesRecipe.Type.INSTANCE);
								for (IceCreamMachineRecipesRecipe recipe : recipes) {
									NonNullList<Ingredient> ingredients = recipe.getIngredients();
									if (!ingredients.get(0).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)))
										continue;
									if (!ingredients.get(1).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)))
										continue;
									if (!ingredients.get(2).test(new ItemStack(ModItems.SLOT_BAN_ITEM.get())))
										continue;
									if (!ingredients.get(3).test(new ItemStack(ModItems.VANILLA_ICE_CREAM_FLUID_BUCKET.get())))
										continue;
									return recipe.getResultItem(null);
								}
							}
							return ItemStack.EMPTY;
						}
					}.getResult()).getItem() == ItemStack.EMPTY.getItem())) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = (new Object() {
								public ItemStack getResult() {
									if (world instanceof Level _lvl) {
										net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
										List<IceCreamMachineRecipesRecipe> recipes = rm.getAllRecipesFor(IceCreamMachineRecipesRecipe.Type.INSTANCE);
										for (IceCreamMachineRecipesRecipe recipe : recipes) {
											NonNullList<Ingredient> ingredients = recipe.getIngredients();
											if (!ingredients.get(0)
													.test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)))
												continue;
											if (!ingredients.get(1)
													.test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)))
												continue;
											if (!ingredients.get(2).test(new ItemStack(ModItems.SLOT_BAN_ITEM.get())))
												continue;
											if (!ingredients.get(3).test(new ItemStack(ModItems.VANILLA_ICE_CREAM_FLUID_BUCKET.get())))
												continue;
											return recipe.getResultItem(null);
										}
									}
									return ItemStack.EMPTY;
								}
							}.getResult()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(0)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("IceCreamFluid", ((new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getDouble(tag);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "IceCreamFluid")) - 200));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get(1)).remove(1);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			} else {
				if (!((new Object() {
					public ItemStack getResult() {
						if (world instanceof Level _lvl) {
							net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
							List<IceCreamMachineRecipesRecipe> recipes = rm.getAllRecipesFor(IceCreamMachineRecipesRecipe.Type.INSTANCE);
							for (IceCreamMachineRecipesRecipe recipe : recipes) {
								NonNullList<Ingredient> ingredients = recipe.getIngredients();
								if (!ingredients.get(0).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)))
									continue;
								if (!ingredients.get(1).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)))
									continue;
								if (!ingredients.get(2).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)))
									continue;
								if (!ingredients.get(3).test(new ItemStack(ModItems.VANILLA_ICE_CREAM_FLUID_BUCKET.get())))
									continue;
								return recipe.getResultItem(null);
							}
						}
						return ItemStack.EMPTY;
					}
				}.getResult()).getItem() == ItemStack.EMPTY.getItem()) || !((new Object() {
					public ItemStack getResult() {
						if (world instanceof Level _lvl) {
							net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
							List<IceCreamMachineRecipesRecipe> recipes = rm.getAllRecipesFor(IceCreamMachineRecipesRecipe.Type.INSTANCE);
							for (IceCreamMachineRecipesRecipe recipe : recipes) {
								NonNullList<Ingredient> ingredients = recipe.getIngredients();
								if (!ingredients.get(0).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)))
									continue;
								if (!ingredients.get(1).test(new ItemStack(ModItems.SLOT_BAN_ITEM.get())))
									continue;
								if (!ingredients.get(2).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)))
									continue;
								if (!ingredients.get(3).test(new ItemStack(ModItems.VANILLA_ICE_CREAM_FLUID_BUCKET.get())))
									continue;
								return recipe.getResultItem(null);
							}
						}
						return ItemStack.EMPTY;
					}
				}.getResult()).getItem() == ItemStack.EMPTY.getItem())) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = (new Object() {
								public ItemStack getResult() {
									if (world instanceof Level _lvl) {
										net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
										List<IceCreamMachineRecipesRecipe> recipes = rm.getAllRecipesFor(IceCreamMachineRecipesRecipe.Type.INSTANCE);
										for (IceCreamMachineRecipesRecipe recipe : recipes) {
											NonNullList<Ingredient> ingredients = recipe.getIngredients();
											if (!ingredients.get(0)
													.test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)))
												continue;
											if (!ingredients.get(1).test(new ItemStack(ModItems.SLOT_BAN_ITEM.get())))
												continue;
											if (!ingredients.get(2)
													.test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)))
												continue;
											if (!ingredients.get(3).test(new ItemStack(ModItems.VANILLA_ICE_CREAM_FLUID_BUCKET.get())))
												continue;
											return recipe.getResultItem(null);
										}
									}
									return ItemStack.EMPTY;
								}
							}.getResult()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(0)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					} else {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = (new Object() {
								public ItemStack getResult() {
									if (world instanceof Level _lvl) {
										net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
										List<IceCreamMachineRecipesRecipe> recipes = rm.getAllRecipesFor(IceCreamMachineRecipesRecipe.Type.INSTANCE);
										for (IceCreamMachineRecipesRecipe recipe : recipes) {
											NonNullList<Ingredient> ingredients = recipe.getIngredients();
											if (!ingredients.get(0)
													.test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)))
												continue;
											if (!ingredients.get(1)
													.test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)))
												continue;
											if (!ingredients.get(2)
													.test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)))
												continue;
											if (!ingredients.get(3).test(new ItemStack(ModItems.VANILLA_ICE_CREAM_FLUID_BUCKET.get())))
												continue;
											return recipe.getResultItem(null);
										}
									}
									return ItemStack.EMPTY;
								}
							}.getResult()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(0)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("IceCreamFluid", ((new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "IceCreamFluid")) - 200));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						((Slot) _slots.get(1)).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						((Slot) _slots.get(2)).remove(1);
						_player.containerMenu.broadcastChanges();
					}
				}
			}
		}
	}
}
