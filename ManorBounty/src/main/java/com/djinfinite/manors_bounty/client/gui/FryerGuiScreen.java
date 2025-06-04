package com.djinfinite.manors_bounty.client.gui;

import com.djinfinite.manors_bounty.block.FryerBlock;
import com.djinfinite.manors_bounty.client.MultiImageButton;
import com.djinfinite.manors_bounty.client.RenderedImage;
import com.djinfinite.manors_bounty.client.RotateImageButton;
import com.djinfinite.manors_bounty.procedures.*;
import com.djinfinite.manors_bounty.utils.ModUtils;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import com.djinfinite.manors_bounty.world.inventory.FryerGuiMenu;
import com.djinfinite.manors_bounty.network.FryerGuiButtonMessage;
import com.djinfinite.manors_bounty.ManorsBountyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import org.jetbrains.annotations.NotNull;

public class FryerGuiScreen extends AbstractContainerScreen<FryerGuiMenu> {
	private final static HashMap<String, Object> guistate = FryerGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
    MultiImageButton workButton;
	RotateImageButton getButton;
    RenderedImage fryOil = new RenderedImage(this.leftPos + 51, this.topPos + 30, 32, 32,
			ManorsBountyMod.createModResourceLocation("textures/screens/fryer_gui_frying_1.png"),
			ManorsBountyMod.createModResourceLocation("textures/screens/fryer_gui_frying_2.png"),
			ManorsBountyMod.createModResourceLocation("textures/screens/fryer_gui_frying_3.png"),
			ManorsBountyMod.createModResourceLocation("textures/screens/fryer_gui_frying_4.png")
	);
    RenderedImage oilBar;

	public FryerGuiScreen(FryerGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
        fryOil.setCycleTick(7);
    }

	@Override
	public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
        CompoundTag data = ModUtils.getBlockEntityData(world, BlockPos.containing(x, y, z));
        if(data.getBoolean(FryerBlock.IS_WORKING_KEY)){
            int workTime = data.getInt(FryerBlock.WORKING_TIME_KEY) - 7;
            if (workTime>=0) {
                workButton.setIndex(workTime);
            }
        }else{
            workButton.setIndex(0);
        }

        float oilAmount = data.getInt(FryerBlock.OIL_KEY);
        oilBar.setY((int) Math.floor(this.topPos + 24 + 66 - 66*oilAmount/4000));
        oilBar.setHeight((int) Math.ceil(oilAmount/4000*66));
        oilBar.setMaxV(oilAmount/4000*66/512);
        int sum = this.getMenu().get().values().stream().limit(4).mapToInt(slot -> slot.getItem().getCount()).sum();
        oilBar.setTooltip(Tooltip.create(
                Component.translatable("ui.manors_bounty.fryer.oil_amount",(int) oilAmount)
                .append("\n")
                .append(Component.translatable("ui.manors_bounty.fryer.oil_consumption",6.25*sum))
        ));
		if (ModUtils.getBlockEntityData(world,new BlockPos(x,y,z)).getBoolean(FryerBlock.IS_WORKING_KEY)) {
			fryOil.guiTick();
			guiGraphics.blit(fryOil.currentTexture(),  fryOil.getX(), fryOil.getY(),1,0,0,32,32,32,32);
		}
        guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/fryer_gui_0.png"),  this.leftPos + 141, this.topPos + 26,1,0,0,7,61,7,61);
    }

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/fryer_gui.png"), this.leftPos, this.topPos - 33, 0, 0, 176, 227, 176, 227);

		if (FryerGuiOilInCheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/fryer_gui_oil_fluid.png"), this.leftPos + 23, this.topPos + 13, 0, 0, 88, 78, 88, 78);
		}

		guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/fryer_gui_red_light.png"), this.leftPos + 5, this.topPos - 28, 0, 0, 10, 10, 10, 10);

		if (FryerGuiGreenLightCheckProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/fryer_gui_green_light.png"), this.leftPos + 21, this.topPos - 28, 0, 0, 10, 10, 10, 10);
		}
		if (FryerGuiHobOnCheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/fryer_gui_hob_on.png"), this.leftPos + 25, this.topPos - 28, 0, 0, 84, 132, 84, 132);
		}
		if (FryerGuiHobInCheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/fryer_gui_hob_in.png"), this.leftPos + 25, this.topPos + 2, 0, 0, 84, 102, 84, 102);
		}
		if (FryerGuiHobOnCheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("manors_bounty:textures/screens/fryer_gui_slot.png"), this.leftPos + 41, this.topPos - 12, 0, 0, 52, 52, 52, 52);
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
		workButton = new MultiImageButton(this.leftPos + 140, this.topPos - 29, 18, 18, 0, 0, 18, new ResourceLocation[]{
				new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_fryer_gui_still_botton.png"),
				new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_fryer_gui_work_botton_8.png"),
				new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_fryer_gui_work_botton_7.png"),
				new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_fryer_gui_work_botton_6.png"),
				new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_fryer_gui_work_botton_5.png"),
				new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_fryer_gui_work_botton_4.png"),
				new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_fryer_gui_work_botton_3.png"),
				new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_fryer_gui_work_botton_2.png"),
				new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_fryer_gui_work_botton_1.png")
		}, 18, 36, e -> {
			if (FryerGuiStillBottonCheckProcedure.execute(world, x, y, z)) {
				ManorsBountyMod.PACKET_HANDLER.sendToServer(new FryerGuiButtonMessage(0, x, y, z));
				FryerGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_fryer_gui_still_botton", workButton);
		this.addRenderableWidget(workButton);
        oilBar = new RenderedImage(this.leftPos + 141, this.topPos + 24,16,512,
                new ResourceLocation("manors_bounty:textures/screens/olive_oil_still.png")
        );
        guistate.put("bar:oil", oilBar);
        this.addRenderableWidget(oilBar);
		fryOil.setX(this.leftPos + 51);
		fryOil.setY(this.topPos + 30);

        getButton = new RotateImageButton(this.leftPos + 118, this.topPos - 29, 18, 18, 0, 0, 18, new ResourceLocation("manors_bounty:textures/screens/atlas/imagebutton_fryer_gui_still_botton1.png"), 18, 36, e -> {
            ManorsBountyMod.PACKET_HANDLER.sendToServer(new FryerGuiButtonMessage(9, x, y, z));
            FryerGuiButtonMessage.handleButtonAction(entity, 9, x, y, z);
        });
		guistate.put("button:imagebutton_fryer_gui_still_botton1", getButton);
		this.addRenderableWidget(getButton);
	}

}
