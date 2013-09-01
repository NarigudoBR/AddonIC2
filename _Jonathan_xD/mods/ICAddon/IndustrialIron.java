package _Jonathan_xD.mods.ICAddon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class IndustrialIron extends Item {

	public IndustrialIron(int industrialIronID) {
		super(industrialIronID);
		
		
		
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg)
	{
		this.itemIcon = reg.registerIcon("icaddon:testwrench");
		this.setUnlocalizedName("testwrench");
	}

}
