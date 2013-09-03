package _Jonathan_xD.mods.ICAddon;

import java.io.File;

import _Jonathan_xD.mods.ICAddon.blocks.InteligentOre;
import _Jonathan_xD.mods.ICAddon.items.IndustrialIron;
import _Jonathan_xD.mods.ICAddon.items.InteligentGem;
import _Jonathan_xD.mods.ICAddon.tools.inteligentWrench;
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

@Mod(modid = "inteligentTools",version = "v1.0",name = "Inteligent Tools")
@NetworkMod(clientSideRequired = true,serverSideRequired = false)

public class MainClass {
	@Instance
	public static MainClass instance;

	public int inteligentWrenchID; 
	public static Item inteligentWrench;
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
	public static int Cables;
	//blocks section
	//creativeTabs section 
	//tools section
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		inteligentWrenchID =  config.get("ItemIDs", "Wrench",1005).getInt();		
		MachineID =  config.get("block", "ICMachine", 250).getInt();		
		MachineID2 = config.get("block", "ICMachine2", 223).getInt();
		blockGeneratorID = config.get("block", "ICblockGenerator", 246).getInt();
		ICElectricID = config.get("block", "ICblockElectric", 227).getInt();
		industrialIronID = config.get("ItemIDs", "IndustrialIron", 1001).getInt();
		oreInteligentID = config.get("block", "inteligentGemOre", 1002).getInt();
		gemInteligentID = config.get("item", "inteligentGem", 1003).getInt();
		config.save();
		Configuration configIC = new Configuration(new File("config/IC2.cfg"));
		configIC.load();
		MachineID =  configIC.get("block", "blockMachine", 250).getInt();		
		MachineID2 = configIC.get("block", "blockMachine2", 223).getInt();
		blockGeneratorID = configIC.get("block", "blockGenerator", 246).getInt();
		ICElectricID = configIC.get("block", "blockElectric", 227).getInt();
		Cables = configIC.get("block", "blockCable", 228).getInt();
		configIC.save();
		industrialIron = new IndustrialIron(industrialIronID);
		gemInteligent = new InteligentGem(gemInteligentID);
		oreInteligent = new InteligentOre(oreInteligentID, Material.rock);
		inteligentWrench = new inteligentWrench(inteligentWrenchID).setMaxDamage(100).setMaxStackSize(1);
		
		
	}
	@EventHandler
	public void load(FMLInitializationEvent event){
		GameRegistry.registerItem(inteligentWrench, "inteligentWrench");
		LanguageRegistry.addName(inteligentWrench, "Inteligent Wrench");
		GameRegistry.addRecipe(new ItemStack(inteligentWrench,1), new Object[]{"cbc","xex","xhx",'c', MainClass.industrialIron, 'e', Item.ingotGold, 'h',Block.cloth,'b',MainClass.gemInteligent});
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
