package onmitsu.naturalstyle.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import onmitsu.naturalstyle.common.NaturalStyle;
import onmitsu.naturalstyle.common.Reference;
import onmitsu.naturalstyle.util.Helper;

import java.util.List;

public class ItemBase extends Item {

	private EnumRarity rare;

	public ItemBase(String name)
	{
		this.setUnlocalizedName(name);
		this.setCreativeTab(NaturalStyle.TAB_NATURALSTYLE);
		this.setTextureName(Reference.RESOURCES_PATH + name);
	}

	public ItemBase register()
	{
		Helper.addItem(this);
		return this;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Deprecated
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean select)
	{
		this.addInfo(itemStack, player, list, select);
	}

	/** addInformation ==> */
	public void addInfo(ItemStack itemStack, EntityPlayer player, List<String> list, boolean select)
	{
		super.addInformation(itemStack, player, list, select);
	}

	public EnumRarity getRarity(ItemStack itemStack)
	{
		return this.rare != null ? this.rare : EnumRarity.common;
	}

	public ItemBase setRarity(EnumRarity rare)
	{
		this.rare = rare;
		return this;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Deprecated
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		this.getMetaItems(item, tab, list);
	}

	/** getSubBlocks ==> */
	public void getMetaItems(Item item, CreativeTabs tab, List<ItemStack> list)
	{
		list.add(new ItemStack(item, 1, 0));
	}
}
