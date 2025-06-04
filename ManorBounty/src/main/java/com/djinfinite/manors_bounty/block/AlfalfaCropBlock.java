package com.djinfinite.manors_bounty.block;


import com.djinfinite.manors_bounty.registries.ModBlocks;
import com.djinfinite.manors_bounty.registries.ModItems;
import com.djinfinite.manors_bounty.utils.ModUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class AlfalfaCropBlock extends CropBlock {
    public static final IntegerProperty THIS_AGE = IntegerProperty.create("blockstate", 0, 5);

    public AlfalfaCropBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.WHEAT));
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return switch (state.getValue(THIS_AGE)) {
            case 1 -> box(0, 0, 0, 16, 5, 16);
            case 2 -> box(0, 0, 0, 16, 6, 16);
            case 3 -> box(0, 0, 0, 16, 8, 16);
            case 4 -> box(0, 0, 0, 16, 13, 16);
            case 5 -> box(0, 0, 0, 16, 15, 16);
            default -> box(0, 0, 0, 16, 3, 16);
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(THIS_AGE);
    }

    @Override
    public boolean canSurvive(@NotNull BlockState blockstate, @NotNull LevelReader levelReader, @NotNull BlockPos pos) {
        return (levelReader.getRawBrightness(pos, 0) >= 8 || levelReader.canSeeSky(pos)) && mayPlaceOn(levelReader.getBlockState(pos.below()), levelReader, pos.below());
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return ModItems.ALFALFA_SEED.get();
    }

    @Override
    public void randomTick(@NotNull BlockState pState, ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
        if (!pLevel.isAreaLoaded(pPos, 1)) return;
        if (pLevel.getRawBrightness(pPos, 0) >= 9) {
            int i = this.getAge(pState);
            if (i < this.getMaxAge()) {
                float f = 0.7f;
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(pLevel, pPos, pState, pRandom.nextInt((int)(25.0F / f) + 1) == 0)) {
                    pLevel.setBlock(pPos, this.getStateForAge(i + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
                }
            }
        }
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState blockstate, @NotNull Level world, @NotNull BlockPos pos, @NotNull Player entity, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (isMaxAge(blockstate)) {
            world.setBlock(pos, blockstate.setValue(THIS_AGE, 1), 3);
            if (world instanceof ServerLevel level) {
                ModUtils.dropItem(level, pos, new ItemStack(ModItems.ALFALFA.get(), Mth.nextInt(RandomSource.create(), 3, 5)));
                ModUtils.dropItem(level, pos, new ItemStack(ModItems.ALFALFA_SEED.get(), Mth.nextInt(RandomSource.create(), 1, 2)));
            }
            if (!world.isClientSide()) {
                world.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1, 1);
            } else {
                world.playLocalSound(pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1, 1, false);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return pState.is(ModBlocks.RICH_BLACK_DIRT_FARMLAND.get());
    }

    @Override
    protected int getBonemealAgeIncrease(Level pLevel) {
        return Mth.nextInt(pLevel.random, 2, 4);
    }

    @Override
    public int getMaxAge() {
        return 5;
    }

    @Override
    protected @NotNull IntegerProperty getAgeProperty() {
        return THIS_AGE;
    }

    @Override
    public boolean isValidBonemealTarget(@NotNull LevelReader worldIn, @NotNull BlockPos pos, @NotNull BlockState blockstate, boolean clientSide) {
        return !isMaxAge(blockstate);
    }

    @Override
    public boolean isBonemealSuccess(@NotNull Level world, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState blockstate) {
        return !isMaxAge(blockstate);
    }
}
