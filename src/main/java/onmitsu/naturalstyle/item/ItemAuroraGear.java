package onmitsu.naturalstyle.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import onmitsu.naturalstyle.client.ClientProxy;
import onmitsu.naturalstyle.common.NaturalStyle;
import onmitsu.naturalstyle.common.Reference;
import onmitsu.naturalstyle.util.Helper;
import onmitsu.naturalstyle.util.Lang;

import java.util.List;

public class ItemAuroraGear extends ItemArmor {

	public ItemAuroraGear(String name, ArmorMaterial material, int armorType)
	{
		super(material, 0, armorType);
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.RESOURCES_PATH + name);
		this.setCreativeTab(NaturalStyle.TAB_NATURALSTYLE);
		this.setNoRepair();
	}

	public ItemAuroraGear register()
	{
		Helper.addItem(this);
		return this;
	}

	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type)
	{
		if(this.armorType == 2)
			return Reference.RESOURCES_PATH + "textures/armor/aurora_armor_2.png";

		return Reference.RESOURCES_PATH + "textures/armor/aurora_armor_1.png";
	}

	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack itemStack, int slot)
	{
		if(slot == 1)
			return ClientProxy.VEST;

		if(slot == 3)
			return ClientProxy.BOOTS;

		return null;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean select)
	{
		//hat
		if(this.armorType == 0 && GuiScreen.isShiftKeyDown())
		{
			list.add(Reference.INFO_FUNCTION_REPAIR);
			list.add(Lang.localize("info.armor.respiration"));
		}
		//chest
		if(this.armorType == 1 && GuiScreen.isShiftKeyDown())
		{
			list.add(Reference.INFO_FUNCTION_REPAIR);
			list.add(Lang.localize("info.armor.regeneration"));
		}
		//pants
		if(this.armorType == 2 && GuiScreen.isShiftKeyDown())
		{
			list.add(Reference.INFO_FUNCTION_REPAIR);
			list.add(Lang.localize("info.armor.speedbonus"));
		}
		//boots
		if(this.armorType == 3 && GuiScreen.isShiftKeyDown())
		{
			list.add(Reference.INFO_FUNCTION_REPAIR);
			list.add(Lang.localize("info.armor.stepassist"));
			list.add(Lang.localize("info.armor.nofall"));
		}
		else
		{
			list.add(Reference.INFO_PRESS_SHIFT);
		}
	}
}
