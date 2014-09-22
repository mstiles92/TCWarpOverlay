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

package com.mstiles92.tcwarpoverlay.proxy;

import com.mstiles92.tcwarpoverlay.gui.GuiWarpOverlay;
import com.mstiles92.tcwarpoverlay.keybindings.KeyBindings;
import com.mstiles92.tcwarpoverlay.keybindings.KeyInputEventHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerOverlayRenderer() {
        MinecraftForge.EVENT_BUS.register(new GuiWarpOverlay());
    }

    @Override
    public void registerEventHandlers() {
        super.registerEventHandlers();

        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
    }

    @Override
    public void registerKeyBindings() {
        ClientRegistry.registerKeyBinding(KeyBindings.toggleWarpOverlay);
    }
}
