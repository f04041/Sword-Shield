package f04041.swordshield.main;

import f04041.swordshield.main.recipe.CraftingRecipe;
import f04041.swordshield.utils.ItemUtil;
import f04041.swordshield.utils.ModelRegistrationUtil;
import f04041.swordshield.utils.RegistrationUtil;
import net.minecraft.item.Item;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "f0_ss",
	name = "Sword&Shield",
	version = "1.0.0",
	dependencies = "required-after:forge",
	acceptedMinecraftVersions = "[1.12,1.12.2]",
	useMetadata = true)
public class SwordShield {
	private CommonProxy proxy= new CommonProxy();
	public final static String MOD_ID = "f0_ss";
	private static final NonNullList<Item> ITEMS = NonNullList.create();
	@Mod.Instance("f0_ss")
	public static SwordShield instance;
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ItemUtil.init();
		MinecraftForge.EVENT_BUS.register(new RegistrationUtil());
		if(event.getSide().isClient()){
			MinecraftForge.EVENT_BUS.register(new ModelRegistrationUtil());
		}
		 MinecraftForge.EVENT_BUS.register(new CraftingRecipe());
	}
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.loadInit();
	}
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){

	}
}
