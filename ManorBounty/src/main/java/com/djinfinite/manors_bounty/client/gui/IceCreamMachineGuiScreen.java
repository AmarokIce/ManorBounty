package com.djinfinite.manors_bounty.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.GuiGraphics;

import com.djinfinite.manors_bounty.world.inventory.IceCreamMachineGuiMenu;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiTypeCheckProcedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiIConeCheckProcedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFullVACCheckProcedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFullStarfruitCheckProcedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFullSAJCheckProcedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFullJalapenoCheckProcedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFullChocolateCheckProcedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFullCherriesCheckProcedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFullCheckProcedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFullBlueberryCheckProcedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFullBACCheckProcedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFluidCheck9Procedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFluidCheck8Procedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFluidCheck7Procedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFluidCheck6Procedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFluidCheck5Procedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFluidCheck4Procedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFluidCheck3Procedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFluidCheck2Procedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFluidCheck1Procedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFluidCheck15Procedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFluidCheck14Procedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFluidCheck13Procedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFluidCheck12Procedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFluidCheck11Procedure;
import com.djinfinite.manors_bounty.procedures.IceCreamMachineGuiFluidCheck10Procedure;
import com.djinfinite.manors_bounty.network.IceCreamMachineGuiButtonMessage;
import com.djinfinite.manors_bounty.ManorsBountyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import org.jetbrains.annotations.NotNull;

public class IceCreamMachineGuiScreen extends AbstractContainerScreen<IceCreamMachineGuiMenu> {
	private final static HashMap<String, Object> guistate = IceCreamMachineGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox IceCreamTypeCheck;
	ImageButton imagebutton_ice_cream_machine_gui_botton;

