package _Jonathan_xD.mods.ICAddon.blocks;

import java.util.Random;

import _Jonathan_xD.mods.ICAddon.MainClass;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class InteligentOre extends Block {

	public InteligentOre(int par1, Material par2Material) {
		super(par1, par2Material);
		
	}
	 public int idDropped(int par1, Random par2Random, int par3)
     {
     return MainClass.gemInteligent.itemID;
     }
     public int quantityDropped(Random random)
     {
             return 1;
     }
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg){
		this.blockIcon = reg.registerIcon("icaddon:inteligentOre");
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

}
