package f04041.swordshield.item;

import f04041.swordshield.item.abstractItem.ISwordAbstract;

public class ItemSwordShieldM extends ISwordAbstract{
	public ItemSwordShieldM(ToolMaterial material) {
		super(material,-2.4000000953674316D);
		setAtackDam(4.0F + ToolMaterial.DIAMOND.getAttackDamage());
	}
	@Override
	public int getItemEnchantability()
    {
        return ToolMaterial.DIAMOND.getEnchantability();
    }
}
