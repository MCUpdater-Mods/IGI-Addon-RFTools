package com.mcupdater.mods.igirftools;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "IGI|RFToolsIntegration", name = "InGameInfo RFTools Integration", version = "1.0", dependencies = "required-after:InGameInfoXML;required-after:rftools")
public class RFTools
{
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if (FMLCommonHandler.instance().getEffectiveSide() != Side.CLIENT) {
			return;
		}

		if (Loader.isModLoaded("rftools")) {
			TagRFTools.register();
		}
	}
}
