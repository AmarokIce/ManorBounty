
package com.djinfinite.manors_bounty.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

public class AlfalfaItem extends Item {

	public static final String ALFALFA_USED_KEY = "alfalfaUsed";

	public AlfalfaItem() {
		super(new Item.Properties());
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand hand) {
		if (livingEntity instanceof Animal animal) {
			int fedTimes = animal.getPersistentData().getInt(ALFALFA_USED_KEY);
			if (!animal.level().isClientSide) {
				if(!player.getAbilities().instabuild && animal.getAge() >= 0){
					itemStack.shrink(1);
				}
				player.swing(hand);
				animal.setInLove(player);
				return InteractionResult.SUCCESS;
			}
			if (animal.isBaby()) {
				if (fedTimes < 3) {
					animal.ageUp(Math.abs(animal.getAge()/40), true);
					if(!player.getAbilities().instabuild){
						itemStack.shrink(1);
					}
					player.swing(hand);
					animal.getPersistentData().putInt(ALFALFA_USED_KEY,fedTimes+1);
					return InteractionResult.sidedSuccess(animal.level().isClientSide);
				}
			}
			if (livingEntity.level().isClientSide) {
				return InteractionResult.CONSUME;
			}
		}
		return super.interactLivingEntity(itemStack, player, livingEntity, hand);
	}
}
