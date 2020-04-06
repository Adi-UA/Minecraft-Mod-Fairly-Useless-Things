package com.minecraftyjedi.fairlyuselessthings.items;

import com.minecraftyjedi.fairlyuselessthings.Main;
import com.minecraftyjedi.fairlyuselessthings.init.ModItems;
import com.minecraftyjedi.fairlyuselessthings.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name) {
		
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.MATERIALS);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this,0,"inventory");

	}

}
