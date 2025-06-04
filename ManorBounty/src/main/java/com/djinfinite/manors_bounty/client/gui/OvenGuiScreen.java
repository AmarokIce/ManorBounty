package com.djinfinite.manors_bounty.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import com.djinfinite.manors_bounty.world.inventory.OvenGuiMenu;
import com.djinfinite.manors_bounty.procedures.OvenGuiWorkingCheckProcedure;
import com.djinfinite.manors_bounty.procedures.OvenGuiTimeCheckProcedure;
import com.djinfinite.manors_bounty.procedures.OvenGuiTemCheckProcedure;
import com.djinfinite.manors_bounty.procedures.OvenGuiOutSlotCheckProcedure;
import com.djinfinite.manors_bounty.procedures.OvenGuiBottonDCheckProcedure;
import com.djinfinite.manors_bounty.procedures.OvenGuiBottonCCheckProcedure;
import com.djinfinite.manors_bounty.procedures.OvenGuiBottonBCheckProcedure;
import com.djinfinite.manors_bounty.procedures.OvenGuiBottonACheckProcedure;
import com.djinfinite.manors_bounty.procedures.OvenGuiBotton4CheckProcedure;
import com.djinfinite.manors_bounty.procedures.OvenGuiBotton3CheckProcedure;
import com.djinfinite.manors_bounty.procedures.OvenGuiBotton2CheckProcedure;
import com.djinfinite.manors_bounty.procedures.OvenGuiBotton1CheckProcedure;
import com.djinfinite.manors_bounty.network.OvenGuiButtonMessage;
import com.djinfinite.manors_bounty.ManorsBountyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import org.jetbrains.annotations.NotNull;

public class OvenGuiScreen extends AbstractContainerScreen<OvenGuiMenu> {
	private final static HashMap<String, Object> guistate = OvenGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_gas_oven_gui_botton_0;
	ImageButton imagebutton_oven_gui_botton_back;
	ImageButton imagebutton_cutting_board_gui_knife_botton_1;

	public OvenGuiScreen(OvenGuiMenu container, Inventory inventory, Component text) {
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

		guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/oven_gui_background.png"), this.leftPos, this.topPos - 32, 0, 0, 176, 227, 176, 227);

		guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/oven_gui_slot.png"), this.leftPos + 63, this.topPos + 19, 0, 0, 50, 44, 50, 44);

		if (OvenGuiOutSlotCheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/oven_gui_slot_out.png"), this.leftPos + 75, this.topPos + 30, 0, 0, 26, 26, 26, 26);
		}
		if (OvenGuiWorkingCheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/oven_gui_door.png"), this.leftPos + 16, this.topPos - 3, 0, 0, 144, 108, 144, 108);
		}
		if (OvenGuiBotton1CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/oven_gui_botton_0.png"), this.leftPos + 30, this.topPos - 29, 0, 0, 24, 24, 24, 24);
		}
		if (OvenGuiBotton2CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/oven_gui_botton_1.png"), this.leftPos + 30, this.topPos - 29, 0, 0, 24, 24, 24, 24);
		}
		if (OvenGuiBotton3CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/oven_gui_botton_2.png"), this.leftPos + 30, this.topPos - 29, 0, 0, 24, 24, 24, 24);
		}
		if (OvenGuiBotton4CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/oven_gui_botton_3.png"), this.leftPos + 30, this.topPos - 29, 0, 0, 24, 24, 24, 24);
		}
		if (OvenGuiBottonACheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/oven_gui_botton_0.png"), this.leftPos + 122, this.topPos - 29, 0, 0, 24, 24, 24, 24);
		}
		if (OvenGuiBottonBCheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/oven_gui_botton_1.png"), this.leftPos + 122, this.topPos - 29, 0, 0, 24, 24, 24, 24);
		}
		if (OvenGuiBottonCCheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/oven_gui_botton_2.png"), this.leftPos + 122, this.topPos - 29, 0, 0, 24, 24, 24, 24);
		}
		if (OvenGuiBottonDCheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/oven_gui_botton_3.png"), this.leftPos + 122, this.topPos - 29, 0, 0, 24, 24, 24, 24);
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
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				OvenGuiTemCheckProcedure.execute(world, x, y, z), 70, -21, -1, false);
		guiGraphics.drawString(this.font,

				OvenGuiTimeCheckProcedure.execute(world, x, y, z), 94, -21, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_gas_oven_gui_botton_0 = new ImageButton(this.leftPos + 30, this.topPos - 29, 24, 24, 0, 0, 24, new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_gas_oven_gui_botton_0.png"), 24, 48, e -> {
            ManorsBountyMod.PACKET_HANDLER.sendToServer(new OvenGuiButtonMessage(0, x, y, z));
            OvenGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
        });
		guistate.put("button:imagebutton_gas_oven_gui_botton_0", imagebutton_gas_oven_gui_botton_0);
		this.addRenderableWidget(imagebutton_gas_oven_gui_botton_0);
		imagebutton_oven_gui_botton_back = new ImageButton(this.leftPos + 122, this.topPos - 29, 24, 24, 0, 0, 24, new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_oven_gui_botton_back.png"), 24, 48, e -> {
            ManorsBountyMod.PACKET_HANDLER.sendToServer(new OvenGuiButtonMessage(1, x, y, z));
            OvenGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
        });
		guistate.put("button:imagebutton_oven_gui_botton_back", imagebutton_oven_gui_botton_back);
		this.addRenderableWidget(imagebutton_oven_gui_botton_back);
		imagebutton_cutting_board_gui_knife_botton_1 = new ImageButton(this.leftPos + 56, this.topPos - 1, 63, 11, 0, 0, 11, new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_cutting_board_gui_knife_botton_1.png"), 63, 22,
				e -> {
                    ManorsBountyMod.PACKET_HANDLER.sendToServer(new OvenGuiButtonMessage(2, x, y, z));
                    OvenGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
                });
		guistate.put("button:imagebutton_cutting_board_gui_knife_botton_1", imagebutton_cutting_board_gui_knife_botton_1);
		this.addRenderableWidget(imagebutton_cutting_board_gui_knife_botton_1);
	}
}
