package com.djinfinite.manors_bounty.client.gui;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import com.djinfinite.manors_bounty.world.inventory.CuttingBoardGuiMenu;
import com.djinfinite.manors_bounty.network.CuttingBoardGuiButtonMessage;
import com.djinfinite.manors_bounty.ManorsBountyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import org.jetbrains.annotations.NotNull;

public class CuttingBoardGuiScreen extends AbstractContainerScreen<CuttingBoardGuiMenu> {
	private final static HashMap<String, Object> guistate = CuttingBoardGuiMenu.guistate;
    private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_cutting_board_gui_knife_botton_1;
	ImageButton imagebutton_cutting_board_gui_knife_botton_2;
	ImageButton imagebutton_cutting_board_gui_knife_botton_3;
	ImageButton imagebutton_cutting_board_gui_knife_botton_4;
	ImageButton imagebutton_cutting_board_gui_knife_botton_5;

	public CuttingBoardGuiScreen(CuttingBoardGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
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

		guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/cutting_board_gui.png"), this.leftPos, this.topPos - 24, 0, 0, 176, 194, 176, 194);

		guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/cutting_board_gui_knife.png"), this.leftPos + 42, this.topPos + 10, 0, 0, 68, 70, 68, 70);

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
		imagebutton_cutting_board_gui_knife_botton_1 = new ImageButton(this.leftPos + 68, this.topPos + 40, 23, 23, 0, 0, 23, new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_cutting_board_gui_knife_botton_1.png"), 23, 46,
				e -> {
                    ManorsBountyMod.PACKET_HANDLER.sendToServer(new CuttingBoardGuiButtonMessage(0, x, y, z));
                    CuttingBoardGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
                });
		guistate.put("button:imagebutton_cutting_board_gui_knife_botton_1", imagebutton_cutting_board_gui_knife_botton_1);
		this.addRenderableWidget(imagebutton_cutting_board_gui_knife_botton_1);
		imagebutton_cutting_board_gui_knife_botton_2 = new ImageButton(this.leftPos + 79, this.topPos + 25, 26, 26, 0, 0, 26, new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_cutting_board_gui_knife_botton_2.png"), 26, 52,
				e -> {
                    ManorsBountyMod.PACKET_HANDLER.sendToServer(new CuttingBoardGuiButtonMessage(1, x, y, z));
                    CuttingBoardGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
                });
		guistate.put("button:imagebutton_cutting_board_gui_knife_botton_2", imagebutton_cutting_board_gui_knife_botton_2);
		this.addRenderableWidget(imagebutton_cutting_board_gui_knife_botton_2);
		imagebutton_cutting_board_gui_knife_botton_3 = new ImageButton(this.leftPos + 90, this.topPos + 11, 20, 20, 0, 0, 20, new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_cutting_board_gui_knife_botton_3.png"), 20, 40,
				e -> {
                    ManorsBountyMod.PACKET_HANDLER.sendToServer(new CuttingBoardGuiButtonMessage(2, x, y, z));
                    CuttingBoardGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
                });
		guistate.put("button:imagebutton_cutting_board_gui_knife_botton_3", imagebutton_cutting_board_gui_knife_botton_3);
		this.addRenderableWidget(imagebutton_cutting_board_gui_knife_botton_3);
		imagebutton_cutting_board_gui_knife_botton_4 = new ImageButton(this.leftPos + 56, this.topPos + 51, 15, 15, 0, 0, 15, new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_cutting_board_gui_knife_botton_4.png"), 15, 30,
				e -> {
                    ManorsBountyMod.PACKET_HANDLER.sendToServer(new CuttingBoardGuiButtonMessage(3, x, y, z));
                    CuttingBoardGuiButtonMessage.handleButtonAction(entity, 3, x, y, z);
                });
		guistate.put("button:imagebutton_cutting_board_gui_knife_botton_4", imagebutton_cutting_board_gui_knife_botton_4);
		this.addRenderableWidget(imagebutton_cutting_board_gui_knife_botton_4);
		imagebutton_cutting_board_gui_knife_botton_5 = new ImageButton(this.leftPos + 42, this.topPos + 59, 20, 20, 0, 0, 20, new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_cutting_board_gui_knife_botton_5.png"), 20, 40,
				e -> {
                    ManorsBountyMod.PACKET_HANDLER.sendToServer(new CuttingBoardGuiButtonMessage(4, x, y, z));
                    CuttingBoardGuiButtonMessage.handleButtonAction(entity, 4, x, y, z);
                });
		guistate.put("button:imagebutton_cutting_board_gui_knife_botton_5", imagebutton_cutting_board_gui_knife_botton_5);
		this.addRenderableWidget(imagebutton_cutting_board_gui_knife_botton_5);
	}
}
