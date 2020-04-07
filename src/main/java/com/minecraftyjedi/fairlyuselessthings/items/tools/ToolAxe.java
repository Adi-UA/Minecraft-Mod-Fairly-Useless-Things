package com.minecraftyjedi.fairlyuselessthings.items.tools;

import com.minecraftyjedi.fairlyuselessthings.Main;
import com.minecraftyjedi.fairlyuselessthings.init.ModItems;
import com.minecraftyjedi.fairlyuselessthings.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

/**
 * This class represents a basic axe which can be used for this mod. It is not
 * very specific, so extending this class while making unique axes is the ideal
 * approach.
 */
public class ToolAxe extends ItemAxe implements IHasModel {
	public ToolAxe(String name, ToolMaterial material) {

		super(material, 6.0F, -3.2F);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.TOOLS);

		ModItems.ITEMS.add(this);
	}

	/**
	 * This method is called at the time of model registration to tell the client
	 * about this block's textures.
	 */
	@Override
	public void registerModels() {

		Main.proxy.registerItemRenderer(this, 0, "inventory");

	}

}
