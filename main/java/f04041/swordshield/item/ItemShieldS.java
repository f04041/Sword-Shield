package f04041.swordshield.item;

import f04041.swordshield.item.abstractItem.IShieldAbstract;
import f04041.swordshield.main.uuid.UuidStore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemShieldS extends IShieldAbstract{

	public ItemShieldS(ToolMaterial material) {
		super(material, 0.6F);
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(entityIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entityIn;
			NBTTagCompound nbtShield = stack.getTagCompound();
			if(!nbtShield.hasKey("reflect")||nbtShield.getBoolean("reflect")){
				super.setProjectileReflect(stack, false);
			}
			IAttributeInstance attributeInstanceMSF = player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
			if(player != null && player.isHandActive() && player.getActiveItemStack() .equals(player.getHeldItemOffhand()) ) {
				if(attributeInstanceMSF.getModifier(UuidStore.UUID_MSF)==null) {
					attributeInstanceMSF.applyModifier(new AttributeModifier(UuidStore.UUID_MSF, "speed boost",0.5D, 0));
				}
			}else {
				if(attributeInstanceMSF.getModifier(UuidStore.UUID_MSF)!=null) {
					attributeInstanceMSF.removeModifier(UuidStore.UUID_MSF);
				}
			}
		}
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}

}
