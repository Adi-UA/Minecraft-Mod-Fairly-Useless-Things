package com.minecraftyjedi.fairlyuselessthings.items.armor;

import com.minecraftyjedi.fairlyuselessthings.Main;
import com.minecraftyjedi.fairlyuselessthings.init.ModItems;
import com.minecraftyjedi.fairlyuselessthings.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorBase extends ItemArmor implements IHasModel {

	public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.COMBAT);

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
