package com.minecraftyjedi.fairlyuselessthings.init;

import java.util.ArrayList;
import java.util.List;

import com.minecraftyjedi.fairlyuselessthings.blocks.CurseOre;
import com.minecraftyjedi.fairlyuselessthings.blocks.HallowOre;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	
	public static final Block HALLOW_ORE_BLOCK = new HallowOre("hallow_ore_block", Material.IRON);
	public static final Block CURSE_ORE_BLOCK = new CurseOre("curse_ore_block", Material.IRON);
}
