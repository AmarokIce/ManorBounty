package club.someoneice.manorsbounty.common.item

import club.someoneice.manorsbounty.client.ClientHandler
import club.someoneice.manorsbounty.init.ModTabs.addToTab
import net.minecraft.sounds.SoundSource
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.UseAnim
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.gameevent.GameEvent

open class ItemFoodBlock(block: Block, private val food: FoodProperties, private val useAnim: UseAnim = UseAnim.EAT,
                         properties: Properties = Properties(), val craftingItem: ItemStack = ItemStack.EMPTY,
                         vararg val effects: MobEffectInstance): BlockItem(block, properties) {
    init {
        this.addToTab()
        ClientHandler.RENDER_LIST.push(this)
    }

    override fun use(pLevel: Level, pPlayer: Player, pUsedHand: InteractionHand): InteractionResultHolder<ItemStack?> {
        if (pPlayer.isShiftKeyDown || !pPlayer.canEat(food.canAlwaysEat())) {
            return super.use(pLevel, pPlayer, pUsedHand)
        }

        pPlayer.startUsingItem(pUsedHand)
        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand))
    }

    override fun place(pContext: BlockPlaceContext): InteractionResult {
        val player = pContext.player ?: return super.place(pContext)
        if (player.isShiftKeyDown || !player.canEat(food.canAlwaysEat())) {
            return super.place(pContext)
        }

        player.startUsingItem(pContext.hand)
        return InteractionResult.CONSUME
    }

    override fun finishUsingItem(pStack: ItemStack, pLevel: Level, pLivingEntity: LivingEntity): ItemStack {
        pLevel.playSound(null, pLivingEntity.x, pLivingEntity.y, pLivingEntity.z, this.eatingSound,
            SoundSource.NEUTRAL, 1.0f, 1.0f + (pLevel.random.nextFloat() - pLevel.random.nextFloat()) * 0.4f)

        if (!pLevel.isClientSide) {
            return pStack
        }

        var shrink = true

        if (pLivingEntity is Player) {
            pLivingEntity.foodData.eat(food.nutrition, food.saturationModifier)
            if (!pLivingEntity.addItem(craftingItem.copy())) {
                pLevel.addFreshEntity(ItemEntity(pLevel, pLivingEntity.x, pLivingEntity.y, pLivingEntity.z, craftingItem.copy()))
            }
            shrink = !pLivingEntity.isCreative
        }

        food.effects
            .filter { pLevel.random.nextFloat() < it.second }
            .forEach { pLivingEntity.addEffect(it.first) }

        this.effects.map(::MobEffectInstance).forEach(pLivingEntity::addEffect)


        pLivingEntity.gameEvent(GameEvent.EAT)
        return pStack.apply { if (shrink) shrink(1) }
    }

    override fun getUseDuration(pStack: ItemStack) = 32
    override fun getUseAnimation(pStack: ItemStack) = useAnim
}
