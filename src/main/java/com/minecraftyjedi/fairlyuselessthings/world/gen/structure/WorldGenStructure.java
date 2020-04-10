package com.minecraftyjedi.fairlyuselessthings.world.gen.structure;

import java.util.Random;

import com.minecraftyjedi.fairlyuselessthings.util.IStructure;
import com.minecraftyjedi.fairlyuselessthings.util.Reference;

import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

/**
 * This class generates structures from .nbt files. The name passed into the
 * construuctor must match the name of the .nbt representing the structure.
 *
 */
public class WorldGenStructure extends WorldGenerator implements IStructure {

	public String structureName;

	/**
	 * Constructor
	 * 
	 * @param name - The name of the structure as used in the nbt filename.
	 */
	public WorldGenStructure(String name) {

		this.structureName = name;
	}

	/**
	 * This method generates the structure stored in the current instance in the
	 * world.
	 */
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		this.generateStructure(worldIn, position);
		return true;
	}

	/**
	 * This method does the actual work of locating the .nbt file and then using
	 * that to add the blocks for that structure into the world.
	 */
	public void generateStructure(World world, BlockPos pos) {

		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager tempManager = WORLD_SERVER.getStructureTemplateManager();
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, structureName);
		Template template = tempManager.get(mcServer, location);

		if (template != null) {
			IBlockState state = world.getBlockState(pos);
			world.notifyBlockUpdate(pos, state, state, 3);
			template.addBlocksToWorldChunk(world, pos, SETTINGS);
		}
	}

}
