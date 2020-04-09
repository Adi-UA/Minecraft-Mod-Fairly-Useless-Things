package com.minecraftyjedi.fairlyuselessthings.world;

import java.util.Random;

import com.minecraftyjedi.fairlyuselessthings.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

/**
 * This class is used to generate the ores for this mod in the Minecraft world.
 */
public class ModWorldGen implements IWorldGenerator {

	public ModWorldGen() {
		;
	}

	/**
	 * This method is called at the time of ore generation. It calls the functions
	 * necessary to generate this mod's ores.
	 */
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		if (world.provider.getDimension() == 0) {
			// All our ores are meant to be generated in the overworld
			this.generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}

	}

	/**
	 * This method generates the ore blocks turn by turn in the overworld by passing
	 * them into the generateOre() method with the correct parameters. If more ores
	 * are to be added, then the appropriate lines must be added to this method.
	 */
	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {

		// Needs to be generated underground, so inAir parameter is passed as false
		this.generateOre(ModBlocks.CURSE_ORE_BLOCK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 6, 30,
				random.nextInt(3) + 1, 5, false);

		// Needs to be generated in the sky, so inAir parameter is set to true
		this.generateOre(ModBlocks.HALLOW_ORE_BLOCK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 150,
				151, random.nextInt(3) + 1, 1, true);

	}

	/**
	 * 
	 * This method does the actual work of randomly generating ores in a chunk using
	 * the generator classes.
	 * 
	 * Note: The Air Ore generator has only a 1 in 10 chance of converting an air
	 * block into the ore vein (vein can be of any size). This has been done to keep
	 * performance high while the world in generated, so if you want an ore to spawn
	 * frequently, compensate for it using the chances and size parameters.
	 * Compensate in moderation; abusing the air ore generation will tank
	 * performance at the time of world creation.
	 * 
	 * @param ore     - The block state for the ore block we want to generate
	 * @param world   - The current world
	 * @param x       - The current x coordinates (chunk no.*16)
	 * @param z       - The current y coordinates (chunk no.*16)
	 * @param minY    - The lowest height at which the ore should spawn
	 * @param maxY    - The max height at which the ore should spawn
	 * @param size    - The number of ores in a vein
	 * @param chances - Frequency of occurrence within a chunk
	 * @param inAir   - true if this should generate in the air and false for normal
	 *                underground generation
	 */
	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size,
			int chances, boolean inAir) {

		int deltaY = maxY - minY;

		for (int i = 0; i < chances; i++) {
			BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

			WorldGenerator generator;
			if (inAir) {
				generator = new WorldGenAirOre(ore, size);
			} else {
				generator = new WorldGenMinable(ore, size);
			}
			generator.generate(world, random, pos);
		}

	}

}
