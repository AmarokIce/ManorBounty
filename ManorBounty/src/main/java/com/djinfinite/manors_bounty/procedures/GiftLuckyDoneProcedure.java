package com.djinfinite.manors_bounty.procedures;

import com.djinfinite.manors_bounty.registries.ModBlocks;
import com.djinfinite.manors_bounty.registries.ModItems;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.djinfinite.manors_bounty.ManorsBountyMod;

public class GiftLuckyDoneProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		double chance;
		chance = Mth.nextInt(RandomSource.create(), 1, 5);
		if (blockstate.getBlock() == ModBlocks.GIFT_SHORT_LUCKY.get()) {
			if (chance == 1) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 1, 1);
                    } else {
                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 1, 1, false);
                    }
                }
                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ModItems.LOVE_SPECTRUM_RED_ITEM.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
                if (world instanceof ServerLevel _level)
                    _level.addFreshEntity(new ExperienceOrb(_level, x, y, z, Mth.nextInt(RandomSource.create(), 1, 50)));
                if (world instanceof ServerLevel _level)
                    _level.addFreshEntity(new ExperienceOrb(_level, x, y, z, Mth.nextInt(RandomSource.create(), 1, 50)));
                if (world instanceof ServerLevel _level)
                    _level.addFreshEntity(new ExperienceOrb(_level, x, y, z, Mth.nextInt(RandomSource.create(), 1, 50)));
                if (world instanceof ServerLevel _level)
                    _level.addFreshEntity(new ExperienceOrb(_level, x, y, z, Mth.nextInt(RandomSource.create(), 1, 50)));
                if (world instanceof ServerLevel _level)
                    _level.addFreshEntity(new ExperienceOrb(_level, x, y, z, Mth.nextInt(RandomSource.create(), 1, 50)));
            } else if (chance == 2) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.scream")), SoundSource.BLOCKS, 1, 1);
                    } else {
                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.scream")), SoundSource.BLOCKS, 1, 1, false);
                    }
                }
                if (world instanceof ServerLevel _level)
                    _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                            "weather thunder");
                if (world instanceof ServerLevel _level) {
                    LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                    entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
                    entityToSpawn.setVisualOnly(true);
                    _level.addFreshEntity(entityToSpawn);
                }
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = EntityType.GHAST.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
                    }
                }
            } else if (chance == 3) {
                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ModItems.VANILLA_CAKE_SLICE.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ModItems.VANILLA_CAKE_SLICE.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ModItems.VANILLA_CAKE_SLICE.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ModItems.VANILLA_CAKE_SLICE.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ModItems.VANILLA_CAKE_SLICE.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ModItems.VANILLA_CAKE_SLICE.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ModItems.VANILLA_CAKE_SLICE.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ModItems.VANILLA_CAKE_SLICE.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ModItems.VANILLA_CAKE_SLICE.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ModItems.VANILLA_CAKE_SLICE.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
                if (world instanceof ServerLevel _level)
                    _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                            ("summon minecraft:firework_rocket ~ ~" + " ~ {LifeTime:10,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:1,Explosions:[" + FireworknbtProcedure.execute(entity) + "]}}}}"));
                if (world instanceof ServerLevel _level)
                    _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                            ("summon minecraft:firework_rocket ~ ~" + " ~ {LifeTime:15,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:1,Explosions:[" + FireworknbtProcedure.execute(entity) + "]}}}}"));
                if (world instanceof ServerLevel _level)
                    _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                            ("summon minecraft:firework_rocket ~ ~" + " ~ {LifeTime:20,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:1,Explosions:[" + FireworknbtProcedure.execute(entity) + "]}}}}"));
            } else if (chance == 4) {
                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ModItems.CHERRIES.get()));
                    entityToSpawn.setPickUpDelay(40);
                    _level.addFreshEntity(entityToSpawn);
                }
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tnt.primed")), SoundSource.NEUTRAL, 1, 1);
                    } else {
                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tnt.primed")), SoundSource.NEUTRAL, 1, 1, false);
                    }
                }
                ManorsBountyMod.queueServerWork(40, () -> {
                    if (world instanceof Level _level && !_level.isClientSide())
                        _level.explode(null, x, y, z, 2, Level.ExplosionInteraction.NONE);
                });
            } else if (chance == 5) {
                if (world instanceof ServerLevel _level)
                    FallingBlockEntity.fall(_level, BlockPos.containing(x, y + 1, z), ModBlocks.GIFT_SHORT_RED.get().defaultBlockState());
                if (world instanceof ServerLevel _level)
                    FallingBlockEntity.fall(_level, BlockPos.containing(x, y + 2, z), ModBlocks.GIFT_SHORT_GREEN.get().defaultBlockState());
                if (world instanceof ServerLevel _level)
                    FallingBlockEntity.fall(_level, BlockPos.containing(x, y + 3, z), ModBlocks.GIFT_SHORT_BLUE.get().defaultBlockState());
                if (world instanceof ServerLevel _level)
                    FallingBlockEntity.fall(_level, BlockPos.containing(x, y + 4, z), ModBlocks.GIFT_SHORT_PINK.get().defaultBlockState());
                if (world instanceof ServerLevel _level)
                    FallingBlockEntity.fall(_level, BlockPos.containing(x, y + 5, z), ModBlocks.GIFT_SHORT_LUCKY.get().defaultBlockState());
            }
		}
	}
}
