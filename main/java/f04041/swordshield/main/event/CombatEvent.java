package f04041.swordshield.main.event;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CombatEvent {
	@SubscribeEvent
	public void onHurt(LivingHurtEvent event){
		EntityLivingBase living = event.getEntityLiving();
		DamageSource source = event.getSource();
		float newDam = event.getAmount();
		float prev = 0.0F;
		if (living != null) {
			if (living instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) living;
			}
		}
	}
}
