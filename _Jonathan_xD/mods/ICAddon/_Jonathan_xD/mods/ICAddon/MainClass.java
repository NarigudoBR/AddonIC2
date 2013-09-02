package _Jonathan_xD.mods.ICAddon;

import _Jonathan_xD.mods.ICAddon.blocks.InteligentOre;
import _Jonathan_xD.mods.ICAddon.items.IndustrialIron;
import _Jonathan_xD.mods.ICAddon.items.InteligentGem;
import _Jonathan_xD.mods.ICAddon.tools.testwrench;
import _Jonathan_xD.mods.ICAddon.world.WorldGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
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
	public static Item gemInteligent;
	public static Block oreInteligent;
	public static int MachineID;
	public int industrialIronID;
	public static int MachineID2;
	public static int blockGeneratorID;
	public static int ICElectricID;
	int oreInteligentID;
	int gemInteligentID;
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
		oreInteligentID = config.get("block", "inteligentGemOre", 1002).getInt();
		gemInteligentID = config.get("item", "inteligentGem", 1003).getInt();
		config.save();
		industrialIron = new IndustrialIron(industrialIronID);
		gemInteligent = new InteligentGem(gemInteligentID);
		oreInteligent = new InteligentOre(oreInteligentID, Material.rock);
		
		
	}
	@EventHandler
	public void load(FMLInitializationEvent event){
		GameRegistry.registerItem(testwrench, "inteligentWrench");
		LanguageRegistry.addName(testwrench, "Inteligent Wrench");
		GameRegistry.addRecipe(new ItemStack(testwrench,1), new Object[]{"cbc","xex","xhx",'c', MainClass.industrialIron, 'e', Item.ingotGold, 'h',Block.cloth,'b',MainClass.gemInteligent});
		GameRegistry.addShapelessRecipe(new ItemStack(industrialIron,5), new Object[]{Item.coal,Item.coal,Item.coal,Item.coal,Item.ingotIron});
		OreDictionary.registerOre("ingotRefinedIron", new ItemStack (industrialIron));
		GameRegistry.registerItem(industrialIron, "industrialIron");
		LanguageRegistry.addName(industrialIron,"Industrial Iron");
		GameRegistry.registerItem(gemInteligent, "gemInteligent");
		LanguageRegistry.addName(gemInteligent, "Inteligent Gem");
		GameRegistry.registerBlock(oreInteligent, "oreInteligent");
		LanguageRegistry.addName(oreInteligent, "Inteligent Ore");
		MinecraftForge.setBlockHarvestLevel(oreInteligent, "pickaxe",2);
		GameRegistry.registerWorldGenerator(new WorldGeneration());

		
		
		
	}
	@EventHandler
	public void load(FMLPostInitializationEvent event){
		
	}
	

}
