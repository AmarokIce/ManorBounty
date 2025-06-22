package club.someoneice.manorsbounty

import club.someoneice.manorsbounty.client.ClientHandler
import club.someoneice.manorsbounty.common.network.FryerPacket
import club.someoneice.manorsbounty.common.network.OvenPacket
import club.someoneice.manorsbounty.common.particles.Peach
import club.someoneice.manorsbounty.common.particles.Pear
import club.someoneice.manorsbounty.common.tile.TileFryer
import club.someoneice.manorsbounty.common.tile.TileOven
import club.someoneice.manorsbounty.core.FoodLevelRegister
import club.someoneice.manorsbounty.init.*
import net.minecraft.client.Minecraft
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.client.event.RegisterParticleProvidersEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.network.NetworkRegistry
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(ManorsBounty.ID)
object ManorsBounty {
    const val ID = "manors_bounty"
    const val NAME = "Manor's Bounty"

    const val PV = "1"

    val MESSAGE_INSTANCE = NetworkRegistry.newSimpleChannel(ResourceLocation.fromNamespaceAndPath(ID, "main_channel"),
        ::PV, PV::equals, PV::equals)

    init {
        ModConfig.read()
        ModCapabilitiesRoot

        ModItems.REGISTRY.register(MOD_BUS)
        ModBlocks.REGISTRY.register(MOD_BUS)
        ModBlocks.ITEMS.register(MOD_BUS)
        ModTile.REGISTRY.register(MOD_BUS)
        ModMenus.REGISTER.register(MOD_BUS)
        ModEffects.REGISTRY.register(MOD_BUS)
        ModParticle.PARTICLES.register(MOD_BUS)
        ModTabs.REGISTRY.register(MOD_BUS)

        registerMessage()

        MOD_BUS.addListener(this::commonInit)
        MOD_BUS.addListener(ClientHandler::onClientSetup)
        MOD_BUS.addListener(ClientHandler::initRender)
    }

    fun registerMessage() {
        var id = 0
        MESSAGE_INSTANCE.registerMessage(id++, FryerPacket::class.java, FryerPacket::encodec, ::FryerPacket, FryerPacket::onMessage)
        MESSAGE_INSTANCE.registerMessage(id++, OvenPacket::class.java, OvenPacket::encodec, ::OvenPacket, OvenPacket::onMessage)
    }

    fun commonInit(event: FMLCommonSetupEvent) {
        TileFryer.initRecipe()
        TileOven.initRecipes()
        FoodLevelRegister
    }

    fun registerParticle(event: RegisterParticleProvidersEvent) {
        Minecraft.getInstance().particleEngine.register(ModParticle.PEAR, Pear::provider)
        Minecraft.getInstance().particleEngine.register(ModParticle.PEACH, Peach::provider)
    }
}
