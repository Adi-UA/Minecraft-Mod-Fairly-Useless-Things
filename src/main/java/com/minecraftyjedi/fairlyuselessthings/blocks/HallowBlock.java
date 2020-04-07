package com.minecraftyjedi.fairlyuselessthings.blocks;

import java.util.Random;

import com.minecraftyjedi.fairlyuselessthings.util.IHasModel;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class HallowBlock extends BlockBase implements IHasModel {

	public HallowBlock(String name, Material material) {
		super(name, material);
		this.setSoundType(SoundType.GLASS);
		this.setHardness(50F);
		this.setResistance(9000);
		this.setHarvestLevel("pickaxe", 3);
		this.setLightLevel(1.0F);
	}

	@Override
	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random random) {
		return 1;
	}

	@Override
	/**
	 * Get the Item that this Block should drop when harvested.
	 */
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

}
