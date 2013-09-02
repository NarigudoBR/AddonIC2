package _Jonathan_xD.mods.ICAddon.tools;

import _Jonathan_xD.mods.ICAddon.MainClass;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.Configuration;
public class testwrench extends Item {
	public static TileEntity BlockClicked;
	public static int BlockIDDrop;
	public static int BlockIDDropMetadata;
	public testwrench(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		
		BlockClicked = par3World.getBlockTileEntity(par4, par5, par6);
		BlockIDDrop = par3World.getBlockId(par4, par5, par6);
		BlockIDDropMetadata = par3World.getBlockMetadata(par4, par5, par6);
		//par2EntityPlayer.dropItem(BlockIDDrop, 0);
		if(BlockIDDrop == MainClass.MachineID || BlockIDDrop == MainClass.MachineID2 || BlockIDDrop == MainClass.blockGeneratorID || BlockIDDrop == MainClass.ICElectricID)
		{			
			if(par2EntityPlayer.inventory.getFirstEmptyStack() != -1 || par2EntityPlayer.inventory.hasItemStack(new ItemStack(Block.blocksList[BlockIDDrop],1,BlockIDDropMetadata)) == true)
			{
				par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Block.blocksList[BlockIDDrop],1,BlockIDDropMetadata));
				//par3World.removeBlockTileEntity(par4, par5, par6);
			}
			else
			{
				par2EntityPlayer.dropPlayerItem(new ItemStack(Block.blocksList[BlockIDDrop],1,BlockIDDropMetadata));
			}
			par3World.setBlock(par4, par5, par6, 0);		
		}
		return true;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg)
	{
		this.itemIcon = reg.registerIcon("icaddon:testwrench");
		this.setUnlocalizedName("testwrench");
	}
}
