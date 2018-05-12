package f04041.swordshield.utils;

import f04041.swordshield.item.ItemShieldM;
import f04041.swordshield.item.ItemShieldS;
import f04041.swordshield.item.ItemSwordShieldM;
import f04041.swordshield.item.ItemSwordShieldS;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public class ItemUtil {
	public static Item sShieldS;
	public static Item sSwordS;
	public static Item sShieldM;
	public static Item sSwordM;
	public static void init(){
		sSwordS=new ItemSwordShieldS(ToolMaterial.STONE)
				.setUnlocalizedName("f0_ss.sswords")
				.setRegistryName("f0_ss.sswords")
				.setMaxStackSize(1)
				.setCreativeTab(CreativeTabs.COMBAT);
		sShieldS = new ItemShieldS(ToolMaterial.STONE)
				.setUnlocalizedName("f0_ss.sshields")
				.setRegistryName("f0_ss.sshields")
				.setMaxStackSize(1);
		sSwordM = new ItemSwordShieldM(ToolMaterial.IRON)
				.setUnlocalizedName("f0_ss.sswordm")
				.setRegistryName("f0_ss.sswordm")
				.setMaxStackSize(1)
				.setCreativeTab(CreativeTabs.COMBAT);
		sShieldM = new ItemShieldM(ToolMaterial.IRON)
				.setUnlocalizedName("f0_ss.sshieldm")
				.setRegistryName("f0_ss.sshieldm")
				.setMaxStackSize(1);
		((ItemSwordShieldS)sSwordS).setShield(sShieldS);
		((ItemShieldS)sShieldS).setSwordShield(sSwordS, sShieldS);
		((ItemSwordShieldM)sSwordM).setShield(sShieldM);
		((ItemShieldM)sShieldM).setSwordShield(sSwordM, sShieldM);
	}
}
