package com.mcupdater.mods.igirftools;

import com.github.lunatrius.ingameinfo.tag.TagIntegration;
import com.github.lunatrius.ingameinfo.tag.registry.TagRegistry;
import mcjty.rftools.dimension.DimensionInformation;
import mcjty.rftools.dimension.DimensionStorage;
import mcjty.rftools.dimension.RfToolsDimensionManager;

public abstract class TagRFTools extends TagIntegration
{
	@Override
	public String getCategory() {
		return "rftools";
	}

	public static class RFToolsDimension extends TagRFTools {
		@Override
		public String getValue() {
			try {
				int id = player.worldObj.provider.dimensionId;
				RfToolsDimensionManager dimensionManager = RfToolsDimensionManager.getDimensionManager(player.worldObj);
				DimensionInformation dimensionInformation = dimensionManager.getDimensionInformation(id);
				return String.valueOf(dimensionInformation != null);
			} catch (Throwable e) {
				log(this, e);
			}
			return String.valueOf(false);
		}
	}

	public static class RFToolsDimPower extends TagRFTools {
		@Override
		public String getValue() {
			try {
				int id = player.worldObj.provider.dimensionId;
				RfToolsDimensionManager dimensionManager = RfToolsDimensionManager.getDimensionManager(player.worldObj);
				DimensionInformation dimensionInformation = dimensionManager.getDimensionInformation(id);
				if (dimensionInformation == null) {
					return "N/A";
				} else {
					DimensionStorage storage = DimensionStorage.getDimensionStorage(player.getEntityWorld());
					int power = storage != null ? storage.getEnergyLevel(id) : 0;
					return String.valueOf(power);
				}
			} catch (Throwable e) {
				log(this, e);
			}
			return String.valueOf(false);
		}
	}

	public static class RFToolsDimName extends TagRFTools {
		@Override
		public String getValue() {
			try {
				int id = player.worldObj.provider.dimensionId;
				RfToolsDimensionManager dimensionManager = RfToolsDimensionManager.getDimensionManager(player.worldObj);
				DimensionInformation dimensionInformation = dimensionManager.getDimensionInformation(id);
				if (dimensionInformation == null) {
					return "N/A";
				} else {
					return dimensionInformation.getName();
				}
			} catch (Throwable e) {
				log(this, e);
			}
			return String.valueOf(false);
		}
	}

	public static class RFToolsDimCost extends TagRFTools {
		@Override
		public String getValue() {
			try {
				int id = player.worldObj.provider.dimensionId;
				RfToolsDimensionManager dimensionManager = RfToolsDimensionManager.getDimensionManager(player.worldObj);
				DimensionInformation dimensionInformation = dimensionManager.getDimensionInformation(id);
				if (dimensionInformation == null) {
					return "N/A";
				} else {
					return String.valueOf(dimensionInformation.getActualRfCost());
				}
			} catch (Throwable e) {
				log(this, e);
			}
			return String.valueOf(false);
		}
	}

	public static void register() {
		TagRegistry.INSTANCE.register(new RFToolsDimension().setName("rftdimension"));
		TagRegistry.INSTANCE.register(new RFToolsDimName().setName("rftdimensionname"));
		TagRegistry.INSTANCE.register(new RFToolsDimPower().setName("rftdimensionpower"));
		TagRegistry.INSTANCE.register(new RFToolsDimCost().setName("rftdimensioncost"));
	}
}
