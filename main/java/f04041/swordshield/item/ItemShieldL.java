package f04041.swordshield.item;

import f04041.swordshield.item.abstractItem.IShieldAbstract;
import f04041.swordshield.main.uuid.UuidStore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemShieldL extends IShieldAbstract{
	public ItemShieldL(ToolMaterial material) {
		super(material,0.2F);
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
	{
		if(entityIn instanceof EntityPlayer){
			EntityPlayer player=(EntityPlayer)entityIn;
			IAttributeInstance attributeInstanceKB = player.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
			if(player.getHeldItemOffhand().equals(stack)) {
				if(attributeInstanceKB.getModifier(UuidStore.UUID_K)==null) {
					attributeInstanceKB.applyModifier(new AttributeModifier(UuidStore.UUID_K, "knockback registance",1.0D, 0));
				}
				setProjectileReflect(stack, true);
			}else {
				if(attributeInstanceKB.getModifier(UuidStore.UUID_K)!=null) {
					attributeInstanceKB.removeModifier(UuidStore.UUID_K);
				}
				setProjectileReflect(stack, false);
			}
			IAttributeInstance attributeInstanceMSS = player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
			if(player != null && player.isHandActive() && player.getActiveItemStack() .equals(player.getHeldItemOffhand()) ) {
				if(attributeInstanceMSS.getModifier(UuidStore.UUID_MSS)!=null) {
					attributeInstanceMSS.removeModifier(UuidStore.UUID_MSS);
				}
			}else {
				if(attributeInstanceMSS.getModifier(UuidStore.UUID_MSS)==null) {
					attributeInstanceMSS.applyModifier(new AttributeModifier(UuidStore.UUID_MSS, "speed down",-0.07D, 0));
				}
			}
		}
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}
}
