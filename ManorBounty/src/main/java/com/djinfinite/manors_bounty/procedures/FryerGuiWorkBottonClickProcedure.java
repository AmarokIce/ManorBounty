package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.NonNullList;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.jei_recipes.FryRecipesRecipe;
import com.djinfinite.manors_bounty.jei_recipes.FryCookRecipe;

import java.util.List;

public class FryerGuiWorkBottonClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double time;
		ItemStack item_done_0 = ItemStack.EMPTY;
		ItemStack item_done_1 = ItemStack.EMPTY;
		ItemStack item_done_2 = ItemStack.EMPTY;
		ItemStack item_done_3 = ItemStack.EMPTY;
		ItemStack item_fried_0 = ItemStack.EMPTY;
		ItemStack item_fried_1 = ItemStack.EMPTY;
		ItemStack item_fried_2 = ItemStack.EMPTY;
		ItemStack item_fried_3 = ItemStack.EMPTY;
		ItemStack item_1 = ItemStack.EMPTY;
		ItemStack item_2 = ItemStack.EMPTY;
		ItemStack item_0 = ItemStack.EMPTY;
		ItemStack item_3 = ItemStack.EMPTY;
		if (new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "working")) {
			time = new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "working_time");
            item_0 = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
                public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                    BlockEntity blockEntity = world.getBlockEntity(pos);
                    if (blockEntity != null)
                        return blockEntity.getPersistentData().getString(tag);
                    return "";
                }
            }.getValue(world, BlockPos.containing(x, y, z), "slot_0_type"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
            item_1 = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
                public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                    BlockEntity blockEntity = world.getBlockEntity(pos);
                    if (blockEntity != null)
                        return blockEntity.getPersistentData().getString(tag);
                    return "";
                }
            }.getValue(world, BlockPos.containing(x, y, z), "slot_1_type"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
            item_2 = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
                public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                    BlockEntity blockEntity = world.getBlockEntity(pos);
                    if (blockEntity != null)
                        return blockEntity.getPersistentData().getString(tag);
                    return "";
                }
            }.getValue(world, BlockPos.containing(x, y, z), "slot_2_type"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
            item_3 = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
                public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                    BlockEntity blockEntity = world.getBlockEntity(pos);
                    if (blockEntity != null)
                        return blockEntity.getPersistentData().getString(tag);
                    return "";
                }
            }.getValue(world, BlockPos.containing(x, y, z), "slot_3_type"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
            item_done_0 = (new Object() {
                public ItemStack getResult() {
                    if (world instanceof Level _lvl) {
                        net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
                        List<FryCookRecipe> recipes = rm.getAllRecipesFor(FryCookRecipe.Type.INSTANCE);
                        for (FryCookRecipe recipe : recipes) {
                            NonNullList<Ingredient> ingredients = recipe.getIngredients();
                            if (!ingredients.get(0).test(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
                                public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                    BlockEntity blockEntity = world.getBlockEntity(pos);
                                    if (blockEntity != null)
                                        return blockEntity.getPersistentData().getString(tag);
                                    return "";
                                }
                            }.getValue(world, BlockPos.containing(x, y, z), "slot_0_type"))).toLowerCase(java.util.Locale.ENGLISH))))))
                                continue;
                            return recipe.getResultItem(null);
                        }
                    }
                    return ItemStack.EMPTY;
                }
            }.getResult()).copy();
            item_done_1 = (new Object() {
                public ItemStack getResult() {
                    if (world instanceof Level _lvl) {
                        net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
                        List<FryCookRecipe> recipes = rm.getAllRecipesFor(FryCookRecipe.Type.INSTANCE);
                        for (FryCookRecipe recipe : recipes) {
                            NonNullList<Ingredient> ingredients = recipe.getIngredients();
                            if (!ingredients.get(0).test(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
                                public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                    BlockEntity blockEntity = world.getBlockEntity(pos);
                                    if (blockEntity != null)
                                        return blockEntity.getPersistentData().getString(tag);
                                    return "";
                                }
                            }.getValue(world, BlockPos.containing(x, y, z), "slot_1_type"))).toLowerCase(java.util.Locale.ENGLISH))))))
                                continue;
                            return recipe.getResultItem(null);
                        }
                    }
                    return ItemStack.EMPTY;
                }
            }.getResult()).copy();
            item_done_2 = (new Object() {
                public ItemStack getResult() {
                    if (world instanceof Level _lvl) {
                        net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
                        List<FryCookRecipe> recipes = rm.getAllRecipesFor(FryCookRecipe.Type.INSTANCE);
                        for (FryCookRecipe recipe : recipes) {
                            NonNullList<Ingredient> ingredients = recipe.getIngredients();
                            if (!ingredients.get(0).test(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
                                public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                    BlockEntity blockEntity = world.getBlockEntity(pos);
                                    if (blockEntity != null)
                                        return blockEntity.getPersistentData().getString(tag);
                                    return "";
                                }
                            }.getValue(world, BlockPos.containing(x, y, z), "slot_2_type"))).toLowerCase(java.util.Locale.ENGLISH))))))
                                continue;
                            return recipe.getResultItem(null);
                        }
                    }
                    return ItemStack.EMPTY;
                }
            }.getResult()).copy();
            item_done_3 = (new Object() {
                public ItemStack getResult() {
                    if (world instanceof Level _lvl) {
                        net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
                        List<FryCookRecipe> recipes = rm.getAllRecipesFor(FryCookRecipe.Type.INSTANCE);
                        for (FryCookRecipe recipe : recipes) {
                            NonNullList<Ingredient> ingredients = recipe.getIngredients();
                            if (!ingredients.get(0).test(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
                                public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                    BlockEntity blockEntity = world.getBlockEntity(pos);
                                    if (blockEntity != null)
                                        return blockEntity.getPersistentData().getString(tag);
                                    return "";
                                }
                            }.getValue(world, BlockPos.containing(x, y, z), "slot_3_type"))).toLowerCase(java.util.Locale.ENGLISH))))))
                                continue;
                            return recipe.getResultItem(null);
                        }
                    }
                    return ItemStack.EMPTY;
                }
            }.getResult()).copy();
            if (item_0.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_cookable_item")))) {
                item_fried_0 = (new Object() {
                    public ItemStack getResult() {
                        if (world instanceof Level _lvl) {
                            net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
                            List<FryRecipesRecipe> recipes = rm.getAllRecipesFor(FryRecipesRecipe.Type.INSTANCE);
                            for (FryRecipesRecipe recipe : recipes) {
                                NonNullList<Ingredient> ingredients = recipe.getIngredients();
                                if (!ingredients.get(0).test(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
                                    public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getString(tag);
                                        return "";
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_0_type"))).toLowerCase(java.util.Locale.ENGLISH))))))
                                    continue;
                                return recipe.getResultItem(null);
                            }
                        }
                        return ItemStack.EMPTY;
                    }
                }.getResult()).copy();
            } else if (item_0.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_fryable_item")))) {
                item_fried_0 = (new Object() {
                    public ItemStack getResult() {
                        if (world instanceof Level _lvl) {
                            net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
                            List<FryCookRecipe> recipes = rm.getAllRecipesFor(FryCookRecipe.Type.INSTANCE);
                            for (FryCookRecipe recipe : recipes) {
                                NonNullList<Ingredient> ingredients = recipe.getIngredients();
                                if (!ingredients.get(0).test(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
                                    public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getString(tag);
                                        return "";
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_0_type"))).toLowerCase(java.util.Locale.ENGLISH))))))
                                    continue;
                                return recipe.getResultItem(null);
                            }
                        }
                        return ItemStack.EMPTY;
                    }
                }.getResult()).copy();
            }
            if (item_1.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_cookable_item")))) {
                item_fried_1 = (new Object() {
                    public ItemStack getResult() {
                        if (world instanceof Level _lvl) {
                            net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
                            List<FryRecipesRecipe> recipes = rm.getAllRecipesFor(FryRecipesRecipe.Type.INSTANCE);
                            for (FryRecipesRecipe recipe : recipes) {
                                NonNullList<Ingredient> ingredients = recipe.getIngredients();
                                if (!ingredients.get(0).test(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
                                    public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getString(tag);
                                        return "";
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_1_type"))).toLowerCase(java.util.Locale.ENGLISH))))))
                                    continue;
                                return recipe.getResultItem(null);
                            }
                        }
                        return ItemStack.EMPTY;
                    }
                }.getResult()).copy();
            } else if (item_1.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_fryable_item")))) {
                item_fried_1 = (new Object() {
                    public ItemStack getResult() {
                        if (world instanceof Level _lvl) {
                            net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
                            List<FryCookRecipe> recipes = rm.getAllRecipesFor(FryCookRecipe.Type.INSTANCE);
                            for (FryCookRecipe recipe : recipes) {
                                NonNullList<Ingredient> ingredients = recipe.getIngredients();
                                if (!ingredients.get(0).test(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
                                    public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getString(tag);
                                        return "";
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_1_type"))).toLowerCase(java.util.Locale.ENGLISH))))))
                                    continue;
                                return recipe.getResultItem(null);
                            }
                        }
                        return ItemStack.EMPTY;
                    }
                }.getResult()).copy();
            }
            if (item_2.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_cookable_item")))) {
                item_fried_2 = (new Object() {
                    public ItemStack getResult() {
                        if (world instanceof Level _lvl) {
                            net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
                            List<FryRecipesRecipe> recipes = rm.getAllRecipesFor(FryRecipesRecipe.Type.INSTANCE);
                            for (FryRecipesRecipe recipe : recipes) {
                                NonNullList<Ingredient> ingredients = recipe.getIngredients();
                                if (!ingredients.get(0).test(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
                                    public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getString(tag);
                                        return "";
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_2_type"))).toLowerCase(java.util.Locale.ENGLISH))))))
                                    continue;
                                return recipe.getResultItem(null);
                            }
                        }
                        return ItemStack.EMPTY;
                    }
                }.getResult()).copy();
            } else if (item_2.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_fryable_item")))) {
                item_fried_2 = (new Object() {
                    public ItemStack getResult() {
                        if (world instanceof Level _lvl) {
                            net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
                            List<FryCookRecipe> recipes = rm.getAllRecipesFor(FryCookRecipe.Type.INSTANCE);
                            for (FryCookRecipe recipe : recipes) {
                                NonNullList<Ingredient> ingredients = recipe.getIngredients();
                                if (!ingredients.get(0).test(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
                                    public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getString(tag);
                                        return "";
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_2_type"))).toLowerCase(java.util.Locale.ENGLISH))))))
                                    continue;
                                return recipe.getResultItem(null);
                            }
                        }
                        return ItemStack.EMPTY;
                    }
                }.getResult()).copy();
            }
            if (item_3.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_cookable_item")))) {
                item_fried_3 = (new Object() {
                    public ItemStack getResult() {
                        if (world instanceof Level _lvl) {
                            net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
                            List<FryRecipesRecipe> recipes = rm.getAllRecipesFor(FryRecipesRecipe.Type.INSTANCE);
                            for (FryRecipesRecipe recipe : recipes) {
                                NonNullList<Ingredient> ingredients = recipe.getIngredients();
                                if (!ingredients.get(0).test(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
                                    public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getString(tag);
                                        return "";
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_3_type"))).toLowerCase(java.util.Locale.ENGLISH))))))
                                    continue;
                                return recipe.getResultItem(null);
                            }
                        }
                        return ItemStack.EMPTY;
                    }
                }.getResult()).copy();
            } else if (item_3.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_fryable_item")))) {
                item_fried_3 = (new Object() {
                    public ItemStack getResult() {
                        if (world instanceof Level _lvl) {
                            net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
                            List<FryCookRecipe> recipes = rm.getAllRecipesFor(FryCookRecipe.Type.INSTANCE);
                            for (FryCookRecipe recipe : recipes) {
                                NonNullList<Ingredient> ingredients = recipe.getIngredients();
                                if (!ingredients.get(0).test(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
                                    public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getString(tag);
                                        return "";
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_3_type"))).toLowerCase(java.util.Locale.ENGLISH))))))
                                    continue;
                                return recipe.getResultItem(null);
                            }
                        }
                        return ItemStack.EMPTY;
                    }
                }.getResult()).copy();
            }
            if (item_done_0.getItem() == Blocks.AIR.asItem()) {
                item_done_0 = item_0.copy();
            }
            if (item_done_1.getItem() == Blocks.AIR.asItem()) {
                item_done_1 = item_1.copy();
            }
            if (item_done_2.getItem() == Blocks.AIR.asItem()) {
                item_done_2 = item_2.copy();
            }
            if (item_done_3.getItem() == Blocks.AIR.asItem()) {
                item_done_3 = item_3.copy();
            }
            if (time > 11) {
                {
                    BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                    if (_ent != null) {
                        final int _slotid = 0;
                        final ItemStack _setstack = item_0.copy();
                        _setstack.setCount((int) (new Object() {
                            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                if (blockEntity != null)
                                    return blockEntity.getPersistentData().getDouble(tag);
                                return -1;
                            }
                        }.getValue(world, BlockPos.containing(x, y, z), "slot_0_num")));
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                            if (capability instanceof IItemHandlerModifiable)
                                ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                        });
                    }
                }
                {
                    BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                    if (_ent != null) {
                        final int _slotid = 1;
                        final ItemStack _setstack = item_1.copy();
                        _setstack.setCount((int) (new Object() {
                            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                if (blockEntity != null)
                                    return blockEntity.getPersistentData().getDouble(tag);
                                return -1;
                            }
                        }.getValue(world, BlockPos.containing(x, y, z), "slot_1_num")));
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                            if (capability instanceof IItemHandlerModifiable)
                                ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                        });
                    }
                }
                {
                    BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                    if (_ent != null) {
                        final int _slotid = 2;
                        final ItemStack _setstack = item_2.copy();
                        _setstack.setCount((int) (new Object() {
                            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                if (blockEntity != null)
                                    return blockEntity.getPersistentData().getDouble(tag);
                                return -1;
                            }
                        }.getValue(world, BlockPos.containing(x, y, z), "slot_2_num")));
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                            if (capability instanceof IItemHandlerModifiable)
                                ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                        });
                    }
                }
                {
                    BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                    if (_ent != null) {
                        final int _slotid = 3;
                        final ItemStack _setstack = item_3.copy();
                        _setstack.setCount((int) (new Object() {
                            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                if (blockEntity != null)
                                    return blockEntity.getPersistentData().getDouble(tag);
                                return -1;
                            }
                        }.getValue(world, BlockPos.containing(x, y, z), "slot_3_num")));
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                            if (capability instanceof IItemHandlerModifiable)
                                ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                        });
                    }
                }
                if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("working_time", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("working", false);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.button.click")), SoundSource.NEUTRAL, (float) 1.25, (float) 1.5);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.button.click")), SoundSource.NEUTRAL, (float) 1.25, (float) 1.5, false);
					}
				}
			} else if (time <= 11 && time > 7) {
                if (item_0.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_cookable_item"))) || item_0.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_fryable_item")))) {
                    if (item_0.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_cookable_item")))) {
                        {
                            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                            if (_ent != null) {
                                final int _slotid = 0;
                                final ItemStack _setstack = item_done_0.copy();
                                _setstack.setCount((int) (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getDouble(tag);
                                        return -1;
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_0_num")));
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable)
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                                });
                            }
                        }
                    } else {
                        {
                            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                            if (_ent != null) {
                                final int _slotid = 0;
                                final ItemStack _setstack = item_fried_0.copy();
                                _setstack.setCount((int) (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getDouble(tag);
                                        return -1;
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_0_num")));
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable)
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                                });
                            }
                        }
                    }
                } else {
                    {
                        BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                        if (_ent != null) {
                            final int _slotid = 0;
                            final ItemStack _setstack = new ItemStack(Items.CHARCOAL).copy();
                            _setstack.setCount((int) (new Object() {
                                public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                    BlockEntity blockEntity = world.getBlockEntity(pos);
                                    if (blockEntity != null)
                                        return blockEntity.getPersistentData().getDouble(tag);
                                    return -1;
                                }
                            }.getValue(world, BlockPos.containing(x, y, z), "slot_0_num")));
                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                if (capability instanceof IItemHandlerModifiable)
                                    ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                            });
                        }
                    }
                }
                if (item_1.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_cookable_item"))) || item_1.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_fryable_item")))) {
                    if (item_1.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_cookable_item")))) {
                        {
                            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                            if (_ent != null) {
                                final int _slotid = 1;
                                final ItemStack _setstack = item_done_1.copy();
                                _setstack.setCount((int) (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getDouble(tag);
                                        return -1;
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_1_num")));
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable)
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                                });
                            }
                        }
                    } else {
                        {
                            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                            if (_ent != null) {
                                final int _slotid = 1;
                                final ItemStack _setstack = item_fried_1.copy();
                                _setstack.setCount((int) (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getDouble(tag);
                                        return -1;
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_1_num")));
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable)
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                                });
                            }
                        }
                    }
                } else {
                    {
                        BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                        if (_ent != null) {
                            final int _slotid = 1;
                            final ItemStack _setstack = new ItemStack(Items.CHARCOAL).copy();
                            _setstack.setCount((int) (new Object() {
                                public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                    BlockEntity blockEntity = world.getBlockEntity(pos);
                                    if (blockEntity != null)
                                        return blockEntity.getPersistentData().getDouble(tag);
                                    return -1;
                                }
                            }.getValue(world, BlockPos.containing(x, y, z), "slot_1_num")));
                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                if (capability instanceof IItemHandlerModifiable)
                                    ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                            });
                        }
                    }
                }
                if (item_2.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_cookable_item"))) || item_2.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_fryable_item")))) {
                    if (item_2.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_cookable_item")))) {
                        {
                            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                            if (_ent != null) {
                                final int _slotid = 2;
                                final ItemStack _setstack = item_done_2.copy();
                                _setstack.setCount((int) (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getDouble(tag);
                                        return -1;
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_2_num")));
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable)
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                                });
                            }
                        }
                    } else {
                        {
                            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                            if (_ent != null) {
                                final int _slotid = 2;
                                final ItemStack _setstack = item_fried_2.copy();
                                _setstack.setCount((int) (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getDouble(tag);
                                        return -1;
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_2_num")));
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable)
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                                });
                            }
                        }
                    }
                } else {
                    {
                        BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                        if (_ent != null) {
                            final int _slotid = 2;
                            final ItemStack _setstack = new ItemStack(Items.CHARCOAL).copy();
                            _setstack.setCount((int) (new Object() {
                                public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                    BlockEntity blockEntity = world.getBlockEntity(pos);
                                    if (blockEntity != null)
                                        return blockEntity.getPersistentData().getDouble(tag);
                                    return -1;
                                }
                            }.getValue(world, BlockPos.containing(x, y, z), "slot_2_num")));
                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                if (capability instanceof IItemHandlerModifiable)
                                    ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                            });
                        }
                    }
                }
                if (item_3.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_cookable_item"))) || item_3.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_fryable_item")))) {
                    if (item_3.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_cookable_item")))) {
                        {
                            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                            if (_ent != null) {
                                final int _slotid = 3;
                                final ItemStack _setstack = item_done_3.copy();
                                _setstack.setCount((int) (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getDouble(tag);
                                        return -1;
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_3_num")));
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable)
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                                });
                            }
                        }
                    } else {
                        {
                            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                            if (_ent != null) {
                                final int _slotid = 3;
                                final ItemStack _setstack = item_fried_3.copy();
                                _setstack.setCount((int) (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getDouble(tag);
                                        return -1;
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_3_num")));
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable)
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                                });
                            }
                        }
                    }
                } else {
                    {
                        BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                        if (_ent != null) {
                            final int _slotid = 3;
                            final ItemStack _setstack = new ItemStack(Items.CHARCOAL).copy();
                            _setstack.setCount((int) (new Object() {
                                public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                    BlockEntity blockEntity = world.getBlockEntity(pos);
                                    if (blockEntity != null)
                                        return blockEntity.getPersistentData().getDouble(tag);
                                    return -1;
                                }
                            }.getValue(world, BlockPos.containing(x, y, z), "slot_3_num")));
                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                if (capability instanceof IItemHandlerModifiable)
                                    ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                            });
                        }
                    }
                }
                if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("working_time", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("working", false);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.button.click")), SoundSource.NEUTRAL, (float) 1.25, (float) 1.5);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.button.click")), SoundSource.NEUTRAL, (float) 1.25, (float) 1.5, false);
					}
				}
			} else if (time <= 7 && time > 0) {
                if (item_0.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_cookable_item")))) {
                    if (item_done_0.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_fryable_item")))) {
                        {
                            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                            if (_ent != null) {
                                final int _slotid = 0;
                                final ItemStack _setstack = item_fried_0.copy();
                                _setstack.setCount((int) (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getDouble(tag);
                                        return -1;
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_0_num")));
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable)
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                                });
                            }
                        }
                    } else {
                        {
                            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                            if (_ent != null) {
                                final int _slotid = 0;
                                final ItemStack _setstack = new ItemStack(Items.CHARCOAL).copy();
                                _setstack.setCount((int) (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getDouble(tag);
                                        return -1;
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_0_num")));
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable)
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                                });
                            }
                        }
                    }
                } else {
                    {
                        BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                        if (_ent != null) {
                            final int _slotid = 0;
                            final ItemStack _setstack = new ItemStack(Items.CHARCOAL).copy();
                            _setstack.setCount((int) (new Object() {
                                public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                    BlockEntity blockEntity = world.getBlockEntity(pos);
                                    if (blockEntity != null)
                                        return blockEntity.getPersistentData().getDouble(tag);
                                    return -1;
                                }
                            }.getValue(world, BlockPos.containing(x, y, z), "slot_0_num")));
                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                if (capability instanceof IItemHandlerModifiable)
                                    ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                            });
                        }
                    }
                }
                if (item_1.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_cookable_item")))) {
                    if (item_done_1.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_fryable_item")))) {
                        {
                            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                            if (_ent != null) {
                                final int _slotid = 1;
                                final ItemStack _setstack = item_fried_1.copy();
                                _setstack.setCount((int) (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getDouble(tag);
                                        return -1;
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_1_num")));
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable)
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                                });
                            }
                        }
                    } else {
                        {
                            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                            if (_ent != null) {
                                final int _slotid = 1;
                                final ItemStack _setstack = new ItemStack(Items.CHARCOAL).copy();
                                _setstack.setCount((int) (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getDouble(tag);
                                        return -1;
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_1_num")));
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable)
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                                });
                            }
                        }
                    }
                } else {
                    {
                        BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                        if (_ent != null) {
                            final int _slotid = 1;
                            final ItemStack _setstack = new ItemStack(Items.CHARCOAL).copy();
                            _setstack.setCount((int) (new Object() {
                                public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                    BlockEntity blockEntity = world.getBlockEntity(pos);
                                    if (blockEntity != null)
                                        return blockEntity.getPersistentData().getDouble(tag);
                                    return -1;
                                }
                            }.getValue(world, BlockPos.containing(x, y, z), "slot_1_num")));
                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                if (capability instanceof IItemHandlerModifiable)
                                    ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                            });
                        }
                    }
                }
                if (item_2.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_cookable_item")))) {
                    if (item_done_2.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_fryable_item")))) {
                        {
                            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                            if (_ent != null) {
                                final int _slotid = 2;
                                final ItemStack _setstack = item_fried_2.copy();
                                _setstack.setCount((int) (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getDouble(tag);
                                        return -1;
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_2_num")));
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable)
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                                });
                            }
                        }
                    } else {
                        {
                            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                            if (_ent != null) {
                                final int _slotid = 2;
                                final ItemStack _setstack = new ItemStack(Items.CHARCOAL).copy();
                                _setstack.setCount((int) (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getDouble(tag);
                                        return -1;
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_2_num")));
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable)
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                                });
                            }
                        }
                    }
                } else {
                    {
                        BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                        if (_ent != null) {
                            final int _slotid = 2;
                            final ItemStack _setstack = new ItemStack(Items.CHARCOAL).copy();
                            _setstack.setCount((int) (new Object() {
                                public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                    BlockEntity blockEntity = world.getBlockEntity(pos);
                                    if (blockEntity != null)
                                        return blockEntity.getPersistentData().getDouble(tag);
                                    return -1;
                                }
                            }.getValue(world, BlockPos.containing(x, y, z), "slot_2_num")));
                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                if (capability instanceof IItemHandlerModifiable)
                                    ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                            });
                        }
                    }
                }
                if (item_3.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_cookable_item")))) {
                    if (item_done_3.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_fryable_item")))) {
                        {
                            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                            if (_ent != null) {
                                final int _slotid = 3;
                                final ItemStack _setstack = item_fried_3.copy();
                                _setstack.setCount((int) (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getDouble(tag);
                                        return -1;
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_3_num")));
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable)
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                                });
                            }
                        }
                    } else {
                        {
                            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                            if (_ent != null) {
                                final int _slotid = 3;
                                final ItemStack _setstack = new ItemStack(Items.CHARCOAL).copy();
                                _setstack.setCount((int) (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                        BlockEntity blockEntity = world.getBlockEntity(pos);
                                        if (blockEntity != null)
                                            return blockEntity.getPersistentData().getDouble(tag);
                                        return -1;
                                    }
                                }.getValue(world, BlockPos.containing(x, y, z), "slot_3_num")));
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                    if (capability instanceof IItemHandlerModifiable)
                                        ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                                });
                            }
                        }
                    }
                } else {
                    {
                        BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                        if (_ent != null) {
                            final int _slotid = 3;
                            final ItemStack _setstack = new ItemStack(Items.CHARCOAL).copy();
                            _setstack.setCount((int) (new Object() {
                                public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                    BlockEntity blockEntity = world.getBlockEntity(pos);
                                    if (blockEntity != null)
                                        return blockEntity.getPersistentData().getDouble(tag);
                                    return -1;
                                }
                            }.getValue(world, BlockPos.containing(x, y, z), "slot_3_num")));
                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                                if (capability instanceof IItemHandlerModifiable)
                                    ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                            });
                        }
                    }
                }
                if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("working_time", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("working", false);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.button.click")), SoundSource.NEUTRAL, (float) 1.25, (float) 1.5);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.button.click")), SoundSource.NEUTRAL, (float) 1.25, (float) 1.5, false);
					}
				}
			} else if (time <= 0) {
                {
                    BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                    if (_ent != null) {
                        final int _slotid = 0;
                        final ItemStack _setstack = new ItemStack(Items.CHARCOAL).copy();
                        _setstack.setCount((int) (new Object() {
                            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                if (blockEntity != null)
                                    return blockEntity.getPersistentData().getDouble(tag);
                                return -1;
                            }
                        }.getValue(world, BlockPos.containing(x, y, z), "slot_0_num")));
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                            if (capability instanceof IItemHandlerModifiable)
                                ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                        });
                    }
                }
                {
                    BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                    if (_ent != null) {
                        final int _slotid = 1;
                        final ItemStack _setstack = new ItemStack(Items.CHARCOAL).copy();
                        _setstack.setCount((int) (new Object() {
                            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                if (blockEntity != null)
                                    return blockEntity.getPersistentData().getDouble(tag);
                                return -1;
                            }
                        }.getValue(world, BlockPos.containing(x, y, z), "slot_1_num")));
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                            if (capability instanceof IItemHandlerModifiable)
                                ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                        });
                    }
                }
                {
                    BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                    if (_ent != null) {
                        final int _slotid = 2;
                        final ItemStack _setstack = new ItemStack(Items.CHARCOAL).copy();
                        _setstack.setCount((int) (new Object() {
                            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                if (blockEntity != null)
                                    return blockEntity.getPersistentData().getDouble(tag);
                                return -1;
                            }
                        }.getValue(world, BlockPos.containing(x, y, z), "slot_2_num")));
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                            if (capability instanceof IItemHandlerModifiable)
                                ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                        });
                    }
                }
                {
                    BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                    if (_ent != null) {
                        final int _slotid = 3;
                        final ItemStack _setstack = new ItemStack(Items.CHARCOAL).copy();
                        _setstack.setCount((int) (new Object() {
                            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                if (blockEntity != null)
                                    return blockEntity.getPersistentData().getDouble(tag);
                                return -1;
                            }
                        }.getValue(world, BlockPos.containing(x, y, z), "slot_3_num")));
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                            if (capability instanceof IItemHandlerModifiable)
                                ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
                        });
                    }
                }
                if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("working_time", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("working", false);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.button.click")), SoundSource.NEUTRAL, (float) 1.25, (float) 1.5);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.button.click")), SoundSource.NEUTRAL, (float) 1.25, (float) 1.5, false);
					}
				}
			}
		}
	}
}
