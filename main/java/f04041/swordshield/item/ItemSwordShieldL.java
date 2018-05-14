package f04041.swordshield.item;

import f04041.swordshield.item.abstractItem.ISwordAbstract;

public class ItemSwordShieldL extends ISwordAbstract{
	public ItemSwordShieldL(ToolMaterial material) {
		super(material,-3.2D,false,3.5D);
		setAtackDam(16.0F + ToolMaterial.DIAMOND.getAttackDamage());
	}
	@Override
	public int getItemEnchantability()
	{
		return ToolMaterial.GOLD.getEnchantability();
	}
}
