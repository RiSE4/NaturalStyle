package onmitsu.naturalstyle.item;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import onmitsu.naturalstyle.common.NaturalStyle;
import onmitsu.naturalstyle.common.Reference;
import onmitsu.naturalstyle.util.Helper;

public class ItemAuroraAxe extends ItemAxe {

	public ItemAuroraAxe(String name)
	{
		super(NaturalStyle.TOOL_AURORA);
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.RESOURCES_PATH + name);
		this.setCreativeTab(NaturalStyle.TAB_NATURALSTYLE);
		this.setNoRepair();

		Helper.addItem(this);
	}

	public void onUpdate(ItemStack itemStack, World world, Entity entity, int meta, boolean select)
	{
		if(entity.ticksExisted % 400 == 0 && itemStack.isItemDamaged())
		{
			itemStack.setItemDamage(itemStack.getItemDamage() - 1);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean select)
	{
		if(GuiScreen.isShiftKeyDown())
		{
//			list.add(Reference.INFO_FUNCTION_SWITCH);
			list.add(Reference.INFO_FUNCTION_REPAIR);
		}
		else
		{
			list.add(Reference.INFO_PRESS_SHIFT);
		}
	}

}
