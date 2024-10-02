package onmitsu.naturalstyle.world;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import onmitsu.naturalstyle.init.NBlocks;

public class NaturalGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if(world.provider instanceof WorldProviderSurface)
			this.generateSurface(world, random, chunkX << 4, chunkZ << 4);

	}

	private void generateSurface(World world, Random random, int x, int z)
	{
		//ESSENCE
		for(int i = 0; i < 4; ++i)
		{
			int genX = x + random.nextInt(16);
			int genY = 1 + random.nextInt(40);
			int genZ = z + random.nextInt(16);
			int number = 6 + random.nextInt(3);
			new WorldGenMinable(NBlocks.NATURAL_ORE, 0, number, Blocks.stone).generate(world, random, genX, genY, genZ);
		}

		//AURORA
		for(int i = 0; i < 2; ++i)
		{
			int genX = x + random.nextInt(16);
			int genY = 1 + random.nextInt(14);
			int genZ = z + random.nextInt(16);
			int number = 2 + random.nextInt(4);
			new WorldGenMinable(NBlocks.NATURAL_ORE, 1, number, Blocks.stone).generate(world, random, genX, genY, genZ);
		}
	}
}
