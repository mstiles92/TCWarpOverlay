/*
 * This document is a part of the source code and related artifacts for
 * TCWarpOverlay, an open source Minecraft Forge mod that provides a simple
 * overlay with information about your current Warp levels from Thaumcraft 4.
 *
 * http://github.com/mstiles92/TCWarpOverlay
 *
 * Copyright (c) 2014 Matthew Stiles (mstiles92)
 *
 * Licensed under the Common Development and Distribution License Version 1.0
 * You may not use this file except in compliance with this License.
 *
 * You may obtain a copy of the CDDL-1.0 License at
 * http://opensource.org/licenses/CDDL-1.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the license.
 */

package com.mstiles92.tcwarpoverlay.gui;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import thaumcraft.common.Thaumcraft;

public class GuiWarpOverlay extends Gui {
    private static boolean shouldRender = false;
    private Minecraft mc;

    public GuiWarpOverlay() {
        super();

        mc = Minecraft.getMinecraft();
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent event) {
        if (shouldRender) {
            if (event.type.equals(RenderGameOverlayEvent.ElementType.HOTBAR)) {
                if (FMLClientHandler.instance().getClient().inGameHasFocus) {
                    if (FMLClientHandler.instance().getClientPlayerEntity() != null) {
                        String playerName = FMLClientHandler.instance().getClientPlayerEntity().getCommandSenderName();
                        String warpString = "Warp: " + Thaumcraft.proxy.getPlayerKnowledge().getWarp(playerName);
                        String tempWarpString = "Temporary Warp: " + Thaumcraft.proxy.getPlayerKnowledge().getWarp(playerName);

                        int textX = 2;
                        int textY = 2;
                        int textColor = 0xFFFFFF;

                        drawString(mc.fontRenderer, warpString, textX, textY, textColor);
                        drawString(mc.fontRenderer, tempWarpString, textX, textY + mc.fontRenderer.FONT_HEIGHT + 2, textColor);
                    }
                }
            }
        }
    }

    public static void toggleOverlay() {
        shouldRender = !shouldRender;
    }
}
