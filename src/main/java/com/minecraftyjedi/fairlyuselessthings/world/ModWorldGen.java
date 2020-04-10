package com.minecraftyjedi.fairlyuselessthings.world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.minecraftyjedi.fairlyuselessthings.init.ModBlocks;
import com.minecraftyjedi.fairlyuselessthings.world.gen.structure.WorldGenStructure;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeBeach;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.biome.BiomeRiver;
import net.minecraft.world.biome.BiomeSnow;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

/**
 * This class is used to generate the ores and structures for this mod in the
 * Minecraft world.
 */
public class ModWorldGen implements IWorldGenerator {

	public static final WorldGenStructure SHRINE = new WorldGenStructure("shrine");
	public static final WorldGenStructure CURSED_ALTAR = new WorldGenStructure("cursed_altar");
	public static final WorldGenStructure STAR = new WorldGenStructure("star");

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
	 * This method generates the ore blocks and structures turn by turn in the
	 * overworld
	 */
	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {

		// Needs to be generated underground, so inAir parameter is passed as false
		this.generateOre(ModBlocks.CURSE_ORE_BLOCK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 6, 30,
				random.nextInt(3) + 1, 5);

		// Generate Structures
		this.generateStructure(SHRINE, world, random, chunkX * 16, chunkZ * 16, 150, 155, 250, BiomeDesert.class,
				BiomePlains.class, BiomeOcean.class);
		this.generateStructure(STAR, world, random, chunkX * 16, chunkZ * 16, 150, 155, 135, BiomeDesert.class,
				BiomePlains.class, BiomeOcean.class, BiomeBeach.class);
		this.generateStructure(CURSED_ALTAR, world, random, chunkX * 16, chunkZ * 16, 6, 30, 230, BiomeDesert.class,
				BiomePlains.class, BiomeOcean.class, BiomeRiver.class, BiomeSnow.class);

	}

	/**
	 * 
	 * This method does the actual work of randomly generating ores in a chunk using
	 * the WorldGenMineable classes.
	 * 
	 * @param ore     - The block state for the ore block we want to generate
	 * @param world   - The current world
	 * @param x       - The current x coordinates (chunk no.*16)
	 * @param z       - The current y coordinates (chunk no.*16)
	 * @param minY    - The lowest height at which the ore should spawn
	 * @param maxY    - The max height at which the ore should spawn
	 * @param size    - The number of ores in a vein
	 * @param chances - Frequency of occurrence within a chunk
	 */
	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size,
			int chances) {

		int deltaY = maxY - minY;

		for (int i = 0; i < chances; i++) {
			BlockPos pos = new BlockPos(x + random.nextInt(15), minY + random.nextInt(deltaY), z + random.nextInt(15));

			WorldGenMinable generator = new WorldGenMinable(ore, size);
			generator.generate(world, random, pos);
		}

	}

	/**
	 * This method generates the structure inside the generator parameter at the
	 * coordinates passed to it.
	 * 
	 * @param generator
	 * @param world     - The current world
	 * @param x         - The current x coordinates (chunk no.*16)
	 * @param z         - The current y coordinates (chunk no.*16)
	 * @param minY      - The lowest height at which the structure should spawn
	 * @param maxY      - The max height at which the structure should spawn
	 * @param rarity    - Rarity of spawn. Higher value means more rare.
	 * @param classes   - The biome classes in which the structure should generate.
	 */
	private void generateStructure(WorldGenerator generator, World world, Random random, int x, int z, int minY,
			int maxY, int rarity, Class<?>... classes) {

		List<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));

		// Select random coordinates in the current chunk
		int deltaY = maxY - minY;
		BlockPos pos = new BlockPos(x + random.nextInt(15), minY + random.nextInt(deltaY), z + random.nextInt(15));

		// Perform checks and add structure
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();

		if (world.getWorldType() != WorldType.FLAT) {
			if (classesList.contains(biome)) {

				if (random.nextInt(rarity) == 0) {
					generator.generate(world, random, pos);
				}
			}

		}

	}

}
