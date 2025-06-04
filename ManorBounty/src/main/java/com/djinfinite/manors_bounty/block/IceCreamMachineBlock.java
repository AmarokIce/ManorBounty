
package com.djinfinite.manors_bounty.block;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.Containers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.world.inventory.IceCreamMachineGuiMenu;
import com.djinfinite.manors_bounty.block.entity.IceCreamMachineBlockEntity;

import io.netty.buffer.Unpooled;
import org.jetbrains.annotations.NotNull;

public class IceCreamMachineBlock extends Block implements EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 11);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public IceCreamMachineBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.COLOR_PINK).sound(SoundType.METAL).strength(2f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 5;
				if (s.getValue(BLOCKSTATE) == 2)
					return 0;
				if (s.getValue(BLOCKSTATE) == 3)
					return 5;
				if (s.getValue(BLOCKSTATE) == 4)
					return 5;
				if (s.getValue(BLOCKSTATE) == 5)
					return 5;
				if (s.getValue(BLOCKSTATE) == 6)
					return 5;
				if (s.getValue(BLOCKSTATE) == 7)
					return 5;
				if (s.getValue(BLOCKSTATE) == 8)
					return 5;
				if (s.getValue(BLOCKSTATE) == 9)
					return 5;
				if (s.getValue(BLOCKSTATE) == 10)
					return 5;
                s.getValue(BLOCKSTATE);
                return 5;
			}
		}.getLightLevel())).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(@NotNull BlockState state, @NotNull BlockGetter reader, @NotNull BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
		return 0;
	}

	@Override
	public @NotNull VoxelShape getVisualShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
		if (state.getValue(BLOCKSTATE) == 1) {
			return switch (state.getValue(FACING)) {
                case NORTH -> Shapes.or(box(1, 0, 4, 15, 15, 16), box(1, 12, 0, 15, 15, 4), box(13, 0, 2, 15, 12, 4), box(3, 0, 2, 13, 2, 4), box(1, 0, 2, 3, 12, 4), box(6, 9, 2, 10, 11, 4), box(5, 4, 2, 11, 5, 4));
				case EAST -> Shapes.or(box(0, 0, 1, 12, 15, 15), box(12, 12, 1, 16, 15, 15), box(12, 0, 13, 14, 12, 15), box(12, 0, 3, 14, 2, 13), box(12, 0, 1, 14, 12, 3), box(12, 9, 6, 14, 11, 10), box(12, 4, 5, 14, 5, 11));
				case WEST -> Shapes.or(box(4, 0, 1, 16, 15, 15), box(0, 12, 1, 4, 15, 15), box(2, 0, 1, 4, 12, 3), box(2, 0, 3, 4, 2, 13), box(2, 0, 13, 4, 12, 15), box(2, 9, 6, 4, 11, 10), box(2, 4, 5, 4, 5, 11));
                default -> Shapes.or(box(1, 0, 0, 15, 15, 12), box(1, 12, 12, 15, 15, 16), box(1, 0, 12, 3, 12, 14), box(3, 0, 12, 13, 2, 14), box(13, 0, 12, 15, 12, 14), box(6, 9, 12, 10, 11, 14), box(5, 4, 12, 11, 5, 14));
            };
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return switch (state.getValue(FACING)) {
                case NORTH -> Shapes.or(box(1, 0, 4, 15, 15, 16), box(1, 12, 0, 15, 15, 4), box(13, 0, 2, 15, 12, 4), box(3, 0, 2, 13, 2, 4), box(1, 0, 2, 3, 12, 4), box(6, 9, 2, 10, 11, 4), box(5, 4, 2, 11, 5, 4));
				case EAST -> Shapes.or(box(0, 0, 1, 12, 15, 15), box(12, 12, 1, 16, 15, 15), box(12, 0, 13, 14, 12, 15), box(12, 0, 3, 14, 2, 13), box(12, 0, 1, 14, 12, 3), box(12, 9, 6, 14, 11, 10), box(12, 4, 5, 14, 5, 11));
				case WEST -> Shapes.or(box(4, 0, 1, 16, 15, 15), box(0, 12, 1, 4, 15, 15), box(2, 0, 1, 4, 12, 3), box(2, 0, 3, 4, 2, 13), box(2, 0, 13, 4, 12, 15), box(2, 9, 6, 4, 11, 10), box(2, 4, 5, 4, 5, 11));
                default -> Shapes.or(box(1, 0, 0, 15, 15, 12), box(1, 12, 12, 15, 15, 16), box(1, 0, 12, 3, 12, 14), box(3, 0, 12, 13, 2, 14), box(13, 0, 12, 15, 12, 14), box(6, 9, 12, 10, 11, 14), box(5, 4, 12, 11, 5, 14));
            };
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			return switch (state.getValue(FACING)) {
                case NORTH -> Shapes.or(box(1, 0, 4, 15, 15, 16), box(1, 12, 0, 15, 15, 4), box(13, 0, 2, 15, 12, 4), box(3, 0, 2, 13, 2, 4), box(1, 0, 2, 3, 12, 4), box(6, 9, 2, 10, 11, 4), box(5, 4, 2, 11, 5, 4));
				case EAST -> Shapes.or(box(0, 0, 1, 12, 15, 15), box(12, 12, 1, 16, 15, 15), box(12, 0, 13, 14, 12, 15), box(12, 0, 3, 14, 2, 13), box(12, 0, 1, 14, 12, 3), box(12, 9, 6, 14, 11, 10), box(12, 4, 5, 14, 5, 11));
				case WEST -> Shapes.or(box(4, 0, 1, 16, 15, 15), box(0, 12, 1, 4, 15, 15), box(2, 0, 1, 4, 12, 3), box(2, 0, 3, 4, 2, 13), box(2, 0, 13, 4, 12, 15), box(2, 9, 6, 4, 11, 10), box(2, 4, 5, 4, 5, 11));
                default -> Shapes.or(box(1, 0, 0, 15, 15, 12), box(1, 12, 12, 15, 15, 16), box(1, 0, 12, 3, 12, 14), box(3, 0, 12, 13, 2, 14), box(13, 0, 12, 15, 12, 14), box(6, 9, 12, 10, 11, 14), box(5, 4, 12, 11, 5, 14));
            };
		}
		if (state.getValue(BLOCKSTATE) == 4) {
			return switch (state.getValue(FACING)) {
                case NORTH -> Shapes.or(box(1, 0, 4, 15, 15, 16), box(1, 12, 0, 15, 15, 4), box(13, 0, 2, 15, 12, 4), box(3, 0, 2, 13, 2, 4), box(1, 0, 2, 3, 12, 4), box(6, 9, 2, 10, 11, 4), box(5, 4, 2, 11, 5, 4));
				case EAST -> Shapes.or(box(0, 0, 1, 12, 15, 15), box(12, 12, 1, 16, 15, 15), box(12, 0, 13, 14, 12, 15), box(12, 0, 3, 14, 2, 13), box(12, 0, 1, 14, 12, 3), box(12, 9, 6, 14, 11, 10), box(12, 4, 5, 14, 5, 11));
				case WEST -> Shapes.or(box(4, 0, 1, 16, 15, 15), box(0, 12, 1, 4, 15, 15), box(2, 0, 1, 4, 12, 3), box(2, 0, 3, 4, 2, 13), box(2, 0, 13, 4, 12, 15), box(2, 9, 6, 4, 11, 10), box(2, 4, 5, 4, 5, 11));
                default -> Shapes.or(box(1, 0, 0, 15, 15, 12), box(1, 12, 12, 15, 15, 16), box(1, 0, 12, 3, 12, 14), box(3, 0, 12, 13, 2, 14), box(13, 0, 12, 15, 12, 14), box(6, 9, 12, 10, 11, 14), box(5, 4, 12, 11, 5, 14));
            };
		}
		if (state.getValue(BLOCKSTATE) == 5) {
			return switch (state.getValue(FACING)) {
                case NORTH -> Shapes.or(box(1, 0, 4, 15, 15, 16), box(1, 12, 0, 15, 15, 4), box(13, 0, 2, 15, 12, 4), box(3, 0, 2, 13, 2, 4), box(1, 0, 2, 3, 12, 4), box(6, 9, 2, 10, 11, 4), box(5, 4, 2, 11, 5, 4));
				case EAST -> Shapes.or(box(0, 0, 1, 12, 15, 15), box(12, 12, 1, 16, 15, 15), box(12, 0, 13, 14, 12, 15), box(12, 0, 3, 14, 2, 13), box(12, 0, 1, 14, 12, 3), box(12, 9, 6, 14, 11, 10), box(12, 4, 5, 14, 5, 11));
				case WEST -> Shapes.or(box(4, 0, 1, 16, 15, 15), box(0, 12, 1, 4, 15, 15), box(2, 0, 1, 4, 12, 3), box(2, 0, 3, 4, 2, 13), box(2, 0, 13, 4, 12, 15), box(2, 9, 6, 4, 11, 10), box(2, 4, 5, 4, 5, 11));
                default -> Shapes.or(box(1, 0, 0, 15, 15, 12), box(1, 12, 12, 15, 15, 16), box(1, 0, 12, 3, 12, 14), box(3, 0, 12, 13, 2, 14), box(13, 0, 12, 15, 12, 14), box(6, 9, 12, 10, 11, 14), box(5, 4, 12, 11, 5, 14));
            };
		}
		if (state.getValue(BLOCKSTATE) == 6) {
			return switch (state.getValue(FACING)) {
                case NORTH -> Shapes.or(box(1, 0, 4, 15, 15, 16), box(1, 12, 0, 15, 15, 4), box(13, 0, 2, 15, 12, 4), box(3, 0, 2, 13, 2, 4), box(1, 0, 2, 3, 12, 4), box(6, 9, 2, 10, 11, 4), box(5, 4, 2, 11, 5, 4));
				case EAST -> Shapes.or(box(0, 0, 1, 12, 15, 15), box(12, 12, 1, 16, 15, 15), box(12, 0, 13, 14, 12, 15), box(12, 0, 3, 14, 2, 13), box(12, 0, 1, 14, 12, 3), box(12, 9, 6, 14, 11, 10), box(12, 4, 5, 14, 5, 11));
				case WEST -> Shapes.or(box(4, 0, 1, 16, 15, 15), box(0, 12, 1, 4, 15, 15), box(2, 0, 1, 4, 12, 3), box(2, 0, 3, 4, 2, 13), box(2, 0, 13, 4, 12, 15), box(2, 9, 6, 4, 11, 10), box(2, 4, 5, 4, 5, 11));
                default -> Shapes.or(box(1, 0, 0, 15, 15, 12), box(1, 12, 12, 15, 15, 16), box(1, 0, 12, 3, 12, 14), box(3, 0, 12, 13, 2, 14), box(13, 0, 12, 15, 12, 14), box(6, 9, 12, 10, 11, 14), box(5, 4, 12, 11, 5, 14));
            };
		}
		if (state.getValue(BLOCKSTATE) == 8) {
			return switch (state.getValue(FACING)) {
                case NORTH -> Shapes.or(box(1, 0, 4, 15, 15, 16), box(1, 12, 0, 15, 15, 4), box(13, 0, 2, 15, 12, 4), box(3, 0, 2, 13, 2, 4), box(1, 0, 2, 3, 12, 4), box(6, 9, 2, 10, 11, 4), box(5, 4, 2, 11, 5, 4));
				case EAST -> Shapes.or(box(0, 0, 1, 12, 15, 15), box(12, 12, 1, 16, 15, 15), box(12, 0, 13, 14, 12, 15), box(12, 0, 3, 14, 2, 13), box(12, 0, 1, 14, 12, 3), box(12, 9, 6, 14, 11, 10), box(12, 4, 5, 14, 5, 11));
				case WEST -> Shapes.or(box(4, 0, 1, 16, 15, 15), box(0, 12, 1, 4, 15, 15), box(2, 0, 1, 4, 12, 3), box(2, 0, 3, 4, 2, 13), box(2, 0, 13, 4, 12, 15), box(2, 9, 6, 4, 11, 10), box(2, 4, 5, 4, 5, 11));
                default -> Shapes.or(box(1, 0, 0, 15, 15, 12), box(1, 12, 12, 15, 15, 16), box(1, 0, 12, 3, 12, 14), box(3, 0, 12, 13, 2, 14), box(13, 0, 12, 15, 12, 14), box(6, 9, 12, 10, 11, 14), box(5, 4, 12, 11, 5, 14));
            };
		}
		if (state.getValue(BLOCKSTATE) == 9) {
			return switch (state.getValue(FACING)) {
                case NORTH -> Shapes.or(box(1, 0, 4, 15, 15, 16), box(1, 12, 0, 15, 15, 4), box(13, 0, 2, 15, 12, 4), box(3, 0, 2, 13, 2, 4), box(1, 0, 2, 3, 12, 4), box(6, 9, 2, 10, 11, 4), box(5, 4, 2, 11, 5, 4));
				case EAST -> Shapes.or(box(0, 0, 1, 12, 15, 15), box(12, 12, 1, 16, 15, 15), box(12, 0, 13, 14, 12, 15), box(12, 0, 3, 14, 2, 13), box(12, 0, 1, 14, 12, 3), box(12, 9, 6, 14, 11, 10), box(12, 4, 5, 14, 5, 11));
				case WEST -> Shapes.or(box(4, 0, 1, 16, 15, 15), box(0, 12, 1, 4, 15, 15), box(2, 0, 1, 4, 12, 3), box(2, 0, 3, 4, 2, 13), box(2, 0, 13, 4, 12, 15), box(2, 9, 6, 4, 11, 10), box(2, 4, 5, 4, 5, 11));
                default -> Shapes.or(box(1, 0, 0, 15, 15, 12), box(1, 12, 12, 15, 15, 16), box(1, 0, 12, 3, 12, 14), box(3, 0, 12, 13, 2, 14), box(13, 0, 12, 15, 12, 14), box(6, 9, 12, 10, 11, 14), box(5, 4, 12, 11, 5, 14));
            };
		}
		if (state.getValue(BLOCKSTATE) == 10) {
			return switch (state.getValue(FACING)) {
                case NORTH -> Shapes.or(box(1, 0, 4, 15, 15, 16), box(1, 12, 0, 15, 15, 4), box(13, 0, 2, 15, 12, 4), box(3, 0, 2, 13, 2, 4), box(1, 0, 2, 3, 12, 4), box(6, 9, 2, 10, 11, 4), box(5, 4, 2, 11, 5, 4));
				case EAST -> Shapes.or(box(0, 0, 1, 12, 15, 15), box(12, 12, 1, 16, 15, 15), box(12, 0, 13, 14, 12, 15), box(12, 0, 3, 14, 2, 13), box(12, 0, 1, 14, 12, 3), box(12, 9, 6, 14, 11, 10), box(12, 4, 5, 14, 5, 11));
				case WEST -> Shapes.or(box(4, 0, 1, 16, 15, 15), box(0, 12, 1, 4, 15, 15), box(2, 0, 1, 4, 12, 3), box(2, 0, 3, 4, 2, 13), box(2, 0, 13, 4, 12, 15), box(2, 9, 6, 4, 11, 10), box(2, 4, 5, 4, 5, 11));
                default -> Shapes.or(box(1, 0, 0, 15, 15, 12), box(1, 12, 12, 15, 15, 16), box(1, 0, 12, 3, 12, 14), box(3, 0, 12, 13, 2, 14), box(13, 0, 12, 15, 12, 14), box(6, 9, 12, 10, 11, 14), box(5, 4, 12, 11, 5, 14));
            };
		}
        state.getValue(BLOCKSTATE);
        return switch (state.getValue(FACING)) {
            case NORTH -> Shapes.or(box(1, 0, 4, 15, 15, 16), box(1, 12, 0, 15, 15, 4), box(13, 0, 2, 15, 12, 4), box(3, 0, 2, 13, 2, 4), box(1, 0, 2, 3, 12, 4), box(6, 9, 2, 10, 11, 4), box(5, 4, 2, 11, 5, 4));
			case EAST -> Shapes.or(box(0, 0, 1, 12, 15, 15), box(12, 12, 1, 16, 15, 15), box(12, 0, 13, 14, 12, 15), box(12, 0, 3, 14, 2, 13), box(12, 0, 1, 14, 12, 3), box(12, 9, 6, 14, 11, 10), box(12, 4, 5, 14, 5, 11));
			case WEST -> Shapes.or(box(4, 0, 1, 16, 15, 15), box(0, 12, 1, 4, 15, 15), box(2, 0, 1, 4, 12, 3), box(2, 0, 3, 4, 2, 13), box(2, 0, 13, 4, 12, 15), box(2, 9, 6, 4, 11, 10), box(2, 4, 5, 4, 5, 11));
            default -> Shapes.or(box(1, 0, 0, 15, 15, 12), box(1, 12, 12, 15, 15, 16), box(1, 0, 12, 3, 12, 14), box(3, 0, 12, 13, 2, 14), box(13, 0, 12, 15, 12, 14), box(6, 9, 12, 10, 11, 14), box(5, 4, 12, 11, 5, 14));
        };
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public @NotNull BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public @NotNull BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public @NotNull InteractionResult use(@NotNull BlockState blockstate, @NotNull Level world, @NotNull BlockPos pos, @NotNull Player entity, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		if (entity instanceof ServerPlayer player) {
			NetworkHooks.openScreen(player, new MenuProvider() {
				@Override
				public @NotNull Component getDisplayName() {
					return Component.literal("Ice Cream Machine");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
					return new IceCreamMachineGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
				}
			}, pos);
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(@NotNull BlockState state, Level worldIn, @NotNull BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
		return new IceCreamMachineBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, @NotNull Level world, @NotNull BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof IceCreamMachineBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(@NotNull BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(@NotNull BlockState blockState, Level world, @NotNull BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof IceCreamMachineBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}
