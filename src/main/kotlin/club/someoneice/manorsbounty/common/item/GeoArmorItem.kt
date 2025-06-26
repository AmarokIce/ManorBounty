package club.someoneice.manorsbounty.common.item

import club.someoneice.manorsbounty.ManorsBounty
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterials
import software.bernie.geckolib.animatable.GeoItem
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.core.animation.AnimatableManager
import software.bernie.geckolib.model.GeoModel
import software.bernie.geckolib.renderer.GeoArmorRenderer
import software.bernie.geckolib.util.GeckoLibUtil


class GeoArmorItem(pType: Type, val name: String) : ArmorItem(ArmorMaterials.LEATHER, pType, Properties()), GeoItem {
    private val cache: AnimatableInstanceCache = GeckoLibUtil.createInstanceCache(this)
    private val renderer = GeoArmorRenderer<GeoArmorItem>(object: GeoModel<GeoArmorItem>() {
        override fun getModelResource(p0: GeoArmorItem) =
            ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, "geo/${name}.geo.json")
        override fun getTextureResource(p0: GeoArmorItem?) =
            ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, "")
        override fun getAnimationResource(p0: GeoArmorItem?) = null
    })

/*    override fun initializeClient(consumer: Consumer<IClientItemExtensions?>) {
        consumer.accept(object : IClientItemExtensions {
            override fun getHumanoidArmorModel(livingEntity: LivingEntity, itemStack: ItemStack, equipmentSlot: EquipmentSlot, original: HumanoidModel<*>?): HumanoidModel<*> {
                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original)

                return this.renderer
            }
        })
    }*/


    override fun registerControllers(p0: AnimatableManager.ControllerRegistrar) {

    }

    override fun getAnimatableInstanceCache(): AnimatableInstanceCache = cache
}
