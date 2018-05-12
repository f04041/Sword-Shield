package f04041.swordshield.main;

import f04041.swordshield.main.event.ArrowReflectEvent;
import f04041.swordshield.main.event.CombatEvent;
import f04041.swordshield.main.event.OnEquipEvent;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {
	public void loadInit() {
		MinecraftForge.EVENT_BUS.register(new CombatEvent());
		MinecraftForge.EVENT_BUS.register(new OnEquipEvent());
		MinecraftForge.EVENT_BUS.register(new ArrowReflectEvent());
	}
}
