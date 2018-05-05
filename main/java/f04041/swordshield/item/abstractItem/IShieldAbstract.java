package f04041.swordshield.item.abstractItem;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

abstract public class IShieldAbstract extends ItemShieldCore{
	private Item sword;
	private Item shield;
	public IShieldAbstract(ToolMaterial material){
		super(material);
		this.setMaxDamage(1000);
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if(entityIn instanceof EntityPlayer){
			NBTTagCompound nbtShield = stack.getTagCompound();
			EntityPlayer player=(EntityPlayer) entityIn;
			if(player.getHeldItem(EnumHand.MAIN_HAND).isEmpty()||!player.getHeldItem(EnumHand.MAIN_HAND).getItem().equals(sword)){
				if(player.getHeldItem(EnumHand.OFF_HAND).isEmpty()){
					ItemStack newStack = stack.copy();
					if(!worldIn.isRemote){
						stack.shrink(1);
						player.setHeldItem(EnumHand.OFF_HAND,newStack);
					}
				}else if(player.getHeldItem(EnumHand.OFF_HAND).equals(stack)){
					if(!worldIn.isRemote){
						delShield(stack, player);
					}
				}else if(!player.getHeldItem(EnumHand.OFF_HAND).getItem().equals(shield)){
					ItemStack offHandNow = player.getHeldItem(EnumHand.OFF_HAND);
					if(!worldIn.isRemote){
						player.setHeldItem(EnumHand.OFF_HAND,stack);
						player.inventory.setInventorySlotContents(itemSlot, offHandNow);
					}
				}
			}else{
				ItemStack swordStack=player.getHeldItem(EnumHand.MAIN_HAND);
				NBTTagCompound nbtSword=swordStack.getTagCompound();
				if(player.getHeldItem(EnumHand.OFF_HAND).equals(stack)){
					if(nbtSword.getInteger("key")!=nbtShield.getInteger("key")){
						delShield(stack, player);
					}
				}
			}
			if(stack.getItemDamage()>0){
				int dam = stack.getItemDamage();
				stack.setItemDamage(0);
				if(player.getHeldItemMainhand().getItem().equals(sword)){
					player.getHeldItemMainhand().damageItem(dam, player);
				}
			}
		}
    }
	public void delShield(ItemStack shiled,EntityPlayer player){
		NBTTagCompound nbtShield = shiled.getTagCompound();
		if(nbtShield.hasKey("inner")){
			ItemStack innerItem =new ItemStack((NBTTagCompound) nbtShield.getTag("inner"));
			player.setHeldItem(EnumHand.OFF_HAND, innerItem);
		}else{
			shiled.shrink(1);
		}
	}
	public void setSwordShield(Item sword,Item shield){
		this.sword=sword;
		this.shield=shield;
	}
	@Override
	public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem)
    {
		ItemStack shield=entityItem.getItem();
		NBTTagCompound nbtShield = shield.getTagCompound();
		if(nbtShield!=null&&nbtShield.hasKey("inner")){
			ItemStack innerItem = new ItemStack((NBTTagCompound) nbtShield.getTag("inner"));
			EntityItem inner = new EntityItem(entityItem.world,entityItem.posX,entityItem.posY,entityItem.posZ,innerItem);
			if(!entityItem.world.isRemote){
				entityItem.world.spawnEntity(inner);
			}
		}
		entityItem.setDead();
        return false;
    }
}