	public IceCreamMachineGuiScreen(IceCreamMachineGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_machine_gui.png"), this.leftPos, this.topPos - 32, 0, 0, 176, 227, 176, 227);

		if (IceCreamMachineGuiIConeCheckProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_machine_gui_cone.png"), this.leftPos + 21, this.topPos + 36, 0, 0, 50, 48, 50, 48);
		}
		if (IceCreamMachineGuiFullCheckProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_machine_gui_cone_full.png"), this.leftPos + 29, this.topPos + 11, 0, 0, 34, 45, 34, 45);
		}
		if (IceCreamMachineGuiFluidCheck1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_fluid_1.png"), this.leftPos + 100, this.topPos + 25, 0, 0, 32, 3, 32, 3);
		}
		if (IceCreamMachineGuiFluidCheck2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_fluid_2.png"), this.leftPos + 100, this.topPos + 22, 0, 0, 32, 6, 32, 6);
		}
		if (IceCreamMachineGuiFluidCheck3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_fluid_3.png"), this.leftPos + 100, this.topPos + 19, 0, 0, 32, 9, 32, 9);
		}
		if (IceCreamMachineGuiFluidCheck4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_fluid_4.png"), this.leftPos + 100, this.topPos + 16, 0, 0, 32, 12, 32, 12);
		}
		if (IceCreamMachineGuiFluidCheck5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_fluid_5.png"), this.leftPos + 100, this.topPos + 13, 0, 0, 32, 15, 32, 15);
		}
		if (IceCreamMachineGuiFluidCheck6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_fluid_6.png"), this.leftPos + 100, this.topPos + 10, 0, 0, 32, 3, 32, 3);
		}
		if (IceCreamMachineGuiFluidCheck7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_fluid_7.png"), this.leftPos + 100, this.topPos + 7, 0, 0, 32, 6, 32, 6);
		}
		if (IceCreamMachineGuiFluidCheck8Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_fluid_8.png"), this.leftPos + 100, this.topPos + 4, 0, 0, 32, 9, 32, 9);
		}
		if (IceCreamMachineGuiFluidCheck9Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_fluid_9.png"), this.leftPos + 100, this.topPos + 1, 0, 0, 32, 12, 32, 12);
		}
		if (IceCreamMachineGuiFluidCheck10Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_fluid_10.png"), this.leftPos + 100, this.topPos - 2, 0, 0, 32, 15, 32, 15);
		}
		if (IceCreamMachineGuiFluidCheck11Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_fluid_11.png"), this.leftPos + 100, this.topPos - 5, 0, 0, 32, 3, 32, 3);
		}
		if (IceCreamMachineGuiFluidCheck12Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_fluid_12.png"), this.leftPos + 100, this.topPos - 8, 0, 0, 32, 6, 32, 6);
		}
		if (IceCreamMachineGuiFluidCheck13Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_fluid_13.png"), this.leftPos + 100, this.topPos - 11, 0, 0, 32, 9, 32, 9);
		}
		if (IceCreamMachineGuiFluidCheck14Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_fluid_14.png"), this.leftPos + 100, this.topPos - 14, 0, 0, 32, 12, 32, 12);
		}
		if (IceCreamMachineGuiFluidCheck15Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_fluid_15.png"), this.leftPos + 100, this.topPos - 17, 0, 0, 32, 15, 32, 15);
		}
		if (IceCreamMachineGuiTypeCheckProcedure.execute(guistate)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_machine_gui_slot_ban.png"), this.leftPos + 142, this.topPos + 85, 0, 0, 18, 18, 18, 18);
		}
		if (IceCreamMachineGuiFullBlueberryCheckProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_machine_gui_cone_ful_blueberry.png"), this.leftPos + 29, this.topPos + 11, 0, 0, 38, 45, 38, 45);
		}
		if (IceCreamMachineGuiFullCherriesCheckProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_machine_gui_cone_ful_cherries.png"), this.leftPos + 24, this.topPos + 11, 0, 0, 39, 45, 39, 45);
		}
		if (IceCreamMachineGuiFullChocolateCheckProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_machine_gui_cone_ful_chocolate.png"), this.leftPos + 29, this.topPos + 11, 0, 0, 34, 45, 34, 45);
		}
		if (IceCreamMachineGuiFullJalapenoCheckProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_machine_gui_cone_ful_jalapeno.png"), this.leftPos + 29, this.topPos + 11, 0, 0, 45, 45, 45, 45);
		}
		if (IceCreamMachineGuiFullStarfruitCheckProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_machine_gui_cone_ful_starfruit.png"), this.leftPos + 29, this.topPos + 11, 0, 0, 34, 45, 34, 45);
		}
		if (IceCreamMachineGuiFullVACCheckProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_machine_gui_cone_ful_vanilla_and_chocolate.png"), this.leftPos + 29, this.topPos + 11, 0, 0, 34, 45, 34, 45);
		}
		if (IceCreamMachineGuiFullSAJCheckProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_machine_gui_cone_ful_starfruit_and_jalapeno.png"), this.leftPos + 29, this.topPos + 11, 0, 0, 45, 45, 45, 45);
		}
		if (IceCreamMachineGuiFullBACCheckProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/ice_cream_machine_gui_cone_ful_blueberry_and_cherries.png"), this.leftPos + 24, this.topPos + 11, 0, 0, 43, 45, 43, 45);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		imagebutton_ice_cream_machine_gui_botton = new ImageButton(this.leftPos + 26, this.topPos - 27, 40, 34, 0, 0, 34, new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_ice_cream_machine_gui_botton.png"), 40, 68, e -> {
            ManorsBountyMod.PACKET_HANDLER.sendToServer(new IceCreamMachineGuiButtonMessage(0, x, y, z));
            IceCreamMachineGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
        });
		guistate.put("button:imagebutton_ice_cream_machine_gui_botton", imagebutton_ice_cream_machine_gui_botton);
		this.addRenderableWidget(imagebutton_ice_cream_machine_gui_botton);
		IceCreamTypeCheck = new Checkbox(this.leftPos + 139, this.topPos - 16, 20, 20, Component.translatable("gui.manors_bounty.ice_cream_machine_gui.IceCreamTypeCheck"), false);
		guistate.put("checkbox:IceCreamTypeCheck", IceCreamTypeCheck);
		this.addRenderableWidget(IceCreamTypeCheck);
	}
}
