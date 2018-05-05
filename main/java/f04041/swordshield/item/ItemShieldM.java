package f04041.swordshield.item;

import f04041.swordshield.item.abstractItem.IShieldAbstract;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemShieldM extends IShieldAbstract{

	public ItemShieldM(ToolMaterial material) {
		super(material,0.4F);
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if(entityIn instanceof EntityPlayer){
			EntityPlayer player=(EntityPlayer)entityIn;
			if(player != null && player.isHandActive() && player.getActiveItemStack() == stack){
				this.setProjectileReflect(true);
			}else{
				this.setProjectileReflect(false);
			}
		}
    }
}
