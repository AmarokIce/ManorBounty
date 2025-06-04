package com.djinfinite.manors_bounty.client;

import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner;
import org.joml.Vector2i;
import org.joml.Vector2ic;

public class CustomTooltipPositioner implements ClientTooltipPositioner {

    public CustomTooltipPositioner() {
    }
    @Override
    public Vector2ic positionTooltip(int screenWidth, int screenHeight, int mouseX, int mouseY, int tooltipWidth, int tooltipHeight) {
        int finalX = mouseX + 10,finalY = mouseY + 10;
        if (mouseX +tooltipWidth > screenWidth) {
            finalX = mouseX-tooltipWidth;
        }
        if (mouseY + tooltipHeight > screenHeight) {
            finalY = mouseY-tooltipWidth;
        }
        return new Vector2i(finalX, finalY);
    }
}
