package f04041.swordshield.item.abstractItem;

import javax.annotation.Nullable;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemShieldCore extends Item {

	protected String repairIngot = "";
	protected ToolMaterial toolMaterial;

	protected boolean showInCreative = true;

	public ItemShieldCore(ToolMaterial toolMaterial) {

		super();
		this.toolMaterial = toolMaterial;
		setMaxStackSize(1);
		setMaxDamage(0);

		addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter() {
			@SideOnly (Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {

				return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
			}
		});
	}

	public ItemShieldCore setRepairIngot(String repairIngot) {

		this.repairIngot = repairIngot;
		return this;
	}

	public ItemShieldCore setShowInCreative(boolean showInCreative) {

		this.showInCreative = showInCreative;
		return this;
	}

	public void onHit(ItemStack stack, EntityPlayer player, Entity source) {

	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {

		if (isInCreativeTab(tab) && showInCreative) {
			items.add(new ItemStack(this, 1, 0));
		}
	}

	@Override
	public boolean getIsRepairable(ItemStack itemToRepair, ItemStack stack) {

		ItemStack mat = this.toolMaterial.getRepairItemStack();
		if (!mat.isEmpty() && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, stack, false)) return true;
		return super.getIsRepairable(itemToRepair, stack);
	}

	@Override
	public boolean isShield(ItemStack stack, @Nullable EntityLivingBase entity) {

		return true;
	}

	@Override
	public int getItemEnchantability(ItemStack stack) {

		return toolMaterial.getEnchantability();
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {

		return 72000;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {

		playerIn.setActiveHand(hand);
		return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {

		return EnumAction.BLOCK;
	}

}