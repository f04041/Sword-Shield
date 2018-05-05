package f04041.swordshield.main.recipe;

import f04041.swordshield.utils.ItemUtil;
import net.minecraft.init.Blocks;
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
		registry.register(new ShapedOreRecipe(ItemUtil.sSwordM.getRegistryName(), new ItemStack(ItemUtil.sSwordM,1),
				"BII",
				"DSI",
				"LII",
				'S',new ItemStack(Items.SHIELD),
				'I',new ItemStack(Items.IRON_INGOT),
				'B',new ItemStack(Items.IRON_SWORD),
				'D',new ItemStack(Items.DIAMOND),
				'L',new ItemStack(Blocks.LAPIS_BLOCK)).setRegistryName(ItemUtil.sSwordM.getRegistryName()));
	}
}
