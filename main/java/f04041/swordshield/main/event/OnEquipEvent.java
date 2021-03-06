package f04041.swordshield.main.event;

import f04041.swordshield.main.uuid.UuidStore;
import f04041.swordshield.utils.ItemUtil;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OnEquipEvent {
	@SubscribeEvent
	public void onEquipChange(LivingEquipmentChangeEvent event) {
		if(event.getEntityLiving() instanceof EntityPlayer ) {
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			IAttributeInstance attributeInstanceMS = event.getEntityLiving().getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
			IAttributeInstance attributeInstanceKB = event.getEntityLiving().getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
			if(event.getSlot().equals(EntityEquipmentSlot.OFFHAND)) {
				//移動速度上昇消去設定(移動速度の設定はItemShieldS参照)
				if(!player.getHeldItemOffhand().isEmpty()&&player.getHeldItemOffhand().getItem().equals(ItemUtil.sShieldS)) {
				}else {
					if(attributeInstanceMS.getModifier(UuidStore.UUID_MSF)!=null) {
						attributeInstanceMS.removeModifier(UuidStore.UUID_MSF);
					}
				}
				//移動速度上昇消去ここまで
				//移動速度減少,ノックバック耐性消去設定(設定はItemShieldL参照)
				if(!player.getHeldItemOffhand().isEmpty()&&player.getHeldItemOffhand().getItem().equals(ItemUtil.sShieldL)) {
				}else {
					if(attributeInstanceMS.getModifier(UuidStore.UUID_MSS)!=null) {
						attributeInstanceMS.removeModifier(UuidStore.UUID_MSS);
					}
					if(attributeInstanceKB.getModifier(UuidStore.UUID_K)!=null) {
						attributeInstanceKB.removeModifier(UuidStore.UUID_K);
					}
				}
				//移動速度減少,ノックバック耐性消去設定
			}
		}
	}
}
