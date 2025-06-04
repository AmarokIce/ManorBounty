package club.someoneice.manorsbounty

import com.google.common.base.Suppliers
import net.minecraft.util.Mth
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.ItemLike
import java.util.function.Supplier
import kotlin.random.Random

fun Double.odds(): Boolean {
    return Random.nextDouble() <= Mth.clamp(this, 0.0, 1.0)
}

fun <T> MutableList<T>.addAndReturnValue(obj: T): T {
    this.add(obj)
    return obj
}

fun <T> MutableList<T>.addAndReturnSelf(obj: T): MutableList<T> {
    this.add(obj)
    return this
}

fun String.removeStringMark(): String {
    if (!this.startsWith("\"")) {
        return this
    }
    return this.substring(1, this.length - 1)
}

fun String.removeNextLineMark(): String {
    if (!this.endsWith(",")) {
        return this
    }
    return this.substring(0, this.length - 1)
}

fun Supplier<out ItemLike>.asStack(size: Int = 1) = ItemStack(this.get(), size)
fun ItemLike.asStack(size: Int = 1) = ItemStack(this, size)

fun ItemLike.asSupplier(): com.google.common.base.Supplier<Item> = Suppliers.ofInstance(this.asItem())
fun ItemStack.asSupplier(): com.google.common.base.Supplier<ItemStack> = Suppliers.ofInstance(this)

fun Player.giveOrDropItemStack(item: ItemStack) {
    val world = this.level()
    if (world.isClientSide() || item.isEmpty) {
        return
    }

    if (this.addItem(item)) {
        return
    }

    val itemEntity = ItemEntity(world, this.x, this.y + 0.5, this.z, item)
    itemEntity.setDefaultPickUpDelay()
    world.addFreshEntity(itemEntity)
}


fun MobEffect.asInstance(time: Int = 20, level: Int = 0) = MobEffectInstance(this, time, level)