
package com.djinfinite.manors_bounty.world.inventory;

import com.djinfinite.manors_bounty.network.FryerOilInputMessage;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.registries.ModMenus;
import com.djinfinite.manors_bounty.registries.ModItems;
import com.djinfinite.manors_bounty.ManorsBountyMod;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

public class FryerGuiMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
	public final static HashMap<String, Object> guistate = new HashMap<>();
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private ContainerLevelAccess access = ContainerLevelAccess.NULL;
	private IItemHandler internal;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	private boolean bound = false;
	private Supplier<Boolean> boundItemMatcher = null;
	private Entity boundEntity = null;
	private BlockEntity boundBlockEntity = null;

	public FryerGuiMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(ModMenus.FRYER_GUI.get(), id);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.internal = new ItemStackHandler(5);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
			access = ContainerLevelAccess.create(world, pos);
		}
		if (pos != null) {
			if (extraData.readableBytes() == 1) { // bound to item
				byte hand = extraData.readByte();
				ItemStack itemstack = hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem();
				this.boundItemMatcher = () -> itemstack == (hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem());
				itemstack.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					this.internal = capability;
					this.bound = true;
				});
			} else if (extraData.readableBytes() > 1) { // bound to entity
				extraData.readByte(); // drop padding
				boundEntity = world.getEntity(extraData.readVarInt());
				if (boundEntity != null)
					boundEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
			} else { // might be bound to block
				boundBlockEntity = this.world.getBlockEntity(pos);
				if (boundBlockEntity != null)
					boundBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
			}
		}
		this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 42, -11) {
			private final int slot = 0;
			private final int x = FryerGuiMenu.this.x;
			private final int y = FryerGuiMenu.this.y;

			@Override
			public boolean mayPlace(@NotNull ItemStack stack) {
				return stack.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_useable_item")));
			}
		}));
		this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 76, -11) {
			private final int slot = 1;
			private final int x = FryerGuiMenu.this.x;
			private final int y = FryerGuiMenu.this.y;

			@Override
			public boolean mayPlace(@NotNull ItemStack stack) {
				return stack.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_useable_item")));
			}
		}));
		this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 42, 23) {

			@Override
			public boolean mayPlace(@NotNull ItemStack stack) {
				return stack.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_useable_item")));
			}
		}));
		this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 76, 23) {
			private final int slot = 3;
			private final int x = FryerGuiMenu.this.x;
			private final int y = FryerGuiMenu.this.y;

			@Override
			public boolean mayPlace(@NotNull ItemStack stack) {
				return stack.is(ItemTags.create(new ResourceLocation("manors_bounty:fryer_useable_item")));
			}
		}));
		this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 141, 2) {
            @Override
            public int getMaxStackSize() {
                return 1;
            }

            @Override
			public void setChanged() {
				super.setChanged();
				oilInput();
			}

			@Override
			public boolean mayPlace(@NotNull ItemStack stack) {
				return ModItems.OLIVE_OIL_BUCKET.get() == stack.getItem();
			}
		}));
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 8 + sj * 18, 28 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 8 + si * 18, 28 + 142));
	}

	@Override
	public boolean stillValid(@NotNull Player player) {
		if (this.bound) {
			if (this.boundItemMatcher != null)
				return this.boundItemMatcher.get();
			else if (this.boundBlockEntity != null)
				return AbstractContainerMenu.stillValid(this.access, player, this.boundBlockEntity.getBlockState().getBlock());
			else if (this.boundEntity != null)
				return this.boundEntity.isAlive();
		}
		return true;
	}

	@Override
	public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < 5) {
				if (!this.moveItemStackTo(itemstack1, 5, this.slots.size(), true))
					return ItemStack.EMPTY;
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 5, false)) {
				if (index < 5 + 27) {
					if (!this.moveItemStackTo(itemstack1, 5 + 27, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.moveItemStackTo(itemstack1, 5, 5 + 27, false))
						return ItemStack.EMPTY;
				}
				return ItemStack.EMPTY;
			}
			if (itemstack1.getCount() == 0)
				slot.set(ItemStack.EMPTY);
			else
				slot.setChanged();
			if (itemstack1.getCount() == itemstack.getCount())
				return ItemStack.EMPTY;
			slot.onTake(playerIn, itemstack1);
		}
		return itemstack;
	}

	@Override
	protected boolean moveItemStackTo(@NotNull ItemStack itemStack, int pStartIndex, int pEndIndex, boolean pReverseDirection) {
		boolean flag = false;
		int i = pStartIndex;
		if (pReverseDirection) {
			i = pEndIndex - 1;
		}
		if (itemStack.isStackable()) {
			while (!itemStack.isEmpty()) {
				if (pReverseDirection) {
					if (i < pStartIndex) {
						break;
					}
				} else if (i >= pEndIndex) {
					break;
				}
				Slot slot = this.slots.get(i);
				ItemStack itemstack = slot.getItem();
				if (slot.mayPlace(itemstack) && !itemstack.isEmpty() && ItemStack.isSameItemSameTags(itemStack, itemstack)) {
					int j = itemstack.getCount() + itemStack.getCount();
					int maxSize = Math.min(slot.getMaxStackSize(), itemStack.getMaxStackSize());
					if (j <= maxSize) {
						itemStack.setCount(0);
						itemstack.setCount(j);
						slot.set(itemstack);
						flag = true;
					} else if (itemstack.getCount() < maxSize) {
						itemStack.shrink(maxSize - itemstack.getCount());
						itemstack.setCount(maxSize);
						slot.set(itemstack);
						flag = true;
					}
				}
				if (pReverseDirection) {
					--i;
				} else {
					++i;
				}
			}
		}
		if (!itemStack.isEmpty()) {
			if (pReverseDirection) {
				i = pEndIndex - 1;
			} else {
				i = pStartIndex;
			}
			while (true) {
				if (pReverseDirection) {
					if (i < pStartIndex) {
						break;
					}
				} else if (i >= pEndIndex) {
					break;
				}
				Slot slot1 = this.slots.get(i);
				ItemStack itemstack1 = slot1.getItem();
				if (itemstack1.isEmpty() && slot1.mayPlace(itemStack)) {
					if (itemStack.getCount() > slot1.getMaxStackSize()) {
						slot1.setByPlayer(itemStack.split(slot1.getMaxStackSize()));
					} else {
						slot1.setByPlayer(itemStack.split(itemStack.getCount()));
					}
					slot1.setChanged();
					flag = true;
					break;
				}
				if (pReverseDirection) {
					--i;
				} else {
					++i;
				}
			}
		}
		return flag;
	}

	@Override
	public void removed(@NotNull Player playerIn) {
		super.removed(playerIn);
		if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
			if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
				for (int j = 0; j < internal.getSlots(); ++j) {
					playerIn.drop(internal.extractItem(j, internal.getStackInSlot(j).getCount(), false), false);
				}
			} else {
				for (int i = 0; i < internal.getSlots(); ++i) {
					playerIn.getInventory().placeItemBackInInventory(internal.extractItem(i, internal.getStackInSlot(i).getCount(), false));
				}
			}
		}
	}

	private void oilInput() {
		if (this.world != null && this.world.isClientSide()) {
			ManorsBountyMod.PACKET_HANDLER.sendToServer(new FryerOilInputMessage(x, y, z));
			FryerOilInputMessage.handleFryerOilInput(entity, x, y, z);
		}
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}
}
