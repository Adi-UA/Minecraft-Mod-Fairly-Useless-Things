package com.minecraftyjedi.fairlyuselessthings.blocks;

import com.minecraftyjedi.fairlyuselessthings.Main;
import com.minecraftyjedi.fairlyuselessthings.init.ModBlocks;
import com.minecraftyjedi.fairlyuselessthings.init.ModItems;
import com.minecraftyjedi.fairlyuselessthings.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

/**
 * This class represents a basic template block which can be used for this mod.
 * It is not very specific, so extending this class while making unique blocks
 * is the ideal approach.
 */
public class BlockBase extends Block implements IHasModel {

	public BlockBase(String name, Material material) {
		super(material);

		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName())); // All Blocks have Item
																							// counterparts

	}

	/**
	 * This method is called at the time of model registration to tell the client
	 * about this block's textures.
	 */
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

	}

}
