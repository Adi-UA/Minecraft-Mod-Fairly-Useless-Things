package com.minecraftyjedi.fairlyuselessthings.world;

import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

/**
 * This class is basically a replica of the WorldGenMinable class with two main
 * differences. It is only meant to be used to spawn ore blocks in the air, and
 * this ore spawning is limited so it replaces only 1 in 10 ore blocks with a
 * vein.
 * 
 * If air ore veins are meant to occur frequently, then the constructor must be
 * passed a larger block count to compensate. Compensate in moderation; abusing
 * the air ore generation will tank performance at the time of world creation.
 * 
 * This class requires that all BlockPos coordinates passed to the generate()
 * method has Y >= 70. This has been done to keep the use of this class
 * streamlined.
 */
public class WorldGenAirOre extends WorldGenerator {

	private final IBlockState oreBlock;
	/** The number of blocks to generate. */
	private final int numberOfBlocks;
	private final Predicate<IBlockState> predicate;

	public WorldGenAirOre(IBlockState state, int blockCount) {
		this.oreBlock = state;
		this.numberOfBlocks = blockCount;
		this.predicate = new WorldGenAirOre.StonePredicate();
	}

	/**
	 * Will generate the ores in the world.
	 */
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {

		if (position.getY() > 70) {
			float f = rand.nextFloat() * (float) Math.PI;
			double d0 = position.getX() + 8
					+ MathHelper.sin(f) * this.numberOfBlocks / 8.0F;
			double d1 = position.getX() + 8
					- MathHelper.sin(f) * this.numberOfBlocks / 8.0F;
			double d2 = position.getZ() + 8
					+ MathHelper.cos(f) * this.numberOfBlocks / 8.0F;
			double d3 = position.getZ() + 8
					- MathHelper.cos(f) * this.numberOfBlocks / 8.0F;
			double d4 = position.getY() + rand.nextInt(3) - 2;
			double d5 = position.getY() + rand.nextInt(3) - 2;

			for (int i = 0; i < this.numberOfBlocks; ++i) {
				float f1 = (float) i / (float) this.numberOfBlocks;
				double d6 = d0 + (d1 - d0) * f1;
				double d7 = d4 + (d5 - d4) * f1;
				double d8 = d2 + (d3 - d2) * f1;
				double d9 = rand.nextDouble() * this.numberOfBlocks / 16.0D;
				double d10 = (MathHelper.sin((float) Math.PI * f1) + 1.0F) * d9 + 1.0D;
				double d11 = (MathHelper.sin((float) Math.PI * f1) + 1.0F) * d9 + 1.0D;
				int j = MathHelper.floor(d6 - d10 / 2.0D);
				int k = MathHelper.floor(d7 - d11 / 2.0D);
				int l = MathHelper.floor(d8 - d10 / 2.0D);
				int i1 = MathHelper.floor(d6 + d10 / 2.0D);
				int j1 = MathHelper.floor(d7 + d11 / 2.0D);
				int k1 = MathHelper.floor(d8 + d10 / 2.0D);

				for (int l1 = j; l1 <= i1; ++l1) {
					double d12 = (l1 + 0.5D - d6) / (d10 / 2.0D);

					if (d12 * d12 < 1.0D) {
						for (int i2 = k; i2 <= j1; ++i2) {
							double d13 = (i2 + 0.5D - d7) / (d11 / 2.0D);

							if (d12 * d12 + d13 * d13 < 1.0D) {
								for (int j2 = l; j2 <= k1; ++j2) {
									double d14 = (j2 + 0.5D - d8) / (d10 / 2.0D);

									if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D) {
										BlockPos blockpos = new BlockPos(l1, i2, j2);

										Random random = new Random();
										if (random.nextInt(10) > 8) {
											worldIn.setBlockState(blockpos, this.oreBlock, 2);
										}

									}
								}
							}
						}
					}
				}
			}

			return true;
		}
		return false; // This class is only meant to be used to generate ores above ground. Normal
						// usage of this class should ensure this statement is never reached
	}

	static class StonePredicate implements Predicate<IBlockState> {
		private StonePredicate() {
		}

		@Override
		public boolean apply(IBlockState p_apply_1_) {
			if (p_apply_1_ != null && p_apply_1_.getBlock() == Blocks.STONE) {
				BlockStone.EnumType blockstone$enumtype = p_apply_1_.getValue(BlockStone.VARIANT);
				return blockstone$enumtype.isNatural();
			} else {
				return false;
			}
		}
	}

}
