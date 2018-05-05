package f04041.swordshield.main.event;

import f04041.swordshield.item.abstractItem.IShieldAbstract;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CombatEvent {
	@SubscribeEvent
	public void onHurt(LivingHurtEvent event){
		EntityLivingBase living = event.getEntityLiving();
		DamageSource source = event.getSource();
		float newDam = event.getAmount();
		float prev = 1.0F;
		if (living != null) {
			if(!source.isFireDamage()){
				if (living instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer) living;
					if(!player.getHeldItemMainhand().isEmpty()&&player.getHeldItemOffhand().getItem() instanceof IShieldAbstract){
						IShieldAbstract shield=(IShieldAbstract)player.getHeldItemOffhand().getItem();
						if(source.isProjectile()&&shield.getProjectileReflect()){
							prev=0F;
							if(!player.world.isRemote){
								((WorldServer)player.world).spawnParticle(EnumParticleTypes.CRIT_MAGIC, player.posX, player.posY+1.5, player.posZ, 15, 0.2D, 0.2D, 0.2D, 0.0D);
							}
						}else{
							prev=shield.getDecay();
							if(!player.world.isRemote){
								((WorldServer)player.world).spawnParticle(EnumParticleTypes.CRIT, player.posX, player.posY+1.5, player.posZ, 15, 0.2D, 0.2D, 0.2D, 0.0D);
							}
						}
					}
				}
			}
		}
		newDam *= prev;
		if(newDam<0.5F){
			event.setAmount(0F);
			event.setCanceled(true);
		}else{
			event.setAmount(newDam);
		}
	}
}
