package club.someoneice.manorsbounty.common.capability

import club.someoneice.manorsbounty.api.IModCapability
import com.google.common.collect.Maps
import net.minecraft.nbt.CompoundTag
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraftforge.registries.ForgeRegistries

@Deprecated("Remove")
class FoodCooldown : IModCapability {
    val foodCooldown: HashMap<Item, Int> = Maps.newHashMap()

    fun getFoodCooldown(stack: Item): Int = foodCooldown[stack] ?: 0
    fun setFoodCooldown(stack: Item, cooldown: Int) {
        foodCooldown[stack] = cooldown
    }

    fun shrinkCooldown() {
        foodCooldown.keys.forEach {
            val cooldown = this.getFoodCooldown(it) - 1
            if (cooldown == 0) {
                foodCooldown.remove(it)
            } else {
                this.setFoodCooldown(it, cooldown)
            }
        }
    }

    override fun serializeNBT() = CompoundTag().also {
        this.foodCooldown.forEach { (item, cooldown) ->
            it.putInt(ForgeRegistries.ITEMS.getKey(item).toString(), cooldown)
        }
    }

    override fun deserializeNBT(nbt: CompoundTag) {
        nbt.allKeys.forEach {
            foodCooldown[ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(it))!!] = nbt.getInt(it)
        }
    }
}
