package club.someoneice.manorsbounty.client.render

import club.someoneice.manorsbounty.ManorsBounty
import net.minecraft.resources.ResourceLocation
import software.bernie.geckolib.core.animatable.GeoAnimatable
import software.bernie.geckolib.model.GeoModel

class GeoRendererBase<T : GeoAnimatable?>(val name: String, val type: Type = Type.BLOCK): GeoModel<T>() {
    override fun getModelResource(animatable: T): ResourceLocation =
        ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, "geo/module/${type.name.lowercase()}/${name}")


    override fun getTextureResource(animatable: T): ResourceLocation =
        ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, "geo/textures/${type.name.lowercase()}/${name}")


    override fun getAnimationResource(animatable: T): ResourceLocation =
        ResourceLocation.fromNamespaceAndPath(ManorsBounty.ID, "geo/anim/${type.name.lowercase()}/${name}")

    enum class Type {
        BLOCK,
        ITEM
    }
}