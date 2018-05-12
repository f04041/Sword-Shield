package f04041.swordshield.utils;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
public class RegistrationUtil {
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event){
		IForgeRegistry<Item> registry =event.getRegistry();
		registry.register(ItemUtil.sSwordS);
		registry.register(ItemUtil.sShieldS);
		registry.register(ItemUtil.sShieldM);
		registry.register(ItemUtil.sSwordM);
	}
}
