package com.djinfinite.manors_bounty.block.entity;

import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoBlockEntity;

import net.minecraftforge.items.wrapper.SidedInvWrapper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.registries.ModBlockEntities;
import com.djinfinite.manors_bounty.block.PrawnAndCornSoupBlockBlock;

import javax.annotation.Nullable;

import java.util.stream.IntStream;

public class PrawnAndCornSoupBlockTileEntity extends RandomizableContainerBlockEntity implements GeoBlockEntity, WorldlyContainer {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private NonNullList<ItemStack> stacks = NonNullList.withSize(9, ItemStack.EMPTY);
	private final LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.values());

	public PrawnAndCornSoupBlockTileEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntities.PRAWN_AND_CORN_SOUP_BLOCK.get(), pos, state);
	}

	private PlayState predicate(AnimationState event) {
		String animationprocedure = ("" + this.getBlockState().getValue(PrawnAndCornSoupBlockBlock.ANIMATION));
		if (animationprocedure.equals("0")) {
			return event.setAndContinue(RawAnimation.begin().thenLoop(animationprocedure));
		}
		return PlayState.STOP;
	}

	String prevAnim = "0";

	private PlayState procedurePredicate(AnimationState event) {
		String animationprocedure = ("" + this.getBlockState().getValue(PrawnAndCornSoupBlockBlock.ANIMATION));
		if (!animationprocedure.equals("0") && event.getController().getAnimationState() == AnimationController.State.STOPPED || (!animationprocedure.equals(prevAnim) && !animationprocedure.equals("0"))) {
			if (!animationprocedure.equals(prevAnim))
				event.getController().forceAnimationReset();
			event.getController().setAnimation(RawAnimation.begin().thenPlay(animationprocedure));
			if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
				if (this.getBlockState().getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp)
					level.setBlock(this.getBlockPos(), this.getBlockState().setValue(_integerProp, 0), 3);
				event.getController().forceAnimationReset();
			}
		} else if (animationprocedure.equals("0")) {
			prevAnim = "0";
			return PlayState.STOP;
		}
		prevAnim = animationprocedure;
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController<>(this, "controller", 0, this::predicate));
		data.add(new AnimationController<>(this, "procedurecontroller", 0, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}

	@Override
	public void load(@NotNull CompoundTag compound) {
		super.load(compound);
		if (!this.tryLoadLootTable(compound))
			this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compound, this.stacks);
	}

	@Override
	public void saveAdditional(@NotNull CompoundTag compound) {
		super.saveAdditional(compound);
		if (!this.trySaveLootTable(compound)) {
			ContainerHelper.saveAllItems(compound, this.stacks);
		}
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public @NotNull CompoundTag getUpdateTag() {
		return this.saveWithFullMetadata();
	}

	@Override
	public int getContainerSize() {
		return stacks.size();
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.stacks)
			if (!itemstack.isEmpty())
				return false;
		return true;
	}

	@Override
	public @NotNull Component getDefaultName() {
		return Component.literal("prawn_and_corn_soup_block");
	}

    @Override
	public @NotNull AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory) {
		return ChestMenu.threeRows(id, inventory);
	}

	@Override
	public @NotNull Component getDisplayName() {
		return Component.literal("Prawn and Corn Soup");
	}

	@Override
	protected @NotNull NonNullList<ItemStack> getItems() {
		return this.stacks;
	}

	@Override
	protected void setItems(@NotNull NonNullList<ItemStack> stacks) {
		this.stacks = stacks;
	}

    @Override
	public int @NotNull [] getSlotsForFace(@NotNull Direction side) {
		return IntStream.range(0, this.getContainerSize()).toArray();
	}

	@Override
	public boolean canPlaceItemThroughFace(int index, @NotNull ItemStack stack, @Nullable Direction direction) {
		return this.canPlaceItem(index, stack);
	}

	@Override
	public boolean canTakeItemThroughFace(int index, @NotNull ItemStack stack, @NotNull Direction direction) {
		return true;
	}

	@Override
	public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction facing) {
		if (!this.remove && facing != null && capability == ForgeCapabilities.ITEM_HANDLER)
			return handlers[facing.ordinal()].cast();
		return super.getCapability(capability, facing);
	}

	@Override
	public void setRemoved() {
		super.setRemoved();
		for (LazyOptional<? extends IItemHandler> handler : handlers)
			handler.invalidate();
	}
}
