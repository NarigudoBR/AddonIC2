package _Jonathan_xD.mods.ICAddon.world;

import java.util.Random;

import _Jonathan_xD.mods.ICAddon.MainClass;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import cpw.mods.fml.common.IWorldGenerator;


public class WorldGeneration implements IWorldGenerator{
	 
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
                    IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
            switch(world.provider.dimensionId){
           
            case 1:
                    generateNether(world, random, chunkX *16, chunkZ *16);
                   
            case 0:
                    generateSurface(world, random, chunkX *16, chunkZ *16);
                   
            case -1:
                    generateEnd(world, random, chunkX *16, chunkZ *16);
                   
            }
           
    }

    private void generateNether(World world, Random random, int chunkX, int chunkZ)
    {
           
    }
    private void generateSurface(World world, Random random, int chunkX, int chunkZ)
    {
            for(int i = 0; i < 15; i++){
                    int xCoord = chunkX + random.nextInt(4);
                    int yCoord = random.nextInt(12);
                    int zCoord = chunkZ + random.nextInt(4);
                   
                    (new WorldGenMinable(MainClass.oreInteligent.blockID, 5)).generate(world, random, xCoord, yCoord, zCoord);
            }
            
    }
    private void generateEnd(World world, Random random, int chunkX, int chunkZ)
    {
           
    }
}

