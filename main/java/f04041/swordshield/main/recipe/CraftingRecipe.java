package f04041.swordshield.main.recipe;

import f04041.swordshield.utils.ItemUtil;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.registries.IForgeRegistry;

public class CraftingRecipe {
	@SubscribeEvent
	public void registerRecipe(RegistryEvent.Register<IRecipe> event){
		IForgeRegistry<IRecipe> registry = event.getRegistry();
		registry.register(new ShapedOreRecipe(ItemUtil.sSwordS.getRegistryName(), new ItemStack(ItemUtil.sSwordS,1),
				"AWW",
				"LSW",
				"GWW",
				'S',new ItemStack(Items.SHIELD),
				'W',"plankWood",
				'A',new ItemStack(Items.STONE_AXE),
				'L',"leather",
				'G',"ingotGold").setRegistryName(ItemUtil.sSwordS.getRegistryName()));

		registry.register(new ShapedOreRecipe(ItemUtil.sSwordM.getRegistryName(), new ItemStack(ItemUtil.sSwordM,1),
				"BII",
				"DSI",
				"LII",
				'S',new ItemStack(Items.SHIELD),
				'I',"ingotIron",
				'B',new ItemStack(Items.IRON_SWORD),
				'D',"gemDiamond",
				'L',"blockLapis").setRegistryName(ItemUtil.sSwordM.getRegistryName()));

		registry.register(new ShapedOreRecipe(ItemUtil.sSwordL.getRegistryName(), new ItemStack(ItemUtil.sSwordL,1),
				"BDD",
				"ESD",
				"RDD",
				'S',new ItemStack(Items.SHIELD),
				'E',"gemEmerald",
				'B',new ItemStack(Items.DIAMOND_SWORD),
				'D',"gemDiamond",
				'R',"blockRedstone").setRegistryName(ItemUtil.sSwordL.getRegistryName()));
	}

}
