package f04041.swordshield.main.event;

import f04041.swordshield.item.abstractItem.IShieldAbstract;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ArrowReflectEvent {
	@SubscribeEvent
	public void onLivingAttack(LivingAttackEvent event) {

		if(!event.getSource().isProjectile()) {
			return;
		}
		if(event.getSource().getImmediateSource() == null) {
			return;
		}
		Entity entity = event.getSource().getImmediateSource();
		if(!(entity.world instanceof WorldServer)) {
			return;
		}
		if(event.getEntityLiving() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.getEntityLiving();
			if(player.getHeldItemOffhand().getItem() instanceof IShieldAbstract) {
				ItemStack shield = player.getHeldItemOffhand();
				NBTTagCompound nbtShield = shield.getTagCompound();
				if(nbtShield.getBoolean("reflect")) {
					event.setCanceled(true);
					entity.setDead();
					if(!player.world.isRemote){
						((WorldServer)player.world).spawnParticle(EnumParticleTypes.CRIT_MAGIC, player.posX, player.posY+1.5, player.posZ, 15, 0.2D, 0.2D, 0.2D, 0.0D);
					}
				}
			}
		}
	}
}
