package _Jonathan_xD.mods.ICAddon;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "ICAddon",version = "v1.0",name = "ICAddon")
@NetworkMod(clientSideRequired = true,serverSideRequired = false)

public class MainClass {
	@Instance
	public static MainClass instance;

	public int IDTW; 
	public static Item testwrench;
	public static Item industrialIron;
	public static int MachineID;
	public static int industrialIronID;
	public static int MachineID2;
	public static int blockGeneratorID;
	public static int ICElectricID;
	//blocks section
	//creativeTabs section 
	//tools section
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		IDTW =  config.get("ItemIDs", "Wrench",1100).getInt();
		testwrench = new testwrench(IDTW).setMaxDamage(100).setMaxStackSize(1);
		MachineID =  config.get("block", "ICMachine", 250).getInt();		
		MachineID2 = config.get("block", "ICMachine2", 223).getInt();
		blockGeneratorID = config.get("block", "ICblockGenerator", 246).getInt();
		ICElectricID = config.get("block", "ICblockElectric", 227).getInt();
		industrialIronID = config.get("ItemIDs", "IndustrialIron", 1001).getInt();
		config.save();
		industrialIron = new IndustrialIron(industrialIronID);
		
		
	}
	@EventHandler
	public void load(FMLInitializationEvent event){
		GameRegistry.registerItem(testwrench, "testwrench");
		LanguageRegistry.addName(testwrench, "testwrench");
		GameRegistry.addRecipe(new ItemStack(testwrench,1), new Object[]{"axc","xex","xhx",'a', Item.ingotIron, 'c', Item.ingotIron, 'e', Item.ingotGold, 'h',Block.cloth});
		GameRegistry.addShapelessRecipe(new ItemStack(industrialIron), new Object[]{Item.coal,Item.coal,Item.coal,Item.ingotIron});
		OreDictionary.registerOre("ingotRefinedIron", new ItemStack (industrialIron));

		
		
		
	}
	@EventHandler
	public void load(FMLPostInitializationEvent event){
		
	}
	

}
