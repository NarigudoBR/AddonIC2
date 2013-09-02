package _Jonathan_xD.mods.ICAddon.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class InteligentGem extends Item {

	public InteligentGem(int par1) {
		
		super(par1);
		
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg){
		this.itemIcon = reg.registerIcon("icaddon:gemInteligent");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setUnlocalizedName("gemIteligent");
	}

}
