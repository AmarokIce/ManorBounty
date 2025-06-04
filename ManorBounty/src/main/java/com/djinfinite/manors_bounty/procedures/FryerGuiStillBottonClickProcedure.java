package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModTags;
import com.djinfinite.manors_bounty.utils.ModUtils;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

public class FryerGuiStillBottonClickProcedure {
    static double one_chance = 0.1;
    static double max_chance = 0.8;
    private static boolean shouldConsumeOli(int itemCount){
        return ModUtils.chanceToTrigger(0.125 * itemCount / 2);
    }
    public static void run(LevelAccessor world, double x, double y, double z, Entity entity){
        if (entity == null) {
            return;
        }
        int itemCount = 0;
    }

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null) {
            return;
        }
		double item_num;
		if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
				.is(ModTags.FRYER_USABLE_ITEM)
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
						.is(ModTags.FRYER_USABLE_ITEM)
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
						.is(ModTags.FRYER_USABLE_ITEM)
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
						.is(ModTags.FRYER_USABLE_ITEM))
				&& new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "OilFluid") >= 250) {
            item_num = new Object() {
                public int getAmount(int sltid) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
                        return stack.getCount();
                    }
                    return 0;
                }
            }.getAmount(0) + new Object() {
                public int getAmount(int sltid) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
                        return stack.getCount();
                    }
                    return 0;
                }
            }.getAmount(1) + new Object() {
                public int getAmount(int sltid) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
                        return stack.getCount();
                    }
                    return 0;
                }
            }.getAmount(2) + new Object() {
                public int getAmount(int sltid) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
                        return stack.getCount();
                    }
                    return 0;
                }
            }.getAmount(3);
            if (Math.random() < ((one_chance / max_chance) * item_num) / 2) {
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("OilFluid", ((new Object() {
                            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                if (blockEntity != null)
                                    return blockEntity.getPersistentData().getDouble(tag);
                                return -1;
                            }
                        }.getValue(world, BlockPos.containing(x, y, z), "OilFluid")) - 250));
                    if (world instanceof Level _level)
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
            }
            if (!world.isClientSide()) {
                BlockPos _bp = BlockPos.containing(x, y, z);
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null)
                    _blockEntity.getPersistentData().putDouble("slot_0_num", ((new Object() {
                        public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                            AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                            BlockEntity _ent = world.getBlockEntity(pos);
                            if (_ent != null)
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                            return _retval.get();
                        }
                    }.getItemStack(world, BlockPos.containing(x, y, z), 0)).getCount()));
                if (world instanceof Level _level)
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
            if (!world.isClientSide()) {
                BlockPos _bp = BlockPos.containing(x, y, z);
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null)
                    _blockEntity.getPersistentData().putDouble("slot_1_num", ((new Object() {
                        public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                            AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                            BlockEntity _ent = world.getBlockEntity(pos);
                            if (_ent != null)
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                            return _retval.get();
                        }
                    }.getItemStack(world, BlockPos.containing(x, y, z), 1)).getCount()));
                if (world instanceof Level _level)
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
            if (!world.isClientSide()) {
                BlockPos _bp = BlockPos.containing(x, y, z);
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null)
                    _blockEntity.getPersistentData().putDouble("slot_2_num", ((new Object() {
                        public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                            AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                            BlockEntity _ent = world.getBlockEntity(pos);
                            if (_ent != null)
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                            return _retval.get();
                        }
                    }.getItemStack(world, BlockPos.containing(x, y, z), 2)).getCount()));
                if (world instanceof Level _level)
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
            if (!world.isClientSide()) {
                BlockPos _bp = BlockPos.containing(x, y, z);
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null)
                    _blockEntity.getPersistentData().putDouble("slot_3_num", ((new Object() {
                        public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                            AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                            BlockEntity _ent = world.getBlockEntity(pos);
                            if (_ent != null)
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                            return _retval.get();
                        }
                    }.getItemStack(world, BlockPos.containing(x, y, z), 3)).getCount()));
                if (world instanceof Level _level)
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
            if (!world.isClientSide()) {
                BlockPos _bp = BlockPos.containing(x, y, z);
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null)
                    _blockEntity.getPersistentData().putString("slot_0_type", (ForgeRegistries.ITEMS.getKey((new Object() {
                        public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                            AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                            BlockEntity _ent = world.getBlockEntity(pos);
                            if (_ent != null)
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                            return _retval.get();
                        }
                    }.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem()).toString()));
                if (world instanceof Level _level)
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
            if (!world.isClientSide()) {
                BlockPos _bp = BlockPos.containing(x, y, z);
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null)
                    _blockEntity.getPersistentData().putString("slot_1_type", (ForgeRegistries.ITEMS.getKey((new Object() {
                        public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                            AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                            BlockEntity _ent = world.getBlockEntity(pos);
                            if (_ent != null)
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                            return _retval.get();
                        }
                    }.getItemStack(world, BlockPos.containing(x, y, z), 1)).getItem()).toString()));
                if (world instanceof Level _level)
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
            if (!world.isClientSide()) {
                BlockPos _bp = BlockPos.containing(x, y, z);
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null)
                    _blockEntity.getPersistentData().putString("slot_2_type", (ForgeRegistries.ITEMS.getKey((new Object() {
                        public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                            AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                            BlockEntity _ent = world.getBlockEntity(pos);
                            if (_ent != null)
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                            return _retval.get();
                        }
                    }.getItemStack(world, BlockPos.containing(x, y, z), 2)).getItem()).toString()));
                if (world instanceof Level _level)
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
            if (!world.isClientSide()) {
                BlockPos _bp = BlockPos.containing(x, y, z);
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null)
                    _blockEntity.getPersistentData().putString("slot_3_type", (ForgeRegistries.ITEMS.getKey((new Object() {
                        public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                            AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                            BlockEntity _ent = world.getBlockEntity(pos);
                            if (_ent != null)
                                _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                            return _retval.get();
                        }
                    }.getItemStack(world, BlockPos.containing(x, y, z), 3)).getItem()).toString()));
                if (world instanceof Level _level)
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                if (_ent != null) {
                    final int _slotid = 0;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable)
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, ItemStack.EMPTY);
                    });
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                if (_ent != null) {
                    final int _slotid = 1;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable)
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, ItemStack.EMPTY);
                    });
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                if (_ent != null) {
                    final int _slotid = 2;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable)
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, ItemStack.EMPTY);
                    });
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                if (_ent != null) {
                    final int _slotid = 3;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable)
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, ItemStack.EMPTY);
                    });
                }
            }
            if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("working", true);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("working_time", 15);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("manors_bounty:frying")), SoundSource.BLOCKS, (float) 1.5, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("manors_bounty:frying")), SoundSource.BLOCKS, (float) 1.5, 1, false);
				}
			}
		}
	}
}
