package com.djinfinite.manors_bounty.blocks;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class WoodBlock extends RotatedPillarBlock {
    Block stripped = null;
    Function<BlockState, BlockState> blockBlockStateFunction = blockState -> stripped != null ? stripped.defaultBlockState().setValue(RotatedPillarBlock.AXIS, blockState.getValue(RotatedPillarBlock.AXIS)) : null;

    public WoodBlock(Properties properties) {
        super(properties);
    }

    public WoodBlock(Properties properties, Block stripped) {
        super(properties);
        this.stripped = stripped;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (toolAction == ToolActions.AXE_STRIP) {
            return blockBlockStateFunction.apply(state);
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
