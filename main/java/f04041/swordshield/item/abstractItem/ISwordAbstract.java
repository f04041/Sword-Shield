package f04041.swordshield.item.abstractItem;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

abstract public class ISwordAbstract extends ItemSword{
	private Item shield;
	private Random rand=new Random();
	private int key=0;
	private float attackDamage;
	private double attackSpeed=-2.4000000953674316D;
	public ISwordAbstract(ToolMaterial material,double attackSpeed)
    {
        super(material);
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses()+500);
        this.attackSpeed=attackSpeed;
        this.addPropertyOverride(new ResourceLocation("hand"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.getHeldItemMainhand() == stack ? 1.0F : 0.0F;
            }
        });
    }
	public void setAtackDam(float dam){
		this.attackDamage=dam;
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		work(stack,worldIn,entityIn);
    }
	public void setShield(Item shield){
		this.shield=shield;
	}
	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = HashMultimap.<String, AttributeModifier>create();

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", attackSpeed, 0));
        }

        return multimap;
    }
	public void work(ItemStack stack, World worldIn, Entity entityIn){
		if(entityIn instanceof EntityPlayer){
			EntityPlayer player=(EntityPlayer) entityIn;
			NBTTagCompound nbtSword=stack.getTagCompound();//メインハンドのアイテムに持たせるkey要素
			if(nbtSword==null){
				nbtSword=new NBTTagCompound();
				stack.setTagCompound(nbtSword);
				nbtSword.setInteger("key", 1);
			}else if(!nbtSword.hasKey("key")){
				nbtSword.setInteger("key", 1);
			}
			if(stack.equals(player.getHeldItem(EnumHand.MAIN_HAND))){
				if(player.getHeldItem(EnumHand.OFF_HAND).isEmpty()){
					ItemStack shieldStack = new ItemStack(shield);
					NBTTagCompound nbtShield= shieldStack.getTagCompound();//サブハンドのアイテムに持たせるkey要素
					do{
						key=rand.nextInt(6000);
					}while(key==0||key==1);
					player.setHeldItem(EnumHand.OFF_HAND,shieldStack);
					nbtShield=new NBTTagCompound();
					shieldStack.setTagCompound(nbtShield);
					nbtSword.setInteger("key", key);
					nbtShield.setInteger("key", key);
					int unbreaking = EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(34), stack);
					if(unbreaking>0){
						shieldStack.addEnchantment(Enchantment.getEnchantmentByID(34), unbreaking);
					}
				}else if(!player.getHeldItem(EnumHand.OFF_HAND).getItem().equals(shield)){
					ItemStack subHandStack =new ItemStack(shield);
					ItemStack innerItemStack=player.getHeldItem(EnumHand.OFF_HAND);
					NBTTagCompound innerItem =new NBTTagCompound();
					NBTTagList innerItemNbtList = new NBTTagList();
					NBTTagCompound innerItemNbt = new NBTTagCompound();
					innerItemStack.writeToNBT(innerItemNbt);
					innerItemNbtList.appendTag(innerItemNbt);
					innerItem.setTag("inner", innerItemNbt);
					player.setHeldItem(EnumHand.OFF_HAND,subHandStack);
					subHandStack.setTagCompound(innerItem);
					do{
						key=rand.nextInt(6000);
					}while(key==0||key==1);
					nbtSword.setInteger("key", key);
					innerItem.setInteger("key", key);
					int unbreaking = EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(34), stack);
					if(unbreaking>0){
						subHandStack.addEnchantment(Enchantment.getEnchantmentByID(34), unbreaking);
					}
				}
			}
		}
	}
}
