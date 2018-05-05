package f04041.swordshield.utils;

import f04041.swordshield.item.ItemShieldM;
import f04041.swordshield.item.ItemSwordShieldM;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public class ItemUtil {
	public static Item sShieldM;
	public static Item sSwordM;
	public static void init(){
		sSwordM = new ItemSwordShieldM(ToolMaterial.IRON)
				.setUnlocalizedName("f0_ss.sswordm")
				.setRegistryName("f0_ss.sswordm")
				.setMaxStackSize(1)
				.setCreativeTab(CreativeTabs.COMBAT);
		sShieldM = new ItemShieldM(ToolMaterial.IRON)
				.setUnlocalizedName("f0_ss.sshieldm")
				.setRegistryName("f0_ss.sshieldm")
				.setMaxStackSize(1);
		((ItemSwordShieldM)sSwordM).setShield(sShieldM);
		((ItemShieldM)sShieldM).setSwordShield(sSwordM, sShieldM);
	}
}
