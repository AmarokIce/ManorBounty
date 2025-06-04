package com.djinfinite.manors_bounty.mixin;

import com.djinfinite.manors_bounty.items.IFoodItem;
import com.djinfinite.manors_bounty.utils.CapabilityUtils;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
//TODO 尝试用一个新的模组物品基类代替mixin
@Mixin(Item.class)
public abstract class ItemMixin {
    @Shadow public abstract boolean isEdible();
    /**
     * @author fho4565
     * @reason 模组物品冷却
     */
    @Overwrite
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if(pLevel.isClientSide()){
            return this.isEdible() ? pLivingEntity.eat(pLevel, pStack) : pStack;
        }
        if (this.isEdible()) {
            Item item = pStack.getItem();
            if (item instanceof IFoodItem iFoodItem) {
                if(pLivingEntity instanceof Player player) {
                    if(CapabilityUtils.isInModCooldown(item,player)) {
                        return iFoodItem.usedWhenInCooldown(pLevel, player, pStack);
                    }else{
                        pLivingEntity.eat(pLevel, pStack);
                        return iFoodItem.usedWhenNotInCooldown(pLevel, player, pStack);
                    }
                }else{
                    return pLivingEntity.eat(pLevel, pStack);
                }
            }else{
                return pLivingEntity.eat(pLevel, pStack);
            }
        }else{
            return pStack;
        }
    }
}
