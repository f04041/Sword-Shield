package f04041.swordshield.main;

import f04041.swordshield.main.event.CombatEvent;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {
	public void loadInit() {
		MinecraftForge.EVENT_BUS.register(new CombatEvent());
	}
}
