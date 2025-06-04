
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
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.djinfinite.manors_bounty.world.inventory.FryerGuiMenu;
import com.djinfinite.manors_bounty.procedures.FryerTickProcedure;
import com.djinfinite.manors_bounty.block.entity.FryerBlockEntity;

import io.netty.buffer.Unpooled;
import org.jetbrains.annotations.NotNull;

public class FryerBlock extends Block implements EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 2);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final String IS_WORKING_KEY = "working";
    public static final String WORKING_TIME_KEY = "working_time";
    public static final String OIL_KEY = "OilFluid";
	public FryerBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.WOOL).sound(SoundType.METAL).strength(2f).lightLevel(s -> 5).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
                case NORTH -> Shapes.or(box(0, 0, 3.5, 1, 16, 13.5), box(0, 0, 13.5, 16, 20, 16.5), box(15, 0, 3.5, 16, 16, 13.5), box(0, 0, 1.5, 16, 16, 3.5), box(1, 0, 3.5, 15, 10, 13.5));
				case EAST -> Shapes.or(box(2.5, 0, 0, 12.5, 16, 1), box(-0.5, 0, 0, 2.5, 20, 16), box(2.5, 0, 15, 12.5, 16, 16), box(12.5, 0, 0, 14.5, 16, 16), box(2.5, 0, 1, 12.5, 10, 15));
				case WEST -> Shapes.or(box(3.5, 0, 15, 13.5, 16, 16), box(13.5, 0, 0, 16.5, 20, 16), box(3.5, 0, 0, 13.5, 16, 1), box(1.5, 0, 0, 3.5, 16, 16), box(3.5, 0, 1, 13.5, 10, 15));
                default -> Shapes.or(box(15, 0, 2.5, 16, 16, 12.5), box(0, 0, -0.5, 16, 20, 2.5), box(0, 0, 2.5, 1, 16, 12.5), box(0, 0, 12.5, 16, 16, 14.5), box(1, 0, 2.5, 15, 10, 12.5));
            };
		}
        state.getValue(BLOCKSTATE);
        return switch (state.getValue(FACING)) {
            case NORTH -> Shapes.or(box(0, 0, 3.5, 1, 16, 13.5), box(0, 0, 13.5, 16, 20, 16.5), box(15, 0, 3.5, 16, 16, 13.5), box(0, 0, 1.5, 16, 16, 3.5), box(1, 0, 3.5, 15, 10, 13.5), box(1, 10, 3.5, 15, 14, 13.5));
			case EAST -> Shapes.or(box(2.5, 0, 0, 12.5, 16, 1), box(-0.5, 0, 0, 2.5, 20, 16), box(2.5, 0, 15, 12.5, 16, 16), box(12.5, 0, 0, 14.5, 16, 16), box(2.5, 0, 1, 12.5, 10, 15), box(2.5, 10, 1, 12.5, 14, 15));
			case WEST -> Shapes.or(box(3.5, 0, 15, 13.5, 16, 16), box(13.5, 0, 0, 16.5, 20, 16), box(3.5, 0, 0, 13.5, 16, 1), box(1.5, 0, 0, 3.5, 16, 16), box(3.5, 0, 1, 13.5, 10, 15), box(3.5, 10, 1, 13.5, 14, 15));
            default -> Shapes.or(box(15, 0, 2.5, 16, 16, 12.5), box(0, 0, -0.5, 16, 20, 2.5), box(0, 0, 2.5, 1, 16, 12.5), box(0, 0, 12.5, 16, 16, 14.5), box(1, 0, 2.5, 15, 10, 12.5), box(1, 10, 2.5, 15, 14, 12.5));
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
	public void onPlace(@NotNull BlockState blockstate, @NotNull Level world, @NotNull BlockPos pos, @NotNull BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 20);
	}

	@Override
	public void tick(@NotNull BlockState blockstate, @NotNull ServerLevel world, @NotNull BlockPos pos, @NotNull RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		FryerTickProcedure.execute(world, x, y, z);
		world.scheduleTick(pos, this, 20);
	}

	@Override
	public @NotNull InteractionResult use(@NotNull BlockState blockstate, @NotNull Level world, @NotNull BlockPos pos, @NotNull Player entity, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		if (entity instanceof ServerPlayer player) {
			NetworkHooks.openScreen(player, new MenuProvider() {
				@Override
				public @NotNull Component getDisplayName() {
					return Component.literal("Fryer");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
					return new FryerGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
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
		return new FryerBlockEntity(pos, state);
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
			if (blockEntity instanceof FryerBlockEntity be) {
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
		if (tileentity instanceof FryerBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}
