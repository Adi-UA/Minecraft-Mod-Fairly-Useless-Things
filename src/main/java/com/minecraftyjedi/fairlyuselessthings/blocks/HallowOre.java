package com.minecraftyjedi.fairlyuselessthings.blocks;

import java.util.Random;

import com.minecraftyjedi.fairlyuselessthings.Main;
import com.minecraftyjedi.fairlyuselessthings.init.ModBlocks;
import com.minecraftyjedi.fairlyuselessthings.init.ModItems;
import com.minecraftyjedi.fairlyuselessthings.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class HallowOre extends Block implements IHasModel {

	public HallowOre(String name, Material material) {
		super(material);

		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

	}
	
	@Override
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 2;
    }
	
	@Override
    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ModItems.HALLOW_INGOT;
    }

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}

}
