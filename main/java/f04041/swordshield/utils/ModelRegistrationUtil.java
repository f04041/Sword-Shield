package f04041.swordshield.utils;

import f04041.swordshield.main.SwordShield;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModelRegistrationUtil {
	@SubscribeEvent
	public void registerModels(ModelRegistryEvent event){
		ModelLoader.setCustomModelResourceLocation(ItemUtil.sSwordS, 0, new ModelResourceLocation(SwordShield.MOD_ID+":"+"sswords", "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemUtil.sShieldS, 0, new ModelResourceLocation(SwordShield.MOD_ID+":"+"sshields", "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemUtil.sSwordM, 0, new ModelResourceLocation(SwordShield.MOD_ID+":"+"sswordm", "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemUtil.sShieldM, 0, new ModelResourceLocation(SwordShield.MOD_ID+":"+"sshieldm", "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemUtil.sSwordL, 0, new ModelResourceLocation(SwordShield.MOD_ID+":"+"sswordl", "inventory"));
		ModelLoader.setCustomModelResourceLocation(ItemUtil.sShieldL, 0, new ModelResourceLocation(SwordShield.MOD_ID+":"+"sshieldl", "inventory"));
	}
}
