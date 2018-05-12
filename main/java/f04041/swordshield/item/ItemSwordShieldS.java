package f04041.swordshield.item;

import f04041.swordshield.item.abstractItem.ISwordAbstract;

public class ItemSwordShieldS extends ISwordAbstract{
	public ItemSwordShieldS(ToolMaterial material) {
		super(material, 1.0D,true,0.0D);
		setAtackDam(3.0F + ToolMaterial.STONE.getAttackDamage());
	}
	@Override
	public int getItemEnchantability()
	{
		return ToolMaterial.IRON.getEnchantability();
	}
}
