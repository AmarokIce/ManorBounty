
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.djinfinite.manors_bounty.registries;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import com.djinfinite.manors_bounty.client.model.Modelxmas_boots;
import com.djinfinite.manors_bounty.client.model.Modelwitch_hat;
import com.djinfinite.manors_bounty.client.model.Modelspear_of_longinus_model;
import com.djinfinite.manors_bounty.client.model.Modelpops;
import com.djinfinite.manors_bounty.client.model.Modelpipis;
import com.djinfinite.manors_bounty.client.model.Modelminer_hat;
import com.djinfinite.manors_bounty.client.model.Modelflower_ring;
import com.djinfinite.manors_bounty.client.model.Modelelectric_arrow_entity;
import com.djinfinite.manors_bounty.client.model.Modeldaoli_mask;
import com.djinfinite.manors_bounty.client.model.Modelchristmas_muffler;
import com.djinfinite.manors_bounty.client.model.Modelchristmas_hat;
import com.djinfinite.manors_bounty.client.model.Modelchef_hat;
@SuppressWarnings("unused")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelchristmas_hat.LAYER_LOCATION, Modelchristmas_hat::createBodyLayer);
		event.registerLayerDefinition(Modelxmas_boots.LAYER_LOCATION, Modelxmas_boots::createBodyLayer);
		event.registerLayerDefinition(Modelelectric_arrow_entity.LAYER_LOCATION, Modelelectric_arrow_entity::createBodyLayer);
		event.registerLayerDefinition(Modelflower_ring.LAYER_LOCATION, Modelflower_ring::createBodyLayer);
		event.registerLayerDefinition(Modelchristmas_muffler.LAYER_LOCATION, Modelchristmas_muffler::createBodyLayer);
		event.registerLayerDefinition(Modelchef_hat.LAYER_LOCATION, Modelchef_hat::createBodyLayer);
		event.registerLayerDefinition(Modelspear_of_longinus_model.LAYER_LOCATION, Modelspear_of_longinus_model::createBodyLayer);
		event.registerLayerDefinition(Modeldaoli_mask.LAYER_LOCATION, Modeldaoli_mask::createBodyLayer);
		event.registerLayerDefinition(Modelpops.LAYER_LOCATION, Modelpops::createBodyLayer);
		event.registerLayerDefinition(Modelpipis.LAYER_LOCATION, Modelpipis::createBodyLayer);
		event.registerLayerDefinition(Modelminer_hat.LAYER_LOCATION, Modelminer_hat::createBodyLayer);
		event.registerLayerDefinition(Modelwitch_hat.LAYER_LOCATION, Modelwitch_hat::createBodyLayer);
	}
}
