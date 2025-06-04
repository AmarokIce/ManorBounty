package com.djinfinite.manors_bounty.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.Map;

public class LogsStrippeProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("minecraft:axes")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.strip")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.strip")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = ForgeRegistries.BLOCKS.getValue(new ResourceLocation((((ForgeRegistries.BLOCKS.getKey(blockstate.getBlock()).toString()).replace("manors_bounty:", "manors_bounty:stripped_"))).toLowerCase(java.util.Locale.ENGLISH)))
						.defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null) {
                        _bs.getValue(_property);
                        try {
                            _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                        } catch (Exception e) {
                        }
                    }
				}
				world.setBlock(_bp, _bs, 3);
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}
}
