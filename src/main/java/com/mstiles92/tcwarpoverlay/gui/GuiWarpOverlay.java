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

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class GuiWarpOverlay extends Gui {
    private Minecraft mc;

    public GuiWarpOverlay() {
        super();

        mc = Minecraft.getMinecraft();
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent event) {
        if (event.type.equals(RenderGameOverlayEvent.ElementType.HOTBAR)) {
            drawString(mc.fontRenderer, "Hello World!", 2, 2, 0xFFFFFF);
        }
    }
}
